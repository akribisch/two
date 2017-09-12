package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.SchoolDao;
import com.web.entity.School;
import com.web.util.PageUtil;

@Repository
public class SchoolDaoImpl extends CommonDaoImpl<School> implements SchoolDao {

	
	public void queryPaging(PageUtil<School> paging, Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<School> query() {
		List<School> list = new ArrayList<>();
	     try {
	    	 list = super.sessionFactory.getCurrentSession().createQuery("from School").list();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
