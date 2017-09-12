package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.FinancialBiz;
import com.web.dao.FinancialDao;
import com.web.entity.Financial;

@Service
public class FinancialBizImpl implements FinancialBiz {

	@Resource
	FinancialDao fdao;
	@Override
	public int insertFinancial(Financial financial) {
		return fdao.insertFinancial(financial);
	}

	@Override
	public int updateFinancial(Financial financial) {
		return fdao.updateFinancial(financial);
	}

	@Override
	public int deleteFinancial(int finId) {
		return fdao.deleteFinancial(finId);
	}

	@Override
	public List<Financial> findAll() {
		return fdao.findAll();
	}

}
