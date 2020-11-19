/**
 * 
 */
package org.yelong.commons.lang.process;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 抽象实现
 * 
 * @since 2.2
 */
public abstract class AbstractProcessManager implements ProcessManager {

	@Override
	public ProcessInfo getByPid(final Integer pid)
			throws ProcessManagerException, CommandExecuteException, IOException {
		if (Objects.isNull(pid))
			return null;
		List<ProcessInfo> processList = getAll();
		return processList.stream().filter(x -> {
			return x.getPid() == pid;
		}).findFirst().orElse(null);
	}

}
