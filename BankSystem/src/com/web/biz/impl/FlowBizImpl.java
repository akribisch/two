package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.FlowBiz;
import com.web.dao.FlowDao;
import com.web.entity.Flow;
import com.web.util.Page;

@Service
public class FlowBizImpl implements FlowBiz {

	@Resource
	FlowDao flowdao;
	
	@Override
	public List<Flow> selectAll() {
		
		return flowdao.selectAll();
	}

	@Override
	public List<Flow> select(Page<Flow> page) {
		return flowdao.select(page);
	}

	@Override
	public int selectCount(Page<Flow> page) {
		return flowdao.selectCount(page);
	}

	@Override
	public int insertFlow(Flow flow) {
		return flowdao.insertFlow(flow);
	}

	@Override
	public int updateById(Flow flow) {
		return flowdao.updateById(flow);
	}

	@Override
	public int deleteById(int flowId) {
		return flowdao.deleteById(flowId);
	}

}
