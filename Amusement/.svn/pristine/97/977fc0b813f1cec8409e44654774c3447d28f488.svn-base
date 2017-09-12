package com.web.biz.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TranstionBiz;
import com.web.dao.TranstionDao;
import com.web.entity.Transtion;
import com.web.util.Page;

@Service
public class TranstionBizImpl extends CommonBizImpl<Transtion> implements TranstionBiz {

	TranstionDao td;

	@Resource(name="transtionDaoImpl")
	public void setTd(TranstionDao td) {
		this.td = td;
		super.setCommonDao(td);
	}
	
	@Override
	public void queryPaging(Page<Transtion> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		td.queryPaging(paging, map, hql, hql2);
	}
}
