package com.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.AdminBiz;
import com.web.dao.AdminDao;
import com.web.entity.Admin;

@Service
public class AdminBizImpl extends CommonBizImpl<Admin> implements AdminBiz {

	AdminDao adminDao;

	@Resource(name="adminDaoImpl")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		super.setCommonDao(adminDao);
	}
	
	
	
}
