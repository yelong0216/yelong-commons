/**
 * 
 */
package test.org.yelong.commons.lang.process;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ApplicationProcessUtils;
import org.yelong.commons.lang.process.ProcessCommandExecutor;
import org.yelong.commons.lang.process.ProcessInfo;
import org.yelong.commons.lang.process.ProcessManager;
import org.yelong.commons.lang.process.WindowsProcessCommandExecutor;
import org.yelong.commons.lang.process.impl.WindowsProcessManager;
import org.yelong.test.ObjectTests;

import test.org.yelong.commons.lang.runtime.CommandExecutorTest;

public class ProcessManagerTest {

	public static final ProcessManager processManager = new WindowsProcessManager(CommandExecutorTest.commandExecutor);

	ProcessCommandExecutor processCommandExecutor = new WindowsProcessCommandExecutor();

	@Test
	public void killThis() throws Exception {
		boolean killOneself = ApplicationProcessUtils.killOneself();
		System.out.println(killOneself);
		System.out.println("哈哈");
	}

	@Test
	public void getAll() throws Exception {
		List<ProcessInfo> all = processCommandExecutor.getAll();
		for (ProcessInfo processInfo : all) {
			ObjectTests.printAllField(processInfo);
		}
	}

}
