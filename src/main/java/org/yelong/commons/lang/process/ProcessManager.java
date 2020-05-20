/**
 * 
 */
package org.yelong.commons.lang.process;

/**
 * 
 * 程序管理
 * 
 * 管理本计算机的程序。如终止进程、查询等
 * 
 * @author PengFei
 * @since 1.0.4
 */
public interface ProcessManager {
	
	/**
	 * 杀死进程
	 * @param pid 进程pid
	 * @return <tt>true</tt> 成功杀死
	 * @throws Exception
	 */
	boolean killProcess(int pid) throws ProcessManagerException;
	
}
