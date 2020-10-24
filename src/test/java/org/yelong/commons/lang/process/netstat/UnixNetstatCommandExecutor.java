/**
 * 
 */
package org.yelong.commons.lang.process.netstat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日下午12:07:12
 * @version 1.3
 */
public class UnixNetstatCommandExecutor extends AbstractNetstatCommandExecutor implements NetstatCommandExecutor{

	private final CommandExecutor commandExecutor = DefaultCommandExecutor.INSTANCE;

	@Override
	public List<NetstatInfo> getAll() throws Exception {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("netstat -tlnp");
		String resultInfo = commandExecuteResult.getResultInfo();
		List<String> netStatInfoLines = new ArrayList<String>(Arrays.asList(resultInfo.split("\n")));
		//移除前两排
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
			netstat.setPort(Integer.valueOf(localAddres.substring(localAddres.lastIndexOf(":")+1)));
			netstat.setForeignAddress(netStatInfo.get(4));
			netstat.setState(netStatInfo.get(5));
			String pidAndProgramName = netStatInfo.get(6);
			netstat.setPid(Integer.valueOf(pidAndProgramName.substring(0, pidAndProgramName.indexOf("/"))));
			netstat.setProgramName(pidAndProgramName.substring(pidAndProgramName.indexOf("/")+1));
			netstatInfoList.add(netstat);
		}
		return netstatInfoList;
	}

}
