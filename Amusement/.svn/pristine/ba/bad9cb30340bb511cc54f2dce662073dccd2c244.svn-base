package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.AttendanceDao;
import com.web.entity.Attendance;
import com.web.util.Page;

@Repository 
public class AttendanceDaoImpl extends CommonDaoImpl<Attendance> implements AttendanceDao {
	/**
	 * 分页查询
	 */
	@Override
	public void queryPaging(Page<Attendance> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
		paging.setTotalRecord(this.queryTotalCount(map));
	}
	public List<Attendance> queryPagingData(Page<Attendance> paging, Map<String, Object> map){
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Attendance where 1=1 ");
			if(map != null){
				for (String key : map.keySet()) {
					if("userId".equals(key)){
						hql.append(" and userId ='"+map.get(key)+"'");
					}
					if("beginTime".equals(key)){
						hql.append(" and beginTime >='"+map.get(key)+"'");
					}
					if("endTime".equals(key)){
						hql.append(" and endTime <='"+map.get(key)+"'");
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
			List<Attendance> list = query.list();
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
			StringBuffer hql = new StringBuffer("select count(*) from  Attendance where 1=1");
			if(map != null){
				for (String key : map.keySet()) {
					if("userId".equals(key)){
						hql.append(" and userId ='"+map.get(key)+"'");
					}
					if("beginTime".equals(key)){
						hql.append(" and beginTime ='"+map.get(key)+"'");
					}
					if("endTime".equals(key)){
						hql.append(" and endTime ='"+map.get(key)+"'");
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
	public Attendance findAttendance(Map<String, Object> map) {
		//1.获取session
		Session session = super.sessionFactory.getCurrentSession();
		//2.持久化操作
		StringBuffer hql = new StringBuffer("from  Attendance where 1 = 1 ");
		if(map != null){
			for (String key : map.keySet()) {
				if("userId".equals(key)){
					hql.append(" and userId ="+map.get(key));
				}
				if("beginTime".equals(key)){
					hql.append(" and beginTime >='"+map.get(key)+"'");
				}
				if("endTime".equals(key)){
					hql.append(" and beginTime <='"+map.get(key)+"'");
				}	
			}
		}
		Query query = session.createQuery(hql.toString());
		Attendance attendance = (Attendance) query.uniqueResult();//只返回一个对象
		
//		String sql = "select count(*) from amusement.attendance a where a.beginTime between '2017-08-01' and '2017-08-30' and a.beginState='迟到' group by a.userId";
//		
//		session.createSQLQuery(sql);
		
		return attendance;
				
	}
	@Override
	public Attendance findById(int id) {
		//1.获取session
		Session session = super.sessionFactory.getCurrentSession();
		//2.持久化操作
		StringBuffer hql = new StringBuffer("from  Attendance  where 1 = 1");
		hql.append(" and userId = '"+id+"'");
		Query query = session.createQuery(hql.toString());
		Attendance attendance = (Attendance) query.uniqueResult();//只返回一个对象
		return attendance;
	}
	@Override
	public int queryByUserNowMonth(Map<String, Object> map) {
		int count = 0;
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("select count(*) from  Attendance where 1=1");
			if(map != null){
				for (String key : map.keySet()) {
					if("userId".equals(key)){
						hql.append(" and userId ='"+map.get(key)+"'");
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
}

