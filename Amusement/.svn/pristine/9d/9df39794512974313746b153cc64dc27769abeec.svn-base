package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.DepartmentDao;
import com.web.entity.Department;
import com.web.util.Page;

@Repository
public class DepartmentDaoImpl extends CommonDaoImpl<Department> implements DepartmentDao {

	@Override
	public List<Department> queryAll(String hql) {
		hql="from Department ";
		return super.queryAll(hql);
	}

	@Override
	public void queryPaging(Page<Department> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
	}
	
	public List<Department> queryPagingData(Page<Department> paging, Map<String, Object> map){
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Department where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("depName".equals(key)){
						hql.append(" and depName like '%"+map.get(key)+"%'");
					}
					if("depNumMin".equals(key)){
						hql.append(" and depNum >= "+map.get(key));
					}
					if("depNumMax".equals(key)){
						hql.append(" and depNum <= "+map.get(key));
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			//设置总条数
			Query newquery = query;
			paging.setTotalRecord(newquery.list().size());
			
			query.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Department> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
