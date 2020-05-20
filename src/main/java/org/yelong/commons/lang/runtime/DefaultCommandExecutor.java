/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.File;
import java.io.IOException;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月14日下午3:36:40
 * @version 1.3
 */
public class DefaultCommandExecutor  implements CommandExecutor{

	@Override
	public CommandExecuteResult execute(String command) throws CommandExecuteException, IOException {
		Process process = Runtime.getRuntime().exec(command);
		return new CommandExecuteResult(process);
	}
	
	@Override
	public CommandExecuteResult execute(String command, File dir) throws CommandExecuteException, IOException {
		Process process = Runtime.getRuntime().exec(command,null,dir);
		return new CommandExecuteResult(process);
	}
	
}
