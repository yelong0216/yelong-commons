package org.yelong.util;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * 秒表
 */
public class StopWatch {

	/**
	 * 此秒表标识符。方便时，我们有多个秒表的输出，需要区分他们在日志或控制台输出。
	 */
	private final String id;

	private final List<TaskInfo> taskList = new LinkedList<>();

	/** 当前任务的启动时间 */
	private long startTimeMillis;

	/** 当前任务的名称 */
	private String currentTaskName;

	private TaskInfo lastTaskInfo;

	private int taskCount;

	/** 总运转时间 */
	private long totalTimeMillis;

	/**
	 * 建造一个新的秒表。不启动任何任务。
	 */
	public StopWatch() {
		this("");
	}

	/**
	 * 用给定的id构造一个新的秒表。不启动任何任务。
	 * 
	 * @param 此秒表的id标识符。当我们有多个秒表的输出，需要区分他们。
	 */
	public StopWatch(String id) {
		this.id = id;
	}

	/**
	 * 返回这个秒表的id，在构造时指定。
	 * 
	 * @return id(默认为空字符串)
	 * @see #StopWatch(String)
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 启动一个未命名的任务。如果没有调用该方法而调用了{@link #stop()}或计时方法，则结果未定义。
	 * 
	 * @see #stop()
	 */
	public void start() throws IllegalStateException {
		start("");
	}

	/**
	 * 启动一个命名的任务。结果是未定义的，如果(@link #stop()}或计时方法被调用而没有调用这个方法。
	 * 
	 * @param 要启动的任务的名称
	 * @see #stop()
	 */
	public void start(String taskName) throws IllegalStateException {
		if (this.currentTaskName != null) {
			throw new IllegalStateException("不能开始秒表:它已经在跑了");
		}
		this.currentTaskName = taskName;
		this.startTimeMillis = System.currentTimeMillis();
	}

	/**
	 * 停止当前任务。如果在调用计时方法时没有调用至少一对方法{@code start()}{@code stop()})，则结果是未定义的。
	 * 
	 * @see #start()
	 */
	public void stop() throws IllegalStateException {
		if (this.currentTaskName == null) {
			throw new IllegalStateException("秒表停不下来:它没有在运行");
		}
		long lastTime = System.currentTimeMillis() - this.startTimeMillis;
		this.totalTimeMillis += lastTime;
		this.lastTaskInfo = new TaskInfo(this.currentTaskName, lastTime);
		this.taskList.add(this.lastTaskInfo);
		++this.taskCount;
		this.currentTaskName = null;
	}

	/**
	 * 返回秒表当前是否在运行。
	 * 
	 * @see #currentTaskName()
	 */
	public boolean isRunning() {
		return (this.currentTaskName != null);
	}

	/**
	 * 返回当前运行的任务的名称(如果有的话)。
	 * 
	 * @since 4.2.2
	 * @see #isRunning()
	 */
	public String currentTaskName() {
		return this.currentTaskName;
	}

	/**
	 * 返回最后一个任务所花费的时间。
	 */
	public long getLastTaskTimeMillis() throws IllegalStateException {
		if (this.lastTaskInfo == null) {
			throw new IllegalStateException("没有任务运行:无法获得最后一个任务间隔");
		}
		return this.lastTaskInfo.getTimeMillis();
	}

	/**
	 * 返回最后一个任务所花费的时间(秒)。
	 */
	public double getLastTaskTimeSeconds() {
		long lastTaskTimeMillis = getLastTaskTimeMillis();
		return lastTaskTimeMillis / 1000.0;
	}

	/**
	 * 返回最后一个任务的名称。
	 */
	public String getLastTaskName() throws IllegalStateException {
		if (this.lastTaskInfo == null) {
			throw new IllegalStateException("没有任务运行:无法获取最后一个任务名称");
		}
		return this.lastTaskInfo.getTaskName();
	}

	/**
	 * 作为TaskInfo对象返回最后一个任务。
	 */
	public TaskInfo getLastTaskInfo() throws IllegalStateException {
		if (this.lastTaskInfo == null) {
			throw new IllegalStateException("没有任务运行:无法获取上一个任务的信息");
		}
		return this.lastTaskInfo;
	}

	public long getStartTimeMillis() {
		return startTimeMillis;
	}

	/**
	 * 返回所有任务的总时间(毫秒)。
	 */
	public long getTotalTimeMillis() {
		return this.totalTimeMillis;
	}

	/**
	 * 返回所有任务的总时间(秒)。
	 */
	public double getTotalTimeSeconds() {
		return this.totalTimeMillis / 1000.0;
	}

	/**
	 * 返回指定时间的任务数量。
	 */
	public int getTaskCount() {
		return this.taskCount;
	}

	/**
	 * 返回所执行任务的数据数组。
	 */
	public TaskInfo[] getTaskInfo() {
		return this.taskList.toArray(new TaskInfo[0]);
	}

	/**
	 * 返回总运行时间的简短描述。
	 */
	public String shortSummary() {
		return "StopWatch '" + getId() + "': running time (millis) = " + getTotalTimeMillis();
	}

	/**
	 * 返回一个字符串，其中包含描述所执行任务的表。对于自定义的报告，调用getTaskInfo()并直接使用任务信息。
	 */
	public String prettyPrint() {
		StringBuilder sb = new StringBuilder(shortSummary());
		sb.append('\n');
		sb.append("-----------------------------------------\n");
		sb.append("ms     %     Task name\n");
		sb.append("-----------------------------------------\n");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(5);
		nf.setGroupingUsed(false);
		NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMinimumIntegerDigits(3);
		pf.setGroupingUsed(false);
		for (TaskInfo task : getTaskInfo()) {
			sb.append(nf.format(task.getTimeMillis())).append("  ");
			sb.append(pf.format(task.getTimeSeconds() / getTotalTimeSeconds())).append("  ");
			sb.append(task.getTaskName()).append("\n");
		}

		return sb.toString();
	}

	/**
	 * 返回一个信息字符串，描述为自定义报告而执行的所有任务，调用{@code getTaskInfo()}并直接使用任务信息。
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(shortSummary());
		for (TaskInfo task : getTaskInfo()) {
			sb.append("; [").append(task.getTaskName()).append("] took ").append(task.getTimeMillis());
			long percent = Math.round((100.0 * task.getTimeSeconds()) / getTotalTimeSeconds());
			sb.append(" = ").append(percent).append("%");
		}

		return sb.toString();
	}

	/**
	 * 内部类来保存关于秒表内执行的一个任务的数据。
	 */
	public static final class TaskInfo {

		private final String taskName;

		private final long timeMillis;

		TaskInfo(String taskName, long timeMillis) {
			this.taskName = taskName;
			this.timeMillis = timeMillis;
		}

		/**
		 * 返回此任务的名称。
		 */
		public String getTaskName() {
			return this.taskName;
		}

		/**
		 * 返回此任务花费的时间(以毫秒为单位)。
		 */
		public long getTimeMillis() {
			return this.timeMillis;
		}

		/**
		 * 返回此任务花费的时间(以秒为单位)。
		 */
		public double getTimeSeconds() {
			return (this.timeMillis / 1000.0);
		}
	}

}
