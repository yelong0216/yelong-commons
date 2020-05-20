/**
 * 
 */
package org.yelong.commons.lang.runtime;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月18日上午11:10:42
 * @version 1.3
 */
@FunctionalInterface
public interface ProcessStreamListener {

	/**
	 * @date 2019年11月18日上午11:13:16
	 * @version 1.3
	 * @param line 进程流每次读取的行信息
	 */
	void listening(String line);
	
}
