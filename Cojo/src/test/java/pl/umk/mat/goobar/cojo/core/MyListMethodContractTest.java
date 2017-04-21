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
import pl.umk.mat.goobar.cojo.core.service.MyList;

/**
 * @author goobar
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = TestConfig.class)
@SuppressWarnings("javadoc")
public class MyListMethodContractTest
{
	@Autowired
	@Qualifier(value = "myFaultyList")
	private MyList<Object> myFaultyList;

	@Autowired
	@Qualifier(value = "myList")
	private MyList<Object> myList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void shoul_AddContractExecuteSuccesfully_When_UsingValidMyListService()
	{
		// fixture
		Object element = new Object();

		// when
		myList.add(element);
	}

	@Test(expected = ContractViolatedException.class)
	public void should_ViolateAddContract_When_UsingFaultyMyListService()
	{
		// fixture
		Object element = new Object();

		// when
		myFaultyList.add(element);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

}
