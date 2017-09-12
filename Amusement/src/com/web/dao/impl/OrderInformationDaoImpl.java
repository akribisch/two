package com.web.dao.impl;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.OrderInformationDao;
import com.web.entity.OrderInformation;
import com.web.entity.Recreation;
import com.web.util.Page;
@Repository
public class OrderInformationDaoImpl extends CommonDaoImpl<OrderInformation> implements OrderInformationDao {

	/**
	 * 分页查询
	 */
	@Override
	public void queryPaging(Page<OrderInformation> paging, Map<String, Object> map) {
		paging.setList(queryPagingData(paging, map));
		paging.setTotalRecord(queryTotalCount(paging,map));
		

	}
	
	/**
	 * 查询数据
	 * @param paging
	 * @param map
	 * @return
	 */
	public List<OrderInformation> queryPagingData(Page<OrderInformation> paging,Map<String, Object> map){
		
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("from OrderInformation where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("tourName".equals(key)){
						hql.append(" and tourist.tourName like '"+"%"+map.get(key)+"%'");
					}
					if("tourPhone".equals(key)){
						hql.append(" and tourist.tourPhone like '"+"%"+map.get(key)+"%'");
					}
					if("vNo".equals(key)){
						hql.append(" and vip.vNo like '"+"%"+map.get(key)+"%'");
					}
					
				}
			}
			Query query=session.createQuery(hql.toString());
			
			query.setFirstResult((int)map.get("prev"));
			query.setMaxResults((int)map.get("pageSize"));
			@SuppressWarnings("unchecked")
			List<OrderInformation> recreationList=query.list();
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
	public int queryTotalCount(Page<OrderInformation> paging,Map<String, Object> map){
		int result=0;
		try {
			Session session=super.sessionFactory.getCurrentSession();//获取session
			
			StringBuffer hql=new StringBuffer("select count(*) from OrderInformation where 1=1");
			
			if(map!=null){
				
				for(String key:map.keySet()){
					if("tourName".equals(key)){
						hql.append(" and tourist.tourName like '"+"%"+map.get(key)+"%'");
					}
					if("tourPhone".equals(key)){
						hql.append(" and tourist.tourPhone like '"+"%"+map.get(key)+"%'");
					}
					if("vNo".equals(key)){
						hql.append(" and vip.vNo like '"+"%"+map.get(key)+"%'");
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
