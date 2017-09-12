package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.SalaryDao;
import com.web.entity.Attendance;
import com.web.entity.Salary;
import com.web.util.Page;

@Repository
public class SalaryDaoImpl extends CommonDaoImpl<Salary> implements SalaryDao {
	/**
	 * 分页查询
	 */
	@Override
	public void queryPaging(Page<Salary> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
		paging.setTotalRecord(this.queryTotalCount(map));
	}
	public List<Salary> queryPagingData(Page<Salary> paging,Map<String, Object> map){
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Salary where 1=1 ");
			if(map != null){
				for (String key : map.keySet()) {
					if("userId".equals(key)){
						hql.append(" and user.userId ='"+map.get(key)+"'");
					}
					if("beginTime".equals(key)){
						hql.append(" and month >='"+map.get(key)+"'");
					}
					if("endTime".equals(key)){
						hql.append(" and month <='"+map.get(key)+"'");
					}
					if("beginState".equals(key)){
						hql.append(" and beginState ='"+map.get(key)+"'");
					}
					if("endState".equals(key)){
						hql.append(" and endState ='"+map.get(key)+"'");
					}
				}
			}
			//执行查询
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			//查询得到集合
			List<Salary> list = query.list();
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
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("select count(*) from  Salary where 1=1");
			if(map != null){
				for (String key : map.keySet()) {
					if("userId".equals(key)){
						hql.append(" and user.userId ='"+map.get(key)+"'");
					}
					if("beginTime".equals(key)){
						hql.append(" and month >='"+map.get(key)+"'");
					}
					if("endTime".equals(key)){
						hql.append(" and month <='"+map.get(key)+"'");
					}
					if("beginState".equals(key)){
						hql.append(" and beginState ='"+map.get(key)+"'");
					}
					if("endState".equals(key)){
						hql.append(" and endState ='"+map.get(key)+"'");
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
	@Override
	public int updateSalary(Salary salary) {
		int count = 0;
		//1.获取session
		Session session = super.sessionFactory.getCurrentSession();
		//2.持久化操作
//		StringBuffer hql = new StringBuffer("update  Salary  set normal="+salary.getNormal());
//		hql.append(",morning = "+salary.getMorning());
//		hql.append(",late = "+salary.getLate());
//		hql.append(" where userid= "+salary.getUser().getUserId());
//		hql.append(" and month ='"+salary.getMonth()+"'");
//		Query query = session.createQuery(hql.toString());
//		count = Integer.parseInt(query.uniqueResult().toString());

		try {
			session.update(salary);
			count =1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public Salary findByUser(Map<String,Object> map) {
		//1.获取session
		Session session = super.sessionFactory.getCurrentSession();	
		//2.持久化操作
		StringBuffer hql = new StringBuffer("from  Salary where 1=1");
		if(map != null){
			for (String key : map.keySet()) {
				if("userId".equals(key)){
					hql.append(" and user.userId ="+map.get(key));
				}
				if("beginTime".equals(key)){
					hql.append(" and month >='"+map.get(key)+"'");
				}
				if("endTime".equals(key)){
					hql.append(" and month <='"+map.get(key)+"'");
				}	
			}
		}
		
		Query query = session.createQuery(hql.toString());
		Salary sala = (Salary) query.uniqueResult();//只返回一个对象
		return sala;
	}
	@Override
	public int queryCount(Map<String,Object> map) {
		int count = 0;
		//1.获取session
		Session session = super.sessionFactory.getCurrentSession();	
		//2.持久化操作
		StringBuffer hql = new StringBuffer("select count(*) from  Salary where 1=1");
		if(map != null){
			for (String key : map.keySet()) {
				if("beginTime".equals(key)){
					hql.append(" and month >='"+map.get(key)+"'");
				}
				if("overTime".equals(key)){
					hql.append(" and month <='"+map.get(key)+"'");
				}
			}
		}
		//执行查询
		Query query = session.createQuery(hql.toString());
		count = Integer.parseInt(query.uniqueResult().toString());
		return count;
	}
	
}