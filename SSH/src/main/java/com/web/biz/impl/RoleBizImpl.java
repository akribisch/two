package com.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.RoleBiz;
import com.web.dao.RoleDao;
import com.web.entity.Role;


@Service
public class RoleBizImpl extends CommonBizImpl<Role> implements RoleBiz {

	RoleDao roleDao;

	@Resource(name="roleDaoImpl")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		super.setCommonDao(roleDao);
	}

}
