package com.web.biz;

import java.util.Map;

import com.web.entity.Credit;
import com.web.util.Page;

public interface CreditBiz {

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
	public Page<Credit> findBySavings(int savingsId,Page<Credit> page, Map<String, Object> map);
	
	public Credit findById(int creditId);
}
