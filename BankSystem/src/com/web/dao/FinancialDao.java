package com.web.dao;

import java.util.List;

import com.web.entity.Financial;

public interface FinancialDao {

	/**
	 * 添加金融产品
	 * @param financial
	 * @return
	 */
	public int insertFinancial(Financial financial);
	
	/**
	 * 修改金融产品
	 * @param financial
	 * @return
	 */
	public int updateFinancial(Financial financial);
	
	/**
	 * 删除金融产品
	 * @param finId
	 * @return
	 */
	public int deleteFinancial(int finId);
	
	/**
	 * 全查金融产品
	 * @return
	 */
	public List<Financial> findAll();
}
