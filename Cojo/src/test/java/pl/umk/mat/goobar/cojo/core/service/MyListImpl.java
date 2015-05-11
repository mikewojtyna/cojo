/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goobar
 *
 */
public class MyListImpl implements MyList<Object>
{
	private final List<Object> list;

	public MyListImpl()
	{
		super();
		list = new ArrayList<Object>();
	}

	public MyListImpl(List<Object> list)
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
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#add(java.lang.Object)
	 */
	@Override
	public void add(Object element)
	{
		list.add(element);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		MyListImpl other = (MyListImpl) obj;
		if (list == null)
		{
			if (other.list != null)
			{
				return false;
			}
		}
		else if (!list.equals(other.list))
		{
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MyList#getAll()
	 */
	@Override
	public List<Object> getAll()
	{
		return list;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((list == null) ? 0 : list.hashCode());
		return result;
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
