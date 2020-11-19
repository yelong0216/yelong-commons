package org.yelong.commons.lang;

import java.nio.charset.Charset;

import org.apache.commons.lang3.CharSetUtils;

/**
 * 字符集工具类
 * 
 * @see CharSetUtils
 * @since 2.2
 */
public final class CharsetUtilsE {

	public static final String UTF_8 = "UTF-8";

	public static final Charset CHARSET_UTF_8 = Charset.forName(UTF_8);

	private CharsetUtilsE() {
	}

}
