package com.gatecm.obsession.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO(日期操作工具集)
 * @author chenxiaohui
 * @date 2017年4月30日 上午9:15:07
 *
 */
public class TimeUtils {
	public static final String START_DATE = "2000-01-01";// 起始时间
	private static final String split = "-";
	private static final String START_TIME = " 00:00:00";
	private static final String END_TIME = " 23:59:59";

	private static final long DATE_DIVISOR = 3600 * 24 * 1000;
	private static final long HOUR_DIVISOR = 3600 * 1000;
	private static final long MINUTE_DIVISOR = 60 * 1000;
	private static final long SECOND_DIVISOR = 1000;

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getDateNow() {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		return FROMAT.format(new Date());
	}

	/**
	 * @param careDate
	 * @return
	 */
	public static Date paseToDateYMD(String careDate) {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return FROMAT.parse(careDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @Title: DateToStr
	 * @Description: TODO(日期转换成字符串)
	 * @param date
	 * @return String
	 * @author chenxiaohui
	 */
	public static String DateToStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}

	public static String DateToShortStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	public static String DateToShortYMStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String str = format.format(date);
		return str;
	}

	public static String DateToShortYStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String str = format.format(date);
		return str;
	}

	// 转换为短日期
	public static String parseToShort(String longDateStr) {
		return longDateStr.substring(0, 10);
	}

	// 解析开始日期
	public static String parseStartDate(String startDate) {
		if (startDate != null) {
			return startDate + START_TIME;
		} else {
			return startDate;
		}
	}

	// 解析终止日期
	public static String parseEndDate(String endDate) {
		return endDate + END_TIME;
	}

	// 获取本日起点，00:00:00
	public static String getDayStart() {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		return parseStartDate(FROMAT.format(new Date()));
	}

	// 获取本日终点，23:59:59
	public static String getDayEnd() {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		return parseEndDate(FROMAT.format(new Date()));
	}

	// 获取本月第一天
	public static String getMonthFirstDate() {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		// c.add(Calendar.MONTH, 0);//月份加
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return FROMAT.format(c.getTime());
	}

	// 获取本月最后一天
	public static String getMonthlastDate() {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return FROMAT.format(c.getTime());
	}

	// 获取季度第一天
	public static String getSeasonFirstDayStart(int seasonNumber) {
		Calendar c = Calendar.getInstance();
		String dayStart;
		switch (seasonNumber) {
		case 1:
			c.set(Calendar.MONTH, Calendar.JANUARY);
			dayStart = getfirstDateStartOfMonth(c);
			break;
		case 2:
			c.set(Calendar.MONTH, Calendar.APRIL);
			dayStart = getfirstDateStartOfMonth(c);
			break;
		case 3:
			c.set(Calendar.MONTH, Calendar.JULY);
			dayStart = getfirstDateStartOfMonth(c);
			break;
		case 4:
			c.set(Calendar.MONTH, Calendar.OCTOBER);
			dayStart = getfirstDateStartOfMonth(c);
			break;
		default:
			c.set(Calendar.MONTH, Calendar.JANUARY);
			dayStart = getfirstDateStartOfMonth(c);
			break;
		}
		return dayStart;
	}

	// 获取季度最后一天
	public static String getSeasonLastDayEnd(int seasonNumber) {
		Calendar c = Calendar.getInstance();
		String dayEnd;
		switch (seasonNumber) {
		case 1:
			c.set(Calendar.MONTH, Calendar.MARCH);
			dayEnd = getLastDateEndOfMonth(c);
			break;
		case 2:
			c.set(Calendar.MONTH, Calendar.JUNE);
			dayEnd = getLastDateEndOfMonth(c);
			break;
		case 3:
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			dayEnd = getLastDateEndOfMonth(c);
			break;
		case 4:
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			dayEnd = getLastDateEndOfMonth(c);
			break;
		default:
			c.set(Calendar.MONTH, Calendar.MARCH);
			dayEnd = getfirstDateStartOfMonth(c);
			break;
		}
		return dayEnd;
	}

	// 获取当年的第一天
	public static String getCurrYearFirst() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	// 获取当年的最后一天
	public static String getCurrYearLast() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	// 获取某年第一天日期
	public static String getYearFirst(int year) {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		return FROMAT.format(calendar.getTime());
	}

	// 获取某年最后一天日期
	public static String getYearLast(int year) {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return FROMAT.format(calendar.getTime());
	}

	// 号年反转，即反转dd与yy
	public static String reverse(String str) {
		String[] strings = str.split(split);
		StringBuilder sbBuffer = new StringBuilder(strings[2]);
		sbBuffer.append(split);
		sbBuffer.append(strings[1]);
		sbBuffer.append(split);
		sbBuffer.append(strings[0]);
		return sbBuffer.toString();
	}

	private static String getfirstDateStartOfMonth(Calendar calendar) {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return FROMAT.format(calendar.getTime()) + START_TIME;
	}

	private static String getLastDateEndOfMonth(Calendar calendar) {
		SimpleDateFormat FROMAT = new SimpleDateFormat("yyyy-MM-dd");
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return FROMAT.format(calendar.getTime()) + END_TIME;
	}

	// 返回两个日期之间隔了多少天
	public static Integer DateDiff(Date date2, Date date1) {
		if (date2 != null && date1 != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			int day1 = cal1.get(Calendar.DAY_OF_YEAR);
			int day2 = cal2.get(Calendar.DAY_OF_YEAR);
			int year1 = cal1.get(Calendar.YEAR);
			int year2 = cal2.get(Calendar.YEAR);
			if (year1 != year2) { // 同一年
				int timeDistance = 0;
				for (int i = year1; i < year2; i++) {
					if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { // 闰年
						timeDistance += 366;
					} else { // 不是闰年
						timeDistance += 365;
					}
				}
				return timeDistance + (day2 - day1);
			} else {// 不同年
				return day2 - day1;
			}
		}
		return null;
	}

	// 返回两个日期之间隔了多少年
	public static int yearDiff(Date date1, Date date2) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date1);
		int day1 = aCalendar.get(Calendar.YEAR);
		aCalendar.setTime(date2);
		int day2 = aCalendar.get(Calendar.YEAR);
		return day1 - day2;
	}

	// 返回两个日期之间隔了多少天,只要date1>date2,则i>=1
	public static Long DateDiffHold(Date date1, Date date2) {
		Long diffMills = date1.getTime() - date2.getTime();
		Long diff = (diffMills / DATE_DIVISOR);
		if (diffMills > 0 && diff == 0) {
			diff = 1L;
		}
		return diff;
	}

	// 返回两个日期之间隔了多少小时
	public static Long HourDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / HOUR_DIVISOR;
	}

	// 返回两个日期之间隔了多少分钟
	public static Long minuteDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / MINUTE_DIVISOR;
	}

	// 返回两个日期之间隔了多少秒
	public static Long secondDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / SECOND_DIVISOR;
	}

	/**
	 * 解析日期，返回YYYY-MM-DD HH:00:00
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date customeDate(Date date, Integer hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 计算指定日期距今多少年
	 * 
	 * @param times
	 *            指定日期
	 * @return 年
	 */
	public static int getTime(String times) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		String t1 = time.replace('-', '/');
		String t2 = times.replace('-', '/');

		@SuppressWarnings("deprecation")
		Date dt1 = new Date(t1);
		@SuppressWarnings("deprecation")
		Date dt2 = new Date(t2);
		long i = (dt1.getTime() - dt2.getTime()) / (1000 * 60 * 60 * 24);
		return (int) (i / 365);
	}

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	public static String getNowTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(new Date());
		return time;
	}

	/**
	 * 获取明天日期
	 * 
	 * @return
	 */
	public static Date getTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 获取明年的当前日期
	 * 
	 * @return
	 */
	public static Date getNextYearInThisDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 年转日期(for stupid IOS)
	 * 
	 * @param establishTimeStr
	 * @return
	 */
	public static Date yearToDate(String establishTimeStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date time;
		try {
			time = sdf.parse(establishTimeStr);
		} catch (ParseException e) {
			time = null;
		}
		return time;
	}

	public static void main(String[] args) {

		Date date = new Date();
		Date date2 = new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		calendar2.set(Calendar.HOUR, 9);

		System.err.println(TimeUtils.DateDiff(date, calendar2.getTime()));
		// System.err.println(TimeUtils.HourDiff(date, calendar.getTime()));

		// System.err.println("季度" + getSeasonFirstDayStart(1));
		// System.err.println("季度" + getSeasonLastDayEnd(1));
		// System.err.println("季度" + getSeasonFirstDayStart(2));
		// System.err.println("季度" + getSeasonLastDayEnd(2));
		// System.err.println("季度" + parseToShort(getSeasonFirstDayStart(3)));
		// System.err.println("季度" + getSeasonLastDayEnd(3));
		// System.err.println("季度" + getSeasonFirstDayStart(4));
		// System.err.println("季度" + getSeasonLastDayEnd(4));

	}

}
