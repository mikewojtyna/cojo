/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author goobar
 *
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MethodContract
{
	String method();

	ContractOrder order();
}
