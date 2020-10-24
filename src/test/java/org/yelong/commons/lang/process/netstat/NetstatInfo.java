/**
 * 
 */
package org.yelong.commons.lang.process.netstat;

/**
 * 网络状态信息
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月20日下午12:00:11
 * @version 1.3
 */
public class NetstatInfo {

	//协议
	private String proto;
	
	//本地地址
	private String localAddress;
	
	//端口号
	private Integer port;
	
	//外部地址
	private String foreignAddress;
	
	//状态
	private String state;
	
	//pid
	private Integer pid;
	
	//程序名称
	private String programName;

	public String getProto() {
		return proto;
	}

	public void setProto(String proto) {
		this.proto = proto;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getForeignAddress() {
		return foreignAddress;
	}

	public void setForeignAddress(String foreignAddress) {
		this.foreignAddress = foreignAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public String toString() {
		return "NetstatInfo [proto=" + proto + ", localAddress=" + localAddress + ", port=" + port + ", foreignAddress="
				+ foreignAddress + ", state=" + state + ", pid=" + pid + ", programName=" + programName + "]";
	}
	
}
