package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.BankBiz;
import com.web.biz.DepartmentBiz;
import com.web.biz.StationBiz;
import com.web.entity.Bank;
import com.web.entity.Department;
import com.web.entity.Station;
import com.web.util.Page;

@Controller
@RequestMapping(value="station/")
public class StationController {

	@Resource(name="stationBizImpl")
	StationBiz sb;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz db;
	
	@Resource(name="bankBizImpl")
	BankBiz bb;
	
	@RequestMapping(value="findStation")
	public ModelAndView findStation(ModelAndView mv,Integer page,Integer minNum,String statName,Integer maxNum,Integer depId,Integer bankId){
		
		List<Department> deplist= db.select(new Page<>());
		List<Bank> banklist= bb.select(new Page<>());
		Page<Station> pages=new Page<>();
		Map<String, Object> map=new HashMap<>();
		map.put("minNum", minNum);
		map.put("statName", statName);
		map.put("maxNum", maxNum);
		map.put("depId", depId);
		map.put("bankId", bankId);
		if(page!=null){
			pages.setCurrentPage(page);
		}
		pages=sb.select(pages,map);
		mv.addObject("map",map);
		mv.addObject("deplist",deplist);
		mv.addObject("banklist",banklist);
		mv.addObject("page", pages);
		mv.setViewName("statlist");
		return mv;
	}
}
