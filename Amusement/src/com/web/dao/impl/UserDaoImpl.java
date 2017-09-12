package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.web.dao.UserDao;
import com.web.entity.User;
import com.web.util.Page;

@Repository
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {
	
	@Override
	public List<User> queryAll(String hql){
		hql = "from User";
		return super.queryAll(hql);
	}
	
	@Override
	public void queryPaging(Page<User> paging, Map<String, Object> map) {
		paging.setList(this.queryPagingData(paging, map));//设置分页查询的数据
	}

	@Override
	public User login(User u) {
		//1.获取session
		Session session = sessionFactory.getCurrentSession();
		
		//2.持久化操作
		StringBuffer hql = new StringBuffer("from User where 1=1 ");
		hql.append(" and userName = '"+u.getUserName()+"'");
		hql.append(" and password = '"+u.getPassword()+"'");
		hql.append(" and state = 0");
		
		//执行查询
		Query query = session.createQuery(hql.toString());
		User user = (User) query.uniqueResult();//只返回一个对象
		return user;
	}
	
	/**
	 * 分页查询得到的数据
	 * @return
	 */
	public List<User> queryPagingData(Page<User> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(User.class);
			if (map != null) {
				for (String key : map.keySet()) {
					if("userName".equals(key) && map.get(key) != null){
						crit.add(Restrictions.like("userName", "%"+map.get(key)+"%"));
					}
					if ("sex".equals(key) && map.get(key) != "-1") {
						crit.add(Restrictions.eq("sex", map.get(key)));
					}
					if ("state".equals(key) && map.get(key) != "-1") {
						crit.add(Restrictions.eq("state", map.get(key)));
					}
					if ("stationid".equals(key) && map.get(key) != "-1") {
						crit.createCriteria("station").add(Restrictions.eq("statId", map.get(key)));
					}
				}
			}
			
			Criteria critAll = crit;
			paging.setTotalRecord(critAll.list().size());//设置分页查询的总条数
			
			crit.setFirstResult(paging.getStartIndex());//设置分页查询  排除前面多少笔数据
			crit.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			List<User> users = crit.list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public User findByName(String userName) {
		//1.获取session
		Session session = sessionFactory.getCurrentSession();
		//2.持久化操作
		StringBuffer hql = new StringBuffer("from User where 1=1 ");
		hql.append(" and userName = '"+userName+"'");
		//执行查询
		Query query = session.createQuery(hql.toString());
		User user = (User) query.uniqueResult();//只返回一个对象
		return user;
	}
}
