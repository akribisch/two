package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.FinalKindBiz;
import com.web.entity.FinalKind;

import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="FinalKind")
public class FinalKindController {
	
	@Resource(name="finalKindBizImpl")
	FinalKindBiz finalKindBiz;
	
	/**
	 * 添加产品种类
	 * @param mv
	 * @param finalKind
	 * @return
	 */
	@RequestMapping(value="insertFinalKind")
	public ModelAndView insertFinalKind(ModelAndView mv,FinalKind finalKind){
		
		int result=finalKindBiz.insertFinalKind(finalKind);
		
		if(result>0){
			 return new ModelAndView("redirect:/FinalKind/findAllKind.do");//添加成功返回查询页面
			
		}
		mv.setViewName("queryFinalKind");
		
		return mv;//localhost:8080/BankSystem/insertFinalKind.do
	}
	
	@RequestMapping(value="findAllKind")
	public ModelAndView findAllKind(ModelAndView mv,Integer page,FinalKind finalKind){
		
		Page<FinalKind> pageUtil=new Page<>();//创建分页查询工具对象
		

		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
			
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(finalKind.getFkName())){
			map.put("fkName",finalKind.getFkName());
		}//向集合中添加账号状态参数
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
		
		
		
		
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
		
		
		List<FinalKind> finalKindList=finalKindBiz.findAllKind(map);//条件查询
		int finalKindTotalCount=finalKindBiz.getFinalKindTotalCount(map);//查询总记录条数
		
		pageUtil.setList(finalKindList);
		pageUtil.setTotalRecord(finalKindTotalCount);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		mv.setViewName("queryFinalKind");
		
		return mv;//localhost:8080/BankSystem/FinalKind/findAllKind.do
	}
	/**
	 * 根据编号查询
	 * @param mv
	 * @param fkId
	 * @return
	 */
	@RequestMapping(value="queryFinalKindByid")
	public ModelAndView queryFinalKindByid(ModelAndView mv,Integer fkId){
		FinalKind FinalKind=finalKindBiz.queryFinalKindById(fkId);
		
		mv.addObject("FinalKind",FinalKind);
		mv.setViewName("updateFinalKind");
		return mv;//localhost:8080/BankSystem/FinalKind/sendUpdate.do
		
	}
	/**
	 * 修改产品类型
	 */
	@RequestMapping(value="updateFinalKind")
	public ModelAndView updateFinalKind(ModelAndView mv,FinalKind finalKind){
		int result=finalKindBiz.updateFinalKind(finalKind);
		
		
		if(result>0){
			return new ModelAndView("redirect:/FinalKind/findAllKind.do");
		}else{
			
		}
		return mv;
	}
	/*
	 * 无条件查询全部
	 */
	@RequestMapping(value="getAllFinalKind")
	public ModelAndView getAllFinalKind(ModelAndView mv){
		
		
		
		List<FinalKind> finalKindList=finalKindBiz.getAllFinalKind();
		
	
		
		mv.addObject("finalKindList",finalKindList);
		
		//mv.setViewName("redirect:/Financial/addFinancial.jsp");
		 mv.setViewName("/Financial/addFinancial");
		return mv;
	}
}
