package com.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.VipBiz;
import com.web.biz.VipLevelBiz;
import com.web.entity.Recreation;
import com.web.entity.Vip;
import com.web.entity.VipLevel;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="Vip")
public class VipController {
	
	@Resource(name="vipBizImpl")
	VipBiz vipBizImpl;
	
	
	@Resource(name="vipLevelBizImpl")
	VipLevelBiz vipLevelBizImpl;
	/**
	 * 添加vip卡
	 * @param mv
	 * @param vip
	 * @return
	 */
	@RequestMapping(value="addVip")
	public ModelAndView addVip(ModelAndView mv,String vNo,Integer levelId,Integer vCount,Integer vWholenumber){
		
		
		VipLevel vipLevel=new VipLevel();
		if(levelId!=null)
		{vipLevel.setLevelId(levelId);}
		
		Vip vip=new Vip();
		if(vNo!=null){
			vip.setvNo(vNo);
		}
		if(vCount!=null){
			
			vip.setvCount(vCount);
		}
		if(vWholenumber!=null){
			vip.setvWholenumber(vWholenumber);
		}
		
		VipLevel level=vipLevelBizImpl.findById(VipLevel.class, levelId);
		
		vip.setRemaining(level.getcPrice());
		vip.setvDate(new Date());
		
		VipLevel Level=vipLevelBizImpl.findById(VipLevel.class, levelId);//根据levelId查询卡种类的有效时间
		
		Date overDate=addDate(new Date(),Level.getValidDate());
		vip.setOverDate(overDate);
			
		vip.setVipLevel(vipLevel);

		boolean result=vipBizImpl.add(vip);
		if(result){
			mv.setViewName("redirect:/Vip/queryVip.do");//成功到查询页面
		}else{
			mv.setViewName("addVip");//失败到添加页面
		}
		return mv;//localhost:8080/Amusement/Vip/addVip.do
	}
	@RequestMapping(value="queryVip")
	public ModelAndView queryVip(ModelAndView mv,String vNo,String waring,Integer page){
		Page<Vip> pageUtil=new Page<>();//创建分页查询工具对象
		
		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
		
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(vNo)){
			map.put("vNo",vNo);
		}//向集合中添加卡编号
		

		if(!StringUtil.isEmpty(waring)){
			map.put("waring",waring);
		}//向集合中添加卡编号
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
		
		
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
		
		vipBizImpl.queryPaging(pageUtil, map);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		
		mv.setViewName("queryVip");
		return mv;//localhost:8080/Amusement/Vip/queryVip.do
	}
	/*
	 * 添加时间
	 */
	public Date addDate(Date date,int cycle){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, cycle);
		date =c.getTime();
		return date;
	}
	@RequestMapping(value="deletevId")
	public ModelAndView deletevId(ModelAndView mv,Vip vip){
		boolean result=false;
		try {
			result=vipBizImpl.delete(vip);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(result){
				mv.setViewName("redirect:/Vip/queryVip.do");
			}else{
				String string="不能删除此卡，因为正在使用";
				
				mv.setViewName("redirect:/Vip/queryVip.do?waring="+string);
			}
		}

		
		
		return mv;//localhost:8080/Amusement/Vip/deletevId.do
	}
}
