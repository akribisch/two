package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.impl.FlowBizImpl;
import com.web.biz.impl.ServiceBizImpl;
import com.web.entity.Flow;
import com.web.entity.Service;
import com.web.util.Page;
import com.web.util.StringUtil;

/**
 * url:http://localhost:8080/BankSystem/Flow/showFlow.do
 * 
 *	流水表实体类控制层
 * @author java201
 *
 */
@Controller//控制器
@RequestMapping(value="Flow/")//请求路径
public class FlowController {

	@Resource(name="flowBizImpl")
	FlowBizImpl flowbizimpl;
	
	@Resource(name="serviceBizImpl")
	ServiceBizImpl servicebizimpl;
	
	@RequestMapping(path="showFlow")
	public ModelAndView select(ModelAndView mv,Integer page,Integer serId,String beginDate,String endDate){
		
		
		//查询业务类型
		Service ser = new Service();
		ser.setSerId(serId != null ? serId : 0);
		Flow f = new Flow();
		f.setService(ser);
		
		
		//查询开始和结束时间
		Map<String, Object> map = new HashMap<>();
		map.put("beginDate", (beginDate == null || beginDate == "") ? beginDate : StringUtil.StringToDate(beginDate));
		map.put("endDate", (endDate == null || endDate == "") ? endDate : StringUtil.StringToDate(endDate));
		
		//决定跳转的页数
		Page<Flow> pg = new Page<>();
		pg.setCurrentPage(page != null ? page : 1);
		pg.setObj(f);
		pg.setMap(map);
		
		//动态查询的结果集总条目数
		int totalPage = flowbizimpl.selectCount(pg);
		pg.setTotalRecord(totalPage);
		
		List<Flow> list = flowbizimpl.select(pg);
		pg.setList(list);
		
		//传递业务类型
		List<Service> serList = servicebizimpl.selectAll();
		
		mv.addObject("serList", serList);
		
		mv.addObject("Pageing", pg);
		//跳转页面
		mv.setViewName("showFlow");
		return mv;
	}
	
	/**
	 * http://localhost:8080/BankSystem/Flow/UpdateFlow.do
	 */
	public ModelAndView update(ModelAndView mv,Flow flow){
		int count = flowbizimpl.updateById(flow);
		if(count == 1){
			mv.setViewName("redirect:/Flow/showFlow.do");
		}else{
			mv.setViewName("loser");
		}
		return mv;
	}
}
