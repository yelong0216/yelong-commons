/**
 * 
 */
package org.yelong.commons.test.util;

import org.junit.jupiter.api.Test;
import org.yelong.commons.util.BothwayMap;

/**
 *
 */
public class BothwayMapTest {

	@Test
	public void test() {
		BothwayMap<String, String> bothwayMap = new BothwayMap<String, String>();
		bothwayMap.add("a", "A");
		bothwayMap.add("b", "B");
		System.out.println(bothwayMap.getLeft("B"));
		System.out.println(bothwayMap.getRight("a"));
		System.out.println(bothwayMap.getLefts());
		System.out.println(bothwayMap.getRights());
	}
	
}
