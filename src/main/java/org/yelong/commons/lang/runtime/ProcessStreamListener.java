/**
 * 
 */
package org.yelong.commons.lang.runtime;

/**
 * 程序执行后的结果流监听
 * 
 * @since 1.1
 */
@FunctionalInterface
public interface ProcessStreamListener {

	/**
	 * @param line 进程流每次读取的行信息
	 */
	void listening(String line);

}
