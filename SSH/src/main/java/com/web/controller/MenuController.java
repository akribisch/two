package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.web.biz.MenuBiz;
import com.web.entity.Menu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@Namespace("/") // @RequestMapping(value="")
@ParentPackage("json-default") 
public class MenuController extends ActionSupport {
	
	@Resource(name="menuBizImpl")
	MenuBiz menuBiz;
	
	JSONArray arr = new JSONArray();
	
	/**
	 * url:searchMenu.action
	 * @return
	 */
	@Action(value="searchMenu",results={@Result(type="json",name="success",params={"root","arr"} )})
	public String searchMenu(){
		 List<Menu>  list = this.menuBiz.findByParentId(0);
		 
		 for (Menu menu : list) {
			JSONObject json = new JSONObject();
			
			json.put("id", menu.getMenuId());
			json.put("text", menu.getMenuName());
			json.put("url", menu.getMenuUrl());
			json.put("img", menu.getMenuImage());
			
			//递归
			json.put("children", recurse(menu));
			
			arr.add(json);
		}
		 return SUCCESS;
	}
	
	/**
	 * 递归下面的子菜单
	 * @param menu
	 * @return
	 */
	public JSONArray recurse(Menu menu){
		List<Menu> childMenu = menu.getChildMenu();
		
		JSONArray jsonArray = new JSONArray();
		
		if(childMenu != null && childMenu.size() > 0){
			for (Menu child : childMenu) {
	            JSONObject json = new JSONObject();
				
				json.put("id", child.getMenuId());
				json.put("text", child.getMenuName());
				json.put("url", child.getMenuUrl());
				json.put("img", child.getMenuImage());
				
				json.put("children", recurse(child));
				
				jsonArray.add(json);
			}
		}
		return jsonArray;
	}

	public JSONArray getArr() {
		return arr;
	}

	public void setArr(JSONArray arr) {
		this.arr = arr;
	}

	
	
}
