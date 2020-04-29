/**
 * 
 */
package org.yelong.commons.test.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.yelong.commons.util.Dates;

/**
 * @author PengFei
 * @since
 */
public class DatesTest {

	/**
	 * @param args
	 * @throws ParseException 
	 * @since
	 */
	public static void main(String[] args) throws ParseException {
		//nowYear();
//		System.out.println(Dates.nowDay());
//		System.out.println( format(Dates.getYearFirstDay(2020)));
//		System.out.println( format(Dates.getYearLastDay(2020)));
//		getYearAllDays();
//		System.out.println(Dates.getDayOfWeek(parseDate("2020-04-20")));
//		System.out.println(Dates.getMonth(parseDate("2020-01-01")));
//		System.out.println(Dates.getDayOfMonth(parseDate("2020-01-01")));
		System.out.println(format(Dates.getFirstDay(2020, 1)));
		System.out.println(format(Dates.getLastDay(2020, 1)));
	}
	
	public static String format(Date d) {
		return DateFormatUtils.format(d, Dates.YYYY_MM_DD_BAR);
	}
	
	public static Date parseDate(String str) throws ParseException {
		return DateUtils.parseDate(str, Dates.YYYY_MM_DD_BAR);
	}
	
	public static void getYearAllDays() {
		List<Date> betweenDays = Dates.getAllDays(2020);
		for (Date date : betweenDays) {
			System.out.println(format(date));
		}
	}
	
	public static final void afterDays() throws ParseException {
		List<Date> betweenDays = Dates.getAfterDays(DateUtils.parseDate("2020-01-01", Dates.YYYY_MM_DD_BAR), 1);
		for (Date date : betweenDays) {
			System.out.println(DateFormatUtils.format(date, Dates.YYYY_MM_DD_BAR));
		}
	}

	public static final void betweenDays() throws ParseException {
		List<Date> betweenDays = Dates.getBetweenDays(DateUtils.parseDate("2020-01-01", Dates.YYYY_MM_DD_BAR), DateUtils.parseDate("2021-01-01", Dates.YYYY_MM_DD_BAR));
		for (Date date : betweenDays) {
			System.out.println(DateFormatUtils.format(date, Dates.YYYY_MM_DD_BAR));
		}
	}

}
