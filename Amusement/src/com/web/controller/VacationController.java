package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.RecreationBiz;
import com.web.biz.VacationBiz;
import com.web.entity.Recreation;
import com.web.entity.Vacation;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="Vacation")
public class VacationController {
	
	@Resource(name="vacationBizImpl")
	VacationBiz vacationBiz;
	
	
	@Resource(name="recreationBizImpl")
	RecreationBiz recreationBiz;
	
	/**
	 * 查询娱乐项目转发到添加活动页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="sendAddVacation")
	public ModelAndView sendAddVacation(ModelAndView mv){
		List<Recreation> list=recreationBiz.queryAll();
		mv.addObject("list",list);
		mv.setViewName("addVacation");
		
		return mv;//localhost:8080/Amusement/Vacation/sendAddVacation.do
	}
	/**
	 * 添加优惠活动
	 * @param mv
	 * @param activeName
	 * @param recreationId
	 * @param discount
	 * @return
	 */
	@RequestMapping(value="addVacation")
	public ModelAndView addVacation(ModelAndView mv,String activeName,Integer recreationId,Double discount){
		Vacation vacation=new Vacation();
		
		if(activeName!=null){
			vacation.setActiveName(activeName);
		}
		if(recreationId!=null){
			Recreation re=new Recreation();
			re.setRno(recreationId);
			vacation.setRecreation(re);
		}
		if(discount!=null){
			vacation.setDiscount(discount);
		}
		boolean result=vacationBiz.add(vacation);
		
		if(result){
			mv.setViewName("redirect:/Vacation/queryVacation.do");
		}
		return mv;//localhost:8080/Amusement/Vacation/addVacation.do
	}
	/**
	 * 查询优惠活动
	 * @param mv
	 * @param page
	 * @param activeName
	 * @param discount1
	 * @param discount2
	 * @return
	 */
	@RequestMapping(value="queryVacation")
	public ModelAndView queryVacation(ModelAndView mv,Integer page,String activeName,Double discount1,Double discount2){
		Page<Vacation> pageUtil=new Page<>();//创建分页查询工具对象
		
		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
		
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(activeName)){
			map.put("activeName",activeName);
		}//向集合中添加活动名称参数
		if(discount1!=null){
			map.put("discount1",discount1);
		}//向集合中添加折扣1参数
		if(discount2!=null){
			map.put("discount2", discount2);
		}//向集合中添加折扣2参数
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
		
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
										
		vacationBiz.queryPaging(pageUtil, map);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		
		mv.setViewName("queryVacation");
		return mv;//localhost:8080/Amusement/Vacation/queryVacation.do
	}
	/**
	 * 查询要修改的优惠活动记录
	 * @param mv
	 * @param vacationId
	 * @return
	 */
	@RequestMapping(value="sendUpdateVacation")
	public ModelAndView sendUpdateVacation(ModelAndView mv,Integer vacationId){
		Vacation vacation=vacationBiz.findById(Vacation.class, vacationId);
		List<Recreation> list=recreationBiz.queryAll();
		
		mv.addObject("vacation",vacation);
		mv.addObject("list",list);
		mv.setViewName("updateVacation");
		return mv;//localhost:8080/Amusement/Vacation/sendUpdateVacation.do
	}
	/**
	 * 修改优惠活动记录
	 * @param mv
	 * @param vacation
	 * @param rno
	 * @return
	 */
	@RequestMapping(value="updateVacation")
	public ModelAndView updateVacation(ModelAndView mv,Vacation vacation,Integer rno){
		if(rno!=null){
			Recreation recreation=new Recreation();
			recreation.setRno(rno);
			vacation.setRecreation(recreation);
		}
		boolean result=vacationBiz.update(vacation);
		
		if(result){
			mv.setViewName("redirect:/Vacation/queryVacation.do");
		}else{
			int vacationId=vacation.getVacationId();
			mv.setViewName("redirect:/Vacation/sendUpdateVacation.do?vacationId="+vacationId);
		}
		return mv;//localhost:8080/Amusement/Vacation/updateVacation.do
	}
	/**
	 * 删除优惠活动记录
	 * @param mv
	 * @param vacation
	 * @return
	 */
	@RequestMapping(value="deleteVacation")
	public ModelAndView deleteVacation(ModelAndView mv,Vacation vacation){
		boolean result=vacationBiz.delete(vacation);
		if(result){
			mv.setViewName("redirect:/Vacation/queryVacation.do");
		}else{
			int vacationId=vacation.getVacationId();
			mv.setViewName("redirect:/Vacation/sendUpdateVacation.do?vacationId="+vacationId);
		}
		return mv;//localhost:8080/Amusement/Vacation/deleteVacation.do
	}
}
