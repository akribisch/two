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
import com.web.biz.FeedbackBiz;
import com.web.biz.UserBiz;
import com.web.entity.Department;
import com.web.entity.Device;
import com.web.entity.Feedback;
import com.web.entity.Type;
import com.web.entity.User;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="feedback/")
public class FeedbackController {

	@Resource(name="feedbackBizImpl")
	FeedbackBiz fb;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz db;
	
	@Resource(name="deviceBizImpl")
	DeviceBiz devb;
	
	@Resource(name="userBizImpl")
	UserBiz ub;
	
	@RequestMapping(value="queryFeedback")
	public ModelAndView queryFeedback(ModelAndView mv,Integer page,String userName,String deviceName,Integer departId){
		Page<Feedback> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(userName!=null){
			map.put("userName",userName );
		}
		if(deviceName!=null){
			map.put("deviceName",deviceName );
		}
		if(departId!=null&&departId!=0){
			map.put("departId",departId);
		}
		mv.addObject("map", map);
		List<Department> departlist= db.queryAll();
		mv.addObject("departlist", departlist);
		fb.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryFeedback");
		return mv;
	}
	
	@RequestMapping(value="sendAddFeedback")
	public ModelAndView sendAddFeedback(ModelAndView mv){
		List<Department> departlist= db.queryAll();
		List<Device> devicelist= devb.queryAll();
		mv.addObject("departlist", departlist);
		mv.addObject("devicelist", devicelist);
		mv.setViewName("addFeedback");
		return mv;
	}
	
	@RequestMapping(value="addFeedback")
	public ModelAndView addFeedback(ModelAndView mv,Feedback feedback,
			Integer depId,Integer deviceId,String userName,String repairDates,String orderDates){
		
		User user=ub.findByName(userName);
		if(user!=null){
			feedback.setUser(user);
		}
		Device device= devb.findById(Device.class, deviceId);
		feedback.setDevice(device);
		Department depart= db.findById(Department.class, depId);
		feedback.setDepart(depart);
		Date reapirdate= StringUtil.StringToDateYMD(repairDates);
		feedback.setRepairDate(reapirdate);
		Date orderdate= StringUtil.StringToDateYMD(orderDates);
		feedback.setOrderDate(orderdate);
		boolean flag=fb.add(feedback);
		mv.setViewName(flag?"redirect:/feedback/queryFeedback.do":"redirect:/feedback/sendAddFeedback.do");
		return mv;
	}
	
	@RequestMapping(value="deleteFeedback")
	public ModelAndView deleteFeedback(ModelAndView mv,Integer feedId){
		Feedback feedback= fb.findById(Feedback.class, feedId);
		fb.delete(feedback);
		mv.setViewName("redirect:/feedback/queryFeedback.do");
		return mv;
	}
	
	@RequestMapping(value="changeFeedback")
	public ModelAndView changeFeedback(ModelAndView mv,Integer feedId){
		List<Department> departlist= db.queryAll();
		List<Device> devicelist= devb.queryAll();
		mv.addObject("departlist", departlist);
		mv.addObject("devicelist", devicelist);
		Feedback feedback= fb.findById(Feedback.class, feedId);
		mv.addObject("feedback", feedback);
		mv.setViewName("changeFeedback");
		return mv;
	}
	
	@RequestMapping(value="updateFeedback")
	public ModelAndView updateFeedback(ModelAndView mv,Feedback feedback,
			Integer depId,Integer deviceId,String userName,String repairDates,String orderDates){
		User user=ub.findByName(userName);
		if(user!=null){
			feedback.setUser(user);
		}
		Device device= devb.findById(Device.class, deviceId);
		feedback.setDevice(device);
		Department depart= db.findById(Department.class, depId);
		feedback.setDepart(depart);
		Date reapirdate= StringUtil.StringToDateYMD(repairDates);
		feedback.setRepairDate(reapirdate);
		Date orderdate= StringUtil.StringToDateYMD(orderDates);
		feedback.setOrderDate(orderdate);
		boolean flag=fb.update(feedback);
		mv.setViewName(flag?"redirect:/feedback/queryFeedback.do":"redirect:/feedback/changeFeedback.do");
		return mv;
	}
}
