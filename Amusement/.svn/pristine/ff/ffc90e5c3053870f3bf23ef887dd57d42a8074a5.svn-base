package com.web.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.RepairDao;
import com.web.entity.Repair;
import com.web.util.Page;
@Repository
public class RepairDaoImpl extends CommonDaoImpl<Repair> implements RepairDao {

	@Override
	public void queryPaging(Page<Repair> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls = new StringBuffer("from Repair where 1=1 ");
		
		if(map != null){
			for (String key : map.keySet()) {
				if("deviceId".equals(key)){
					hqls.append(" and deviceId ="+map.get(key)+"");
				}
			}
		}
		hql=hqls.toString();
		StringBuffer hqls2 = new StringBuffer("select count(*) from Repair where 1=1 ");
		
		if(map != null){
			for (String key : map.keySet()) {
				if("deviceId".equals(key)){
					hqls2.append(" and deviceId ="+map.get(key)+"");
				}
			}
		}
		hql2= hqls2.toString();
		super.queryPaging(paging, map, hql, hql2);
	}

}
