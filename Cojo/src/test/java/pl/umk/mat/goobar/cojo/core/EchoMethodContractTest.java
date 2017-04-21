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
import pl.umk.mat.goobar.cojo.core.service.Echo;

/**
 * @author goobar
 *
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SuppressWarnings("javadoc")
public class EchoMethodContractTest
{
	@Autowired
	@Qualifier(value = "echo")
	private Echo echo;

	@Autowired
	@Qualifier(value = "faultyEcho")
	private Echo faultyEcho;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void should_ContractExecuteSuccesfully_When_UsingValidEchoService()
	{
		// fixture
		String msg = "message";

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void should_ViolateContractForEmptyMessage_When_UsingValidEchoService()
	{
		// fixture
		String msg = "";

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void should_ViolateContractForNullMessage_When_UsingValidEchoService()
	{
		// fixture
		String msg = null;

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void should_ViolateContractForValidMessage_When_UsingFaultyEchoService()
	{
		// fixture
		String msg = "message";

		// when
		faultyEcho.echo(msg);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

}
