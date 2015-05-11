/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import pl.umk.mat.goobar.cojo.core.annotation.MethodContractReference;
import pl.umk.mat.goobar.cojo.core.contract.EchoContract;

/**
 * Simple echo service.
 * 
 * @author goobar
 *
 */
public interface Echo
{
	/**
	 * Returns the same message. This method must meet the
	 * {@link EchoContract} contract.
	 * 
	 * @param msg
	 *                non-null, non-empty message
	 * @return exactly the same, non-null, non-empty message
	 */
	@MethodContractReference(contract = EchoContract.class, method = "echo")
	String echo(String msg);
}
