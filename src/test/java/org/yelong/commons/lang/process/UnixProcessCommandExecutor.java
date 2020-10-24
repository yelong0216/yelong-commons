/**
 * 
 */
package org.yelong.commons.lang.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日上午11:37:16
 * @version 1.3
 */
public class UnixProcessCommandExecutor extends AbstractProcessCommandExecutor {

	private final CommandExecutor commandExecutor = DefaultCommandExecutor.INSTANCE;

	@Override
	public boolean killByPid(Integer pid) throws Exception {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("kill -s 9 " + pid);
		return StringUtils.isEmpty(commandExecuteResult.getErrorInfo());
	}

	@Override
	public List<ProcessInfo> getAll() throws Exception {
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
