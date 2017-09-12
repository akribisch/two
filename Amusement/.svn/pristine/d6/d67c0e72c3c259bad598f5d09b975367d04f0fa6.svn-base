package com.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.DepartmentBiz;
import com.web.biz.StationBiz;
import com.web.biz.UserBiz;
import com.web.entity.Department;
import com.web.entity.Menu;
import com.web.entity.Station;
import com.web.entity.User;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="user/")
public class UserController {
	
	@Resource(name="userBizImpl")
	UserBiz userBiz;//业务逻辑层
	
	@Resource(name="stationBizImpl")
	StationBiz stationBiz;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz departmentBiz;
	
	/**
	 * 登陆验证
	 * URL:/user/login.do
	 * @param u
	 * @param mv
	 * @param req
	 * @return
	 */
	@RequestMapping(value="login")
	public ModelAndView login(User u,ModelAndView mv,HttpServletRequest req){
		User user = userBiz.login(u);
		if (user != null) {//登陆成功
			HttpSession session = req.getSession();
			session.setAttribute("User", user);//员工信息存入session中
			Station station = stationBiz.findById(Station.class, user.getStation().getStatId());
			List<Menu> menulist = new ArrayList<>(station.getMenus());
			Collections.sort(menulist);
			mv.addObject("menuList",menulist);
			mv.setViewName("/menu/main");
		}else{
			mv.setViewName("redirect:/user/login.jsp");
		}
		return mv;
	}
	
	/**
	 * 动态查询+分页
	 * URL:user/select.do
	 * @param mv
	 * @param page
	 * @param userName
	 * @param sex
	 * @param stationid
	 * @param state
	 * @return
	 */
	@RequestMapping(value="select")
	public ModelAndView select(ModelAndView mv,Integer page,String userName,Integer sex,Integer stationid,Integer state){
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName != null ? userName : null);
		map.put("sex", (sex == null || sex == -1) ? "-1" : sex);
		map.put("stationid", (stationid == null || stationid == -1) ? "-1" : stationid);
		map.put("state", (state == null || state == -1) ? "-1" : state);
		
		Page<User> pg = new Page<>(); 
		pg.setMap(map);
		pg.setCurrentPage(page != null ? page : 1);
		userBiz.queryPaging(pg, map);
		
		List<Station> list =  stationBiz.queryAll();
		mv.addObject("StatList",list);
		mv.addObject("Paging",pg);
		mv.setViewName("selectUser");
		return mv;
	}
	
	
	@RequestMapping(value="updateById")
	public ModelAndView updateById(ModelAndView mv,Integer userId){
		User u = userBiz.findById(User.class, userId);
		List<Station> list =  stationBiz.queryAll();
		mv.addObject("StatList",list);
		mv.addObject("upUser",u);
		mv.setViewName("updateUser");
		return mv;
	}
	
	@RequestMapping(value="sendUpdateUser")
	public ModelAndView sendUpdateUser(ModelAndView mv,Integer userId,String userName,String password,String phone,Integer sex,String birthday,Integer statId,Integer oldStatId,Integer state){
		User u = new User(userId, userName, password, new Station(statId, null, 0, 0, null, null), phone, sex, StringUtil.StringToDateYMD(birthday), state);
		if (userBiz.update(u)) {//修改成功
			if (oldStatId != statId) {
				Station sta1 = stationBiz.findById(Station.class, oldStatId);
				sta1.setStatNum(sta1.getStatNum() - 1 );
				stationBiz.update(sta1);
				
				Department dep1 = departmentBiz.findById(Department.class, sta1.getDepartment().getDepId());
				dep1.setDepNum(dep1.getDepNum() - 1 );
				departmentBiz.update(dep1);
				
				Station sta2 = stationBiz.findById(Station.class, statId);
				sta2.setStatNum(sta2.getStatNum() + 1 );
				stationBiz.update(sta2);
				
				Department dep2 = departmentBiz.findById(Department.class, sta2.getDepartment().getDepId());
				dep2.setDepNum(dep2.getDepNum() + 1 );
				departmentBiz.update(dep2);
			}
			
			mv.setViewName("redirect:/user/select.do");
		}else{
			mv.setViewName("redirect:/user/updateById.do?userId="+userId);
		}
		return mv;
	}
	
	@RequestMapping(value="addUser")
	public ModelAndView addUser(ModelAndView mv,Integer userId){
		List<Station> list =  stationBiz.queryAll();//岗位集合
		mv.addObject("StatList",list);
		mv.setViewName("addUser");
		return mv;
	}
	
	
	@RequestMapping(value="sendAddUser")
	public ModelAndView sendAddUser(ModelAndView mv,String userName,String password,String phone,Integer sex,String birthday,Integer statId){
		User u = new User(0, userName, password, new Station(statId, null, 0, 0, null, null), phone, sex, StringUtil.StringToDateYMD(birthday), 0);
		if (userBiz.add(u)) {//添加成功
			Station station = stationBiz.findById(Station.class, u.getStation().getStatId());
			station.setStatNum(station.getStatNum() + 1 );
			stationBiz.update(station);
			
			Department department = departmentBiz.findById(Department.class, station.getDepartment().getDepId());
			department.setDepNum(department.getDepNum() + 1 );
			departmentBiz.update(department);
			
			mv.setViewName("redirect:/user/select.do");
		}else{
			mv.setViewName("redirect:/user/addUser.do");
		}
		return mv;
	}
	
	@RequestMapping(value="deleteById")
	public ModelAndView deleteById(ModelAndView mv,Integer userId){
		User u = userBiz.findById(User.class, userId);
		if(userBiz.delete(u)){
			Station station = stationBiz.findById(Station.class, u.getStation().getStatId());
			station.setStatNum(station.getStatNum() - 1 );
			stationBiz.update(station);
			
			Department department = departmentBiz.findById(Department.class, station.getDepartment().getDepId());
			department.setDepNum(department.getDepNum() - 1 );
			departmentBiz.update(department);
			
			mv.setViewName("redirect:/user/select.do");
		}else{
			mv.setViewName("redirect:/user/select.do");
		}
		return mv;
	}
	
}
