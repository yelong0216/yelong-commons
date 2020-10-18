/**
 * 
 */
package test.org.yelong.commons.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.yelong.commons.util.ListUtilsE;

/**
 * @since
 */
public class ListUtilsETest {

	@Test
	public void get() {
		List<String> list = Arrays.asList("123","456");
		System.out.println(ListUtilsE.get(list, 2));
		System.out.println(ListUtilsE.get(list, 2,"离开了的风格"));
	}
}
