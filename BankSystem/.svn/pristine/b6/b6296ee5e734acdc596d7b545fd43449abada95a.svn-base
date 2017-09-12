package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.SavStateBiz;
import com.web.dao.SavStateDao;
import com.web.entity.SavState;
@Service
public class SavStateBizImpl implements SavStateBiz {

	
	
	@Resource(name="savStateDao")
	SavStateDao savStateDao;
	
	@Override
	public int addSavState(SavState savState) {
		return savStateDao.addSavState(savState);
		

	}
	@Override
	public List<SavState> querySavState(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return savStateDao.querySavState(map);
	}
	@Override
	public int getSavStateTotalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return savStateDao.getSavStateTotalCount(map);
	}

}
