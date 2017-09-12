package com.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串工具类
 * @author java201
 *
 */
public class StringUtil {
	
	/**
	 *判断字符串是否为空
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
	 * 判断整形数据是否为空
	 * @param num
	 * @return
	 */
	public static boolean isNotEmpty(Integer num){
		
		return num != null ? true : false;
	}
	
	/**
	 * 字符串转换为日期格式
	 * @param str
	 * @return
	 */
	public static Date StringToDate(String str){
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
	 * 日期转换为字符串格式
	 * @param date
	 * @return
	 */
	public static String DateToString(Date date){
		String str = null;
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			str = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 截取地址
	 * @param url
	 * @return
	 */
	public static String removeUrlPrefix(String url){
		
		String newUrl = "";
		
		if(!StringUtil.isEmpty(url)){
			if(url.startsWith("/SpringMVC_2/attached/image/")){
				newUrl = url.substring("/SpringMVC_2/attached/image/".length());
			}
		}
		return newUrl;
	}

}
