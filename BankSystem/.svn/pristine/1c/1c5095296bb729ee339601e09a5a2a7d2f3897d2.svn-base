package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.impl.ServiceBizImpl;
import com.web.entity.Service;
import com.web.util.Page;

/***
 * 
 * @author java201
 *
 */
@Controller
@RequestMapping(value="Service/")
public class ServiceController {

	@Resource(name="serviceBizImpl")
	ServiceBizImpl servicebizimpl;
	
	/**
	 * url:http://localhost:8080/BankSystem/Service/showService.do
	 * 
	 * 查询全部业务类型
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(path="showService")
	public ModelAndView select(ModelAndView mv,Integer page,Integer serId){
		
		//查询业务类型
		Service ser = new Service();
		ser.setSerId(serId != null ? serId : 0);
		
		//决定跳转的页数
		Page<Service> pg = new Page<>();
		pg.setCurrentPage(page != null ? page : 1 );
		pg.setObj(ser);
		int totalPage = servicebizimpl.selectCount(pg);
		pg.setTotalRecord(totalPage);
		
		List<Service> list1 = servicebizimpl.select(pg);
		
		pg.setList(list1);
		mv.addObject("Pageing", pg);
		mv.setViewName("showService");
		return mv;
	}
	
	/**
	 * 根据编号修改业务类型
	 * 
	 * url:http://localhost:8080/BankSystem/Service/updateService.do
	 * 
	 * @param mv
	 * @param service
	 * @return
	 */
	@RequestMapping(path="updateService")
	public ModelAndView update(ModelAndView mv,Service service){
		
		int count = servicebizimpl.updateServiceById(service);
		if(count == 1){
			mv.setViewName("redirect:/Service/showService.do");//修改成功跳转页面
		}else{
			mv.setViewName("loser");//修改失败跳转页面
		}
		return mv;
	}
	
	/**
	 * 根据编号删除业务类型
	 * 
	 * url:http://localhost:8080/BankSystem/Service/deleteService.do
	 * 
	 * @param mv
	 * @param service
	 * @return
	 */
	public ModelAndView delete(ModelAndView mv,Integer serId){
		int count = servicebizimpl.deleteServiceById(serId);
		if(count == 1){
			mv.setViewName("redirect:/Service/showService.do");//删除成功跳转页面
		}else{
			mv.setViewName("loser");//删除失败跳转页面
		}
		return mv;
	}
	
	/**
	 * 添加业务类型
	 * 
	 * url:http://localhost:8080/BankSystem/Service/insertService.do
	 * 
	 * @param mv
	 * @param service
	 * @return
	 */
	public ModelAndView insert(ModelAndView mv,Service service){
		int count = servicebizimpl.insertService(service);
		if(count == 1){
			mv.setViewName("redirect:/Service/showService.do");//添加成功跳转页面
		}else{
			mv.setViewName("loser");//添加失败跳转页面
		}
		return mv;
	}
}

