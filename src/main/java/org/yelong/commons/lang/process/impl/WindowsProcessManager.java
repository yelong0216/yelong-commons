/**
 * 
 */
package org.yelong.commons.lang.process.impl;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.process.ProcessManager;
import org.yelong.commons.lang.process.ProcessManagerException;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;

/**
 * @author PengFei
 *
 */
public class WindowsProcessManager implements ProcessManager {

	private final CommandExecutor commandExecutor;

	public WindowsProcessManager(final CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

	@Override
	public boolean killProcess(int pid) throws ProcessManagerException {
		try {
			CommandExecuteResult commandExecuteResult = commandExecutor.execute("taskkill /pid " + pid + " /f");
			return StringUtils.isBlank(commandExecuteResult.getErrorInfo());
		} catch (Exception e) {
			throw new ProcessManagerException(e);
		}
	}

}
