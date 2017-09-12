package com.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.web.biz.DepartmentBiz;
import com.web.biz.MenuBiz;
import com.web.biz.StationBiz;
import com.web.entity.Department;
import com.web.entity.Menu;
import com.web.entity.Station;
import com.web.entity.User;
import com.web.util.Page;
import com.web.util.PermissionsMenu;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="station/")
public class StationController {
	@Resource(name="stationBizImpl")
	StationBiz stationBiz;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz departmentBiz;
	
	@Resource(name="menuBizImpl")
	MenuBiz menuBiz;
	
	@RequestMapping(value="selectStation")
	public ModelAndView selectStation(ModelAndView mv,Integer page,String statName,Integer statNumMin,Integer statNumMax,Integer depId){
		List<Department> depList = departmentBiz.queryAll();
		mv.addObject("DepList",depList);
		
		Map<String, Object> map = new HashMap<>();
		if (statName != null) {
			map.put("statName", statName);
		}
		if (statNumMin != null) {
			map.put("statNumMin", statNumMin);
		}
		if (statNumMax != null) {
			map.put("statNumMax", statNumMax);
		}
		if (depId != null) {
			map.put("depId", depId);
		}
		
		Page<Station> pg = new Page<>();
		pg.setMap(map);
		pg.setCurrentPage(page != null ? page : 1);
		stationBiz.queryPaging(pg, map);
		
		mv.addObject("Paging",pg);
		mv.setViewName("selectStation");
		return mv;
	}
	
	@RequestMapping(value="updateById")
	public ModelAndView updateById(ModelAndView mv,Integer statId){
		//所有的菜单集合
		List<Menu> menulist = menuBiz.queryAll();
		Collections.sort(menulist);
		
		//对应Id的岗位的实体类，内含该岗位所能查看的菜单集合
		Station station = stationBiz.findById(Station.class, statId);
		mv.addObject("upStation",station);
		
		List<PermissionsMenu> mList = new ArrayList<>();
		for (Menu m1 : menulist) {
			PermissionsMenu perMenu = new PermissionsMenu(
					m1.getMenuId(), 
					m1.getMenuName(), 
					m1.getParentInt(), 
					m1.getMenuUrl(), 
					false);
			for (Menu m2 : station.getMenus()) {
				if (m1.getMenuId() == m2.getMenuId()) {
					perMenu.setVisible(true);
					break;
				}
			}
			mList.add(perMenu);
		}
		mv.addObject("menuList",mList);
		
		//所有的部门集合
		List<Department> depList = departmentBiz.queryAll();
		mv.addObject("DepList",depList);
		
		mv.setViewName("updateStation");
		return mv;
	}
	
	@RequestMapping(value="sendUpdateStation")
	public ModelAndView sendUpdateStation(ModelAndView mv,Integer statId,String statName,Integer statNum,double money,Integer depId,Integer[] check){
		Set<Menu> menus = new HashSet<>();
		for (Integer menuId : check) {
			Menu menu = new Menu();
			menu.setMenuId(menuId);
			menus.add(menu);
		}
		Station station = new Station(statId, statName, statNum, money, new Department(depId,null,0), menus);
		if (stationBiz.update(station)) {//修改成功
			mv.setViewName("redirect:/station/selectStation.do");
		}else{
			mv.setViewName("redirect:/station/updateById.do?statId="+statId);
		}
		return mv;
	}
	
	@RequestMapping(value="addStation")
	public ModelAndView addStation(ModelAndView mv){
		List<Menu> menulist = menuBiz.queryAll();
		Collections.sort(menulist);
		mv.addObject("menuList",menulist);//所有的菜单集合
		
		List<Department> depList = departmentBiz.queryAll();
		mv.addObject("DepList",depList);//所有的部门集合
		
		mv.setViewName("addStation");
		return mv;
	}
	
	
	@RequestMapping(value="sendAddStation")
	public ModelAndView sendAddStation(ModelAndView mv,String statName,Integer statNum,double money,Integer depId,Integer[] check){
		Set<Menu> menus = new HashSet<>();
		for (Integer menuId : check) {
			Menu menu = new Menu();
			menu.setMenuId(menuId);
			menus.add(menu);
		}
		Station station = new Station(0, statName, statNum, money, new Department(depId,null,0), menus);
		if (stationBiz.add(station)) {//添加成功
			mv.setViewName("redirect:/station/selectStation.do");
		}else{
			mv.setViewName("redirect:/station/addStation.do");
		}
		return mv;
	}
	
	@RequestMapping(value="deleteById")
	public ModelAndView deleteById(ModelAndView mv,Integer statId){
		Station station = new Station();
		station.setStatId(statId);
		if(stationBiz.delete(station)){//删除成功
			mv.setViewName("redirect:/station/selectStation.do");
		}else{
			mv.setViewName("redirect:/station/selectStation.do");
		}
		return mv;
	}
	
}
