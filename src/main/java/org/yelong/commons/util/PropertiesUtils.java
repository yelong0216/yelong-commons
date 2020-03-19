/**
 * 
 */
package org.yelong.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PengFei
 */
public class PropertiesUtils {

	/**
	 * 加载properties
	 * @param properties 资源路径
	 * @return {@link Properties}
	 */
	public static Properties load(String properties){
		return load(new Properties(), properties);
	}
	
	/**
	 * 对props加载properties资源
	 * @param props {@link Properties}
	 * @param properties 资源路径
	 * @return {@link Properties}
	 */
	public static Properties load(Properties props , String properties){
		Class<?> c = PropertiesUtils.class;
		try {
			InputStream inStream = null;
			if(properties.contains(":"))
				inStream = new FileInputStream(new File(properties));
			if(null == inStream)
				inStream = c.getResourceAsStream(properties);
			if(null == inStream)
				inStream = ClassLoader.getSystemResourceAsStream(properties);
			if(null == inStream)
				inStream = c.getClassLoader().getResourceAsStream(properties);
			if(null == inStream)
				inStream = c.getClassLoader().getResourceAsStream("resources/"+properties);
			if(null == inStream)
				inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(properties);
			if(null != inStream){
				props.load(inStream);
				inStream.close();
			}else{
				throw new RuntimeException("未找到配置文件："+properties);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}
