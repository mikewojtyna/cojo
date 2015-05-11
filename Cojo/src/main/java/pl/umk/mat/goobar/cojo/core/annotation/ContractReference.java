/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pl.umk.mat.goobar.cojo.core.contract.Contract;

/**
 * @author goobar
 *
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ContractReference
{
	Class<? extends Contract<?>> contract();
}
