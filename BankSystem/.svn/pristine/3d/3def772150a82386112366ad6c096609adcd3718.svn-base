package com.web.dao;

import java.util.List;

import com.web.entity.Access;
import com.web.util.Page;

/**
 * 存取款表实体类的数据访问层
 * @author java201
 *
 */
public interface AccessDao {
	/**
	 * 查询所有存取款信息
	 * @return
	 */
	public List<Access> selectAll();
	
	/**
	 * 动态分页查询存取款信息
	 * @return
	 */
	public List<Access> select(Page<Access> page);
	
	/**
	 * 动态分页查询存取款信息的总条目数
	 * @return
	 */
	public int selectCount(Page<Access> page);
	
	/**
	 * 添加存取款信息
	 * @param access
	 * @return
	 */
	public int insert(Access access);
	
	/**
	 * 根据主键删除存取款信息
	 * @param accessId
	 * @return
	 */
	public int deleteById(int accessId);
	
	/**
	 * 根据主键修改存取款信息
	 * @param access
	 * @return
	 */
	public int updateById(Access access);
	
}
