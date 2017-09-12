package com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.DepartmentBiz;
import com.web.biz.DeviceBiz;
import com.web.biz.TranstionBiz;
import com.web.entity.Department;
import com.web.entity.Device;
import com.web.entity.Transtion;
import com.web.entity.Type;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="transtion/")
public class TranstionController {

	@Resource(name="transtionBizImpl")
	TranstionBiz tb;
	
	@Resource(name="deviceBizImpl")
	DeviceBiz db;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz depb;
	
	@RequestMapping(value="queryTranstion")
	public ModelAndView queryTranstion(ModelAndView mv,Integer page,Integer depId ,Integer deviceId){
		Map<String, Object> map=new HashMap<>();
		Page<Transtion> paging=new Page<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(deviceId!=null&&deviceId!=0){
			map.put("deviceId",deviceId );
		}
		if(depId!=null&&depId!=0){
			map.put("depId",depId );
		}
		mv.addObject("map", map);
		List<Device> list= db.queryAll();
		mv.addObject("devicelist", list);
		List<Department> deplist= depb.queryAll();
		mv.addObject("deplist", deplist);
		tb.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryTranstion");
		return mv;
	}
	
	@RequestMapping(value="sendAddTranstion")
	public ModelAndView sendAddTranstion(ModelAndView mv){
		List<Device> list= db.queryAll();
		mv.addObject("devicelist", list);
		List<Department> deplist= depb.queryAll();
		mv.addObject("deplist", deplist);
		mv.setViewName("addTranstion");
		return mv;
	}
	
	@RequestMapping(value="addTranstion")
	public ModelAndView addTranstion(ModelAndView mv,Integer deviceId,Integer depId,Transtion trans){
		Device device= db.findById(Device.class, deviceId);
		Department dep= depb.findById(Department.class, depId);
		trans.setDepart(dep);
		trans.setDevice(device);
		trans.setBeginDate(new Date());
		boolean flag= tb.add(trans);
		mv.setViewName(flag?"redirect:/transtion/queryTranstion.do":"redirect:/transtion/sendAddTranstion.do");
		return mv;
	}
	@RequestMapping(value="changeTranstion")
	public ModelAndView changeTranstion(ModelAndView mv,Integer transId){
		Transtion trans= tb.findById(Transtion.class, transId);
		mv.addObject("trans", trans);
		List<Device> list= db.queryAll();
		mv.addObject("devicelist", list);
		List<Department> deplist= depb.queryAll();
		mv.addObject("deplist", deplist);
		mv.setViewName("changeTranstion");
		return mv;
	}
	
	@RequestMapping(value="updateTranstion")
	public ModelAndView updateTranstion(ModelAndView mv,Integer deviceId,Integer depId,Transtion trans,String beginDates){
		Date beginDate=StringUtil.StringToDateYMD(beginDates);
		Device device= db.findById(Device.class, deviceId);
		Department dep= depb.findById(Department.class, depId);
		trans.setDepart(dep);
		trans.setDevice(device);
		trans.setBeginDate(beginDate);
		boolean flag= tb.update(trans);
		mv.setViewName(flag?"redirect:/transtion/queryTranstion.do":"redirect:/transtion/changeTranstion.do");
		return mv;
	}
	
	@RequestMapping(value="deleteTranstion")
	public ModelAndView deleteTranstion(ModelAndView mv,Integer transId){
		Transtion trans= tb.findById(Transtion.class, transId);
		tb.delete(trans);
		mv.setViewName("redirect:/transtion/queryTranstion.do");
		return mv;
	}
}
