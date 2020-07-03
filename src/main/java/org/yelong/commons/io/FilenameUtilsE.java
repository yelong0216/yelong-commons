/**
 * 
 */
package org.yelong.commons.io;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * 文件名称工具类拓展
 * 
 * @see FilenameUtils
 * @author PengFei
 */
public final class FilenameUtilsE {

	private FilenameUtilsE() {
	}

	/**
	 * 文件分隔符
	 */
	public static final String FS = File.separator;

	/**
	 * 获取文件的路径。多个目录之间通过文件分隔符分隔
	 * 
	 * <pre>
	 * params = new String [] {"yelong","file","annex","yelong.docx"};
	 * 
	 * windows return "yelong\file\annex\yelong.docx"
	 * linux return "yelong/file/annex/yelong.docx"
	 * </pre>
	 * 
	 * @param names file dir name array
	 * @return 文件路径
	 */
	public static String getFilePath(String... names) {
		if (null == names) {
			return null;
		}
		StringBuilder filename = new StringBuilder();
		for (String name : names) {
			filename.append(name + FS);
		}
		return filename.delete(filename.lastIndexOf(FS), filename.length()).toString();
	}

}
