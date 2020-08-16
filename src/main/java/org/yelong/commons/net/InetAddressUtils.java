/**
 * 
 */
package org.yelong.commons.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 地址工具类
 * 
 * @since 1.1
 */
public final class InetAddressUtils {

	private InetAddressUtils() {
	}

	/**
	 * 获取本地主机硬件地址
	 * 
	 * @return 本地主机硬件地址 （MAC）
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static byte[] getLocalHostHardwareAddress() throws SocketException, UnknownHostException {
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		byte[] hardwareAddress = networkInterface.getHardwareAddress();
		return hardwareAddress;
	}

	/**
	 * 获取本地主机硬件地址，并转换为16进制
	 * 
	 * @return 16进制的本地主机硬件地址
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String[] getLocalHostHardwareAddressToHex() throws SocketException, UnknownHostException {
		byte[] localHostHardwareAddress = getLocalHostHardwareAddress();
		String[] localHostHardwareAddressHex = new String[localHostHardwareAddress.length];
		for (int i = 0; i < localHostHardwareAddress.length; i++) {
			String str = Integer.toHexString(localHostHardwareAddress[i] & 0xff);
			if (str.length() == 1) {
				// 如果遇到单字符，前置0占位补满两格
				str = "0" + str;
			}
			localHostHardwareAddressHex[i] = str;
		}
		return localHostHardwareAddressHex;
	}

	/**
	 * 获取mac地址
	 * 
	 * @return mac 地址
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getMACAddress() throws SocketException, UnknownHostException {
		String[] localHostHardwareAddressToHex = getLocalHostHardwareAddressToHex();
		List<String> asList = Arrays.asList(localHostHardwareAddressToHex);
		return asList.stream().map(String::toUpperCase).collect(Collectors.joining("-"));
	}

	/**
	 * 获取当前系统的地址。这一般是该系统的ip4地址
	 * 
	 * @return 当前系统地址。一般为ip4地址
	 * @throws UnknownHostException
	 */
	public static String getLocalHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

}
