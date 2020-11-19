package org.yelong.commons.lang.runtime;

/**
 * 命令执行异常
 * 
 * @since 1.1
 */
public class CommandExecuteException extends Exception {

	private static final long serialVersionUID = -7820161673235998138L;

	public CommandExecuteException() {
		super();
	}

	public CommandExecuteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandExecuteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandExecuteException(String message) {
		super(message);
	}

	public CommandExecuteException(Throwable cause) {
		super(cause);
	}

}
