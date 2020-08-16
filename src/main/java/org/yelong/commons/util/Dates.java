/**
 * 
 */
package org.yelong.commons.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期、时间工具类
 * 
 * @see DateUtils
 * @see DateFormatUtils
 * @since 1.1
 */
public final class Dates {

	private Dates() {
	}

	// ================================ 日期格式 ================================

	/**
	 * yyyyMMdd
	 * 
	 * @since 1.3.0
	 */
	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD_BAR = "yyyy-MM-dd";

	/**
	 * yyyy/MM/dd
	 */
	public static final String YYYY_MM_DD_SLASH = "yyyy/MM/dd";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyy年MM月dd日
	 */
	public static final String YYYY_Y_MM_M_DD_D = "yyyy年MM月dd日";

	// ================================获取指定日期之后、之间、相差的日期================================

	/**
	 * 获取 date 日期之后 dayNum 天的所有日期 不包含date 包含最后一天
	 * 
	 * @param date   开头的日期
	 * @param dayNum 天数
	 * @return 从date开始到dayNum天内的所有日期 包含最后一天
	 */
	public static List<Date> getAfterDays(Date date, int dayNum) {
		List<Date> dates = new ArrayList<>(dayNum + 1);
		for (int i = 1; i <= dayNum; i++) {
			dates.add(DateUtils.addDays(date, i));
		}
		return dates;
	}

	/**
	 * 获取 date 日期之前 dayNum 天的所有日期 不包含date 包含最后一天
	 * 
	 * @param date   开头的日期
	 * @param dayNum 天数
	 * @return 从date开始（包含date）到-dayNum天内的所有日期包含最后一天
	 */
	public static List<Date> getBeforeDays(Date date, int dayNum) {
		List<Date> dates = new ArrayList<>(dayNum + 1);
		for (int i = 1; i <= dayNum; i++) {
			dates.add(DateUtils.addDays(date, -i));
		}
		return dates;
	}

	/**
	 * 获取两个日期之间的所有天 不包含d1,d2 开始日期不是必须比结束日期小
	 * 
	 * betweenDays('2020-01-01','2021-01-01')返回 2020-01-02~2020-12-31所有的Date
	 * betweenDays('2021-01-01','2020-01-01')返回 2020-12-31~2020-01-02所有的Date
	 * 
	 * @param d1 开始日期
	 * @param d2 结束日期
	 * @return d1与d2之间所有的天日期
	 */
	public static List<Date> getBetweenDays(Date d1, Date d2) {
		int betweenDayNum = betweenDayNum(d1, d2);
		if (d1.getTime() > d2.getTime()) {
			return getBeforeDays(d1, betweenDayNum - 1);
		} else {
			return getAfterDays(d1, betweenDayNum - 1);
		}
	}

	/**
	 * 获取指定年的一年内所有的‘天’日期
	 * 
	 * @param year 年份
	 * @return year年一年内所有的‘天’日期
	 */
	public static List<Date> getAllDays(int year) {
		Date yearFirstDay = getFirstDay(year);
		Date yearLastDay = getLastDay(year);
		List<Date> betweenDays = getBetweenDays(yearFirstDay, yearLastDay);
		betweenDays.add(0, yearFirstDay);
		betweenDays.add(yearLastDay);
		return betweenDays;
	}

	/**
	 * 获取指定年和月内所有的‘天’日期
	 * 
	 * @param year 年份
	 * @return year年month月内所有的‘天’日期
	 */
	public static List<Date> getAllDays(int year, int month) {
		Date yearFirstDay = getFirstDay(year, month);
		Date yearLastDay = getLastDay(year, month);
		List<Date> betweenDays = getBetweenDays(yearFirstDay, yearLastDay);
		betweenDays.add(0, yearFirstDay);
		betweenDays.add(yearLastDay);
		return betweenDays;
	}

	/**
	 * 推算两个日期之间相差的天数 相差的天数，两个参数不限制前大，后小，后大，前小的。默认均会转换为正数
	 * 
	 * @param d1 第一个日期
	 * @param d2 第二个日期
	 * @return 两个日期相差的天数
	 */
	public static int betweenDayNum(Date d1, Date d2) {
		return Math.abs((int) ((d1.getTime() - d2.getTime()) / (60 * 60 * 24 * 1000)));
	}

	// ================================ 获取指定天的年月日 ================================

	/**
	 * 获取指定年的第一天的日期
	 * 
	 * @param year 年份
	 * @return year年的第一天日期
	 */
	public static Date getFirstDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取指定年的最后一天的日期
	 * 
	 * @param year 年份
	 * @return year年的最后一天日期
	 */
	public static Date getLastDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	/**
	 * 获取指定年，月的第一天的日期
	 * 
	 * @param year  年份
	 * @param month 月份
	 * @return year年month月的第一天日期
	 */
	public static Date getFirstDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取指定年，月的最后一天的日期
	 * 
	 * @param year  年份
	 * @param month 月份
	 * @return year年month月的最后一天日期
	 */
	public static Date getLastDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	// ================================ 获取年、月、日 ================================

	/**
	 * 获取日期的年份
	 * 
	 * @param date 日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		return getCalendar(date).get(Calendar.YEAR);
	}

	/**
	 * 获取日期的月份
	 * 
	 * <pre>
	 * 其值为0~11。与中国月份对应如下：
	 * 		0：一月
	 * 		1：二月
	 * 		2：三月
	 * 		3：四月
	 * 		4：五月
	 * 		5：六月
	 * 		6：七月
	 * 		7：八月
	 * 		8：九月
	 * 		9：十月
	 * 		10：十一月
	 * 		11：十二月
	 * </pre>
	 * 
	 * @param date 日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		return getCalendar(date).get(Calendar.MONTH);
	}

	/**
	 * 获取指定的日期为其年内的第几天
	 * 
	 * @param date 日期
	 * @return 指定的日期为其年内的第几天
	 */
	public static int getDayOfYear(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取指定的日期为其月内的第几天
	 * 
	 * @param date 日期
	 * @return 指定的日期为其月内的第几天
	 */
	public static int getDayOfMonth(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取指定的日期为其星期内的第几天
	 * 
	 * <pre>
	 * 其值为1~7。与中国星期对应如下：
	 * 		1：星期天
	 * 		2：星期一
	 * 		3：星期二
	 * 		4：星期三
	 * 		5：星期四
	 * 		6：星期五
	 * 		7：星期六
	 * </pre>
	 * 
	 * @param date 日期
	 * @return 指定的日期为其星期内的第几天
	 */
	public static int getDayOfWeek(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_WEEK);
	}

	// ================================获取当前日期，以及当前日期的年、月、日等================================

	/**
	 * @return 当前日期的年份
	 */
	public static int nowYear() {
		return getYear(nowDate());
	}

	/**
	 * 当前日期的月份
	 * 
	 * @return 当前日期的月份
	 */
	public static int nowMonth() {
		return getMonth(nowDate());
	}

	/**
	 * @return 当天为该年的第几天
	 */
	public static int nowDayOfYear() {
		return getDayOfYear(nowDate());
	}

	/**
	 * @return 当天为该月的第几天
	 */
	public static int nowDayOfMonth() {
		return getDayOfMonth(nowDate());
	}

	/**
	 * @return 当天为该星期的第几天
	 */
	public static int nowDayOfWeek() {
		return getDayOfWeek(nowDate());
	}

	/**
	 * @return 当前日期的日历
	 */
	public static Calendar nowCalendar() {
		return getCalendar(nowDate());
	}

	/**
	 * @return 当前的日期
	 */
	public static Date nowDate() {
		return new Date();
	}

	// ================================ parse ================================

	/**
	 * <pre>
	 * 根据
	 * {@link #YYYY_MM_DD_BAR}
	 * {@link #YYYY_MM_DD_SLASH}
	 * {@link #YYYY_MM_DD_HH_MM_SS}
	 * 的格式进行解析
	 * </pre>
	 * 
	 * @param str 日期字符串
	 * @return 解析后的日期
	 * @throws ParseException
	 */
	public static Date parseDate(String str) throws ParseException {
		return DateUtils.parseDate(str, YYYY_MM_DD_HH_MM_SS, YYYY_MM_DD_BAR, YYYY_MM_DD_SLASH);
	}

	// ================================ util ================================

	/**
	 * 获取日期的日历
	 * 
	 * @param date 日期
	 * @return 日历
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 获取日期
	 * 
	 * @param year  年份
	 * @param month 月份（月份按照程序来算）
	 * @param day   日 日子按照月份来算（该月的第几天）
	 * @return 日期
	 */
	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

}
