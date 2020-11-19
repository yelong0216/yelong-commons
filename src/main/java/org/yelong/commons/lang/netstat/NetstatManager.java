/**
 * 
 */
package org.yelong.commons.lang.netstat;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.yelong.commons.lang.runtime.CommandExecuteException;

/**
 * 网络状态命令执行器
 * 
 * @since 2.2
 */
public interface NetstatManager {

	/**
	 * 获取当前系统所有网络状态信息
	 * 
	 * @return 该系统下所有的网络状态信息。
	 */
	List<NetstatInfo> getAll() throws NetstatManageException, CommandExecuteException, IOException;

	/**
	 * 根据端口号获取网络状态信息
	 * 
	 * @param port 端口号
	 * @return 获取指定端口号的网络状态信息。如果该端口没有被进程使用则返回 <code>null</code>
	 */
	NetstatInfo getByPort(Integer port) throws NetstatManageException, CommandExecuteException, IOException;

	/**
	 * 根据PID获取网络状态信息
	 * 
	 * @param pid 进程PID
	 * @return 该PID的进程的网络状态信息。如果该PID不存在进程则返回 <code>null</code>
	 */
	NetstatInfo getByPid(Integer pid) throws NetstatManageException, CommandExecuteException, IOException;

	/**
	 * 根据端口号查询PID
	 * 
	 * @param port 端口号
	 * @return 该端口号进程的PID。如果该端口号没有进程在使用则返回 <code>null</code>
	 */
	default Integer getPidByPort(Integer port) throws NetstatManageException, CommandExecuteException, IOException {
		NetstatInfo netstatInfo = getByPort(port);
		return netstatInfo == null ? null : netstatInfo.getPid();
	}

	/**
	 * 根据PID查询端口号
	 * 
	 * @param pid PID
	 * @return 该PID的进程的端口号。如果该PID没有或者进程没有使用端口号都会返回 <code>null</code>
	 */
	default Integer getPortByPid(Integer pid) throws NetstatManageException, CommandExecuteException, IOException {
		NetstatInfo netstatInfo = getByPid(pid);
		return netstatInfo == null ? null : netstatInfo.getPort();
	}

	/**
	 * 查询端口号是否被占用
	 * 
	 * @param port 端口号
	 * @return <tt>true</tt> 该端口号被占用
	 */
	default boolean existByPort(Integer port) throws NetstatManageException, CommandExecuteException, IOException {
		return Objects.nonNull(getByPort(port));
	}

}
