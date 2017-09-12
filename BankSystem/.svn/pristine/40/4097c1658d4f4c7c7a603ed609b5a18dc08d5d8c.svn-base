package com.web.dao;

import java.util.List;

import com.web.entity.Savings;
import com.web.util.Page;

public interface SavingsDao {
	/**
	 * 查询全部
	 * @return
	 */
	public List<Savings> queryAll();
	/**
	 * 添加
	 * @param savings
	 */
	public int add(Savings savings);
	/**
	 * 修改
	 * @param id
	 */
	public int updateSavings(Savings savings);
	/**
	 * 删除
	 * @param id
	 */
	public int deleteSavings(int id);

	
	/**
	 * 根据储蓄卡卡号查询对应的在表中的主键编号
	 * @param savingsNum
	 * @return
	 */
	public Integer findByNumForId(String savingsNum);
	/**
	 * 动态分页查询储蓄卡信息
	 * @param page
	 * @return
	 */
	public List<Savings> queryPage(Page<Savings> page);
	/**
	 * 动态分页查询存取款信息的总条目数
	 * @return
	 */
	public int selectCount(Page<Savings> page);
	/**
	 * 登录
	 * @param savings
	 * @return
	 */
	public Savings findBySavings(Savings savings);
	/**
	 * 通过主键查找卡号
	 * @param savingsId
	 * @return
	 */
	public String findBySavingsid(int savingsId);
	
	/**
	 * 根据主键查询
	 * @param savingsId
	 * @return
	 */
	public Savings selectById(int savingsId);
}
