package com.web.dao.impl;




import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.VacationDao;

import com.web.entity.Vacation;
import com.web.util.Page;
@Repository
public class VacationDaoImpl extends CommonDaoImpl<Vacation> implements VacationDao {
	

	/**
	 * 分页查询
	 */
	@Override
	public void queryPaging(Page<Vacation> paging, Map<String, Object> map) {
		paging.setList(queryPagingData(paging, map));
		paging.setTotalRecord(queryTotalCount(paging,map));
		

	}
	
	public List<Vacation> queryPagingData(Page<Vacation> paging,Map<String, Object> map){
		
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("from Vacation where 1=1");
			
			if(map!=null){
				for (String item : map.keySet()) {
					if("activeName".equals(item)){
						hql.append(" and activeName like '%"+map.get(item)+"%'");
						
					}
					
					if("discount1".equals(item)){
						hql.append(" and discount>='"+map.get(item)+"'");
						
					}
					if("discount2".equals(item)){
						hql.append(" and discount<='"+map.get(item)+"'");
						
					}
				}
			}
			Query query=session.createQuery(hql.toString());
			
			query.setFirstResult((int)map.get("prev"));
			query.setMaxResults((int)map.get("pageSize"));
			@SuppressWarnings("unchecked")
			List<Vacation> recreationList=query.list();
			return recreationList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	public int queryTotalCount(Page<Vacation> paging,Map<String, Object> map){
		int result=0;
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("select count(*) from Vacation where 1=1");
			
			if(map!=null){
				for (String item : map.keySet()) {
					if("activeName".equals(item)){
						
						hql.append(" and activeName like '%"+map.get(item)+"%'");
					}
					
					if("discount1".equals(item)){
						hql.append(" and discount>='"+map.get(item)+"'");
						
					}
					if("discount2".equals(item)){
						hql.append(" and discount<='"+map.get(item)+"'");
						
					}
				}
			}
			Query query=session.createQuery(hql.toString());
			
			
			result=Integer.valueOf(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
}
	
	/*@Override
	public void queryPaging(Page<Vacation> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls=new StringBuffer("from Vacation where 1=1");
		StringBuffer hqls2=new StringBuffer("select count(*) from Vacation where 1=1");
		if(map!=null){
			for (String item : map.keySet()) {
				if("activeName".equals(item)){
					hqls.append(" and Vacation.activeName='%"+map.get(item)+"%'");
					hqls2.append(" and Vacation.activeName='%"+map.get(item)+"%'");
				}
				
				if("discount1".equals(item)){
					hqls.append(" and discount>='"+map.get(item)+"'");
					hqls2.append(" and discount>='"+map.get(item)+"'");
				}
				if("discount2".equals(item)){
					hqls.append(" and discount<='"+map.get(item)+"'");
					hqls2.append(" and discount<='"+map.get(item)+"'");
				}
			}
		}
		hql=hqls.toString();
		hql2=hqls2.toString();
		
		super.queryPaging(paging, map, hql, hql2);
	}
}*/