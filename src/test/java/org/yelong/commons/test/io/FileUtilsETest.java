/**
 * 
 */
package org.yelong.commons.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.yelong.commons.io.FileUtilsE;
import org.yelong.commons.util.Dates;

/**
 * @see FileUtilsE
 */
public class FileUtilsETest {

	@Test
	public void getFileCreateTime() {
		Long dateLong = null;
		try {
			dateLong = FileUtilsE.getFileCreateTime("C:\\temp\\temp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (null == dateLong) {
			System.out.println("获取时间失败！");
			return;
		}
		Date date = new Date(dateLong);
		System.out.println(DateFormatUtils.format(date, Dates.YYYY_MM_DD_HH_MM_SS));
	}

	@Test
	public void createNewFile() throws IOException {
		FileUtils.deleteQuietly(FileUtilsE.getFile("C:\\temp\\temp-java-create-test.txt"));
		File file = FileUtilsE.createNewFile("C:\\temp\\temp-java-create-test.txt");
		System.out.println(file);
		System.out.println(file.exists());
		FileUtils.deleteQuietly(FileUtilsE.getFile("C:\\temp\\temp-java-create-test.txt"));
	}

	@Test
	public void createNewFileOverride() throws IOException {
		File file = FileUtilsE.createNewFileOverride("C:\\temp\\temp-java-create-test.txt");
		System.out.println(file);
		System.out.println(file.exists());
		FileUtils.deleteQuietly(FileUtilsE.getFile("C:\\temp\\temp-java-create-test.txt"));
	}

	@Test
	public void createDirectory() throws IOException {
		File file = FileUtilsE.createDirectory("C:\\temp\\temp-java-create-test-dir");
		System.out.println(file);
		System.out.println(file.exists());
		FileUtilsE.deleteQuietly(FileUtils.getFile("C:\\temp\\temp-java-create-test-dir"));
	}

	@Test
	public void createDirectoryOverride() throws IOException {
		File file = FileUtilsE.createDirectoryOverride("C:\\temp\\temp-java-create-test-dir");
		System.out.println(file);
		System.out.println(file.exists());
	}

	@Test
	public void exists() throws IOException {
		boolean exist = FileUtilsE.exists("C:\\temp\\temp-java-create-test-dir");
		System.out.println(exist);
	}

	@Test
	public void getFile() throws IOException {
		File file = FileUtilsE.getFile("C:\\temp\\temp-java-create-test-dir");
		System.out.println(file);
		System.out.println(file.exists());
	}

	@Test
	public void cleanDirectory() throws IOException {
		FileUtilsE.cleanDirectory(FileUtilsE.getFile("C:\\temp\\temp-java-create-test-dir"));
	}

	@Test
	public void deleteDirectory() throws IOException {
		FileUtilsE.deleteDirectory(FileUtilsE.getFile("C:\\temp\\temp-java-create-test-dir"));
	}

	@Test
	public void deleteQuietly() throws IOException {
		FileUtilsE.deleteQuietly(FileUtilsE.getFile("C:\\temp\\temp-java-create-test-dir"));
	}

	@Test
	public void requireNonExist() throws IOException {
		try {
			FileUtilsE.requireNonExist("C:\\temp\\temp-java-create-test-dir");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void byteCountToDisplaySize() {
		System.out.println(FileUtilsE.byteCountToDisplaySize(4513165L, 2));
	}

}
