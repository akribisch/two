package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.DepartmentBiz;
import com.web.biz.impl.BankBizImpl;
import com.web.entity.Bank;
import com.web.entity.Department;
import com.web.util.Page;

@Controller
@RequestMapping(value="department/")
public class DepartmentController {
	@Resource(name="departmentBizImpl")
	DepartmentBiz biz;
	@Resource(name="bankBizImpl")
	BankBizImpl sb;
	/**
	 *url:http://localhost:8080/BankSystem/department/queryDepartment.do
	 * 动态分页查询
	 * @param mv
	 * @param page
	 * @param depName
	 * @return
	 */
	@RequestMapping("queryDepartment")
	public ModelAndView querySavings(ModelAndView mv,Integer page,String depName){
		Page<Department> pg = new Page<>();
		Map<String,Object> map = new HashMap<>();
		map.put("depName",depName != null ? depName : "");
		
		//决定跳转的页数
		pg.setCurrentPage(page != null ? page : 1);
		pg.setMap(map);

		//动态查询的结果集总条目数
		int totalRecord = biz.selectCount(pg);
		pg.setTotalRecord(totalRecord);
		List<Department> list = biz.select(pg);
		pg.setList(list);
		mv.addObject("Paging", pg);
		//跳转页面
		mv.setViewName("queryDepartment");
		return mv;
	}
	@RequestMapping("sendAllDepartment")
	public ModelAndView sendAllDepartment(ModelAndView mv,Integer depId){
		Department department=biz.selectById(depId);
		List<Bank> list = sb.selectAll();
		mv.addObject("list", list);
		mv.addObject("department", department);
		mv.setViewName("updateDepartment");
		return mv;
		}
	@RequestMapping("updateDepartment")
	public ModelAndView updateDepartment(ModelAndView mv,Integer depId,String depName,Integer depNum,String depFunc,Integer bankId){
		Department department = new Department(depId,depName,depNum,depFunc,new Bank(bankId,null));
		int count = biz.updateById(department);
		if(count>0){
			mv.setViewName("redirect:http://localhost:8080/BankSystem/department/queryDepartment.do");
		}else{
			mv.setViewName("redirect:http://localhost:8080/BankSystem/department/queryDepartment.do");
		}
		return mv;
			
	}
	
	}
