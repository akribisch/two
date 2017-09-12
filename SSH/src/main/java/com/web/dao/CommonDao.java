package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.util.PageUtil;

public interface CommonDao<T> {

	public boolean add(T obj);
	public boolean update(T obj);
	public boolean delete(T obj);
	public T findById(int id);
	public T findById(Class<T> entity,int id);
	public List<T> query();
	
	/**
	 * 分页查询
	 */
	public void  queryPaging(PageUtil<T> paging,Map<String,Object> map);

}
