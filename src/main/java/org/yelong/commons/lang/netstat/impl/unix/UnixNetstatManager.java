/**
 * 
 */
package org.yelong.commons.lang.netstat.impl.unix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.netstat.AbstractNetstatManager;
import org.yelong.commons.lang.netstat.NetstatInfo;
import org.yelong.commons.lang.netstat.NetstatManageException;
import org.yelong.commons.lang.runtime.CommandExecuteException;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * unix实现
 * 
 * @since 2.2
 */
public class UnixNetstatManager extends AbstractNetstatManager {

	protected final CommandExecutor commandExecutor;

	public UnixNetstatManager() {
		this(DefaultCommandExecutor.INSTANCE);
	}

	public UnixNetstatManager(CommandExecutor commandExecutor) {
		this.commandExecutor = Objects.requireNonNull(commandExecutor);
	}

	@Override
	public List<NetstatInfo> getAll() throws NetstatManageException, CommandExecuteException, IOException {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("netstat -tlnp");
		String resultInfo = commandExecuteResult.getResultInfo();
		List<String> netStatInfoLines = new ArrayList<String>(Arrays.asList(resultInfo.split("\n")));
		// 移除前两排
		netStatInfoLines.remove(0);
		netStatInfoLines.remove(0);
		List<NetstatInfo> netstatInfoList = new ArrayList<NetstatInfo>(netStatInfoLines.size());
		for (String netStatInfoLine : netStatInfoLines) {
			List<String> netStatInfo = new ArrayList<String>(Arrays.asList(netStatInfoLine.split(" ")));
			netStatInfo.removeIf(StringUtils::isBlank);
			NetstatInfo netstat = new NetstatInfo();
			netstat.setProto(netStatInfo.get(0));
			String localAddres = netStatInfo.get(3);
			netstat.setLocalAddress(localAddres);
			netstat.setPort(Integer.valueOf(localAddres.substring(localAddres.lastIndexOf(":") + 1)));
			netstat.setForeignAddress(netStatInfo.get(4));
			netstat.setState(netStatInfo.get(5));
			String pidAndProgramName = netStatInfo.get(6);
			netstat.setPid(Integer.valueOf(pidAndProgramName.substring(0, pidAndProgramName.indexOf("/"))));
			netstat.setProgramName(pidAndProgramName.substring(pidAndProgramName.indexOf("/") + 1));
			netstatInfoList.add(netstat);
		}
		return netstatInfoList;
	}

}
