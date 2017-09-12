package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.web.biz.AttendanceBiz;
import com.web.biz.SalaryBiz;
import com.web.biz.UserBiz;
import com.web.biz.WorkTimeBiz;
import com.web.entity.Attendance;
import com.web.entity.Salary;
import com.web.entity.User;
import com.web.entity.WorkTime;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="Attendance/")
public class AttendanceController {
	
	@Resource(name="attendanceBizImpl")
	AttendanceBiz biz;
	@Resource(name="workTimeBizImpl")
	WorkTimeBiz ub;
	@Resource(name="userBizImpl")
	UserBiz sn;
	@Resource(name="salaryBizImpl")
	SalaryBiz sb;
	/**
	 * 动态分页查询
	 * url:http://localhost:8080/Amusement/Attendance/queryAttendance.do?select=all
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="queryAttendance")
	public ModelAndView queryAttendance(ModelAndView mv,Integer page,String userName,String select,HttpServletRequest req,String beginTime,String endTime,String beginState,String endState){
		Page<Attendance> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();	
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if (select.equals("all")) {
			if(!StringUtil.isEmpty(beginTime)){
				map.put("beginTime", beginTime);
				paging.setMap(map);
			}
			if(!StringUtil.isEmpty(endTime)){
				map.put("endTime", endTime);
				paging.setMap(map);
			}
			if(beginState != null && (!beginState.equals("无"))){
				map.put("beginState", beginState);
				paging.setMap(map);
			}
			if(endState != null && (!endState.equals("无"))){
				map.put("endState", endState);
				paging.setMap(map);
			}
			
			if(!StringUtil.isEmpty(userName)){
				map.put("userName", userName);
				User user = sn.findByName(userName);
				paging.setMap(map);
				int userId = user.getUserId();
				if(userId!=0){
					map.put("userId", userId);
				}
			}
			biz.queryPaging(paging, map);
			mv.addObject("paging", paging);
			mv.setViewName("queryAttendance");
		}else if (select.equals("one")) {
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("User");
			int userId = u.getUserId();
			map.put("userId", userId);
			paging.setMap(map);
			if(!StringUtil.isEmpty(beginTime)){
				map.put("beginTime", beginTime);
				paging.setMap(map);
			}
			if(!StringUtil.isEmpty(endTime)){
				map.put("endTime", endTime);
				paging.setMap(map);
			}
			if(beginState != null && (!beginState.equals("无"))){
				map.put("beginState", beginState);
				paging.setMap(map);
			}
			if(endState != null && (!endState.equals("无"))){
				map.put("endState", endState);
				paging.setMap(map);
			}
			biz.queryPaging(paging, map);
			mv.addObject("paging", paging);
			mv.setViewName("queryOneAttendance");
		}
			
			return mv;
	}
	/**
	 * 上班打卡
	 * @param mv
	 * @param userName
	 * @param beginState
	 * @return
	 */
	@RequestMapping(value="addAttendance")
	public ModelAndView addAttendance(ModelAndView mv,HttpServletRequest req){
		Map<String, Object> map=new HashMap<>();
		//User user = new User(1,userName,null,null,null,0,null,0);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String begin = dateFormat.format(now);
		Date date1 = StringUtil.StringToDate(begin);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("User");
//		User us = sn.findByName(userName);
//		int userId = us.getUserId();
		int userId = u.getUserId();
		String b = begin.substring(0,11);
		String f = "00:00:00";
		String g = b+f;
		Date beginTime = StringUtil.StringToDate(g);
		if(beginTime!=null){
			map.put("beginTime", g);
		}
		if(userId != 0){
			map.put("userId", userId);
		}
		if(date1!=null){
			map.put("endTime", begin);
		}
		String e = "08:30:00";
		String h = b+e;
		Date date2 = StringUtil.StringToDate(h);
//		List<WorkTime> list = ub.queryAll();
//		WorkTime s = list.get(0);
//		Date start = s.getStart();
		Attendance attendance = biz.findAttendance(map);
		if(attendance!=null){
			attendance.setBeginTime(date1);
			if(date1.getTime()>=date2.getTime()){
				attendance.setBeginState("迟到");
			}else{
				attendance.setBeginState("正常");
			}
			boolean flag = biz.update(attendance);
			if(flag){					
				mv.setViewName("redirect:queryAttendance.do?select=one");		
			}	
		}else{
			Attendance newattendance = new Attendance();
			newattendance.setBeginTime(date1);
			newattendance.setUser(u);
			if(date1.getTime()>=date2.getTime()){
				newattendance.setBeginState("迟到");
			}else{
				newattendance.setBeginState("正常");
			}
			boolean flag = biz.add(newattendance);
			if(flag){
				mv.setViewName("redirect:queryAttendance.do?select=one");		
		}
	}
		return mv;
	}
	/**
	 * 下班打卡
	 * @param mv
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="updateAttendance")
	public ModelAndView updateAttendance(ModelAndView mv,HttpServletRequest req){
		Map<String, Object> map=new HashMap<>();
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("User");
		int userId = u.getUserId();
		if(userId!=0){
			map.put("userId", userId);
		}
		Date a = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String end = dateFormat.format(a);
		String b = end.substring(0,11);
		String c = "00:00:00";
		String d = b+c;
		Date beginTime = StringUtil.StringToDate(d);
		if(beginTime!=null){
			map.put("beginTime", d);
		}
		Date date1 = StringUtil.StringToDate(end);
		if(date1!=null){
			map.put("endTime", end);
		}
		String e = "17:30:00";
		String h = b+e;
		Date date2 = StringUtil.StringToDate(h);
//		List<WorkTime> list = ub.queryAll();
//		WorkTime s = list.get(0);
//		Date  endtime= s.getEnd();
		Attendance attendance = biz.findAttendance(map);
		if(attendance!=null){
			attendance.setEndTime(StringUtil.StringToDate(end));
			if(date1.getTime()>=date2.getTime()){
				attendance.setEndState("正常");
			}else{
				attendance.setEndState("早退");
			}
			boolean flag =  biz.update(attendance);
			if(flag){
				mv.setViewName("redirect:queryAttendance.do?select=one");
			}else{
				mv.setViewName("redirect:queryAttendance.do?select=one");
			}
		}
		return mv;
	}
}
