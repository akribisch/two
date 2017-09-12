package com.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.web.biz.SchoolBiz;
import com.web.entity.School;

@Controller
@Namespace("/")
@ParentPackage("json-default")
public class SchoolController extends ActionSupport {
	
	@Resource(name="schoolBizImpl")
	SchoolBiz schoolBiz;

	List<School> schoolList = new ArrayList<>();
	
	@Action(value="querySchool",results={@Result(name="success",type="json",params={"root","schoolList"})})
	public String query(){
		schoolList = this.schoolBiz.query();
		return SUCCESS;
	}

	public List<School> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<School> schoolList) {
		this.schoolList = schoolList;
	}
	
	
}
