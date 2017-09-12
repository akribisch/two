package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.WorkTimeDao;
import com.web.entity.WorkTime;
import com.web.util.Page;

@Repository 
public class WorkTimeDaoImpl extends CommonDaoImpl<WorkTime> implements WorkTimeDao {

	@Override
	public void queryPaging(Page<WorkTime> paging, Map<String, Object> map) {
		
		
	}

	@Override
	public  List<WorkTime> queryAll(String hql) {
		hql="from WorkTime";
		return super.queryAll(hql);
	}
}
