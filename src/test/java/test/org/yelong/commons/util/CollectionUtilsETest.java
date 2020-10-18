/**
 * 
 */
package test.org.yelong.commons.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.yelong.commons.util.CollectionUtilsE;

/**
 *
 */
public class CollectionUtilsETest {

	@Test
	public void get() {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("z");
		set.add("b");
		System.out.println(CollectionUtilsE.get(set, 1));
		System.out.println(CollectionUtilsE.get(set, -1,"haha"));
	}

}
