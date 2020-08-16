/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.File;
import java.io.IOException;

/**
 * 默认的命令执行器
 * 
 * @since 1.1
 */
public class DefaultCommandExecutor implements CommandExecutor {

	@Override
	public CommandExecuteResult execute(String command) throws CommandExecuteException, IOException {
		Process process = Runtime.getRuntime().exec(command);
		return new CommandExecuteResult(process);
	}

	@Override
	public CommandExecuteResult execute(String command, File dir) throws CommandExecuteException, IOException {
		Process process = Runtime.getRuntime().exec(command, null, dir);
		return new CommandExecuteResult(process);
	}

}
