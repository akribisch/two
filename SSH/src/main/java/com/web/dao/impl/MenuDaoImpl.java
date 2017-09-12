package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.web.dao.MenuDao;
import com.web.entity.Menu;
import com.web.util.PageUtil;

@Repository
public class MenuDaoImpl extends CommonDaoImpl<Menu> implements MenuDao {

	@Override
	public List<Menu> query() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据父级节点查询菜单对象
	 */
	public List<Menu> findByParentId(int parentId){
		List<Menu> list = new ArrayList<>();
		try {
			
			StringBuffer sb = new StringBuffer("from Menu where 1=1 ");
			
			if(parentId == 0){
				sb.append(" and parentMenu is null");
			}else{
				sb.append(" and parentMenu.menuId = "+parentId);
			}
					
			
			Query query = super.sessionFactory.getCurrentSession().createQuery(sb.toString());
			
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void queryPaging(PageUtil<Menu> paging, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	

}
