/**
 * 
 */
package test.org.yelong.commons.pojo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.yelong.commons.pojo.POJOUtils;

import test.org.yelong.Student;

/**
 *
 */
public class POJOUtilsTest {

	Student student = new Student();
	{
		student.setId("123456");
		student.setCreateTime(new Date());
		student.setName("鵬飛");
		student.setAge(10);
	}
	
	@Test
	public void getValue() throws IllegalAccessException {
		Object value = POJOUtils.getValue(student, "id");
		System.out.println(value);
		Object value1 = POJOUtils.getValue(student, "aAb");
		System.out.println(value1);
		Object value2 = POJOUtils.getValue(student, "aAb","456");
		System.out.println(value2);
	}
	
	@Test
	public void setValue() throws IllegalAccessException {
		POJOUtils.setValue(student, "id","asdfdsf");
		Object value = POJOUtils.getValue(student, "id");
		System.out.println(value);
	}
}
