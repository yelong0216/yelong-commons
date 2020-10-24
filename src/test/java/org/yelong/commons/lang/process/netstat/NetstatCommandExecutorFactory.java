/**
 * 
 */
package org.yelong.commons.lang.process.netstat;

import org.apache.commons.lang3.SystemUtils;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日下午2:01:35
 * @version 1.3
 */
public class NetstatCommandExecutorFactory {
	
	private static final NetstatCommandExecutor netstatCommandExecutor;
	
	static {
		if(SystemUtils.IS_OS_WINDOWS) {
			netstatCommandExecutor = new WindowsNetstatCommandExecutor();
		} else if(SystemUtils.IS_OS_UNIX){
			netstatCommandExecutor = new UnixNetstatCommandExecutor();
		} else {
			netstatCommandExecutor = null;
		}
	}
	
	public static NetstatCommandExecutor getNetstatCommandExecutor() {
		return netstatCommandExecutor;
	}
	
	
	
	
	
}
