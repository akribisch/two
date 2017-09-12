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
import com.web.entity.House;
import com.web.biz.HouseBiz;



@Controller
@Namespace("/") 
@ParentPackage("json-default") 
public class HouseController extends  ActionSupport{
	
	@Resource(name="houseBizImpl")
	HouseBiz houseBiz;

	List<House> list = new ArrayList<House>();
	
	 @Action(value = "test", results = {
                 @Result(name = "success", location = "/index.jsp")})
	public String index(){
		System.out.println("okokopkoko---------------------");
		return SUCCESS;
	}
	
	//@Action(value="getHouseList", results={@Result(type="json",name="success",params={"root","list"})})
	@Action(value="getHouseList",results={@Result(type="json",name="success",params={"root","list"} )}) 
	public String query(){
		list = this.houseBiz.query();
		return SUCCESS;
	}

	public List<House> getList() {
		return list;
	}

	public void setList(List<House> list) {
		this.list = list;
	}
	
	
}
