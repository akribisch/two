package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.TypeBiz;
import com.web.entity.Type;

@Controller
@RequestMapping(value="type/")
public class TypeController {

	@Resource(name="typeBizImpl")
	TypeBiz tb;
	
	@RequestMapping(value="addType")
	public ModelAndView addType(ModelAndView mv,String typeName){
		if(typeName!=null){
			tb.add(new Type(0, typeName));
		}
		mv.setViewName("addType");
		return mv;
	}
	
}
