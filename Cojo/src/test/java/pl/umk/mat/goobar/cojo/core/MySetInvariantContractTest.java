/**
 * 
 */
package pl.umk.mat.goobar.cojo.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.umk.mat.goobar.cojo.core.config.TestConfig;
import pl.umk.mat.goobar.cojo.core.contract.ContractViolatedException;
import pl.umk.mat.goobar.cojo.core.service.MySet;

/**
 * @author goobar
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MySetInvariantContractTest
{
	private MySet<Object> myFaultySet;
	private MySet<Object> mySet;

	/**
	 * @param myFaultySet
	 *                the myFaultySet to set
	 */
	@Autowired
	@Qualifier(value = "myFaultySet")
	public void setMyFaultySet(MySet<Object> myFaultySet)
	{
		this.myFaultySet = myFaultySet;
	}

	/**
	 * @param mySet
	 *                the mySet to set
	 */
	@Autowired
	@Qualifier(value = "mySet")
	public void setMySet(MySet<Object> mySet)
	{
		this.mySet = mySet;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void shouldInvariantContractExecuteSuccesfullyWhenStoringNotUniqueElementsUsingValidMySet()
	{
		// fixture
		Object firstElement = "aa";
		Object secondElement = "bb";
		Object thirdElement = "aa";

		// when
		mySet.add(firstElement);
		mySet.add(secondElement);
		mySet.add(thirdElement);
	}

	@Test(expected = ContractViolatedException.class)
	public void shouldViolateInvariantWhenStoringNotUniqueElementsUsingFaultyMySet()
	{
		// fixture
		Object firstElement = "aa";
		Object secondElement = "bb";
		Object thirdElement = "aa";

		// when
		myFaultySet.add(firstElement);
		myFaultySet.add(secondElement);
		myFaultySet.add(thirdElement);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

}
