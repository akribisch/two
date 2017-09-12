package com.web.biz.impl;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.VipLevelBiz;

import com.web.dao.VipLevelDao;
import com.web.entity.VipLevel;

@Service
public class VipLevelBizImpl extends CommonBizImpl<VipLevel> implements VipLevelBiz {
	VipLevelDao vipLevelDao;
	
	@Resource(name="vipLevelDaoImpl")
	public void setRecreationDao(VipLevelDao vipLevelDao){
		this.vipLevelDao=vipLevelDao;
		super.setCommonDao(vipLevelDao);
		
		
	}
	
	
}
