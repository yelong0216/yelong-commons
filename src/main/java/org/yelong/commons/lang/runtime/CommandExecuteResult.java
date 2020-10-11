/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 命令执行结果
 * 
 * @since 1.1
 */
public class CommandExecuteResult {

	private final Process process;

	private String resultInfo;

	private String errorInfo;

	private String charsetName = "GBK";

	public CommandExecuteResult(Process process) {
		this.process = process;
	}

	public Process getProcess() {
		return this.process;
	}

	public String getResultInfo() throws IOException {
		if (null == resultInfo) {
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), charsetName));
			StringBuilder result = new StringBuilder();
			String line;
			while ((line = input.readLine()) != null) {
				result.append(line + "\n");
			}
			resultInfo = result.toString();
		}
		return resultInfo;
	}

	public String getErrorInfo() throws IOException {
		if (null == errorInfo) {
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getErrorStream(), charsetName));
			StringBuilder error = new StringBuilder();
			String line;
			while ((line = input.readLine()) != null) {
				error.append(line + "\n");
			}
			errorInfo = error.toString();
		}
		return errorInfo;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public String getCharsetName() {
		return charsetName;
	}

	/**
	 * 创建进程流管理
	 */
	public ProcessStreamManager createProcessStreamManage() {
		ProcessStreamManager processStreamManager = new ProcessStreamManager(process);
		processStreamManager.setCharsetName(charsetName);
		return processStreamManager;
	}

}
