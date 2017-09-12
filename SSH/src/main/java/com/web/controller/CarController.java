package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.web.biz.CarBiz;
import com.web.entity.Car;
import com.web.util.JSONResult;
import com.web.util.PageUtil;


@Controller
@Namespace("/")
@ParentPackage("json-default")
public class CarController extends ActionSupport{

	@Resource(name="carBizImpl")
	CarBiz cb;
	
	private Integer page;//页码
	private Integer rows;//每页显示的条数
	
	JSONResult<Car> result=new JSONResult<>();
	
	
	@Action(value="queryCar",results={@Result(name="success",type="json",params={"root","result"})})
	public String queryCar(){
		PageUtil<Car> paging=new PageUtil<>();
		Map<String, Object> map=new HashMap<>();
		if(page != null){
			paging.setCurrentPage(page);
		}
		
		if(rows != null){
			paging.setPageSize(rows);
		}
		cb.queryPaging(paging, map);
		
		result.setTotal(paging.getTotalCount());
		result.setRows(paging.getData());
		
		return SUCCESS;
		
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public JSONResult<Car> getResult() {
		return result;
	}


	public void setResult(JSONResult<Car> result) {
		this.result = result;
	}
	
	
}
