/**
 * 
 */
package test.org.yelong.commons.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ClassUtilsE;

/**
 *
 */
public class ClassUtilsETest {

	@Test
	public void getNamePrefixLowerCase() {
		String namePrefixLowerCase = ClassUtilsE.getNamePrefixLowerCase(ClassUtilsETest.class);
		System.out.println(namePrefixLowerCase);
	}
	
}
