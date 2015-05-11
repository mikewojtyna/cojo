/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.util;

import pl.umk.mat.goobar.cojo.core.contract.ContractViolatedException;

/**
 * @author goobar
 *
 */
public class ContractAssert
{
	public static void assertTrue(Class<?> contract, boolean expression)
	{
		if (!expression)
		{
			prepareAndThrowContractViolatedException(contract);
		}
	}

	private static void prepareAndThrowContractViolatedException(
		Class<?> contract)
	{
		throw new ContractViolatedException(contract);
	}
}
