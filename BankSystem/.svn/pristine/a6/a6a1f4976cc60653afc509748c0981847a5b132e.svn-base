package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.SavStateBiz;
import com.web.entity.SavState;
import com.web.util.Page;
import com.web.util.StringUtil;


@Controller
@RequestMapping
public class SavStateController {
	
	@Resource(name="savStateBizImpl")
	SavStateBiz savStateBiz;
	
	
	/**
	 * 添加账号状态记录
	 * @param mv
	 * @param savState
	 * @return
	 */
	@RequestMapping(value="addSavState")
	public ModelAndView addSavSate(ModelAndView mv,SavState savState){
		int result=savStateBiz.addSavState(savState);
		if(result>0){
			mv.setViewName("addSavState");
		}
		return mv;//localhost:8080/BankSystem/addSavState.do
	}
	/**
	 * 查询账号状态记录
	 * @param mv
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping(value="querySavState")
	public ModelAndView querySavState(ModelAndView mv,Integer page,SavState savState){
		Page<SavState> pageUtil=new Page<>();//创建分页查询工具对象
		

		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
			
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(savState.getSavStat())){
			map.put("savstat", savState.getSavStat());
		}//向集合中添加账号状态参数
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
		
		
		
		
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
		
		
		List<SavState> savStateList=savStateBiz.querySavState(map);//条件查询
		int savStateTotalCount=savStateBiz.getSavStateTotalCount(map);//查询总记录条数
		
		pageUtil.setList(savStateList);
		pageUtil.setTotalRecord(savStateTotalCount);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		mv.setViewName("querySavState");
		
		return mv;//localhost:8080/BankSystem/querySavState.do
	}
	
}
