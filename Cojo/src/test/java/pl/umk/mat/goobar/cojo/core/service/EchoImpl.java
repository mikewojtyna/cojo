/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author goobar
 *
 */
@Service
@Qualifier(value = "echo")
public class EchoImpl implements Echo
{

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.Echo#echo(java.lang.String)
	 */
	@Override
	public String echo(String msg)
	{
		return msg;
	}

}
