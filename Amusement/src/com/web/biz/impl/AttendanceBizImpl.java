package com.web.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.AttendanceBiz;
import com.web.dao.AttendanceDao;
import com.web.entity.Attendance;

@Service
public class AttendanceBizImpl extends CommonBizImpl<Attendance> implements AttendanceBiz {
	
	AttendanceDao attendanceDao;
	
	@Resource(name="attendanceDaoImpl")
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
		super.setCommonDao(attendanceDao);
	}

	@Override
	public Attendance findAttendance(Map<String, Object> map) {
		return attendanceDao.findAttendance(map);
	}

	@Override
	public Attendance findById(int id) {		
		return attendanceDao.findById(id);
	}

	@Override
	public int queryByUserNowMonth(Map<String, Object> map) {
		return attendanceDao.queryByUserNowMonth(map);
	}


}
