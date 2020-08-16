/**
 * 
 */
package org.yelong.test.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.yelong.Student;
import org.yelong.test.ObjectTests;

/**
 * @author YL
 *
 */
public class ObjectTestsTest {

	@Test
	public void printAllField() {
		Student student = new Student();
		student.setId("123456");
		student.setCreateTime(new Date());
		student.setName("鵬飛");
		student.setAge(10);
		ObjectTests.printAllField(student);
	}

}
