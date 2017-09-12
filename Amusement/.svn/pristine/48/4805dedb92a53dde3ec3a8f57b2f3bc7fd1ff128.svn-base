package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.web.dao.MenuDao;
import com.web.entity.Menu;
import com.web.entity.User;
import com.web.util.Page;

@Repository
public class MenuDaoImpl extends CommonDaoImpl<Menu> implements MenuDao {

	@Override
	public void queryPaging(Page<Menu> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));//设置分页查询的数据
	}
	
	@Override
	public List<Menu> queryAll(String hql) {
		hql="from Menu";
		return super.queryAll(hql);
	}
	
	/**
	 * 分页查询得到的数据
	 * @return
	 */
	public List<Menu> queryPagingData(Page<Menu> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Menu.class);
			if (map != null) {
				for (String key : map.keySet()) {
					if("menuName".equals(key) && map.get(key) != null){
						crit.add(Restrictions.like("menuName", "%"+map.get(key)+"%"));
					}
				}
			}
			
			Criteria critAll = crit;
			paging.setTotalRecord(critAll.list().size());//设置分页查询的总条数
			
			crit.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			crit.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			List<Menu> users = crit.list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
