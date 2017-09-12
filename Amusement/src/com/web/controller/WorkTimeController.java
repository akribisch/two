package com.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.WorkTimeBiz;
import com.web.entity.WorkTime;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="WorkTime/")
public class WorkTimeController {
	
	@Resource(name="workTimeBizImpl")
	WorkTimeBiz work;
	
	/**
	 *url:http://localhost:8080/Amusement/WorkTime/queryWorkTime.do
	 * 调整上下班时间
	 * @param s
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="sendupdateWorkTime")
	public ModelAndView sendupdateWorkTime(ModelAndView mv,Integer wid){
		if(wid!=null){
			WorkTime worktime = work.findById(WorkTime.class, wid);
			mv.addObject("worktime", worktime);
			mv.setViewName("updateWorkTime");
		}else{
			mv.setViewName("redirect:http://localhost:8080/Amusement/WorkTime/queryWorkTime.do");
		}
		return mv;
	}
	
	@RequestMapping(value="updateWorkTime")
	public ModelAndView updateWorkTime(Integer wid,String start,String end,ModelAndView mv){
		WorkTime worktime = new WorkTime();
		if(wid!=null){
			worktime.setWid(wid);
		}
		worktime.setWid(1);
		if(start!=null){
			Date date1 = StringUtil.StringToDate(start);
			worktime.setStart(date1);
		}
		if(end!=null){
			Date date2 = StringUtil.StringToDate(end);
			worktime.setEnd(date2);
		}
		boolean flag = work.update(worktime);
		if(flag){
			mv.setViewName("redirect:http://localhost:8080/Amusement/WorkTime/queryWorkTime.do");
		}else{
			mv.setViewName("redirect:http://localhost:8080/Amusement/WorkTime/queryWorkTime.do");
		}
		return mv;
	}
	@RequestMapping(value="queryWorkTime")
	public ModelAndView queryWorkTime(ModelAndView mv){
		
		List<WorkTime> list = work.queryAll();
		mv.addObject("list",list);
		mv.setViewName("queryWorkTime");
		return mv;
	}
}
