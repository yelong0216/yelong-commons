/**
 * 
 */
package org.yelong.commons.lang.process;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 程序管理异常
 * 
 * @since 1.1
 */
public class ProcessManagerException extends CommandExecuteException {

	private static final long serialVersionUID = 8054543505641995866L;

	public ProcessManagerException() {

	}

	public ProcessManagerException(String message) {
		super(message);
	}

	public ProcessManagerException(Throwable t) {
		super(t);
	}

	public ProcessManagerException(String message, Throwable t) {
		super(message, t);
	}

}
