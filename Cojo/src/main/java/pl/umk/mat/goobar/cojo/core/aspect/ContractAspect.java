/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import pl.umk.mat.goobar.cojo.core.annotation.ContractOrder;
import pl.umk.mat.goobar.cojo.core.annotation.ContractReference;
import pl.umk.mat.goobar.cojo.core.annotation.Invariant;
import pl.umk.mat.goobar.cojo.core.annotation.MethodContract;
import pl.umk.mat.goobar.cojo.core.annotation.MethodContractReference;
import pl.umk.mat.goobar.cojo.core.contract.Contract;
import pl.umk.mat.goobar.cojo.core.contract.ContractViolatedException;

import com.rits.cloning.Cloner;

/**
 * @author goobar
 *
 */
@Aspect
public class ContractAspect
{
	private Cloner cloner;

	/**
	 * @param cloner
	 *                the cloner to set
	 */
	@Autowired
	public void setCloner(Cloner cloner)
	{
		this.cloner = cloner;
	}

	@Around(value = "servicePublicMethod()")
	public Object validateContract(ProceedingJoinPoint joinPoint)
	{
		MethodSignature methodSignature = (MethodSignature) joinPoint
			.getSignature();
		MethodContractReference methodContractReference = methodSignature
			.getMethod().getAnnotation(
				MethodContractReference.class);
		ContractReference contractReference = AnnotationUtils
			.findAnnotation(joinPoint.getTarget().getClass(),
				ContractReference.class);
		Class<? extends Contract<?>> contract = null;
		if (methodContractReference != null)
		{
			contract = methodContractReference.contract();
		}
		else
		{
			if (contractReference != null)
			{
				contract = contractReference.contract();
			}
		}

		try
		{
			// create new instance of contract class
			@SuppressWarnings("unchecked")
			Contract<Object> contractInstance = (Contract<Object>) contract
				.newInstance();
			// store the original reference
			Object originalObject = joinPoint.getTarget();
			contractInstance.setOriginalObject(originalObject);
			// store the copy of the original object
			Object originalObjectCopy = cloner
				.deepClone(originalObject);
			contractInstance.setOldObject(originalObjectCopy);

			String methodContractName = methodContractReference
				.method();
			List<Method> beforeMethodContracts = findMethodsByMethodNameAndContractOrder(
				contract, methodContractName,
				ContractOrder.BEFORE);
			List<Method> afterMethodContracts = findMethodsByMethodNameAndContractOrder(
				contract, methodContractName,
				ContractOrder.AFTER);
			List<Method> invariantMethodContracts = findInvariants(contract);

			// execute all before contracts and invariants
			invariantMethodContracts
				.forEach(method -> invokeMethod(
					contractInstance, method));
			List<Object> methodArgs = Arrays.asList(joinPoint
				.getArgs());
			beforeMethodContracts.forEach(method -> invokeMethod(
				contractInstance, method, methodArgs));
			// run method
			Object returnValue = joinPoint.proceed();
			// execute all after contracts and invariants
			ArrayList<Object> returnValueAndMethodArgs = new ArrayList<>(
				methodArgs);
			Class<?> returnType = methodSignature.getReturnType();
			if (!Void.TYPE.equals(returnType))
			{
				returnValueAndMethodArgs.add(0, returnValue);
			}
			afterMethodContracts.forEach(method -> invokeMethod(
				contractInstance, method,
				returnValueAndMethodArgs));
			invariantMethodContracts
				.forEach(method -> invokeMethod(
					contractInstance, method));

			return returnValue;
		}
		catch (Throwable e)
		{
			throw new ContractViolatedException(contract, e);
		}
	}

	private List<Method> findAllMethods(Class<?> clazz)
	{
		List<Method> result = new ArrayList<>();
		Method[] methods = clazz.getMethods();
		result = Arrays.asList(methods);
		return result;
	}

	private List<Method> findInvariants(Class<?> clazz)
	{
		List<Method> result = new ArrayList<>();
		List<Method> methods = findAllMethods(clazz);
		for (Method method : methods)
		{
			boolean invariantPresent = method
				.isAnnotationPresent(Invariant.class);
			if (invariantPresent)
			{
				result.add(method);
			}
		}
		return result;
	}

	private List<Method> findMethodsByMethodNameAndContractOrder(
		Class<?> clazz, String methodName, ContractOrder order)
	{
		List<Method> result = new ArrayList<>();
		List<Method> methods = findAllMethods(clazz);
		for (Method method : methods)
		{
			List<MethodContract> contracts = Arrays.asList(method
				.getAnnotationsByType(MethodContract.class));
			List<MethodContract> filteredContracts = contracts
				.stream()
				.filter(methodContract -> methodName
					.equals(methodContract.method())
					&& order == methodContract.order())
				.collect(Collectors.toList());
			if (!filteredContracts.isEmpty())
			{
				result.add(method);
			}
		}
		return result;
	}

	private void invokeMethod(Object object, Method method,
		List<Object> args)
	{
		invokeMethod(object, method, args.toArray());
	}

	private void invokeMethod(Object object, Method method, Object... args)
	{
		try
		{
			method.invoke(object, args);
		}
		catch (IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Pointcut("execution(public * pl.umk.mat.goobar.cojo.core.service.*.*(..)) "
		+ "&& !within(pl.umk.mat.goobar.cojo.core.contract..*)")
	private void servicePublicMethod()
	{
	}

}
