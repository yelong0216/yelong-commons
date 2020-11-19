/**
 * 
 */
package org.yelong.commons.lang.process.impl.windows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.StringUtilsE;
import org.yelong.commons.lang.process.AbstractProcessManager;
import org.yelong.commons.lang.process.ProcessInfo;
import org.yelong.commons.lang.process.ProcessManagerException;
import org.yelong.commons.lang.runtime.CommandExecuteException;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * windows 实现
 * 
 * @since 2.2
 */
public class WindowsProcessManager extends AbstractProcessManager {

	protected final CommandExecutor commandExecutor;

	public WindowsProcessManager() {
		this(DefaultCommandExecutor.INSTANCE);
	}

	public WindowsProcessManager(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

	@Override
	public boolean killProcess(int pid) throws ProcessManagerException, CommandExecuteException, IOException {
		if (Objects.isNull(pid))
			return false;
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("taskkill /pid " + pid + " /f");
		return StringUtils.isEmpty(commandExecuteResult.getErrorInfo());
	}

	@Override
	public List<ProcessInfo> getAll() throws ProcessManagerException, CommandExecuteException, IOException {
		Process process = Runtime.getRuntime().exec("tasklist");
		CommandExecuteResult commandExecuteResult = new CommandExecuteResult(process);
		StringBuilder resultInfo = new StringBuilder(commandExecuteResult.getResultInfo());
		List<ProcessInfo> processInfoList = new ArrayList<ProcessInfo>(
				StringUtilsE.containCount(resultInfo.toString(), "\n") - 2);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		String[] lines = resultInfo.toString().split("\n");
		for (String oneLine : lines) {
			List<String> valueList = Arrays.asList(oneLine.split(" "));
			valueList = new ArrayList<>(valueList);
			valueList.removeIf(StringUtils::isBlank);
			int listSize = valueList.size();
			ProcessInfo processInfo = new ProcessInfo();
			processInfo.setInternalStorage(valueList.get(listSize - 2) + valueList.get(listSize - 1));
			processInfo.setSession(valueList.get(listSize - 3));
			processInfo.setSessionName(valueList.get(listSize - 4));
			processInfo.setPid(Integer.valueOf(valueList.get(listSize - 5)));
			String name = "";
			for (int i = 0; i < valueList.size() - 5 - 1; i++) {
				name += valueList.get(i);
			}
			processInfo.setName(name);
			processInfoList.add(processInfo);
		}
		return processInfoList;
	}

}
