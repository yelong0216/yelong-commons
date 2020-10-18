/**
 * 
 */
package test.org.yelong.commons.util.map;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.junit.jupiter.api.Test;
import org.yelong.commons.util.map.CaseInsensitiveMapUtils;
import org.yelong.commons.util.map.CaseInsensitiveMapUtils.KeyStoreMode;

/**
 *
 */
public class CaseInsensitiveMapUtilsTest {

	@Test
	public void CaseInsensitiveMap() {
		CaseInsensitiveMap<Object, Object> caseInsensitiveMap_LOWER = CaseInsensitiveMapUtils
				.createCaseInsensitiveMap(KeyStoreMode.LOWER);
		caseInsensitiveMap_LOWER.put("userName", "彭飞");
		caseInsensitiveMap_LOWER.put("passWord", "彭飞");
		System.out.println(caseInsensitiveMap_LOWER.get("USERname"));
		System.out.println(caseInsensitiveMap_LOWER.get("PASSword"));
		System.out.println(caseInsensitiveMap_LOWER);
		CaseInsensitiveMap<Object, Object> caseInsensitiveMap_UPPER = CaseInsensitiveMapUtils
				.createCaseInsensitiveMap(KeyStoreMode.UPPER);
		caseInsensitiveMap_UPPER.put("userName", "彭飞");
		caseInsensitiveMap_UPPER.put("passWord", "彭飞");
		System.out.println(caseInsensitiveMap_UPPER.get("USERname"));
		System.out.println(caseInsensitiveMap_UPPER.get("PASSword"));
		System.out.println(caseInsensitiveMap_UPPER);

	}

}
