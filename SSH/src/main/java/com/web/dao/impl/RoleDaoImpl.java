package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.RoleDao;
import com.web.entity.Role;
import com.web.util.PageUtil;

@Repository
public class RoleDaoImpl extends CommonDaoImpl<Role> implements RoleDao {

	/**
	 * 查询
	 */
	@SuppressWarnings("unchecked")
	public List<Role> query() {
		List<Role> list = new ArrayList<Role>();
		try {
			Session session = super.sessionFactory.getCurrentSession();
			
			list = session.createQuery("from Role").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void queryPaging(PageUtil<Role> paging, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	

}
