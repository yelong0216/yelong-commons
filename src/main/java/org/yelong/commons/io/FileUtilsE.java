/**
 * 
 */
package org.yelong.commons.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 文件工具类。
 * 
 * @see org.apache.commons.io.FileUtils
 * @since 1.2
 */
public final class FileUtilsE {

	private FileUtilsE() {
	}

	/**
	 * 1 KB
	 */
	public static final long ONE_KB = 1024;

	/**
	 * 1 MB
	 */
	public static final long ONE_MB = ONE_KB * ONE_KB;

	/**
	 * 1 GB
	 */
	public static final long ONE_GB = ONE_MB * ONE_KB;

	/**
	 * 1 TB
	 */
	public static final long ONE_TB = ONE_GB * ONE_KB;

	/**
	 * 将base64码转换为文件
	 * 
	 * @param base64 base64码
	 * @param names  被写入的文件名称元素
	 * @return base64码转换为的文件
	 * @throws IOException in case of an I/O error
	 * @see FileUtilsE#createNewFile(String...)
	 */
	public static File base64ConvertFile(String base64, String... names) throws IOException {
		if (StringUtils.isBlank(base64)) {
			throw new NullPointerException();
		}
		File file = createNewFile(names);
		byte[] data = java.util.Base64.getDecoder().decode(base64);
		org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data);
		return file;
	}

	/**
	 * 获取文件的创建时间
	 * 
	 * @param names the name elements
	 * @return 文件创建时间(毫秒 MS)
	 * @throws FileNotFoundException 文件不存在
	 */
	public static Long getFileCreateTime(String... names) throws FileNotFoundException {
		File file = getFile(names);
		requireNonExist(file.getAbsolutePath());
		try {
			Path path = Paths.get(file.getAbsolutePath());
			BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class,
					LinkOption.NOFOLLOW_LINKS);
			BasicFileAttributes attr = basicview.readAttributes();
			return attr.creationTime().toMillis();
		} catch (Exception e) {
			return file.lastModified();
		}
	}

	/**
	 * 创建文件，如果文件所在的目录不存在则一同创建
	 * 
	 * @param names the name elements
	 * @return the file
	 * @throws FileExistsException 这个文件已经存在
	 * @throws IOException         in case of an I/O error
	 */
	public static File createNewFile(String... names) throws IOException {
		File file = getFile(names);
		if (file.exists()) {
			throw new FileExistsException(file);
		} else {
			createDirectory(FilenameUtils.getFullPath(file.getAbsolutePath()));
			file.createNewFile();
		}
		return file;
	}

	/**
	 * <pre>
	 * 创建文件，如果文件所在目录不存在则一同创建。
	 * 如果这个文件已经存在则删除原文件并创建新文件
	 * </pre>
	 * 
	 * @param names the name elements
	 * @return the file
	 * @throws IOException in case of an I/O error
	 */
	public static final File createNewFileOverride(String... names) throws IOException {
		File file = getFile(names);
		if (file.exists()) {
			org.apache.commons.io.FileUtils.deleteQuietly(file);
		}
		createDirectory(FilenameUtils.getFullPath(file.getAbsolutePath()));
		file.createNewFile();
		return file;
	}

	/**
	 * <pre>
	 * 创建目录
	 * 如果目录存在则返回它本身
	 * 如果目录的抽象路径中的目录不存在则创建。
	 * </pre>
	 * 
	 * @param names the name elements
	 * @return the file
	 */
	public static File createDirectory(String... names) {
		File file = getFile(names);
		if (file.exists()) {
			return file;
		} else {
			file.mkdirs();
		}
		return file;
	}

	/**
	 * <pre>
	 * 创建目录
	 * 如果目录存在则删除目录内文件
	 * 如果目录的抽象路径中的目录不存在则创建
	 * </pre>
	 * 
	 * @param names the name elements
	 * @return the file
	 * @throws IOException in case of an I/O error
	 */
	public static File createDirectoryOverride(String... names) throws IOException {
		File file = getFile(names);
		if (file.exists()) {
			cleanDirectory(file);
		}
		return file;
	}

	/**
	 * 判断的文件是否存在
	 * 
	 * @param names the name elements
	 * @return <tt>true</tt> 文件存在
	 */
	public static boolean exists(String... names) {
		if (null == names) {
			return false;
		}
		return getFile(names).exists();
	}

	/**
	 * 从名称元素集构造一个文件
	 *
	 * @param names the name elements
	 * @return the file
	 * @see org.apache.commons.io.FileUtils#getFile
	 */
	public static File getFile(String... names) {
		if (null == names) {
			return null;
		}
		return org.apache.commons.io.FileUtils.getFile(names);
	}

	/**
	 * 清空目录内的所有文件
	 * 
	 * @param directory directory to clean
	 * @throws IOException              in case cleaning is unsuccessful
	 * @throws IllegalArgumentException if {@code directory} does not exist or is
	 *                                  not a directory
	 */
	public static void cleanDirectory(final File directory) throws IOException {
		if (!directory.exists()) {
			return;
		}
		org.apache.commons.io.FileUtils.cleanDirectory(directory);
	}

	/**
	 * 删除目录(包含目录内的所有文件)
	 *
	 * @param directory directory to delete
	 * @throws IOException              in case deletion is unsuccessful
	 * @throws IllegalArgumentException if {@code directory} does not exist or is
	 *                                  not a directory
	 */
	public static void deleteDirectory(final File directory) throws IOException {
		org.apache.commons.io.FileUtils.deleteDirectory(directory);
	}

	/**
	 * 安静的删除文件（支持目录、文件）
	 *
	 * @param file file or directory to delete, can be {@code null}
	 * @return {@code true} if the file or directory was deleted, otherwise
	 *         {@code false}
	 */
	public static boolean deleteQuietly(final File file) {
		return org.apache.commons.io.FileUtils.deleteQuietly(file);
	}

	/**
	 * 文件是否存在
	 * 
	 * @param filePath 文件路径
	 * @return the filePath
	 * @throws FileNotFoundException filePath的文件不存在
	 */
	public static String requireNonExist(String filePath) throws FileNotFoundException {
		if (!exists(filePath)) {
			throw new FileNotFoundException(filePath);
		}
		return filePath;
	}

	/**
	 * 文件是否存在
	 * 
	 * @param filePath 文件路径
	 * @param message  异常消息
	 * @return the filePath
	 * @throws FileNotFoundException filePath的文件不存在
	 */
	public static String requireNonExist(String filePath, String message) throws FileNotFoundException {
		if (!exists(filePath)) {
			throw new FileNotFoundException(message);
		}
		return filePath;
	}

	/**
	 * 字节记录显示大小
	 * 
	 * @param size          大小
	 * @param decimalDigits 小数位数
	 * @return a human-readable display value (includes units - TB, GB, MB, KB or
	 *         bytes)
	 */
	public static String byteCountToDisplaySize(long size, int decimalDigits) {
		double s = size;
		String unit;
		if (s < ONE_KB) {
			unit = "bytes";
		} else if (s < ONE_MB) {
			unit = "kb";
			s = s / ONE_KB;
		} else if (s < ONE_GB) {
			unit = "mb";
			s = s / ONE_MB;
		} else if (s < ONE_TB) {
			unit = "gb";
			s = s / ONE_GB;
		} else {
			unit = "tb";
			s = s / ONE_TB;
		}
		return String.format("%.2f", s) + unit;
	}

}
