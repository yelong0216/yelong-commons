/**
 * 
 */
package org.yelong.commons.lang.process;

import org.apache.commons.lang3.SystemUtils;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月14日下午4:57:29
 * @version 1.3
 */
public class ProcessCommandExecutorFactory {


	private static final ProcessCommandExecutor currentSystemProcessCommandExecute;

	static {
		if(SystemUtils.IS_OS_WINDOWS) {
			currentSystemProcessCommandExecute = new WindowsProcessCommandExecutor();
		} else if(SystemUtils.IS_OS_UNIX) {
			currentSystemProcessCommandExecute = new UnixProcessCommandExecutor();
		} else {
			currentSystemProcessCommandExecute = null;
		}
	}

	/**
	 * 构建当前系统的命令执行器
	 * @date 2019年11月14日下午4:29:25
	 * @version 1.3
	 * @return
	 */
	public static ProcessCommandExecutor getProcessCommandExecutor() {
		if( null == currentSystemProcessCommandExecute ) {
			throw new RuntimeException("没有找到符合当前系统的进程命令执行器！");
		}
		return currentSystemProcessCommandExecute;
	}


}
