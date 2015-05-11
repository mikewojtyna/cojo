/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.contract;

import java.util.HashSet;

import pl.umk.mat.goobar.cojo.core.annotation.Invariant;
import pl.umk.mat.goobar.cojo.core.service.MySet;
import pl.umk.mat.goobar.cojo.core.util.ContractAssert;

/**
 * @author goobar
 *
 */
public class MySetContract implements Contract<MySet<Object>>
{
	@SuppressWarnings("unused")
	private MySet<Object> oldObject;
	private MySet<Object> originalObject;

	@Invariant
	public void everyElementIsUnique()
	{
		HashSet<Object> hashSet = new HashSet<Object>(
			originalObject.getAll());
		int expectedSetSize = hashSet.size();
		int realSetSize = originalObject.size();
		ContractAssert.assertTrue(getClass(),
			expectedSetSize == realSetSize);
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.contract.OldObjectHolder#setOldObject(java.lang.Object)
	 */
	@Override
	public void setOldObject(MySet<Object> object)
	{
		oldObject = object;
	}

	/* (non-Javadoc)
	 * @see pl.umk.mat.goobar.cojo.core.contract.OriginalObjectHolder#setOriginalObject(java.lang.Object)
	 */
	@Override
	public void setOriginalObject(MySet<Object> object)
	{
		originalObject = object;
	}

}
