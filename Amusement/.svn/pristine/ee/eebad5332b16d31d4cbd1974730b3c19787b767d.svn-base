package com.web.biz.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.RecreationBiz;
import com.web.dao.RecreationDao;
import com.web.entity.Recreation;

@Service
public class RecreationBizImpl extends CommonBizImpl<Recreation> implements RecreationBiz {
	
	
	RecreationDao recreationDao;
	
	@Resource(name="recreationDaoImpl")
	public void setRecreationDao(RecreationDao recreationDao){
		this.recreationDao=recreationDao;
		super.setCommonDao(recreationDao);
	}
	
}
