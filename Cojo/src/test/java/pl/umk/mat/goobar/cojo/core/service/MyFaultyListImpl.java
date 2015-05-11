/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author goobar
 *
 */
public class MyFaultyListImpl implements MyList<Object>
{
	private final List<Object> list;

	public MyFaultyListImpl()
	{
		super();
		list = new ArrayList<>();
	}

	public MyFaultyListImpl(List<Object> list)
	{
		super();
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Object element)
	{
		// nothing
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#add(java.lang.Object)
	 */
	@Override
	public void add(Object element)
	{
		list.addAll(Arrays.asList("aa", "bb", "cc", "dd", "ee"));
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#getAll()
	 */
	@Override
	public List<Object> getAll()
	{
		return list;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#remove(int)
	 */
	@Override
	public void remove(int index)
	{
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
