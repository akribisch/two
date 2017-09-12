package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.RateBiz;
import com.web.dao.RateDao;
import com.web.entity.Rate;
import com.web.util.Page;

@Service
public class RateBizImpl implements RateBiz {
	
	@Resource
	RateDao rdao;

	@Override
	public int updateRate(Rate rate) {
		return rdao.updateRate(rate);
	}

	@Override
	public int insertRate(Rate rate) {
		return rdao.insertRate(rate);
	}

	@Override
	public int deleteRate(int rateId) {
		return rdao.deleteRate(rateId);
	}

	@Override
	public List<Rate> findAllRate() {
		return rdao.findAllRate();
	}

	@Override
	public Page<Rate> findByCondtion(Page<Rate> page, Map<String, Object> map) {
		map.put("startIndex", page.getStartIndex());
		map.put("pageSize", page.getPageSize());
		page.setTotalRecord(rdao.findCount());
		page.setList(rdao.findByCondtion(map));
		return page;
	}

}
