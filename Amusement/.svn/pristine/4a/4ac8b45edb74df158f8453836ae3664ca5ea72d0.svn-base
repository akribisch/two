package com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.DeviceBiz;
import com.web.biz.RepairBiz;
import com.web.entity.Device;
import com.web.entity.Repair;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="repair/")
public class RepairController {

	@Resource(name="repairBizImpl")
	RepairBiz rb;
	
	@Resource(name="deviceBizImpl")
	DeviceBiz db;
	
	@RequestMapping(value="queryAll")
	public ModelAndView queryAll(ModelAndView mv,Integer page,Integer deviceId){
		Page<Repair> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		List<Device> list= db.queryAll();
		mv.addObject("list", list);
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(deviceId!=null&&deviceId!=0){
			map.put("deviceId",deviceId );
		}
		mv.addObject("map", map);
		rb.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryAll");
		return mv;
	}
	
	@RequestMapping(value="sendAddRepair")
	public ModelAndView sendAddRepair(ModelAndView mv){
		List<Device> list= db.queryAll();
		mv.addObject("list", list);
		mv.setViewName("addRepair");
		return mv;
	}
	
	@RequestMapping(value="addRepair")
	public ModelAndView addDevice(ModelAndView mv,Repair repair,Integer deviceId){
		repair.setBeginDate(new Date());
		Device device=db.findById(Device.class, deviceId);
		device.setDeviceState("维修中");
		boolean flag=db.update(device);
		repair.setDevice(device);
		if(flag){
			flag=rb.add(repair);
		}
		mv.setViewName(flag?"redirect:/repair/queryAll.do":"redirect:/repair/sendAddRepair.do");
		return mv;
	}
	@RequestMapping(value="changeRepair")
	public ModelAndView changeRepair(ModelAndView mv,Integer repairId){
		Repair repair=rb.findById(Repair.class, repairId);
		mv.addObject("repair", repair);
		List<Device> list= db.queryAll();
		mv.addObject("list", list);
		mv.setViewName("changeRepair");
		return mv;
	}
	@RequestMapping(value="updateRepair")
	public ModelAndView updateRepair(ModelAndView mv,Repair repair,Integer deviceId,String beginDates){
		Date beginDate=StringUtil.StringToDateYMD(beginDates);
		Device device=db.findById(Device.class, deviceId);
		repair.setDevice(device);
		repair.setBeginDate(beginDate);
		boolean flag= rb.update(repair);
		mv.setViewName(flag?"redirect:/repair/queryAll.do":"redirect:/repair/changeRepair.do");
		return mv;
	}
	@RequestMapping(value="deleteRepair")
	public ModelAndView deleteRepair(ModelAndView mv,Integer repairId){
		Repair repair=rb.findById(Repair.class, repairId);
		rb.delete(repair);
		mv.setViewName("redirect:/repair/queryAll.do");
		return mv;
	}
}
