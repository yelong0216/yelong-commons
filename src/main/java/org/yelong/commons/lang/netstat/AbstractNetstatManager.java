/**
 * 
 */
package org.yelong.commons.lang.netstat;

import java.io.IOException;
import java.util.Objects;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 抽象实现
 * 
 * @since 2.2
 */
public abstract class AbstractNetstatManager implements NetstatManager {

	@Override
	public NetstatInfo getByPort(Integer port) throws NetstatManageException, CommandExecuteException, IOException {
		if (Objects.isNull(port))
			return null;
		return getAll().stream().filter(x -> x.getPort().equals(port)).findFirst().orElse(null);
	}

	@Override
	public NetstatInfo getByPid(Integer pid) throws NetstatManageException, CommandExecuteException, IOException {
		if (Objects.isNull(pid))
			return null;
		return getAll().stream().filter(x -> x.getPid().equals(pid)).findFirst().orElse(null);
	}

}
