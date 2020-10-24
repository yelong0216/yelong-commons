/**
 * 
 */
package org.yelong.commons.lang.process.netstat;

import java.util.List;
import java.util.Objects;

/**
 * 网络状态命令执行器
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日上午11:54:39
 * @version 1.3
 */
public interface NetstatCommandExecutor{
	
	/**
	 * 获取当前系统所有网络状态信息
	 * @date 2019年11月20日下午12:06:00
	 * @version 1.3
	 * @return
	 * @throws Exception
	 */
	List<NetstatInfo> getAll() throws Exception;
	
	/**
	 * 根据端口号获取网络状态信息
	 * @date 2019年11月20日下午12:06:13
	 * @version 1.3
	 * @param port
	 * @return
	 * @throws Exception
	 */
	NetstatInfo getByPort(Integer port) throws Exception;
	
	/**
	 * 根据pid获取网络状态信息
	 * @date 2019年11月20日下午12:06:37
	 * @version 1.3
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	NetstatInfo getByPid(Integer pid) throws Exception;
	
	default Integer getPidByPort(Integer port) throws Exception{
		NetstatInfo netstatInfo = getByPort(port);
		return netstatInfo == null ? null : netstatInfo.getPid();
	}
	
	default Integer getPortByPid(Integer pid) throws Exception{
		NetstatInfo netstatInfo = getByPid(pid);
		return netstatInfo == null ? null : netstatInfo.getPort();
	}
	
	/**
	 * 查询端口号是否被占用
	 * @date 2019年11月20日下午3:07:46
	 * @version 1.3
	 * @param port 端口号
	 * @return <tt>true</tt> 该端口号被占用
	 * @throws Exception
	 */
	default boolean existByPort(Integer port) throws Exception{
		return Objects.nonNull(getByPort(port));
	}

}
