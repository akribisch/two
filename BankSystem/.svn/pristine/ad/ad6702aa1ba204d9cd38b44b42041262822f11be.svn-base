package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.InterestBiz;
import com.web.dao.InterestDao;
import com.web.entity.Interest;
/**
 * 利率业务逻辑实现类
 * @author orange
 *
 */
@Service
public class InterestBizImpl implements InterestBiz {
	
	
	
	@Resource(name="interestDao")
	InterestDao interestDao;
	/**
	 * 添加利率记录
	 */
	@Override
	public int addInterest(Interest interest) {
		return interestDao.addInterest(interest);

	}
	/**
	 * 分页查询利率记录
	 * @return
	 */
	@Override
	public List<Interest> getInterest(Map<String, Object> map) {
		
		return interestDao.getInterest(map);
	}
	/**
	 * 查询总记录
	 */
	@Override
	public int getInterestTotalCount(Map<String, Object> map) {
		
		return interestDao.getInterestTotalCount(map);
	}
	/**
	 * 通过编号删除记录
	 */
	@Override
	public int deleteInterestById(int interestId) {
		return interestDao.deleteInterestById(interestId);

	}
	/**
	 * 根据编号查询利率记录
	 */
	@Override
	public Interest sendUpdateInterest(int interestId) {
		
		return interestDao.sendUpdateInterest(interestId);
	}

	@Override
	public int updateInterest(Map<String, Object> map) {
		return interestDao.updateInterest(map);

	}
	@Override
	public List<Interest> findCredit(String interestName) {
		return interestDao.findCredit(interestName);
	}

}
