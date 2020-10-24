/**
 * 
 */
package org.yelong.commons.lang.process.netstat;

import java.util.Objects;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日下午12:07:49
 * @version 1.3
 */
public abstract class AbstractNetstatCommandExecutor implements NetstatCommandExecutor {

	@Override
	public NetstatInfo getByPort(Integer port) throws Exception {
		if (Objects.isNull(port))
			return null;
		return getAll().stream().filter(x -> x.getPort().equals(port)).findFirst().orElse(null);
	}

	@Override
	public NetstatInfo getByPid(Integer pid) throws Exception {
		if (Objects.isNull(pid))
			return null;
		return getAll().stream().filter(x -> x.getPid().equals(pid)).findFirst().orElse(null);
	}

}
