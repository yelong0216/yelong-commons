/**
 * 
 */
package org.yelong.commons.lang.netstat.impl.windows;

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
 * windows 实现
 * 
 * @since 2.2
 */
public class WindowsNetstatManager extends AbstractNetstatManager {

	protected final CommandExecutor commandExecutor;

	public WindowsNetstatManager() {
		this(DefaultCommandExecutor.INSTANCE);
	}

	public WindowsNetstatManager(CommandExecutor commandExecutor) {
		this.commandExecutor = Objects.requireNonNull(commandExecutor);
	}

	@Override
	public List<NetstatInfo> getAll() throws NetstatManageException, CommandExecuteException, IOException {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("netstat -ano");
		StringBuilder resultInfo = new StringBuilder(commandExecuteResult.getResultInfo());
		// 删除前四行
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		resultInfo.delete(0, resultInfo.indexOf("\n") + 1);
		// 每一行的端口信息。（一般有两行，我们取一行）
		String[] netstatInfos = resultInfo.toString().split("\n");
		List<NetstatInfo> netstatList = new ArrayList<>(netstatInfos.length);
		for (String netstatStr : netstatInfos) {
			// 每一行信息通过空格获取每一个信息。
			// 转换成可操作的集合
			List<String> netstatInfo = new ArrayList<>(Arrays.asList(netstatStr.split(" ")));
			// 移除所有空白符号
			netstatInfo.removeIf(StringUtils::isBlank);
			NetstatInfo netstat = new NetstatInfo();
			// 第一个是协议
			netstat.setProto(netstatInfo.get(0));
			// 获取最后一个是pid
			netstat.setPid(Integer.valueOf(netstatInfo.get(netstatInfo.size() - 1)));
			// 第二个是ip和端口
			String localAddres = netstatInfo.get(1);
			netstat.setLocalAddress(localAddres);
			netstat.setPort(Integer.valueOf(localAddres.substring(localAddres.lastIndexOf(":") + 1)));
			netstat.setForeignAddress(netstatInfo.get(2));
			netstatList.add(netstat);
		}
		return netstatList;
	}

}
