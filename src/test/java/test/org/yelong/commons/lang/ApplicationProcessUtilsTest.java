/**
 * 
 */
package test.org.yelong.commons.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ApplicationProcessUtils;
import org.yelong.commons.lang.process.ProcessManagerException;

/**
 * @see ApplicationProcessUtils
 */
public class ApplicationProcessUtilsTest {

	@Test
	public void getOneselfPid() {
		System.out.println(ApplicationProcessUtils.getOneselfPid());
	}

	@Test
	public void killOneself() throws ProcessManagerException {
		System.out.println("abc");
		ApplicationProcessUtils.killOneself();
		System.out.println("bcd");
	}

}
