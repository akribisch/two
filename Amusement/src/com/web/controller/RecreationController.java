package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.RecreationBiz;

import com.web.entity.Recreation;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="Recreation/")
public class RecreationController {
	
	@Resource(name="recreationBizImpl")
	RecreationBiz recreationBizImpl;
	
	/**
	 * 添加娱乐项目
	 * @param mv
	 * @param recreation
	 * @return
	 */
	@RequestMapping(value="addRecreation")
	public ModelAndView addRecreation(ModelAndView mv,Recreation recreation){
		boolean result=recreationBizImpl.add(recreation);
		if(result){
			mv.setViewName("queryRecreation");//成功到查询页面
		}else{
			mv.setViewName("addRecreation");//失败到添加页面
		}
		
		return mv;
		
	}//localhost:8080/Amusement/Recreation/addRecreation
	@RequestMapping(value="queryRecreation")
	public ModelAndView queryRecreation(ModelAndView mv,String rname,String raddress,Integer page,Double Rpice1,Double Rpice2){
		Page<Recreation> pageUtil=new Page<>();//创建分页查询工具对象
		
		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
		
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(rname)){
			map.put("Rname",rname);
		}//向集合中添加项目名称参数
		if(!StringUtil.isEmpty(raddress)){
			map.put("Raddress",raddress);
		}//向集合中添加地址参数
		if(Rpice1!=null){
			map.put("Rpice1", Rpice1);
		}//向集合中添加价格一参数
		if(Rpice2!=null){
			map.put("Rpice2", Rpice2);
		}//向集合中添加价格二参数
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
				
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
					
		recreationBizImpl.queryPaging(pageUtil, map);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		
		mv.setViewName("queryRecreation");
		return mv;//localhost:8080/Amusement/Recreation/queryRecreation.do
	}
	@RequestMapping(value="sendUpdateRecreation")
	public ModelAndView sendUpdateRecreation(ModelAndView mv,Integer rno){
		Recreation re=recreationBizImpl.findById(Recreation.class, rno);
		mv.addObject("recreation",re);
		mv.setViewName("updateRecreation");
		return mv;//localhost:8080/Amusement/Recreation/sendUpdateRecreation.do
	}
	@RequestMapping(value="updateRecreation")
	public ModelAndView updateRecreation(ModelAndView mv,Recreation re){
		boolean result=recreationBizImpl.update(re);
		if(result){
			mv.setViewName("redirect:/Recreation/queryRecreation.do");
		}
		return mv;
	}//localhost:8080/Amusement/Recreation/updateRecreation.do
	@RequestMapping(value="deleteRecreation")
	public ModelAndView deleteRecreation(ModelAndView mv,Recreation re){
		boolean result=false;
		try {
			result=recreationBizImpl.delete(re);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(result){
				mv.setViewName("redirect:/Recreation/queryRecreation.do");
			}else{
				String string="不能删除此卡，因为正在使用";
				
				mv.setViewName("redirect:/Recreation/queryRecreation.do?waring="+string);
			}
		}

		return mv;
	}
}
