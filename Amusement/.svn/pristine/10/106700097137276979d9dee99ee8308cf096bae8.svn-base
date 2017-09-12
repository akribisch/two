package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.ChargeDao;
import com.web.entity.Car;
import com.web.entity.Charge;
import com.web.util.Page;

@Repository
public class ChargeDaoImpl extends CommonDaoImpl<Charge> implements ChargeDao {

	@Override
	public void queryPaging(Page<Charge> pageing, Map<String, Object> map) {
		pageing.setList(this.queryPagingData(pageing, map));
		pageing.setTotalRecord(this.queryTotalCount(map));
	}

	public List<Charge> queryPagingData(Page<Charge> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			//StringBuffer hql = new StringBuffer("from t_Charge where 1=1 ");
			
			/*if(map != null){
				for (String key : map.keySet()) {
					if("typeId".equals(key)){
						hql.append(" and typeId =="+map.get(key)+"");
					}
					if("deviceTypeId".equals(key)){
						hql.append(" and deviceTypeId like '%"+map.get(key)+"%'");
					}
					if("deviceTypeId".equals(key)){
						hql.append(" and deviceTypeId like '%"+map.get(key)+"%'");
					}
				}
			}*/
			
			//执行查询
			Query query = session.createQuery("from Charge");
			
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Charge> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Charge selectCharge(int catId) {
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Charge where 1=1 ");
			if(catId != 0){
				hql.append(" and car.carId ="+catId+"  and carTime = "+0+"");
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			//查询得到对象
			
			Charge charge = (Charge) query.uniqueResult();
			return charge;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 分页查询得到的总条数
	 * @return
	 */
	public int  queryTotalCount(Map<String, Object> map){
		
		int count = 0;
		
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			//2.持久化操作
			//2.持久化操作
			StringBuffer hql = new StringBuffer("select count(*) from Charge where 1=1 ");
			
			/*if(map != null){
				for (String key : map.keySet()) {
					if("typeId".equals(key)){
						hql.append(" and typeId =="+map.get(key)+"");
					}
					if("deviceTypeId".equals(key)){
						hql.append(" and deviceTypeId like '%"+map.get(key)+"%'");
					}
					if("deviceTypeId".equals(key)){
						hql.append(" and deviceTypeId like '%"+map.get(key)+"%'");
					}
				}
			}*/
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return count;
	}



}
