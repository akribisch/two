package com.web.biz;

import java.util.List;


import com.web.entity.Commission;
import com.web.util.Page;

public interface CommissionBiz {

	/**
	 * 动态分页查询
	 */
	public List<Commission> select(Page<Commission> page);
	
	/**
	 * 动态分页查询总条数
	 */
	public int selectCount(Page<Commission> page);
	
	/**
	 * 查询全部提成信息
	 */
	public List<Commission> selectAll();
	
	/**
	 * 添加提成信息
	 */
	public int insertCommission(Commission commission);
	
	/**
	 * 根据编号修改提成信息
	 */
	public int updateCommissionById(Commission commission);
	
	/**
	 * 根据编号删除提成信息
	 * @return
	 */
	public int deleteById(int CommissionID);
}
