/**
 * 
 */
package org.yelong.commons.lang.process;

/**
 * 进程信息
 * 
 * @since 2.2
 */
public class ProcessInfo {

	private String name;

	private int pid;

	private String sessionName;

	private String session;

	/** 占用内存：kb */
	private String internalStorage;

	private String cmd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getInternalStorage() {
		return internalStorage;
	}

	public void setInternalStorage(String internalStorage) {
		this.internalStorage = internalStorage;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public String toString() {
		return "ProcessInfo [name=" + name + ", pid=" + pid + ", sessionName=" + sessionName + ", session=" + session
				+ ", internalStorage=" + internalStorage + ", cmd=" + cmd + "]";
	}

}
