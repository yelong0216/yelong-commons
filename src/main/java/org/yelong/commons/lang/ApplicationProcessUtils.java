/**
 * 
 */
package org.yelong.commons.lang;

import java.lang.management.ManagementFactory;
import java.util.Objects;

import org.apache.commons.lang3.SystemUtils;
import org.yelong.commons.lang.process.ProcessManager;
import org.yelong.commons.lang.process.ProcessManagerException;
import org.yelong.commons.lang.process.impl.WindowsProcessManager;
import org.yelong.commons.lang.runtime.CommandExecutor;
import org.yelong.commons.lang.runtime.DefaultCommandExecutor;

/**
 * 应用程序工具类
 * 
 * @since 1.1
 */
public final class ApplicationProcessUtils {

	private ApplicationProcessUtils() {
	}

	private static final CommandExecutor COMMAND_EXECUTOR = new DefaultCommandExecutor();

	private static ProcessManager PROCESS_MANAGER;

	static {
		// 根据当前系统创建程序管理者
		if (SystemUtils.IS_OS_WINDOWS) {
			PROCESS_MANAGER = new WindowsProcessManager(COMMAND_EXECUTOR);
		} else {
			PROCESS_MANAGER = null;
		}
	}

	/**
	 * 修改程序管理器
	 * 
	 * @param processManager 程序管理器
	 * @see 2.0
	 */
	public static void setProcessManager(ProcessManager processManager) {
		PROCESS_MANAGER = processManager;
	}

	/**
	 * 获取这个程序运行时的pid
	 * 
	 * @return 该java程序运行时的pid
	 */
	public static Integer getOneselfPid() {
		try {
			String jvmName = ManagementFactory.getRuntimeMXBean().getName();
			String pid = jvmName.split("@")[0];
			return null == pid ? null : Integer.valueOf(pid);
		} catch (Throwable ex) {
			return null;
		}
	}

	/**
	 * 终止当前程序（杀死自己的进程）
	 * 
	 * @return <tt>true</tt> 当进程成功被杀死时，这个返回值不具有任何意义（程序都终止了，就不会在运行了）
	 * @throws ProcessManagerException
	 */
	public static boolean killOneself() throws ProcessManagerException {
		validateProcessManager();
		Integer oneselfPid = getOneselfPid();
		if (null == oneselfPid) {
			throw new NullPointerException("未能识别当前程序的PID");
		}
		return PROCESS_MANAGER.killProcess(oneselfPid);
	}

	private static void validateProcessManager() {
		Objects.requireNonNull(PROCESS_MANAGER, "没有找到当前系统所匹配的" + ProcessManager.class);
	}

}
