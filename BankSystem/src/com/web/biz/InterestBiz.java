package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.Interest;
/**
 * 利率业务逻辑层接口
 * @author liudong
 *
 */
public interface InterestBiz {
	/**
	 * 添加利率记录
	 * @param interest
	 */
	public int addInterest(Interest interest);
	/**
	 * 分页查询利率记录
	 * @return
	 */
	public List<Interest> getInterest(Map<String, Object> map);
	/**
	 * 条件查询利率记录的总条数
	 * @return
	 */
	public int getInterestTotalCount(Map<String, Object> map);
	/**
	 * 根据编号删除利率记录
	 * @param interestId
	 */
	public int deleteInterestById(int interestId);
	/**
	 * 根据编号查询
	 * @param interestId
	 * @return
	 */
	public Interest sendUpdateInterest(int interestId);
	/**
	 * 根据编号修改利率记录
	 */
	public int updateInterest(Map<String, Object> map);

	/**
	 * 根据模糊查询贷款利率
	 * @return
	 */
	public List<Interest> findCredit(String interestName);
}
