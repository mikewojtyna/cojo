/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.umk.mat.goobar.cojo.core.aspect.ContractAspect;
import pl.umk.mat.goobar.cojo.core.service.MyFaultyListImpl;
import pl.umk.mat.goobar.cojo.core.service.MyList;
import pl.umk.mat.goobar.cojo.core.service.MyListImpl;

import com.rits.cloning.Cloner;

/**
 * @author goobar
 *
 */
@ComponentScan(value = "pl.umk.mat.goobar.cojo.core.service")
@Configuration
@EnableAspectJAutoProxy
public class TestConfig
{

	@Bean
	public Cloner cloner()
	{
		return new Cloner();
	}

	@Bean
	public ContractAspect greeterAspect()
	{
		return new ContractAspect();
	}

	@Bean
	@Qualifier(value = "myFaultyList")
	public MyList<Object> myFaultyList()
	{
		return new MyFaultyListImpl();
	}

	@Bean
	@Qualifier(value = "myList")
	public MyList<Object> myList()
	{
		ArrayList<Object> data = new ArrayList<>(Arrays.asList("first",
			"second", "third"));
		MyListImpl myListImpl = new MyListImpl(data);
		return myListImpl;
	}
}
