/**
 * 
 */
package org.yelong.commons.lang;

/**
 * @author PengFei
 * @since 1.0.2
 */
public final class Strings {

	private Strings() {}

	/**
	 * 验证字符串是否是空字符
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <T extends CharSequence> T requireNonEmpty(T c) {
		if(org.apache.commons.lang3.StringUtils.isEmpty(c)){
			throw new CharSequenceNotAllowEmptyException();
		}
		return c;
	}

	/**
	 * 验证字符串是否是空字符
	 * @param c 需要验证的字符串
	 * @param message 异常消息
	 * @return c
	 */
	public static <T extends CharSequence> T requireNonEmpty(T c,String message) {
		if(org.apache.commons.lang3.StringUtils.isEmpty(c)){
			throw new CharSequenceNotAllowEmptyException(message);
		}
		return c;
	}

	/**
	 * 验证字符串是否是空白字符
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <T extends CharSequence> T requireNonBlank(T c) {
		if(org.apache.commons.lang3.StringUtils.isBlank(c)){
			throw new CharSequenceNotAllowBlankException();
		}
		return c;
	}

	/**
	 * 验证字符串是否是空白字符
	 * @param c 需要验证的字符串
	 * @param message 异常消息
	 * @return c 
	 */
	public static <T extends CharSequence> T requireNonBlank(T c,String message) {
		if(org.apache.commons.lang3.StringUtils.isBlank(c)){
			throw new CharSequenceNotAllowBlankException(message);
		}
		return c;
	}

	/**
	 * 字符不允许为空字符异常
	 */
	public static class CharSequenceNotAllowEmptyException extends RuntimeException {

		private static final long serialVersionUID = 7254731206561925448L;
		
		public CharSequenceNotAllowEmptyException() {}
		
		public CharSequenceNotAllowEmptyException(String message) {super(message);}
		
	}
	
	/**
	 * 字符不允许为空白字符异常
	 */
	public static class CharSequenceNotAllowBlankException extends RuntimeException {

		private static final long serialVersionUID = 7254731206561925448L;
		
		public CharSequenceNotAllowBlankException() {}
		
		public CharSequenceNotAllowBlankException(String message) {super(message);}
		
	}
	
	
}
