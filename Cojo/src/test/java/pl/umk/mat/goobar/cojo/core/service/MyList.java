/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.service;

import java.util.List;

import pl.umk.mat.goobar.cojo.core.annotation.MethodContractReference;
import pl.umk.mat.goobar.cojo.core.contract.MyListContract;

/**
 * @author goobar
 *
 */
public interface MyList<T>
{
	void add(int index, T element);

	@MethodContractReference(contract = MyListContract.class,
		method = "addToEnd")
	void add(T element);

	List<T> getAll();

	void remove(int index);
}
