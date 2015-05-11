/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pl.umk.mat.goobar.cojo.core.contract.Contract;

/**
 * @author goobar
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface MethodContractReference
{
	Class<? extends Contract<?>> contract();

	String method();
}
