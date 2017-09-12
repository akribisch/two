package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.web.biz.DepartmentBiz;
import com.web.entity.Department;
import com.web.util.Page;

@Controller
@RequestMapping(value="department/")
public class DepartmentController {
	@Resource(name="departmentBizImpl")
	DepartmentBiz departmentBiz;
	
	@RequestMapping(value="select")
	public ModelAndView select(ModelAndView mv,Integer page,String depName,Integer depNumMin,Integer depNumMax){
		Map<String, Object> map = new HashMap<>();
		if (depName != null && depName != "") {
			map.put("depName", depName);
		}
		if (depNumMin != null && depNumMin != 0) {
			map.put("depNumMin", depNumMin);
		}
		if (depNumMax != null && depNumMax != 0) {
			map.put("depNumMax", depNumMax);
		}
		
		Page<Department> pg = new Page<>();
		pg.setMap(map);
		pg.setCurrentPage(page != null ? page : 1);
		departmentBiz.queryPaging(pg, map);
		
		mv.addObject("Paging",pg);
		mv.setViewName("selectDepartment");
		return mv;
	}
	
	@RequestMapping(value="addDepartment")
	public ModelAndView addDepartment(ModelAndView mv,String depName){
		Department dep = new Department(0, depName, 0);
		if (departmentBiz.add(dep)) {//添加成功
			mv.setViewName("redirect:/department/select.do");
		}else {
			mv.setViewName("redirect:/department/addDepartment.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value="deleteById")
	public ModelAndView deleteById(ModelAndView mv,Integer depId){
		Department dep = new Department(depId, null, 0);
		if (departmentBiz.delete(dep)) {//删除成功
			mv.setViewName("redirect:/department/select.do");
		}else {
			mv.setViewName("redirect:/department/select.do");
		}
		return mv;
	}
	
	@RequestMapping(value="updateById")
	public ModelAndView updateById(ModelAndView mv,Integer depId){
		Department dep = departmentBiz.findById(Department.class, depId);
		mv.addObject("upDep",dep);
		mv.setViewName("updateDepartment");
		return mv;
	}
	
	@RequestMapping(value="sendUpdateDepartment")
	public ModelAndView sendUpdateDepartment(ModelAndView mv,Department department){
		if (departmentBiz.update(department)) {//修改成功
			mv.setViewName("redirect:/department/select.do");
		}else {
			mv.setViewName("redirect:/department/updateById.do?depId="+department.getDepId());
		}
		return mv;
	}
	
}
