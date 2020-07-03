/**
 * 
 */
package org.yelong.commons.lang.process;

/**
 * 程序管理异常
 * 
 * @author PengFei
 * @since 1.0.4
 */
public class ProcessManagerException extends Exception {

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
