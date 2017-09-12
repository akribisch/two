package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.SavingsBiz;
import com.web.dao.SavingsDao;
import com.web.entity.Savings;
import com.web.util.Page;
@Service
public class SavingsBizImpl implements SavingsBiz {
	@Resource
	SavingsDao savingsdao;
	@Override
	public List<Savings> queryAll() {
		return savingsdao.queryAll();
	}

	@Override
	public int add(Savings savings) {
		return savingsdao.add(savings);

	}

	@Override
	public int deleteSavings(int id) {
		return savingsdao.deleteSavings(id);	
	}

	@Override
	public int updateSavings(Savings savings) {
		return savingsdao.updateSavings(savings);
		
	}

	@Override
	public Integer findByNumForId(String savingsNum) {
		return savingsdao.findByNumForId(savingsNum);
	}
	
	@Override
	public void queryPage(Page<Savings> page) {
		page.setList(savingsdao.queryPage(page));//设置数据
		page.setTotalRecord(savingsdao.selectCount(page));//设置总条数
		
	}

	@Override
	public Savings findBySavings(Savings savings) {
		return savingsdao.findBySavings(savings);
	}

	@Override
	public String findBySavingsid(int savingsId) {
		return savingsdao.findBySavingsid(savingsId);
	}

	@Override
	public Savings selectById(int savingsId) {
		return savingsdao.selectById(savingsId);
	}

}


