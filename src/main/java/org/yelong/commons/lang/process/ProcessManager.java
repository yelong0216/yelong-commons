/**
 * 
 */
package org.yelong.commons.lang.process;

import java.io.IOException;
import java.util.List;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 管理本计算机的程序。如终止进程、查询等
 * 
 * @since 1.1
 */
public interface ProcessManager {

	/**
	 * 杀死进程
	 * 
	 * @param pid 进程PID
	 * @return <tt>true</tt> 成功杀死
	 * @throws ProcessManagerException 进程管理异常
	 */
	boolean killProcess(int pid) throws ProcessManagerException, CommandExecuteException, IOException;

	/**
	 * 获取当前所有进程信息
	 * 
	 * @return 当前系统所有的进程信息
	 * @since 2.2
	 */
	List<ProcessInfo> getAll() throws ProcessManagerException, CommandExecuteException, IOException;

	/**
	 * 根据PID获取进程信息
	 * 
	 * @param pid 进程id
	 * @return 该PID的进程信息
	 * @since 2.2
	 */
	ProcessInfo getByPid(Integer pid) throws ProcessManagerException, CommandExecuteException, IOException;

	/**
	 * 根据PID判断进程是否存在
	 * 
	 * @param pid 进程id
	 * @return <tt>true</tt> 进程存在
	 * @since 2.2
	 */
	default boolean existByPid(Integer pid) throws ProcessManagerException, CommandExecuteException, IOException {
		return getByPid(pid) != null;
	}

}
