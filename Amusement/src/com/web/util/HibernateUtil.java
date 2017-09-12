package com.web.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * hibernate的工具类
 * @author java201
 *
 */
public class HibernateUtil {

	static Configuration cfg = null;
	static ServiceRegistry serviceRegistry = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	
	static{
		//读取配置文件
		 cfg = new Configuration().configure();
		
		//注册服务
		 serviceRegistry = new StandardServiceRegistryBuilder()
				                  .applySettings(cfg.getProperties()).build();
		
		//创建session工程
		 sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * 获取session对象
	 * @return
	 */
	public static Session getCurrentSession(){
		session = sessionFactory.getCurrentSession();
		return session;
	}
}
