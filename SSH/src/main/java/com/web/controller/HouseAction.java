//package com.web.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;
//import com.web.biz.HouseBiz;
//import com.web.entity.House;
//
//@Controller//控制层
//@Scope(value="prototype")//原型实例化   每次调用它都会实例化一次
//public class HouseAction extends ActionSupport implements ModelDriven<House>{
//
//	@Resource(name="houseBizImpl")
//	HouseBiz houseBiz;
//	
//	House house = new House();
//	List<House> list = new ArrayList<House>();
//	
//	public House getModel() {
//		return house;
//	}
//	
//	/**
//	 * 添加
//	 * @return
//	 */
//	public String add(){
//		
//		boolean flag = this.houseBiz.add(house);
//		
//		return flag ? SUCCESS : INPUT;
//	}
//
//	public String query(){
//		
//		list = this.houseBiz.query();
//		return SUCCESS;
//	}
//	
//	public String sendUpdate(){
//		house = this.houseBiz.findById(house.getId());
//		return SUCCESS;
//	}
//	
//	public String update(){
//		boolean flag = this.houseBiz.update(house);
//		return flag ? SUCCESS : INPUT;
//	}
//
//	public List<House> getList() {
//		return list;
//	}
//
//	public void setList(List<House> list) {
//		this.list = list;
//	}
//
//	public House getHouse() {
//		return house;
//	}
//
//	public void setHouse(House house) {
//		this.house = house;
//	}
//	
//	
//}
