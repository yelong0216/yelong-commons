/**
 * 
 */
package org.yelong.commons.lang.process.impl.unix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.process.AbstractProcessManager;
import org.yelong.commons.lang.process.ProcessInfo;
import org.yelong.commons.lang.process.ProcessManagerException;
import org.yelong.commons.lang.runtime.CommandExecuteException;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * UNIX实现
 * 
 * @since 2.2
 */
public class UnixProcessManager extends AbstractProcessManager {

	private final CommandExecutor commandExecutor = DefaultCommandExecutor.INSTANCE;

	@Override
	public boolean killProcess(int pid) throws ProcessManagerException, CommandExecuteException, IOException {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("kill -s 9 " + pid);
		return StringUtils.isEmpty(commandExecuteResult.getErrorInfo());
	}

	@Override
	public List<ProcessInfo> getAll() throws ProcessManagerException, CommandExecuteException, IOException {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("ps -ef");
		String resultInfo = commandExecuteResult.getResultInfo();
		List<String> processInfoLines = new ArrayList<String>(Arrays.asList(resultInfo.split("\n")));
		// 移除前一排
		processInfoLines.remove(0);
		List<ProcessInfo> processInfoList = new ArrayList<ProcessInfo>(processInfoLines.size());
		for (String processInfoLine : processInfoLines) {
			List<String> valueList = new ArrayList<>(Arrays.asList(processInfoLine.split(" ")));
			valueList.removeIf(StringUtils::isBlank);
			ProcessInfo processInfo = new ProcessInfo();
			processInfo.setPid(Integer.valueOf(valueList.get(2)));
			processInfoList.add(processInfo);
		}
		return processInfoList;
	}

}
