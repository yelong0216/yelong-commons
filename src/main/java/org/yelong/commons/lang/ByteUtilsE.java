/**
 * 
 */
package org.yelong.commons.lang;

import org.apache.commons.codec.binary.Base64;

/**
 * byte工具类
 * 
 * @since 1.1
 */
public class ByteUtilsE {

	/**
	 * 字节数组转换为 Base64
	 * 
	 * @param byteArray 字节数组
	 * @return base64 编码字符串
	 */
	public static String toBase64(byte[] byteArray) {
		Base64 encoder = new Base64();
		return byteArray != null ? encoder.encodeToString(byteArray) : "";
	}

}
