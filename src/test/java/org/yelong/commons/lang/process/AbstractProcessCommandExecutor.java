/**
 * 
 */
package org.yelong.commons.lang.process;

import java.util.List;
import java.util.Objects;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月14日下午4:56:37
 * @version 1.3
 */
public abstract class AbstractProcessCommandExecutor implements ProcessCommandExecutor{

	@Override
	public ProcessInfo getByPid(final Integer pid) throws Exception {
		if(Objects.isNull(pid))return null;
		List<ProcessInfo> processList = getAll();
		return processList.stream().filter(x-> {
			return x.getPid() == pid;
		}).findFirst().orElse(null);
	}
	
}
