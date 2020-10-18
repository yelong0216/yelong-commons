/**
 * 
 */
package org.yelong.commons.util;

import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

/**
 * 资源工具类
 * 
 * @since 1.1
 */
public final class ResourcesUtils {

	private ResourcesUtils() {
	}

	// ==================================================获取资源流==================================================

	/**
	 * @see #getResourceAsStream(String, ClassLoader, Class)
	 */
	public static InputStream getResourceAsStream(String resource) {
		return getResourceAsStream(resource, Thread.currentThread().getContextClassLoader(), ResourcesUtils.class);
	}

	/**
	 * @see #getResourceAsStream(String, ClassLoader, Class)
	 */
	public static InputStream getResourceAsStream(String resource, ClassLoader classLoader) {
		return getResourceAsStream(resource, classLoader, ResourcesUtils.class);
	}

	/**
	 * @see #getResourceAsStream(String, ClassLoader, Class)
	 */
	public static InputStream getResourceAsStream(String resource, Class<?> cls) {
		return getResourceAsStream(resource, Thread.currentThread().getContextClassLoader(), cls);
	}

	/**
	 * 获取资源的流。 获取顺序： 1、{@link ClassLoader#getSystemResourceAsStream(String)}
	 * 2、{@link ClassLoader#getResourceAsStream(String)}
	 * 3、{@link Class#getResourceAsStream(String)}
	 * 
	 * @param resource    资源文件路径。允许为null
	 * @param classLoader 类加载器。允许为null
	 * @param cls         类。允许为null
	 * @return 资源流
	 */
	public static InputStream getResourceAsStream(String resource, ClassLoader classLoader, Class<?> cls) {
		if (StringUtils.isBlank(resource)) {
			return null;
		}

		InputStream is = null;
		if (null == is)
			is = ClassLoader.getSystemResourceAsStream(resource);

		if (null == is && null != classLoader) {
			is = classLoader.getResourceAsStream(resource);
		}

		if (null == is && null != cls) {
			is = cls.getResourceAsStream(resource);
		}
		return is;
	}

}
