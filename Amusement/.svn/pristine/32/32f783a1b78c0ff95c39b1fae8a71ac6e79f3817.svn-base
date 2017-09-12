package com.web.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.FeedbackDao;
import com.web.entity.Feedback;
import com.web.util.Page;

@Repository
public class FeedbackDaoImpl extends CommonDaoImpl<Feedback> implements FeedbackDao {

	@Override
	public void queryPaging(Page<Feedback> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls=new StringBuffer("from Feedback where 1=1 ");
		StringBuffer hqls2=new StringBuffer("select count(*) from Feedback where 1=1 ");
		if(map!=null){
			for (String item : map.keySet()) {
				if("departId".equals(item)){
					hqls.append(" and departId='"+map.get(item)+"'");
					hqls2.append(" and departId='"+map.get(item)+"'");
				}
				if("userName".equals(item)){
					hqls.append(" and userName like '%"+map.get(item)+"%'");
					hqls2.append(" and userName like '%"+map.get(item)+"%'");
				}
				if("deviceName".equals(item)){
					hqls.append(" and deviceName like '%"+map.get(item)+"%'");
					hqls2.append(" and deviceName like '%"+map.get(item)+"%'");
				}
			}
		}
		hql=hqls.toString();
		hql2=hqls2.toString();
		super.queryPaging(paging, map, hql, hql2);
	}

}
