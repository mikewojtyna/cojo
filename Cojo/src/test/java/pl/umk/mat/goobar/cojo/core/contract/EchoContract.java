/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.contract;

import pl.umk.mat.goobar.cojo.core.annotation.ContractOrder;
import pl.umk.mat.goobar.cojo.core.annotation.MethodContract;
import pl.umk.mat.goobar.cojo.core.service.Echo;
import pl.umk.mat.goobar.cojo.core.util.ContractAssert;

/**
 * {@link Echo} service contract.
 * 
 * @author goobar
 *
 */
public class EchoContract implements Contract<Echo>
{
	@MethodContract(method = "echo", order = ContractOrder.AFTER)
	public void afterEcho(String returnValue, String msg)
	{
		ContractAssert.assertTrue(Echo.class, msg.equals(returnValue));
	}

	@MethodContract(method = "echo", order = ContractOrder.BEFORE)
	public void beforeEcho(String msg)
	{
		ContractAssert.assertTrue(Echo.class, msg != null);
		ContractAssert.assertTrue(Echo.class, !msg.isEmpty());
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.contract.OldObjectHolder#setOldObject(java.lang.Object)
	 */
	@Override
	public void setOldObject(Echo object)
	{
		// we can use that later if we wish
		// echo = (Echo) object;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.core.contract.OriginalObjectHolder#setOriginalObject(java.lang.Object)
	 */
	@Override
	public void setOriginalObject(Echo object)
	{
		// we can use that later if we wish
		// echo = (Echo) object;
	}

}
