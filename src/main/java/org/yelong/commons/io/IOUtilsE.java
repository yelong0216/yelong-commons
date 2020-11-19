/**
 * 
 */
package org.yelong.commons.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * 流工具类
 * 
 * @since 2.1.2
 */
public final class IOUtilsE {

	public final static int DEFAULT_BUFFER_SIZE = 1024 * 4;

	public final static Charset defaultCharset = Charset.forName("UTF-8");

	private IOUtilsE() {
	}

	// ==================================================read==================================================

	/**
	 * 读取流中的字符串内容
	 * 
	 * @param in 需要读取的流
	 * @return 流中的字符串内容
	 * @throws IOException 流读取异常
	 */
	public static String readString(InputStream in) throws IOException {
		return readString(new InputStreamReader(in, defaultCharset));
	}

	/**
	 * 读取流中的字符串内容
	 * 
	 * @param in       需要读取的流
	 * @param encoding 编码
	 * @return 流中的字符串内容
	 * @throws IOException 流读取异常
	 */
	public static String readString(InputStream in, String encoding) throws IOException {
		return readString(new InputStreamReader(in, Charset.forName(encoding)));
	}

	/**
	 * 读取流中的字符串内容
	 * 
	 * @param reader 需要读取的流
	 * @return 流中的字符串内容
	 * @throws IOException 流读取异常
	 */
	public static String readString(Reader reader) throws IOException {
		StringWriter writer = new StringWriter();
		char[] buffer = new char[DEFAULT_BUFFER_SIZE];
		int n = 0;
		while (-1 != (n = reader.read(buffer))) {
			writer.write(buffer, 0, n);
		}
		return writer.toString();
	}

	// ==================================================close==================================================

	/**
	 * 安静的关闭流
	 * 
	 * @param closeable 需要关闭的流
	 */
	public static void closeQuietly(final Closeable closeable) {
		if (null != closeable) {
			try {
				closeable.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}

}
