/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.contract;

import java.util.List;

import pl.umk.mat.goobar.cojo.core.annotation.ContractOrder;
import pl.umk.mat.goobar.cojo.core.annotation.MethodContract;
import pl.umk.mat.goobar.cojo.core.service.MyList;
import pl.umk.mat.goobar.cojo.core.util.ContractAssert;

/**
 * @author goobar
 *
 */
public class MyListContract implements Contract<MyList<Object>>
{
	private MyList<Object> oldObject;
	private MyList<Object> originalObject;

	@MethodContract(method = "addToEnd", order = ContractOrder.AFTER)
	public void add(Object element)
	{
		List<Object> oldList = oldObject.getAll();
		List<Object> newList = originalObject.getAll();
		if (!(oldList.isEmpty() && newList.size() == 1))
		{
			ContractAssert.assertTrue(
				getClass(),
				oldList.equals(newList.subList(0,
					newList.size() - 1)));
		}
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.contract.OldObjectHolder#setOldObject(java.lang.Object)
	 */
	@Override
	public void setOldObject(MyList<Object> object)
	{
		oldObject = object;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.contract.OriginalObjectHolder#setOriginalObject(java.lang.Object)
	 */
	@Override
	public void setOriginalObject(MyList<Object> object)
	{
		originalObject = object;
	}
}
