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
import com.web.biz.MenuBiz;
import com.web.biz.StationBiz;
import com.web.entity.Menu;
import com.web.entity.Station;
import com.web.entity.User;
import com.web.util.Page;

@Controller
@RequestMapping(value="menu/")
public class MenuController {
	
	@Resource(name="menuBizImpl")
	MenuBiz menuBiz;
	
	@Resource(name="stationBizImpl")
	StationBiz stationBiz;
	
	@RequestMapping(value="showMenu")
	public ModelAndView showMenu(HttpServletRequest req,ModelAndView mv){
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("User");
		Station station = stationBiz.findById(Station.class, u.getStation().getStatId());
		List<Menu> menulist = new ArrayList<>(station.getMenus());
		Collections.sort(menulist);
		mv.addObject("menuList",menulist);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping(value="selectMenu")
	public ModelAndView selectMenu(ModelAndView mv,Integer page,String menuName){
		Map<String, Object> map = new HashMap<>();
		map.put("menuName", menuName);
		
		Page<Menu> pg = new Page<>();
		pg.setMap(map);
		pg.setCurrentPage(page != null ? page : 1);
		menuBiz.queryPaging(pg, map);
		
		mv.addObject("Paging",pg);
		mv.setViewName("selectMenu");
		return mv;
	}
	
	@RequestMapping(value="addMenu")
	public ModelAndView addMenu(ModelAndView mv){
		List<Menu> menulist = menuBiz.queryAll();
		Collections.sort(menulist);
		mv.addObject("menuList",menulist);
		mv.setViewName("addMenu");
		return mv;
	}
	
	@RequestMapping(value="sendAddMenu")
	public ModelAndView sendAddMenu(ModelAndView mv,String menuName,Integer parentInt,String menuUrl){
		Menu m = new Menu(0, menuName, parentInt, menuUrl);
		if(menuBiz.add(m)){//添加成功
			mv.setViewName("redirect:/menu/selectMenu.do");
		}else {
			mv.setViewName("redirect:/menu/addMenu.do");
		}
		return mv;
	}
	
	@RequestMapping(value="updateById")
	public ModelAndView updateById(ModelAndView mv,Integer menuId){
		List<Menu> menulist = menuBiz.queryAll();
		Collections.sort(menulist);
		mv.addObject("menuList",menulist);
		
		Menu m = menuBiz.findById(Menu.class, menuId);
		mv.addObject("upMenu",m);
		
		mv.setViewName("updateMenu");
		return mv;
	}
	
	@RequestMapping(value="sendUpdateMenu")
	public ModelAndView sendUpdateMenu(ModelAndView mv,Integer menuId,String menuName,Integer parentInt,String menuUrl){
		Menu m = new Menu(menuId, menuName, parentInt, menuUrl);
		if(menuBiz.update(m)){//修改成功
			mv.setViewName("redirect:/menu/selectMenu.do");
		}else {
			mv.setViewName("redirect:/menu/updateById.do?menuId="+menuId);
		}
		return mv;
	}
	
	@RequestMapping(value="deleteById")
	public ModelAndView deleteById(ModelAndView mv,Integer menuId){
		if(menuBiz.delete(new Menu(menuId, null, 0, null))){//删除成功
			mv.setViewName("redirect:/menu/selectMenu.do");
		}else {
			mv.setViewName("redirect:/menu/selectMenu.do");
		}
		return mv;
	}
}
