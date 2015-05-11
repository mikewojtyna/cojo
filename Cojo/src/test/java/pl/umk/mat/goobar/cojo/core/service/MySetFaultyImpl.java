/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author goobar
 *
 */
public class MySetFaultyImpl implements MySet<Object>
{
	private final List<Object> list;

	/**
	 * 
	 */
	public MySetFaultyImpl()
	{
		list = new ArrayList<>();
	}

	public MySetFaultyImpl(Collection<Object> collection)
	{
		list = new ArrayList<>(collection);
	}

	public void add(int index, Object element)
	{
		list.add(index, element);
	}

	@Override
	public boolean add(Object e)
	{
		return list.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends Object> c)
	{
		return list.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Object> c)
	{
		return list.addAll(index, c);
	}

	@Override
	public void clear()
	{
		list.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return list.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return list.containsAll(c);
	}

	@Override
	public boolean equals(Object o)
	{
		return list.equals(o);
	}

	public Object get(int index)
	{
		return list.get(index);
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.service.MySet#getAll()
	 */
	@Override
	public Collection<Object> getAll()
	{
		return list;
	}

	@Override
	public int hashCode()
	{
		return list.hashCode();
	}

	public int indexOf(Object o)
	{
		return list.indexOf(o);
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	@Override
	public Iterator<Object> iterator()
	{
		return list.iterator();
	}

	public int lastIndexOf(Object o)
	{
		return list.lastIndexOf(o);
	}

	public ListIterator<Object> listIterator()
	{
		return list.listIterator();
	}

	public ListIterator<Object> listIterator(int index)
	{
		return list.listIterator(index);
	}

	public Object remove(int index)
	{
		return list.remove(index);
	}

	@Override
	public boolean remove(Object o)
	{
		return list.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return list.retainAll(c);
	}

	public Object set(int index, Object element)
	{
		return list.set(index, element);
	}

	@Override
	public int size()
	{
		return list.size();
	}

	public List<Object> subList(int fromIndex, int toIndex)
	{
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray()
	{
		return list.toArray();
	}

	@Override
	public Object[] toArray(Object[] a)
	{
		return list.toArray(a);
	}

}
