package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.util.Page;


public interface CommonBiz<T> {
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public boolean add(T obj);
	
	/**
	 * 修改
	 * @param obj
	 * @return
	 */
	public boolean update(T obj);
	
	/**
	 * 删除
	 * @param obj
	 * @return
	 */
	public boolean delete(T obj);
	
	/**
	 * 分页查询
	 */
	public void  queryPaging(Page<T> paging,Map<String,Object> map);
	
	/**
	 * 全查
	 * @return
	 */
	public <T> List<T> queryAll();
	
	/**
	 * 根据id查询对象
	 * @param claz
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> claz,int id);
}
