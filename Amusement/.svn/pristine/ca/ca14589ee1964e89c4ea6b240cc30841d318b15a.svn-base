package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TouristBiz;
import com.web.dao.TouristDao;
import com.web.entity.Tourist;
import com.web.util.Page;
@Service
public class TouristBizImpl extends CommonBizImpl<Tourist> implements TouristBiz {

	TouristDao td;
	
	@Resource(name="touristDaoImpl")
	public void setTd(TouristDao td) {
		this.td = td;
		super.setCommonDao(td);
	}



	@Override
	public void queryPaging(Page<Tourist> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		td.queryPaging(paging, map, hql, hql2);

	}



	@Override
	public Tourist findByTourCount(String name) {
		return td.findByTourCount(name);
	}



	@Override
	public List<Tourist> findBycondition(String tourPhone) {
		return td.findBycondition(tourPhone);
	}


}
