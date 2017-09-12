package com.web.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.CreditBiz;
import com.web.dao.CreditDao;
import com.web.entity.Credit;
import com.web.util.Page;
@Service
public class CreditBizImpl implements CreditBiz {
	
	@Resource
	CreditDao cd;

	@Override
	public int insertCredit(Credit credit) {
		return cd.insertCredit(credit);
	}

	@Override
	public int updateCredit(Credit credit) {
		return cd.updateCredit(credit);
	}

	@Override
	public int deleteCredit(int savingsId) {
		return cd.deleteCredit(savingsId);
	}

	@Override
	public Page<Credit> findBySavings(int savingsId,Page<Credit> page, Map<String, Object> map) {
		map.put("savingsId", savingsId);
		map.put("startIndex", page.getStartIndex());
		map.put("pageSize", page.getPageSize());
		page.setTotalRecord(cd.findCreditCount(savingsId));
		page.setList(cd.findBySavings(map));
		return page;
	}

	@Override
	public Credit findById(int creditId) {
		return cd.findById(creditId);
	}

}
