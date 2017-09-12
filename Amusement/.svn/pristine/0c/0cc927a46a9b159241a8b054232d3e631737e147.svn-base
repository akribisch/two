package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.ParkingDao;
import com.web.entity.Car;
import com.web.entity.Parking;
import com.web.util.Page;

@Repository
public class ParkingDaoImpl extends CommonDaoImpl<Parking> implements ParkingDao{

	@Override
	public void queryPaging(Page<Parking> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
		paging.setTotalRecord(this.queryTotalCount(map));
	}

	public List<Parking> queryPagingData(Page<Parking> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			//StringBuffer hql = new StringBuffer("from t_car where 1=1 ");
			
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
			Query query = session.createQuery("from Parking");
			
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Parking> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Parking queryParking(int carId) {
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Parking where 1=1 ");
			if(carId != 0){
				hql.append(" and carId ="+carId+" ");
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			//查询得到对象
			
			Parking parking = (Parking) query.uniqueResult();
			return parking;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Parking> queryNull() {
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Parking where car.carId = 1 ");
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			//查询得到对象
			
			List<Parking> list  = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
			StringBuffer hql = new StringBuffer("select count(*) from Parking where 1=1 ");
			
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
