package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Credit;

public interface CreditDao {
	
	/**
	 * 添加贷款信息
	 * @param credit
	 * @return
	 */
	public int insertCredit(Credit credit);

	/**
	 * 修改贷款信息
	 * @param credit
	 * @return
	 */
	public int updateCredit(Credit credit);
	
	/**
	 * 删除储蓄卡上的贷款信息
	 * @param creditId
	 * @return
	 */
	public int deleteCredit(int savingsId);
	
	/**
	 * 查找储蓄卡上的贷款信息
	 * @param savingsId
	 * @return
	 */
	public List<Credit> findBySavings(Map<String, Object> map);
	
	/**
	 * 总的个数
	 * @return
	 */
	public int findCreditCount(int savingsId);
	
	public Credit findById(int creditId);
}
