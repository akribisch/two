package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Rate;

public interface RateDao {
	/**
	 * 修改汇率
	 * @return
	 */
	public int updateRate(Rate rate);
	
	/**
	 * 添加汇率
	 * @param rate
	 * @return
	 */
	public int insertRate(Rate rate);
	
	/**
	 * 删除汇率
	 * @return
	 */
	public int deleteRate(int rateId);
	
	/**
	 * 查询全部汇率
	 * @return
	 */
	public List<Rate> findAllRate();
	
	/**
	 * 根据条件查询分页
	 * @param map
	 * @return
	 */
	public List<Rate> findByCondtion(Map<String, Object> map);
	
	/**
	 * 总共多少数据
	 * @return
	 */
	public int findCount();
	
}
