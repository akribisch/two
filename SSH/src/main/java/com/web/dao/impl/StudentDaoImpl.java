package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.StudentDao;
import com.web.entity.Student;
import com.web.util.PageUtil;

@Repository //数据访问层
public class StudentDaoImpl extends CommonDaoImpl<Student> implements StudentDao {

	/**
	 * 分页查询
	 */
	public void queryPaging(PageUtil<Student> paging, Map<String, Object> map) {
		
		paging.setData(this.queryPagingData(paging, map));//设置分页查询的数据
		
		paging.setTotalCount(this.queryTotalCount(map));//设置分页查询的总条数
	}
	
	/**
	 * 分页查询得到的数据
	 * @return
	 */
	public List<Student> queryPagingData(PageUtil<Student> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Student where 1=1 ");
			
			
			if(map != null){
				for (String key : map.keySet()) {
					if("sname".equals(key)){
						hql.append(" and sname like '%"+map.get(key)+"%'");
					}
					if("schoolName".equals(key)){
						hql.append(" and school.scname like '%"+map.get(key)+"%'");
					}
					if("schoolId".equals(key)){
						hql.append(" and school.scid="+map.get(key));
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			query.setFirstResult(paging.getPrev());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Student> list = query.list();
			
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
			StringBuffer hql = new StringBuffer("select count(*) from Student where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("sname".equals(key)){
						hql.append(" and sname like '%"+map.get(key)+"%'");
					}
					if("schoolName".equals(key)){
						hql.append(" and school.scname like '%"+map.get(key)+"%'");
					}
					if("schoolId".equals(key)){
						hql.append(" and school.scid="+map.get(key));
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
	public List<Student> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
