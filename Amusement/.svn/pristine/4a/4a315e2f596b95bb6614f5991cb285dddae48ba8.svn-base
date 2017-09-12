package com.web.biz.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.DeviceBiz;
import com.web.dao.DeviceDao;
import com.web.entity.Device;
import com.web.util.Page;

@Service
public class DeviceBizImpl extends CommonBizImpl<Device> implements DeviceBiz {

	DeviceDao dd;

	@Resource(name="deviceDaoImpl")
	public void setDd(DeviceDao dd) {
		this.dd = dd;
		super.setCommonDao(dd);
	}

	@Override
	public void queryPaging(Page<Device> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		dd.queryPaging(paging, map, hql, hql2);
	}
	
	
}
