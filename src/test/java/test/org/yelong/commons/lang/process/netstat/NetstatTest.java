package test.org.yelong.commons.lang.process.netstat;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.netstat.NetstatInfo;
import org.yelong.commons.lang.netstat.NetstatManager;
import org.yelong.commons.lang.netstat.impl.windows.WindowsNetstatManager;

public class NetstatTest {

	@Test
	public void test() throws Exception {
		NetstatManager netstatManager = new WindowsNetstatManager();
		NetstatInfo netstatInfo = netstatManager.getByPort(21600);
		System.out.println(netstatInfo);
	}

}
