/**
 * 
 */
package org.yelong.commons.lang.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年11月18日上午11:05:58
 * @version 1.3
 */
public class ProcessStreamManager{

	private final Process process;

	private String charsetName;
	
	public ProcessStreamManager(Process process) {
		this.process = process;
	}

	/**
	 * 启动ErrorStream线程
	 * @date 2019年11月18日上午11:27:42
	 * @version 1.3
	 */
	public void startErrorStreamThread() {
		startErrorStreamThread(null);
	}

	/**
	 * 启动ErrorStream线程。通过listener监听错误流信息
	 * @date 2019年11月18日上午11:29:02
	 * @version 1.3
	 * @param listener 流监听器
	 */
	public void startErrorStreamThread(ProcessStreamListener listener) {
		InputStreamThread inputStreamThread = new InputStreamThread(process.getErrorStream(), listener);
		inputStreamThread.start();
	}

	/**
	 * 启动InputStream线程
	 * @date 2019年11月18日上午11:29:42
	 * @version 1.3
	 */
	public void startInputStreamThread() {
		startInputStreamThread(null);
	}

	/**
	 * 启动InputStream线程。通过listener监听错误流信息
	 * @date 2019年11月18日上午11:29:58
	 * @version 1.3
	 * @param listtener 流监听器
	 */
	public void startInputStreamThread(ProcessStreamListener listener) {
		InputStreamThread inputStreamThread = new InputStreamThread(process.getInputStream(), listener);
		inputStreamThread.start();
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}
	
	public String getCharsetName() {
		return charsetName;
	}
	
	/**
	 * 流线程
	 * @author pengfei<yl1430834495@163.com>
	 * @date 2019年11月18日上午11:37:54
	 * @version 1.3
	 */
	private class InputStreamThread extends Thread {

		private final InputStream inputStream;

		private final ProcessStreamListener listener;

		public InputStreamThread(InputStream inputStream, ProcessStreamListener listener) {
			this.inputStream = inputStream;
			this.listener = listener;
		}

		@Override
		public void run() {
			try {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charsetName);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line = null;
				while((line = bufferedReader.readLine()) !=null ) {
					if( null != listener) {
						listener.listening(line);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
