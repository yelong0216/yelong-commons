/**
 * 
 */
package test.org.yelong.commons.lang.runtime;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.runtime.CommandExecuteResult;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * @author PengFei
 * @since
 */
public class CommandExecutorTest {
	
	public static final CommandExecutor commandExecutor = new DefaultCommandExecutor();
	
	@Test
	public void exec() throws Exception {
		CommandExecuteResult commandExecuteResult = commandExecutor.execute("ipconfig");
		String resultInfo = commandExecuteResult.getResultInfo();
		System.out.println(resultInfo);
		System.out.println(commandExecuteResult.getErrorInfo());
	}
	
	
	
	
}
