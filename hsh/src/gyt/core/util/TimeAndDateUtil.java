package gyt.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 日期处理工具类
 */
public class TimeAndDateUtil {
	
	private static final Logger log = Logger.getLogger(TimeAndDateUtil.class);
	
	/**
	 * 常用小时
	 */
	public static final List<String> COMMON_HOUR = new ArrayList<String>(24);
	
	/**
	 * 常用分钟和秒钟
	 */
	public static final List<String> COMMON_MINUTE_OR_SECOND = new ArrayList<String>(60);
	
	/**
	 * 常用刻钟
	 */
	public static final List<String> SIMPLE_MINUTE = new ArrayList<String>(4);
	
	static{
		for(int i = 0 ; i <= 59 ;i ++)
		{
			String temp = "";
			if(i < 10)
			{
				temp = "0";
			}
			temp += i;
			COMMON_MINUTE_OR_SECOND.add(temp);
			if(i % 15 == 0)
			{
				SIMPLE_MINUTE.add(temp);
			}
			if(i <= 23)
			{
				COMMON_HOUR.add(temp);
			}
		}
	}
	
	/**
	 * 将时间按串按指定时间格式输出
	 * 
	 * @param dataTimeStr 时间串 
	 * 支持格式'yyyy-MM-dd HH:mm:ss SSS','yyyy-MM-dd HH:mm:ss','yyyy-MM-dd HH:mm'
	 * 'yyyy-MM-dd HH','yyyy-MM-dd','yyyy-MM','yyyy'
	 * @param formatKey 时间格式串 例如'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return String 按指定格式串的格式输出时间格式
	 */
	public static String format(String dataTimeStr, String formatKey) {
		SimpleDateFormat format = getDateFormat(formatKey);
		String[] items = dataTimeStr.split("[^0-9]+");
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;
		int millisecond = 0;
		switch (items.length) {
		case 7:
			millisecond = Integer.parseInt(items[6]);
		case 6:
			second = Integer.parseInt(items[5]);
		case 5:
			minute = Integer.parseInt(items[4]);
		case 4:
			hour = Integer.parseInt(items[3]);
		case 3:
			day = Integer.parseInt(items[2]);
		case 2:
			month = Integer.parseInt(items[1]);
		case 1:
			year = Integer.parseInt(items[0]);
			break;
		default:
			break;
		}
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return format.format(cal.getTime());
	}
	
	/**
	 * 下一个时间段
	 * 
	 * @param dataTimeStr 时间串
	 * @param field 指定下一个值的类型;
	 * 例如dataTimeStr = 2012-03; field = Calendar.MONTH
	 * 那么返回值为 2012-04
	 */
	public static String next(String dataTimeStr,int field) {
		String formatKey = null;
		Date date = null;
		try{
			switch (field) {
			case Calendar.YEAR:
				date = parseDate(dataTimeStr, formatKey = "yyyy");
				break;
			case Calendar.MONTH:
				date = parseDate(dataTimeStr, formatKey = "yyyy-MM");
				break;
			case Calendar.DAY_OF_MONTH:
				date = parseDate(dataTimeStr, formatKey = "yyyy-MM-dd");
				break;
			case Calendar.HOUR_OF_DAY:
				date = parseDate(dataTimeStr, formatKey = "yyyy-MM-dd HH");
				break;
			case Calendar.MINUTE:
				date = parseDate(dataTimeStr, formatKey = "yyyy-MM-dd HH:mm");
				break;
			case Calendar.SECOND:
				date = parseDate(dataTimeStr, formatKey = "yyyy-MM-dd HH:mm:ss");
				break;
			default:
				break;
			}
		}catch (Exception e) {
			log.error("", e);
		}
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		cal.add(field, 1);
		return format(cal.getTime(), formatKey);
	}
	
	/**
	 * 下一个时间段
	 * 
	 * @param date 时间
	 * @param field 指定下一个值的类型;
	 * 例如date = 2012-03 (Date 其他时间值只略); field = Calendar.MONTH
	 * 那么返回值为 2012-04
	 */
	public static String next(Date date,int field) {
		String formatKey = null;
		try{
			switch (field) {
			case Calendar.YEAR:
				formatKey = "yyyy";
				break;
			case Calendar.MONTH:
				formatKey = "yyyy-MM";
				break;
			case Calendar.DAY_OF_MONTH:
				formatKey = "yyyy-MM-dd";
				break;
			case Calendar.HOUR_OF_DAY:
				formatKey = "yyyy-MM-dd HH";
				break;
			case Calendar.MINUTE:
				formatKey = "yyyy-MM-dd HH:mm";
				break;
			case Calendar.SECOND:
				formatKey = "yyyy-MM-dd HH:mm:ss";
				break;
			default:
				break;
			}
		}catch (Exception e) {
			log.error("", e);
		}
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		cal.add(field, 1);
		return format(cal.getTime(), formatKey);
	}
	
	/**
	 * 下一个时间段
	 * 
	 * @param dateValue 时间毫秒值
	 * @param field 指定下一个值的类型;
	 * 例如dateValue = 2012-03 (long 表示的时间 其他时间值只略); field = Calendar.MONTH
	 * 那么返回值为 2012-04
	 */
	public static String next(long dateValue,int field) {
		Date date = new Date(dateValue);
		return next(date, field);
	}

	/**
	 * 将日期类型转为字符串格式
	 * 
	 * @param date 时间对象
	 * @param formatKey 时间输出格式 例如'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return String 按指定格式串的格式输出时间格式
	 */
	public static String format(Date date, String formatKey) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = getDateFormat(formatKey);
		return format.format(date);
	}
	
	/**
	 * 将日期类型转为字符串格式
	 * 
	 * @param dateTime 时间的毫秒值数据
	 * @param formatKey 时间输出格式 例如'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return String 按指定格式串的格式输出时间格式
	 */
	public static String format(long dateTime, String formatKey) {
		SimpleDateFormat format = getDateFormat(formatKey);
		return format.format(new Date(dateTime));
	}
	
	/**
	 * 将日期格式的字符串转为日期类型
	 * 
	 * @param source 时间对象
	 * @param formatKey 时间输出格式 例如'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return Date 日期格式的字符串表达的时间
	 * @throws ParseException 
	 */
	public static Date parseDate(String source , String formatKey) throws ParseException
	{
		SimpleDateFormat format = getDateFormat(formatKey);
		return format.parse(source);
	}

	/**
	 * 获取单例的 SimpleDateFormat对象
	 * 
	 * @param formatKey 时间格式 例如'yyyy-MM-dd HH:mm:ss'
	 */
	public static SimpleDateFormat getDateFormat(String formatKey) {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern(formatKey);
		return format;
	}
	
	/**
	 * 查看start和end是不是在同一个filed中
	 * 
	 * @param start 时间串
	 * @param end 时间串
	 * @param filed 比较类型，
	 * 
	 * 例如：filed = Calendar.YEAR是否为同一年;
	 * 		filed = Calendar.MONTH是否为同一月；
	 * 		filed = Calendar.DAY_OF_MONTH是否为同一天；
	 *  	filed = Calendar.HOUR_OF_DAY是否为同一小时内；
	 */
	public static boolean same(String start,String end,int filed)
	{
		boolean same = false;
		switch (filed) {
		case Calendar.YEAR:
			start = format(start, "yyyy");
			end = format(end, "yyyy");
			same = start.equals(end);
			break;

		case Calendar.MONTH:
			start = format(start, "yyyy-MM");
			end = format(end, "yyyy-MM");
			same = start.equals(end);
			break;
		case Calendar.DAY_OF_MONTH:
			start = format(start, "yyyy-MM-dd");
			end = format(end, "yyyy-MM-dd");
			same = start.equals(end);
			break;
		case Calendar.HOUR_OF_DAY:
			start = format(start, "yyyy-MM-dd HH");
			end = format(end, "yyyy-MM-dd HH");
			same = start.equals(end);
			break;
		case Calendar.MINUTE:
			start = format(start, "yyyy-MM-dd HH:mm");
			end = format(end, "yyyy-MM-dd HH:mm");
			same = start.equals(end);
			break;
		case Calendar.SECOND:
			start = format(start, "yyyy-MM-dd HH:mm:ss");
			end = format(end, "yyyy-MM-dd HH:mm:ss");
			same = start.equals(end);
			break;
		default:
			same = false;
			break;
		}
		return same;
	}
	
	/**
	 * 查看startDay和endDay是不是在同一个filed中
	 * 
	 * @param startDay 时间
	 * @param endDay 时间
	 * @param filed 比较类型，
	 * 
	 * 例如：filed = Calendar.YEAR是否为同一年;
	 * 		filed = Calendar.MONTH是否为同一月；
	 * 		filed = Calendar.DAY_OF_MONTH是否为同一天；
	 *  	filed = Calendar.HOUR_OF_DAY是否为同一小时内；
	 */
	public static boolean same(Date startDay,Date endDay,int filed)
	{
		String start = format(startDay, "yyyy-MM-dd HH:mm:ss");
		String end = format(endDay, "yyyy-MM-dd HH:mm:ss");
		return same(start, end, filed);
	}
	
	/**
	 * 查看startDay和endDay是不是在同一个filed中
	 * 
	 * @param startDay 时间长整形
	 * @param endDay 时间长整形
	 * @param filed 比较类型，
	 * 
	 * 例如：filed = Calendar.YEAR是否为同一年;
	 * 		filed = Calendar.MONTH是否为同一月；
	 * 		filed = Calendar.DAY_OF_MONTH是否为同一天；
	 *  	filed = Calendar.HOUR_OF_DAY是否为同一小时内；
	 */
	public static boolean same(long startDay,long endDay,int filed)
	{
		String start = format(startDay, "yyyy-MM-dd HH:mm:ss");
		String end = format(endDay, "yyyy-MM-dd HH:mm:ss");
		return same(start, end, filed);
	}

	
}
