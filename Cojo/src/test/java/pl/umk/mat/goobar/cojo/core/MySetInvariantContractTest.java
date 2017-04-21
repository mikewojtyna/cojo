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
@SuppressWarnings("javadoc")
public class MySetInvariantContractTest
{
	@Autowired
	@Qualifier(value = "myFaultySet")
	private MySet<Object> myFaultySet;

	@Autowired
	@Qualifier(value = "mySet")
	private MySet<Object> mySet;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void should_InvariantContractExecuteSuccesfully_When_StoringNotUniqueElementsUsingValidMySet()
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
	public void should_ViolateInvariant_When_StoringNotUniqueElementsUsingFaultyMySet()
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
