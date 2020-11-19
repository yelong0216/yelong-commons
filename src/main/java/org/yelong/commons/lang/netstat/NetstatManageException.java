package org.yelong.commons.lang.netstat;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 网络状态管理异常
 * 
 * @since 2.2
 */
public class NetstatManageException extends CommandExecuteException {

	private static final long serialVersionUID = 7738014385383156674L;

	public NetstatManageException() {
		super();
	}

	public NetstatManageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NetstatManageException(String message, Throwable cause) {
		super(message, cause);
	}

	public NetstatManageException(String message) {
		super(message);
	}

	public NetstatManageException(Throwable cause) {
		super(cause);
	}

}
