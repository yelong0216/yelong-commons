/**
 * 
 */
package test.org.yelong.commons.lang.process;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ApplicationProcessUtils;
import org.yelong.commons.lang.netstat.NetstatManageException;
import org.yelong.commons.lang.netstat.NetstatManager;
import org.yelong.commons.lang.netstat.impl.windows.WindowsNetstatManager;
import org.yelong.commons.lang.process.ProcessInfo;
import org.yelong.commons.lang.process.ProcessManager;
import org.yelong.commons.lang.process.impl.windows.WindowsProcessManager;
import org.yelong.commons.lang.runtime.CommandExecuteException;
import org.yelong.test.ObjectTests;

import test.org.yelong.commons.lang.runtime.CommandExecutorTest;

public class ProcessManagerTest {

	public static final ProcessManager processManager = new WindowsProcessManager(CommandExecutorTest.commandExecutor);

	public static final NetstatManager netstatManager = new WindowsNetstatManager();
	
	@Test
	public void killThis() throws Exception {
		boolean killOneself = ApplicationProcessUtils.killOneself();
		System.out.println(killOneself);
		System.out.println("哈哈");
	}

	@Test
	public void getAll() throws Exception {
		List<ProcessInfo> all = processManager.getAll();
		for (ProcessInfo processInfo : all) {
			ObjectTests.printAllField(processInfo);
		}
	}

	@Test
	public void netstat() throws NetstatManageException, CommandExecuteException, IOException {
		Integer pid = netstatManager.getPidByPort(21600);
		System.out.println(pid);
		ProcessInfo processInfo = processManager.getByPid(pid);
		System.out.println(processInfo);
	}
	
}
