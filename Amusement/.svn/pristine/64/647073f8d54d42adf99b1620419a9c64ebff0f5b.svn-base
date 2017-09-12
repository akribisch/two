package com.web.biz.impl;


import java.util.List;
import java.util.Map;

import com.web.biz.CommonBiz;
import com.web.dao.CommonDao;
import com.web.util.Page;

public abstract class CommonBizImpl<T> implements CommonBiz<T> {

	CommonDao<T> commonDao;

	public void setCommonDao(CommonDao<T> commonDao) {
		this.commonDao = commonDao;
	}
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public boolean add(T obj){
		return commonDao.add(obj);
	}
	
	/**
	 * 修改
	 * @param obj
	 * @return
	 */
	public boolean update(T obj){
		return commonDao.update(obj);
	}
	
	/**
	 * 删除
	 * @param obj
	 * @return
	 */
	public boolean delete(T obj){
		return commonDao.delete(obj);
	}
	
	/**
	 * 分页查询
	 */
	public void  queryPaging(Page<T> paging,Map<String,Object> map){
		commonDao.queryPaging(paging, map);
	}

	@Override
	public <T> List<T> queryAll() {
		String hql=null;
		return commonDao.queryAll(hql);
	}

	@Override
	public <T> T findById(Class<T> claz, int id) {
		return commonDao.findById(claz, id);
	}
	
	
}
