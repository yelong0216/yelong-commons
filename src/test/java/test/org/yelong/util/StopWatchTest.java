package test.org.yelong.util;

import org.junit.jupiter.api.Test;
import org.yelong.util.StopWatch;

public class StopWatchTest {

	@Test
	public void test() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("嘿嘿");
		Thread.sleep(1000);
		stopWatch.stop();
		stopWatch.start("哈哈");
		Thread.sleep(1000);
		stopWatch.stop();
		System.out.println(stopWatch.getTotalTimeSeconds());
		System.out.println(stopWatch.prettyPrint());
		System.out.println("-----------");
		System.out.println(stopWatch.shortSummary());
	}
	
}
