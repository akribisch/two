package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.web.biz.CommonBiz;
import com.web.dao.CommonDao;
import com.web.util.PageUtil;

public abstract class CommonBizImpl<T> implements CommonBiz<T> {

	CommonDao<T> commonDao;

	public void setCommonDao(CommonDao<T> commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean add(T obj){
		return commonDao.add(obj);
	}
	
	public boolean update(T obj){
		return commonDao.update(obj);
	}
	
	public boolean delete(T obj){
		return commonDao.delete(obj);
	}
	
	public T findById(int id){
		return commonDao.findById(id);
	}
	
	public T findById(Class<T> entity,int id){
		return commonDao.findById(entity, id);
	}
	
	public List<T> query(){
		return commonDao.query();
	}
	
	/**
	 * 分页查询
	 */
	public void  queryPaging(PageUtil<T> paging,Map<String,Object> map){
		commonDao.queryPaging(paging, map);
	}
}
