package com.web.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.web.dao.HouseDao;
import com.web.entity.House;

@Repository //数据访问层
public class HouseDaoImpl implements HouseDao{

//	@Resource(name="sessionFactory")//自动查找
//	SessionFactory sessionFactory;
	
	private SessionFactory  sessionFactory; 

    @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 添加
	 */
	public boolean add(House house) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
//			Transaction trans = session.beginTransaction();
			
			session.save(house);
			
//			trans.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(House house){
		try {
			sessionFactory.getCurrentSession().update(house);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<House> query() {
		List<House> list = new ArrayList<House>();
		try {
			
			list = sessionFactory.getCurrentSession().createQuery("from House").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public House findById(int id) {
		House house = null;
		try {
			house = (House) sessionFactory.getCurrentSession().get(House.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return house;
	}
	
}
