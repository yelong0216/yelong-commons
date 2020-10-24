package test.org.yelong.commons.lang.process.netstat;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.process.netstat.NetstatCommandExecutor;
import org.yelong.commons.lang.process.netstat.NetstatCommandExecutorFactory;
import org.yelong.commons.lang.process.netstat.NetstatInfo;

public class NetstatTest {

	@Test
	public void test() throws Exception {
		NetstatCommandExecutor netstatCommandExecutor = NetstatCommandExecutorFactory.getNetstatCommandExecutor();
		NetstatInfo netstatInfo = netstatCommandExecutor.getByPort(12511);
		System.out.println(netstatInfo);
	}

}
