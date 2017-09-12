package com.web.biz.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.RepairBiz;
import com.web.dao.RepairDao;
import com.web.entity.Repair;
import com.web.util.Page;

@Service
public class RepairBizImpl extends CommonBizImpl<Repair> implements RepairBiz {

	RepairDao rd;

	@Resource(name="repairDaoImpl")
	public void setRd(RepairDao rd) {
		this.rd = rd;
		super.setCommonDao(rd);
	}

	@Override
	public void queryPaging(Page<Repair> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		rd.queryPaging(paging, map, hql, hql2);
	}
	
}
