package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.VipDao;
import com.web.entity.Recreation;
import com.web.entity.Tourist;
import com.web.entity.Vip;
import com.web.util.Page;
@Repository
public class VipDaoImpl extends CommonDaoImpl<Vip> implements VipDao {

	@Override
	public void queryPaging(Page<Vip> paging, Map<String, Object> map) {
		paging.setList(queryPagingData(paging, map));
		paging.setTotalRecord(queryTotalCount(paging,map));
		
	}
	/**
	 * 查询数据
	 * @param paging
	 * @param map
	 * @return
	 */
	public List<Vip> queryPagingData(Page<Vip> paging,Map<String, Object> map){
		
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("from Vip where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("vNo".equals(key)){
						hql.append(" and vNo like '"+"%"+map.get(key)+"%'");
					}
					
				}
			}
			Query query=session.createQuery(hql.toString());
			
			query.setFirstResult((int)map.get("prev"));
			query.setMaxResults((int)map.get("pageSize"));
			
			List<Vip> vipList=query.list();
			return vipList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/**
	 * 查询总记录
	 * @param paging
	 * @param map
	 * @return
	 */
	public int queryTotalCount(Page<Vip> paging,Map<String, Object> map){
		int result=0;
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("select count(*) from Vip where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("vNo".equals(key)){
						hql.append(" and vNo like '"+"%"+map.get(key)+"%'");
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
	public List<Vip> findBycondition(String vNo){
		Session session=super.sessionFactory.getCurrentSession();
		
		StringBuffer hql=new StringBuffer("from Vip where");
		
		hql.append(" vNo ='"+vNo+"'" );
		
		Query query=session.createQuery(hql.toString());
		return query.list();
		 
	}
}
