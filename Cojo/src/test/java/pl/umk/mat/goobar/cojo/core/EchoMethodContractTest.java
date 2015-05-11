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
public class EchoMethodContractTest
{
	private Echo echo;
	private Echo faultyEcho;

	/**
	 * @param echo
	 *                the echo to set
	 */
	@Autowired
	@Qualifier(value = "echo")
	public void setEcho(Echo echo)
	{
		this.echo = echo;
	}

	/**
	 * @param faultyEcho
	 *                the faultyEcho to set
	 */
	@Autowired
	@Qualifier(value = "faultyEcho")
	public void setFaultyEcho(Echo faultyEcho)
	{
		this.faultyEcho = faultyEcho;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void shouldContractExecuteSuccesfullyWhenUsingValidEchoService()
	{
		// fixture
		String msg = "message";

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void shouldViolateContractForEmptyMessageWhenUsingValidEchoService()
	{
		// fixture
		String msg = "";

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void shouldViolateContractForNullMessageWhenUsingValidEchoService()
	{
		// fixtture
		String msg = null;

		// when
		echo.echo(msg);
	}

	@Test(expected = ContractViolatedException.class)
	public void shouldViolateContractForValidMessageWhenUsingFaultyEchoService()
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
