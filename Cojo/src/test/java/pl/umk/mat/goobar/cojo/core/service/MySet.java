/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.Collection;
import java.util.Iterator;

import pl.umk.mat.goobar.cojo.core.annotation.ContractReference;
import pl.umk.mat.goobar.cojo.core.contract.MySetContract;

/**
 * @author goobar
 *
 */
@ContractReference(contract = MySetContract.class)
public interface MySet<T>
{

	public boolean add(T e);

	public boolean addAll(Collection<? extends T> c);

	public void clear();

	public boolean contains(Object o);

	public boolean containsAll(Collection<?> c);

	public Collection<T> getAll();

	public boolean isEmpty();

	public Iterator<T> iterator();

	public boolean remove(Object o);

	public boolean removeAll(Collection<?> c);

	public boolean retainAll(Collection<?> c);

	public int size();

	public Object[] toArray();

	public T[] toArray(T[] a);
}