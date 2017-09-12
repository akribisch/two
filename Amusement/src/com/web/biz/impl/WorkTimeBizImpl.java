package com.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.WorkTimeBiz;
import com.web.dao.WorkTimeDao;
import com.web.entity.WorkTime;

@Service
public class WorkTimeBizImpl extends CommonBizImpl<WorkTime> implements WorkTimeBiz {
	
	WorkTimeDao workTimeDao;
	
	@Resource(name="workTimeDaoImpl")
	public void setWorkTimeDao(WorkTimeDao workTimeDao) {
		this.workTimeDao = workTimeDao;
		super.setCommonDao(workTimeDao);
	}
}