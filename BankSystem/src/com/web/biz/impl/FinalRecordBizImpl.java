package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.FinalRecordBiz;
import com.web.dao.FinalRecordDao;
import com.web.entity.FinalRecord;
@Service
public class FinalRecordBizImpl implements FinalRecordBiz {
	
	@Resource
	FinalRecordDao frdao;

	@Override
	public int updateFinalRecord(FinalRecord finalRecord) {
		return frdao.updateFinalRecord(finalRecord);
	}

	@Override
	public int insertFinalRecord(FinalRecord finalRecord) {
		return frdao.insertFinalRecord(finalRecord);
	}

	@Override
	public int deleteFinalRecord(int finRecordId) {
		return frdao.deleteFinalRecord(finRecordId);
	}

	@Override
	public List<FinalRecord> findAllRecord() {
		return frdao.findAllRecord();
	}


}
