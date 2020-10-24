/**
 * 
 */
package org.yelong.commons.lang.process;

import java.util.List;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月14日下午4:55:14
 * @version 1.3
 */
public interface ProcessCommandExecutor {

	/**
	 * 根据pid杀死进程
	 * 
	 * @date 2019年11月14日下午3:36:21
	 * @version 1.3
	 * @param pid pid
	 * @return <tt>true</tt>进程被杀死
	 * @throws Exception
	 */
	boolean killByPid(Integer pid) throws Exception;

	/**
	 * 获取当前所有进程信息
	 * 
	 * @date 2019年11月14日下午4:55:39
	 * @version 1.3
	 * @return
	 * @throws Exception
	 */
	List<ProcessInfo> getAll() throws Exception;

	/**
	 * 根据pid获取进程信息
	 * 
	 * @date 2019年11月14日下午4:59:15
	 * @version 1.3
	 * @param pid 进程id
	 * @return 进程信息
	 * @throws Exception
	 */
	ProcessInfo getByPid(Integer pid) throws Exception;

	/**
	 * 根据pid判断进程是否存在
	 * 
	 * @date 2019年11月14日下午4:59:54
	 * @version 1.3
	 * @param pid 进程id
	 * @return <tt>true</tt> 进程存在
	 * @throws Exception
	 */
	default boolean existByPid(Integer pid) throws Exception {
		return getByPid(pid) != null;
	}

}
