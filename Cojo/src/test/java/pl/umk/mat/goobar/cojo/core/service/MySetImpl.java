/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author goobar
 *
 */
public class MySetImpl extends HashSet<Object> implements MySet<Object>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MySet#getAll()
	 */
	@Override
	public Collection<Object> getAll()
	{
		return this;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MySet#toArray(java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a)
	{
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
