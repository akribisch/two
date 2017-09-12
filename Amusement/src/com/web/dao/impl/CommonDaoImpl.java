package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CommonDao;
import com.web.entity.Device;
import com.web.util.Page;


public abstract class CommonDaoImpl<T> implements CommonDao<T>{

	@Autowired //自动查找
	SessionFactory sessionFactory;
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public boolean add(T obj){
		
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			//2.不需要开启事务 (session.beginTransaction())    持久化操作
			session.save(obj);
			
			//3.事务提交    也不需要   trans.commit()
			return true;
		} catch (Exception e) {
			e.printStackTrace();//事务的回滚也不需要   trans.rollback();
			return false;
		}
		
		
	}
	

	@Override
	public boolean update(T obj) {
		
		try {
			//1.获取session
			
			Session session = sessionFactory.getCurrentSession();
			
			//2.不需要开启事务 (session.beginTransaction())    持久化操作
			session.update(obj);
			
			//3.事务提交    也不需要   trans.commit()
			return true;
		} catch (Exception e) {
			e.printStackTrace();//事务的回滚也不需要   trans.rollback();
			return false;
		}
	}
	
	@Override
	public boolean delete(T obj) {
	
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			//2.不需要开启事务 (session.beginTransaction())    持久化操作
			session.delete(obj);
			//3.事务提交    也不需要   trans.commit()
			return true;
		} catch (Exception e) {
			e.printStackTrace();//事务的回滚也不需要   trans.rollback();
			return false;
		}
	}


	@Override
	public <T> T findById(Class<T> claz, int id) {
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			return (T) session.get(claz, id);
		} catch (Exception e) {
			e.printStackTrace();//事务的回滚也不需要   trans.rollback();
			return null;
		}
	}


	@Override
	public List<T> queryAll(String hql) {
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery(hql);
			return query.list();
			
		} catch (Exception e) {
			e.printStackTrace();//事务的回滚也不需要   trans.rollback();
			return null;
		}
	}


	@Override
	public void queryPaging(Page<T> paging, Map<String, Object> map,String hql,String hql2) {
		paging.setList(this.queryPagingData(paging, hql));
		paging.setTotalRecord(this.queryTotalCount(hql2));
	}
	
	public List<T> queryPagingData(Page<T> paging,String hql){
		
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			
			//执行查询
			Query query = session.createQuery(hql);
			
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 分页查询得到的总条数
	 * @return
	 */
	public int  queryTotalCount(String hql2){
		
		int count = 0;
		
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			Query query = session.createQuery(hql2);
			
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return count;
	}

	public void  queryPaging(Page<T> paging,Map<String,Object> map){
		
	}
}
