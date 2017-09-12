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
import com.web.biz.TypeBiz;
import com.web.entity.Device;
import com.web.entity.Type;
import com.web.util.Page;
import com.web.util.StringUtil;


@Controller
@RequestMapping(value="device/")
public class DeviceController {

	@Resource(name="deviceBizImpl")
	DeviceBiz db;
	
	@Resource(name="typeBizImpl")
	TypeBiz tb;
	
	@RequestMapping(value="queryDevice")
	public ModelAndView queryDevice(ModelAndView mv,Integer page,String deviceTypeId,String deviceName,Integer typeId){
		Page<Device> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(deviceTypeId!=null){
			map.put("deviceTypeId",deviceTypeId );
		}
		if(deviceName!=null){
			map.put("deviceName",deviceName );
		}
		if(typeId!=null&&typeId!=0){
			map.put("typeId",typeId);
		}
		mv.addObject("map", map);
		List<Type> list= tb.queryAll();
		mv.addObject("list", list);
		db.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryDevice");
		return mv;
	}
	
	@RequestMapping(value="sendAddDevice")
	public ModelAndView sendAddDevice(ModelAndView mv){
		List<Type> list= tb.queryAll();
		mv.addObject("list", list);
		mv.setViewName("addDevice");
		return mv;
	}
	@RequestMapping(value="addDevice")
	public ModelAndView addDevice(ModelAndView mv,Device device,Integer typeId){
		device.setBuyDate(new Date());
		device.setDeviceState("正常");
		device.setType(new Type(typeId, null));
		boolean flag=db.add(device);
		
		mv.setViewName(flag?"redirect:/device/queryDevice.do":"redirect:/device/sendAddDevice.do");
		return mv;
	}
	@RequestMapping(value="changeDevice")
	public ModelAndView changeDevice(ModelAndView mv,Integer deviceId){
		Device device= db.findById(Device.class, deviceId);
		mv.addObject("device", device);
		List<Type> list= tb.queryAll();
		mv.addObject("list", list);
		mv.setViewName("changeDevice");
		return mv;
	}
	@RequestMapping(value="updateDevice")
	public ModelAndView updateDevice(ModelAndView mv,Device device,Integer typeId,Integer stateId,String buyDates){
		Date buyDate= StringUtil.StringToDateYMD(buyDates);
		device.setBuyDate(buyDate);
		device.setType(new Type(typeId, null));
		if(stateId==1){
			device.setDeviceState("正常");
		}else if(stateId==2){
			device.setDeviceState("维修中");
		}else if(stateId==3){
			device.setDeviceState("报废");
		}
		boolean flag=db.update(device);
		mv.setViewName(flag?"redirect:/device/queryDevice.do":"redirect:/device/changeDevice.do");
		return mv;
	}
	@RequestMapping(value="deleteDevice")
	public ModelAndView deleteDevice(ModelAndView mv,Integer deviceId){
		Device device= db.findById(Device.class, deviceId);
		db.delete(device);
		mv.setViewName("redirect:/device/queryDevice.do");
		return mv;
	}
}
