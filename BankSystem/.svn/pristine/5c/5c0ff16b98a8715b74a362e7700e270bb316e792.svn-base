package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.CommissionBiz;
import com.web.dao.CommissionDao;
import com.web.entity.Commission;
import com.web.util.Page;

@Service
public class CommissionBizImpl implements CommissionBiz {

	@Resource
	CommissionDao commissiondao;

	@Override
	public List<Commission> selectAll() {
		return commissiondao.selectAll();
	}

	@Override
	public int insertCommission(Commission commission) {
		return commissiondao.insertCommission(commission);
	}

	@Override
	public int updateCommissionById(Commission commission) {
		return commissiondao.updateCommissionById(commission);
	}

	@Override
	public int deleteById(int CommissionID) {
		return commissiondao.deleteById(CommissionID);
	}

	@Override
	public List<Commission> select(Page<Commission> page) {
		return commissiondao.select(page);
	}

	@Override
	public int selectCount(Page<Commission> page) {
		return commissiondao.selectCount(page);
	}

	
	
	

}
