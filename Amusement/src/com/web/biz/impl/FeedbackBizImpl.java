package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.FeedbackBiz;
import com.web.dao.FeedbackDao;
import com.web.entity.Feedback;
import com.web.util.Page;
@Service
public class FeedbackBizImpl extends CommonBizImpl<Feedback> implements FeedbackBiz {

	FeedbackDao fd;
	
	@Resource(name="feedbackDaoImpl")
	public void setFd(FeedbackDao fd) {
		this.fd = fd;
		super.setCommonDao(fd);
	}


	@Override
	public void queryPaging(Page<Feedback> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		fd.queryPaging(paging, map, hql, hql2);

	}


}
