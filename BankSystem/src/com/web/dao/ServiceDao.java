package com.web.dao;

import java.util.List;

import com.web.entity.Service;
import com.web.util.Page;

/**
 * 业务类型数据访问层
 * @author java201
 *
 */
public interface ServiceDao {

	/**
	 * 动态分页查询
	 */
	public List<Service> select(Page<Service> page);
	
	/**
	 * 动态分页查询总条数
	 */
	public int selectCount(Page<Service> page);
	
	/**
	 * 全查
	 */
	public List<Service> selectAll();
	
	/**
	 * 添加
	 */
	public int insertService(Service service);
	
	/**
	 * 修改
	 */       
	public int updateServiceById(Service service);
	
	/**
	 * 删除
	 */
	public int deleteServiceById(int serId);
}
