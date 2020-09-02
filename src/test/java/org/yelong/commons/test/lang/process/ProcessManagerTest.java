/**
 * 
 */
package org.yelong.commons.test.lang.process;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ApplicationProcessUtils;
import org.yelong.commons.lang.process.ProcessManager;
import org.yelong.commons.lang.process.impl.WindowsProcessManager;
import org.yelong.commons.test.lang.runtime.CommandExecutorTest;

public class ProcessManagerTest {
	
	public static final  ProcessManager processManager = new WindowsProcessManager(CommandExecutorTest.commandExecutor);
	
	
	@Test
	public void killThis() throws Exception {
		boolean killOneself = ApplicationProcessUtils.killOneself();
		System.out.println(killOneself);
		System.out.println("哈哈");
	}
	
}
