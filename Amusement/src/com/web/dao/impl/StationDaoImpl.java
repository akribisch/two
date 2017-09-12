package com.web.dao.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.web.dao.StationDao;
import com.web.entity.Station;
import com.web.util.Page;

@Repository
public class StationDaoImpl extends CommonDaoImpl<Station> implements StationDao {

	@Override
	public void queryPaging(Page<Station> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));
	}
	
	@Override
	public List<Station> queryAll(String hql){
		hql = "from Station";
		return super.queryAll(hql);
	}
	
	public List<Station> queryPagingData(Page<Station> paging, Map<String, Object> map){
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Station where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("statName".equals(key)){
						hql.append(" and statName like '%"+map.get(key)+"%'");
					}
					if("statNumMin".equals(key)){
						hql.append(" and statNum >= "+map.get(key));
					}
					if("statNumMax".equals(key)){
						hql.append(" and statNum <= "+map.get(key));
					}
					if("depId".equals(key)){
						hql.append(" and department.depId = "+map.get(key));
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
			List<Station> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
