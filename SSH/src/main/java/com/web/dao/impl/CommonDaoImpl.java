package com.web.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.web.dao.CommonDao;

public abstract class CommonDaoImpl<T> implements CommonDao<T> {

	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	
	public boolean add(T obj){
		try {
			sessionFactory.getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(T obj){
		try {
			sessionFactory.getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean delete(T obj){
		try {
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * java的反射机制
	 */
	public T findById(int id){
		
		return null;
	}
	
	public T findById(Class<T> entity,int id){
		T obj = null;
		try {
			obj = (T) sessionFactory.getCurrentSession().get(entity, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	     return obj;
	}
}
