package com.web.dao;
/**
 * 账号状态数据访问层接口
 * @author liudong
 *
 */

import java.util.List;
import java.util.Map;

import com.web.entity.SavState;

public interface SavStateDao {
	/**
	 * 查询账号状态 
	 * @return
	 */
	public List<SavState> querySavState(Map<String, Object> map);
	/**
	 * 查询账号状态记录总条数
	 * @param map
	 * @return
	 */
	public int getSavStateTotalCount(Map<String, Object> map);
	/**
	 * 添加账号状态
	 * @param savState
	 */
	public int addSavState(SavState savState);
}
