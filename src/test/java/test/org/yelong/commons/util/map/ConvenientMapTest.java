/**
 * 
 */
package test.org.yelong.commons.util.map;

import org.junit.jupiter.api.Test;
import org.yelong.commons.util.map.ConvenientMap;

/**
 *
 */
public class ConvenientMapTest {

	@Test
	public void test() {
		ConvenientMap<String, Object> convenientMap = new ConvenientMap<String, Object>();
		convenientMap.put_("username", "彭飞").put_("password", "彭飞");
		System.out.println(convenientMap);
	}

}
