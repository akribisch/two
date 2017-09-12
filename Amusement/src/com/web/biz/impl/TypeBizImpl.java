package com.web.biz.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TypeBiz;
import com.web.dao.TypeDao;
import com.web.entity.Type;

@Service
public class TypeBizImpl extends CommonBizImpl<Type> implements TypeBiz {

	TypeDao td;

	@Resource(name="typeDaoImpl")
	public void setTd(TypeDao td) {
		this.td = td;
		super.setCommonDao(td);
	}
	
}
