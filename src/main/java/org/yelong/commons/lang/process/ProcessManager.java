/**
 * 
 */
package org.yelong.commons.lang.process;

/**
 * 管理本计算机的程序。如终止进程、查询等
 * 
 * @since 1.1
 */
public interface ProcessManager {

	/**
	 * 杀死进程
	 * 
	 * @param pid 进程pid
	 * @return <tt>true</tt> 成功杀死
	 * @throws ProcessManagerException 进程管理异常
	 */
	boolean killProcess(int pid) throws ProcessManagerException;

}
