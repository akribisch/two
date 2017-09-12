package com.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.web.entity.Salary;
import com.web.entity.User;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="Salary/")
public class SalaryController {
	
	@Resource(name="salaryBizImpl")
	SalaryBiz biz;
	
	@Resource(name="userBizImpl")
	UserBiz sn;
	@Resource(name="attendanceBizImpl")
	AttendanceBiz sb;
	/**
	 * 动态分页查询
	 * url:http://localhost:8080/Amusement/Salary/querySalary.do?select=all
	 * @param mv
	 * @param page
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="querySalary")
	public ModelAndView querySalary(ModelAndView mv,Integer page,String userName,String beginTime,String endTime,String select,HttpServletRequest req){
		Page<Salary> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if (select.equals("all")) {
			if(!StringUtil.isEmpty(userName)){
				map.put("userName", userName);
				User user = sn.findByName(userName);
				paging.setMap(map);
				int userId = user.getUserId();
				if(userId!=0){
					map.put("userId", userId);
				}
			}
			if(!StringUtil.isEmpty(beginTime)){
				map.put("beginTime", beginTime);
				paging.setMap(map);
			}
			if(!StringUtil.isEmpty(endTime)){
				map.put("endTime", endTime);
				paging.setMap(map);
			}
			biz.queryPaging(paging, map);
			mv.addObject("paging", paging);
			mv.setViewName("querysalary");
		}else if(select.equals("one")) {
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("User");
			int userId = u.getUserId();
			map.put("userId", userId);
			if(!StringUtil.isEmpty(beginTime)){
				map.put("beginTime", beginTime);
				paging.setMap(map);
			}
			if(!StringUtil.isEmpty(endTime)){
				map.put("endTime", endTime);
				paging.setMap(map);
			}
			biz.queryPaging(paging, map);
			mv.addObject("paging", paging);
			mv.setViewName("queryOnesalary");
		}
		
		return mv;
		
	}
	@RequestMapping(value="queryAllSalary")
	public ModelAndView queryAllSalary(ModelAndView mv){
		int count;
		Map<String, Object> map=new HashMap<>();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a = dateFormat.format(now);
		Date date1 = StringUtil.StringToDate(a);
		String b = a.substring(0,8);
		String c = "01";
		String beginTime = b+c;
		map.put("beginTime", beginTime);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String endTime = format.format(calendar.getTime());
		int MonthDay = Integer.parseInt(endTime.substring(8, 10));
		map.put("endTime", endTime);
		String beginState = "正常";
		map.put("beginState", beginState);
		String endState ="正常";
		map.put("endState", endState);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String overTime = format.format(calendar.getTime());
		map.put("overTime", overTime);
		List<User> list = sn.queryAll();
		count = list.size();
		int counts = biz.queryCount(map);
		if(counts!=count){
			for (User user : list) {
				Salary salary = new Salary();
				int  userId = user.getUserId();
				map.put("userId",userId );
				int cc = sb.queryByUserNowMonth(map);		
				salary.setId(0);
				salary.setMonth(date1);
				salary.setMonthMoney(user.getStation().getMoney()-(MonthDay-cc)*50);
				salary.setNormal(cc);
				salary.setUnnormal(MonthDay-cc);
				salary.setUser(user);
				boolean flag = biz.add(salary);
				count--;
			}
			if(count==0){
				mv.setViewName("redirect:querySalary.do?select=all");
			}
		}else{
			mv.setViewName("redirect:querySalary.do?select=all");
		}
		
		return mv;
	}
}











