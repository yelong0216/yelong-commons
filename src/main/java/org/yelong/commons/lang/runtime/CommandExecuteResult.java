/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 命令执行结果
 */
public class CommandExecuteResult {

	private final Process process;

	private String resultInfo;

	private String errorInfo;

	private String charsetName = "GBK";

	public CommandExecuteResult(Process process) {
		this.process = process;
	}

	public Process getProcess() throws Exception {
		return this.process;
	}

	public String getResultInfo() throws Exception {
		if (null == resultInfo) {
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
			StringBuilder result = new StringBuilder();
			String line;
			while ((line = input.readLine()) != null) {
				result.append(line + "\n");
			}
			resultInfo = result.toString();
		}
		return resultInfo;
	}

	public String getErrorInfo() throws Exception {
		if (null == errorInfo) {
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
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
	 * 
	 * @date 2019年11月18日上午11:39:40
	 * @version 1.3
	 * @return
	 */
	public ProcessStreamManager createProcessStreamManage() {
		ProcessStreamManager processStreamManager = new ProcessStreamManager(process);
		processStreamManager.setCharsetName(charsetName);
		return processStreamManager;
	}

}
