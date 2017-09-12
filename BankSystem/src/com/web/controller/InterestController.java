package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.InterestBiz;
import com.web.entity.Interest;
import com.web.util.Page;
import com.web.util.StringUtil;
/**
 * 利率控制层
 * @author liudong
 *
 */
@Controller
@RequestMapping
public class InterestController {
	
	
	@Resource(name="interestBizImpl")
	InterestBiz interestBiz;
	
	
	/**
	 * 添加利率记录
	 * @param mv
	 * @param interestName
	 * @param interest
	 * @param interestCycle
	 * @return
	 */
	@RequestMapping(path="addInterest")
	public ModelAndView addInterest(ModelAndView mv,String interestName,double interest,int interestCycle){
		
		Interest inter=new Interest();
		
		
		if(!StringUtil.isEmpty(interestName)){
			
			inter.setInterestName(interestName);
			
		}//设置对象的interestName值
		
		inter.setInterestCycle(interestCycle);//设置对象的InterestCycle值
		inter.setInterest(interest);//设置对象的Interest值
		
		int result=interestBiz.addInterest(inter);//添加利率记录
		if(result>0){
			 mv.setViewName("addInterestSuccess");
		}
		
		return mv;//localhost:8080/BankSystem/addInterest.do
	}
	
	/**
	 * 条件分页查询利率记录
	 * @param mv
	 * @param currentPage
	 * @param interestName
	 * @param interestCycle
	 * @return
	 */
	@RequestMapping(value="getInterest")
	public ModelAndView getInterest(ModelAndView mv,Integer page,String interestName,Integer interestCycle,Double interest){
		
		Page<Interest> pageUtil=new Page<>();//创建分页查询工具对象
		
		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
			
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		if(!StringUtil.isEmpty(interestName)){
			map.put("interestName", interestName);
		}//向集合中添加利率种类参数
		
		
		if(interest!=null){
			map.put("interest", interest);
		}//向集合中添加利率值参数
		
		if(interestCycle!=null){
			map.put("interestCycle", interestCycle);
		}//向集合中添加利率周期参数
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
		
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
		
		List<Interest> interestList=interestBiz.getInterest(map);//条件查询记录
		int InterestTotalCount= interestBiz.getInterestTotalCount(map);//田间查询总记录条数
		
		pageUtil.setList(interestList);
		pageUtil.setTotalRecord(InterestTotalCount);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		mv.setViewName("queryInterest");
		return mv;//localhost:8080/BankSystem/getInterest.do
	}
	/**
	 * 查询要修改的信息
	 * @param interestId
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="sendUpdate")
	public ModelAndView sendUpdate(Integer interestId,ModelAndView mv){
		
		
		Interest interest=interestBiz.sendUpdateInterest(interestId);
		
		mv.addObject("interest",interest);
		mv.setViewName("updateInterest");
		return mv;//localhost:8080/BankSystem/sendUpdate.do
	}
	/**
	 * 修改利率记录
	 * @param mv
	 * @param interest
	 * @return
	 */
	@RequestMapping(value="updateInterest")
	public ModelAndView updateInterest(ModelAndView mv,Integer interestId,String interestName,Double interest,Integer interestCycle){
		
		Map<String, Object> map=new HashMap<>();
		
		map.put("interestId", interestId);//添加利率编号参数
		if(!StringUtil.isEmpty(interestName)){
			map.put("interestName",interestName);//添加利率种类参数
		}
		if(interest!=null){
			map.put("interest", interest);//添加利率值参数
			
		}
		if( interestCycle!=null){
			map.put("interestCycle",interestCycle);//添加利率周期参数
			
		}
		
		
		int result=interestBiz.updateInterest(map);//调用修改参数
		
		if(result>0){
			 return new ModelAndView("redirect:/getInterest.do");//修改成功返回查询页面
		}else{
			
		}
		return mv;//localhost:8080/BankSystem/updateInterest.do
	}
	@SuppressWarnings("finally")
	@RequestMapping(value="deleteInterest")
	public ModelAndView  deleteInterest(Integer interestId){
		ModelAndView mv=new ModelAndView("redirect:/getInterest.do");
		int result=0;
		try {
			result=interestBiz.deleteInterestById(interestId);
		} catch (Exception e) {
		
		} finally {
			if(result>0){
				 return new ModelAndView("redirect:/getInterest.do");//删除成功返回查询页面
			}else{
				String alert="删除失败,可能某字段被引用为外键";
				mv.addObject("alert",alert);
				
				return mv;
			}
		}
	}
}
