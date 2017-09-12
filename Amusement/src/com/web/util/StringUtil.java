package com.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串处理工具类
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		
		if(str == null){
			return true;
		}
		
		return str.length() <=0 ? true : false;
	}
	
	/**
	 * 字符串转日期yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static Date StringToDate(String str){
		Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			d = sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @return
	 */
	public static String DateToString(Date date){
		String str = null;
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			str = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 字符串转日期yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static Date StringToDateYMD(String str){
		Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			d = sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 日起计算
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static long getCountTime(Date beginTime,Date endTime){
		long begin = beginTime.getTime();
		long end = endTime.getTime();
		long result = (end - begin)/(1000 * 60 * 60);
		return result;
	}
	
}
