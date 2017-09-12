package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.web.biz.UserBiz;
import com.web.entity.User;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="")
public class UserController {
	
	@Resource(name="userBizImpl")
	UserBiz ub;
	/**
	 * 动态分页查询用户信息
	 * @param mv
	 * @return
	 */
	//http://localhost:8080/BankSystem/queryUser.do
	@RequestMapping("queryUser")
	public ModelAndView query(ModelAndView mv,Integer currentPage,String uphone,String uidcard){
		  Page<User> page = new Page<>();
		  if(currentPage!=null){
			  page.setCurrentPage(currentPage);
			}//设置当前页
		  Map<String, Object> map=new HashMap<>();//创建组装参数集合
		  if(!StringUtil.isEmpty(uphone)){
				map.put("uphone", uphone);
			}
		  if(!StringUtil.isEmpty(uidcard)){
				map.put("uidcard", uidcard);
			}
		  int prev=(page.getCurrentPage()-1)*page.getPageSize();//计算limit排除的总页数
		  map.put("prev", prev);//添加排除总页数参数
		  map.put("pageSize", page.getPageSize());//添加每页显示记录条数的参数
		  List<User>  pages  =  ub.queryPageUser(map);//条件查询记录
		  int Count = ub.queryPageUserCount(map);//查询总记录条数
		  page.setList(pages);
		  page.setTotalRecord(Count);
		  String nav=page.getNav();
		  mv.addObject("nav",nav);
		  mv.addObject("page", page);
		  mv.setViewName("queryAllUser");
		  return mv;
	}
	/**
	 * 添加用户信息
	 * @param mv
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser")
	public  ModelAndView addUser(ModelAndView mv,User user){
		int count = ub.addUser(user);
		if(count>0){
			mv.setViewName("redirect:/queryUser.do");
		}else{
			mv.setViewName("redirect:/addUser.do");
		}
			
		return mv;
	}
	/**
	 * 保存修改数据
	 * @param mv
	 * @param userId
	 * @return
	 */
	@RequestMapping("sendAllUser")
	public  ModelAndView sendAllUser(ModelAndView mv,Integer userId){
		User user = ub.queryById(userId);
		mv.addObject("user", user);
		mv.setViewName("updateUser");
		return mv;
	}
	/**
	 * 修改
	 * @param mv
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public  ModelAndView updateUser(ModelAndView mv,User user){
		ub.updateUser(user);
		mv.setViewName("redirect:/queryUser.do");
		return mv;
	}
	@RequestMapping("deleteUser")
	public  ModelAndView deleteUser(ModelAndView mv,Integer userId){
		int count =ub.delectUser(userId);
		if(count>0){
			mv.setViewName("success");
		}else{
			mv.setViewName("fail");
		}
		return mv;
	}
}
