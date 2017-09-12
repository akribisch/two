package com.web.biz;

import java.util.List;

import com.web.entity.FinalRecord;

public interface FinalRecordBiz {
	/**
	 * 修改理财记录
	 * @return
	 */
	public int updateFinalRecord(FinalRecord finalRecord);
	
	/**
	 * 添加理财记录
	 * @param finalRecord
	 * @return
	 */
	public int insertFinalRecord(FinalRecord finalRecord);
	
	/**
	 * 删除理财记录
	 * @return
	 */
	public int deleteFinalRecord(int finRecordId);
	
	/**
	 * 查询某张卡全部理财记录
	 * @return
	 */
	public List<FinalRecord> findAllRecord();
	
}
