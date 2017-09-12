package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.RecreationDao;
import com.web.entity.Recreation;
import com.web.util.Page;
@Repository
public class RecreationDaoImpl extends CommonDaoImpl<Recreation> implements RecreationDao {


	/**
	 * 分页查询
	 */
	@Override
	public void queryPaging(Page<Recreation> paging, Map<String, Object> map) {
		paging.setList(queryPagingData(paging, map));
		paging.setTotalRecord(queryTotalCount(paging,map));
		

	}
	
	/**
	 * 查询数据
	 * @param paging
	 * @param map
	 * @return
	 */
	public List<Recreation> queryPagingData(Page<Recreation> paging,Map<String, Object> map){
		
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("from Recreation where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("Rname".equals(key)){
						hql.append(" and Rname like '"+"%"+map.get(key)+"%'");
					}
					if("Raddress".equals(key)){
						hql.append(" and Raddress like '"+"%"+map.get(key)+"%'");
					}
					if("Rpice1".equals(key)){
						hql.append(" and Rpice>"+map.get(key));
					}
					if("Rpice2".equals(key)){
						hql.append(" and Rpice<"+map.get(key));
					}
				}
			}
			Query query=session.createQuery(hql.toString());
			
			query.setFirstResult((int)map.get("prev"));
			query.setMaxResults((int)map.get("pageSize"));
			@SuppressWarnings("unchecked")
			List<Recreation> recreationList=query.list();
			return recreationList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 * 条件查询记录总数
	 * @param paging
	 * @param map
	 * @return
	 */
	public int queryTotalCount(Page<Recreation> paging,Map<String, Object> map){
		int result=0;
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("select count(*) from Recreation where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("Rname".equals(key)){
						hql.append(" and Rname like '"+"%"+map.get(key)+"%'");
					}
					if("Raddress".equals(key)){
						hql.append(" and Raddress like '"+"%"+map.get(key)+"%'");
					}
					if("Rpice1".equals(key)){
						hql.append(" and Rpice>"+map.get(key));
					}
					if("Rpice2".equals(key)){
						hql.append(" and Rpice<"+map.get(key));
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
	@SuppressWarnings("unchecked")
	public  List<Recreation> queryAll(String hql){
		
		 hql="from Recreation";
		 
		 return super.queryAll(hql);
		
	}

}
