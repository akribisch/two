package com.web.dao;

import java.util.List;

import com.web.entity.Flow;
import com.web.util.Page;

/**
 * 流水数据访问层
 * @author java201
 *
 */
public interface FlowDao {

	/**
	 * 查询全部流水
	 */
	public List<Flow> selectAll();
	
	/**
	 * 动态查询流水信息
	 */
	public List<Flow> select(Page<Flow> page);
	
	/**
	 * 动态查询总条数
	 */
	public int selectCount(Page<Flow> page);
	
	/**
	 * 添加流水信息
	 */
	public int insertFlow(Flow flow);
	
	/**
	 * 根据主键修改流水信息
	 */
	public int updateById(Flow flow);
	
	/**
	 * 根据主键删除流水信息
	 */
	public int deleteById(int flowId);
}
