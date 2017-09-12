package com.web.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.web.biz.SalaryBiz;
import com.web.dao.SalaryDao;
import com.web.entity.Salary;

@Service
public class SalaryBizImpl extends CommonBizImpl<Salary> implements SalaryBiz {
		
	SalaryDao salaryDao;
	
	@Resource(name="salaryDaoImpl")
	public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
		super.setCommonDao(salaryDao);
	}

	@Override
	public int updateSalary(Salary salary) {
		return salaryDao.updateSalary(salary);
	}

	@Override
	public Salary findByUser(Map<String,Object> map) {
		return salaryDao.findByUser(map);
	}

	@Override
	public int queryCount(Map<String,Object> map) {
		return salaryDao.queryCount(map);
	}
	
	

}
