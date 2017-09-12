package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.TouristDao;
import com.web.entity.Tourist;
import com.web.util.Page;

@Repository
public class TouristDaoImpl extends CommonDaoImpl<Tourist> implements TouristDao {

	@Override
	public void queryPaging(Page<Tourist> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls=new StringBuffer("from Tourist where 1=1 ");
		StringBuffer hqls2=new StringBuffer("select count(*) from Tourist where 1=1 ");
		if(map!=null){
			for (String item : map.keySet()) {
				if("tourName".equals(item)){
					hqls.append(" and tourName like '%"+map.get(item)+"%'");
					hqls2.append(" and tourName like '%"+map.get(item)+"%'");
				}
				if("tourCount".equals(item)){
					hqls.append(" and tourCount like '%"+map.get(item)+"%'");
					hqls2.append(" and tourCount like '%"+map.get(item)+"%'");
				}
				if("tourSex".equals(item)){
					hqls.append(" and tourSex='"+map.get(item)+"'");
					hqls2.append(" and tourSex='"+map.get(item)+"'");
				}
			}
		}
		hql=hqls.toString();
		hql2=hqls2.toString();
		super.queryPaging(paging, map, hql, hql2);
	}

	@Override
	public Tourist findByTourCount(String name){
		Session session = super.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Tourist where tourCount='"+name+"'");
		Tourist tourist= (Tourist) query.list().get(0);
		return tourist;
	}

	@Override
	public List<Tourist> findBycondition(String tourPhone) {
		Session session=super.sessionFactory.getCurrentSession();
		
		StringBuffer hql=new StringBuffer("from Tourist where");
		
		hql.append(" tourPhone='"+tourPhone+"'" );
		
		Query query=session.createQuery(hql.toString());
		return query.list();
	}
	
}
