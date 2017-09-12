package com.web.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.TranstionDao;
import com.web.entity.Transtion;
import com.web.util.Page;

@Repository
public class TranstionDaoImpl extends CommonDaoImpl<Transtion> implements TranstionDao {


	@Override
	public void queryPaging(Page<Transtion> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls = new StringBuffer("from Transtion where 1=1 ");
		StringBuffer hqls2 = new StringBuffer("select count(*) from Transtion where 1=1 ");
		if(map != null){
			for (String key : map.keySet()) {
				if("deviceId".equals(key)){
					hqls.append(" and deviceId ="+map.get(key)+"");
					hqls2.append(" and deviceId ="+map.get(key)+"");
				}
				if("depId".equals(key)){
					hqls.append(" and depId ="+map.get(key)+"");
					hqls2.append(" and depId ="+map.get(key)+"");
				}
			}
		}
		hql=hqls.toString();
		hql2=hqls2.toString();
		super.queryPaging(paging, map, hql, hql2);
	}


}
