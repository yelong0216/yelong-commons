/**
 * 
 */
package org.yelong.commons.test.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.StringUtilsE;

/**
 *
 */
public class StringUtilsETest {

	@Test
	public void underscoreToCamelCase() {
		System.out.println(StringUtilsE.underscoreToCamelCase("_string_utils"));
	}
	
	@Test
	public void camelCaseToUnderscore() {
		System.out.println(StringUtilsE.camelCaseToUnderscore("StringUtils"));
	}
	
}
