package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.VipLevelBiz;
import com.web.entity.VipLevel;

@Controller
@RequestMapping(value="VipLevel")
public class VipLevelController {
	
	/**
	 * 添加VIP卡级别
	 */
	@Resource(name="vipLevelBizImpl")
	VipLevelBiz vipLevelBizImpl;
	@RequestMapping(value="addVipLevel")
	public ModelAndView addVipLevel(ModelAndView mv,VipLevel vipLevel){
		boolean result=vipLevelBizImpl.add(vipLevel);
		if(result){
			mv.setViewName("redirect:/VipLevel/queryVipLevel.do");//成功到查询页面
		}else{
			mv.setViewName("addVipLevel");//失败到添加页面
		}
		
		return mv;//localhost:8080/Amusement/VipLevel/addVipLevel.do
	}
	/**
	 * 查询
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="queryVipLevel")
	public ModelAndView queryVipLevel(ModelAndView mv){
		
		
		
		List<VipLevel> vipLevelList=vipLevelBizImpl.queryAll();
		
		mv.addObject("list", vipLevelList);
		mv.setViewName("queryVipLevel");
		return mv;//localhost:8080/Amusement/VipLevel/queryVipLevel.do
	}
	/**
	 * 根据编号查询修改的信息
	 * @param mv
	 * @param levelId
	 * @return
	 */
	@RequestMapping(value="sendUpdateVipLevel")
	public ModelAndView sendUpdateVipLevel(ModelAndView mv,String levelId){
		
		VipLevel vipLevel=vipLevelBizImpl.findById(VipLevel.class, Integer.valueOf(levelId));
		mv.addObject("vipLevel",vipLevel);
		mv.setViewName("updateVipLevel");
		return mv;
	}
	/**
	 * 修改
	 * @param mv
	 * @param vipLevel
	 * @return
	 */
	@RequestMapping(value="updateVipLevel")
	public ModelAndView updateVipLevel(ModelAndView mv,VipLevel vipLevel){
		boolean result=vipLevelBizImpl.update(vipLevel);
		
		if(result){
			mv.setViewName("redirect:/VipLevel/queryVipLevel.do");
		}else{
			mv.setViewName("updateVipLevel");
		}
		
		return mv;//localhost:8080/Amusement/VipLevel/updateVipLevel.do
	}
	/**
	 * 查询传到卡的添加页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="queryVipLevelToAdd")
	public ModelAndView queryVipLevelToAdd(ModelAndView mv){
		
		
		
		List<VipLevel> vipLevelList=vipLevelBizImpl.queryAll();
		
		mv.addObject("list", vipLevelList);
		mv.setViewName("/Vip/addVip");
		return mv;//localhost:8080/Amusement/VipLevel/queryVipLevelToAdd.do
	}
}
