/**
 * 
 */
package test.org.yelong.commons.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.Integers;

/**
 *
 */
public class IntegersTest {

	@Test
	public void valueOf() {
		System.out.println(Integers.valueOf("a123"));
		System.out.println(Integers.valueOf("a123",123));
	}
	
}
