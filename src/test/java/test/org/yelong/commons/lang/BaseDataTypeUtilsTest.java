/**
 * 
 */
package test.org.yelong.commons.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.BaseDataTypeUtils;

/**
 *
 */
public class BaseDataTypeUtilsTest {

	@Test
	public void getWrapperType() {
		System.out.println(BaseDataTypeUtils.getWrapperType("byte"));
		System.out.println(BaseDataTypeUtils.getWrapperType("short"));
		System.out.println(BaseDataTypeUtils.getWrapperType("int"));
		System.out.println(BaseDataTypeUtils.getWrapperType("long"));
		System.out.println(BaseDataTypeUtils.getWrapperType("boolean"));
		System.out.println(BaseDataTypeUtils.getWrapperType("double"));
		System.out.println(BaseDataTypeUtils.getWrapperType("float"));
		System.out.println(BaseDataTypeUtils.getWrapperType("char"));
		System.out.println(BaseDataTypeUtils.getWrapperType("String"));
	}

	@Test
	public void getBaseDataType() {
		System.out.println(BaseDataTypeUtils.getBaseDataType(Byte.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Short.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Integer.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Long.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Boolean.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Double.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Float.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(Character.class));
		System.out.println(BaseDataTypeUtils.getBaseDataType(String.class));
	}

	@Test
	public void isBaseDataType() {
		System.out.println(BaseDataTypeUtils.isBaseDataType("byte"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("short"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("int"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("long"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("boolean"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("double"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("float"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("char"));
		System.out.println(BaseDataTypeUtils.isBaseDataType("String"));
	}

	@Test
	public void isWrapperType() {
		System.out.println(BaseDataTypeUtils.isWrapperType(Byte.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Short.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Integer.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Long.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Boolean.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Double.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Float.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(Character.class));
		System.out.println(BaseDataTypeUtils.isWrapperType(String.class));
	}

}
