package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.ServiceBiz;
import com.web.dao.ServiceDao;
import com.web.util.Page;

@Service
public class ServiceBizImpl implements ServiceBiz{

	@Resource
	ServiceDao servicedao;
	
	@Override
	public List<com.web.entity.Service> selectAll() {
		return servicedao.selectAll();
	}

	@Override
	public int insertService(com.web.entity.Service service) {
		return servicedao.insertService(service);
	}

	public int updateServiceById(com.web.entity.Service service) {
		return servicedao.updateServiceById(service);
	}

	@Override
	public int deleteServiceById(int serId) {
		return servicedao.deleteServiceById(serId);
	}

	@Override
	public List<com.web.entity.Service> select(Page<com.web.entity.Service> page) {
		return servicedao.select(page);
	}

	@Override
	public int selectCount(Page<com.web.entity.Service> page) {
		return servicedao.selectCount(page);
	}

}
