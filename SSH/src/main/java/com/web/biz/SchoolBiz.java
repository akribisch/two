package com.web.biz;

import java.util.List;

import com.web.entity.School;

public interface SchoolBiz extends CommonBiz<School> {
	
	public List<School> query();
	
}
