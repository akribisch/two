package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.Rate;
import com.web.util.Page;

public interface RateBiz {
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
	 * @param page
	 * @param map
	 * @return
	 */
	public Page<Rate> findByCondtion(Page<Rate> page,Map<String, Object> map);
}
