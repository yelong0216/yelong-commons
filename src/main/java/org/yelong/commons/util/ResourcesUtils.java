/**
 * 
 */
package org.yelong.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author PengFei
 * @since 1.0.4
 */
public final class ResourcesUtils {
	
	private ResourcesUtils() {}

	/**
	 * 获取资源的流
	 * @param properties
	 * @return
	 * @throws FileNotFoundException
	 */
	public static InputStream getResourceAsStream(String resource) throws FileNotFoundException {
		Class<?> c = PropertiesUtils.class;
		InputStream is = null;
		if(resource.contains(":"))
			is = new FileInputStream(new File(resource));
		if(null == is)
			is = c.getResourceAsStream(resource);
		if(null == is)
			is = ClassLoader.getSystemResourceAsStream(resource);
		if(null == is)
			is = c.getClassLoader().getResourceAsStream(resource);
		if(null == is)
			is = c.getClassLoader().getResourceAsStream("resources/"+resource);
		if(null == is)
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		return is;
	}
	
}
