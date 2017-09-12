package com.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.dao.TypeDao;
import com.web.entity.Type;

@Repository
public class TypeDaoImpl extends CommonDaoImpl<Type> implements TypeDao {


	@Override
	public List<Type> queryAll(String hql) {
		hql="from Type";
		return super.queryAll(hql);
	}
	
}
