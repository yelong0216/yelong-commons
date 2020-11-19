/**
 * 
 */
package org.yelong.commons.lang.process.impl;

import org.yelong.commons.lang.runtime.CommandExecutor;

/**
 * windows 程序管理
 * 
 * @since 1.1
 * @see org.yelong.commons.lang.process.impl.windows.WindowsProcessManager
 */
@Deprecated
public class WindowsProcessManager extends org.yelong.commons.lang.process.impl.windows.WindowsProcessManager {

	public WindowsProcessManager() {
		super();
	}

	public WindowsProcessManager(final CommandExecutor commandExecutor) {
		super(commandExecutor);
	}

}
