package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.AdminDao;
import com.web.entity.Admin;
import com.web.util.PageUtil;

@Repository
public class AdminDaoImpl extends CommonDaoImpl<Admin> implements AdminDao {

	public List<Admin> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void queryPaging(PageUtil<Admin> paging, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	

}
