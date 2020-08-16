/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.File;
import java.io.IOException;

/**
 * 命令执行器
 * 
 * @since 1.1
 */
public interface CommandExecutor {

	/**
	 * 执行命令
	 * 
	 * @param command 命令，如window在黑窗口输入的命令
	 * @return 命令执行结果
	 * @throws CommandExecuteException 命令执行异常
	 * @throws IOException             流异常
	 */
	CommandExecuteResult execute(String command) throws CommandExecuteException, IOException;

	/**
	 * 在指定的目录下执行命令
	 * 
	 * @param command 命令，如window在黑窗口输入的命令
	 * @param dir     指定的目录
	 * @return 命令执行结果
	 * @throws CommandExecuteException 命令执行异常
	 * @throws IOException             流异常
	 */
	CommandExecuteResult execute(String command, File dir) throws CommandExecuteException, IOException;

}
