package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.FinalKindBiz;
import com.web.dao.FinalKindDao;
import com.web.entity.FinalKind;

@Service
public class FinalKindBizImpl implements FinalKindBiz {

	@Resource
	FinalKindDao fkdao;
	
	@Override
	public int updateFinalKind(FinalKind finalKind) {
		return fkdao.updateFinalKind(finalKind);
	}

	@Override
	public int insertFinalKind(FinalKind finalKind) {
		return fkdao.insertFinalKind(finalKind);
	}

	@Override
	public int deleteFinalKind(int fkId) {
		return fkdao.deleteFinalKind(fkId);
	}

	
	@Override
	public List<FinalKind> findAllKind(Map<String, Object> map) {
		
		return fkdao.findAllKind(map);
	}

	@Override
	public int getFinalKindTotalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fkdao.getFinalKindTotalCount(map);
	}

	@Override
	public FinalKind queryFinalKindById(Integer fkId) {
		// TODO Auto-generated method stub
		return fkdao.queryFinalKindById(fkId);
	}
	public List<FinalKind> getAllFinalKind() {
		// TODO Auto-generated method stub
		return fkdao.getAllFinalKind();
	}


}
