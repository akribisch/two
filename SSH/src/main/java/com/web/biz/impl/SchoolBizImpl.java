package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.SchoolBiz;
import com.web.dao.SchoolDao;
import com.web.entity.School;
import com.web.util.PageUtil;

@Service
public class SchoolBizImpl extends CommonBizImpl<School> implements SchoolBiz {

	
	SchoolDao schoolDao;
	
	@Resource(name="schoolDaoImpl")
	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
		super.setCommonDao(schoolDao);
	}



	@Override
	public List<School> query() {
		// TODO Auto-generated method stub
		return schoolDao.query();
	}

}
