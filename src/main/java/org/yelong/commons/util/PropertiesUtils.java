/**
 * 
 */
package org.yelong.commons.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PengFei
 */
public final class PropertiesUtils {
	
	private PropertiesUtils() {}

	/**
	 * 加载properties
	 * @param properties 资源路径
	 * @return {@link Properties}
	 */
	public static Properties load(String resource){
		return load(new Properties(), resource);
	}

	/**
	 * 对props加载properties资源
	 * @param props {@link Properties}
	 * @param properties 资源路径
	 * @return {@link Properties}
	 */
	public static Properties load(Properties props , String resource){
		try {
			InputStream inStream = ResourcesUtils.getResourceAsStream(resource);
			if(null != inStream){
				props.load(inStream);
				inStream.close();
			}else{
				throw new RuntimeException("未找到配置文件："+resource);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}


}
