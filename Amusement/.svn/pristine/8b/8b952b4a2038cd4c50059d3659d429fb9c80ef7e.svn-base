package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.CarDao;
import com.web.entity.Car;
import com.web.util.Page;

@Repository
public class CarDaoImpl extends CommonDaoImpl<Car> implements CarDao {

	@Override
	public void queryPaging(Page<Car> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
		paging.setTotalRecord(this.queryTotalCount(map));
	}

	public List<Car> queryPagingData(Page<Car> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Car where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("plateNumber".equals(key)){
						hql.append(" and plateNumber =="+map.get(key)+"");
					}
					if("carIn".equals(key)){
						hql.append(" and carIn > "+map.get(key)+"");
					}
					if("carOut".equals(key)){
						hql.append(" and carOut < '%"+map.get(key)+"%'");
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Car> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 在位车辆查询
	 * @param plateNumber
	 * @param carAt
	 * @return
	 */
	@Override
	public Car queryCar(String plateNumber){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Car where 1=1 ");
			if(plateNumber != null){
				hql.append(" and plateNumber ="+plateNumber+"  and carAt = "+0+"");
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			//查询得到对象
			
			Car car = (Car) query.uniqueResult();
			return car;
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
			StringBuffer hql = new StringBuffer("select count(*) from Car where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("plateNumber".equals(key)){
						hql.append(" and plateNumber =="+map.get(key)+"");
					}
					if("carIn".equals(key)){
						hql.append(" and carIn > "+map.get(key)+"");
					}
					if("carOut".equals(key)){
						hql.append(" and carOut < '%"+map.get(key)+"%'");
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return count;
	}

}
