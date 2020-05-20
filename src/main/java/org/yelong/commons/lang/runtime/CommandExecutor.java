/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.File;
import java.io.IOException;

/**
 * 命令执行
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月14日下午3:35:07
 * @version 1.3
 */
public interface CommandExecutor {

	/**
	 * 执行命令
	 * @date 2019年11月15日上午11:13:44
	 * @version 1.3
	 * @param command
	 * @return
	 * @throws Exception
	 */
	CommandExecuteResult execute(String command) throws CommandExecuteException , IOException;
	
	/**
	 * 在指定的目录下执行命令
	 * @date 2019年11月15日上午11:13:44
	 * @version 1.3
	 * @param command
	 * @param dir 指定的目录
	 * @return
	 * @throws Exception
	 */
	CommandExecuteResult execute(String command,File dir) throws CommandExecuteException , IOException;
	
}
