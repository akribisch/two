package com.web.dao;


import java.util.Map;

import com.web.entity.Attendance;

public interface AttendanceDao extends CommonDao<Attendance> {
	/**
	 * 通过Id查找对象
	 * @param id
	 * @return
	 */
	public Attendance findById(int id);
	/**
	 * 查找打卡人当天记录
	 * @param map
	 * @return
	 */
	public Attendance findAttendance(Map<String,Object> map);
	/**
	 * 查找条数
	 * @param map
	 * @return
	 */
	public int queryByUserNowMonth(Map<String,Object> map);
}
