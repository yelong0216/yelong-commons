/**
 * 
 */
package org.yelong.commons.test.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.EnumUtilsE;
import org.yelong.commons.lang.EnumUtilsE.Codeable;

/**
 *
 */
public class EnumUtilsETest {

	@Test
	public void valueOf() {
		System.out.println(Sex.valueOf("MAN"));
		System.out.println(EnumUtilsE.valueOf(Sex.class, "MAN"));
	}

	@Test
	public void valueOfByCode() {
		System.out.println(EnumUtilsE.valueOfByCode(Sex.class, null));
		System.out.println(EnumUtilsE.valueOfByCode(Sex.class, "01"));
		System.out.println(EnumUtilsE.valueOfByCode(Sex.class, "02"));
		System.out.println(EnumUtilsE.valueOfByCode(Sex.class, "03"));
	}

	public static enum Sex implements Codeable<String> {

		MAN("01"), WOMAN("02"), RENYAO(null);

		public final String CODE;

		private Sex(String code) {
			this.CODE = code;
		}

		@Override
		public String getCode() {
			return CODE;
		}

	}

}
