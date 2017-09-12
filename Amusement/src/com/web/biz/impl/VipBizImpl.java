package com.web.biz.impl;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.VipBiz;

import com.web.dao.VipDao;
import com.web.entity.Vip;

@Service
public class VipBizImpl extends CommonBizImpl<Vip> implements VipBiz {
	
	VipDao vipDao;
	
	@Resource(name="vipDaoImpl")
	public void setVipDao(VipDao vipDao){
		this.vipDao=vipDao;
		super.setCommonDao(vipDao);
	}

	@Override
	public List<Vip> findBycondition(String vNo) {
		
		return vipDao.findBycondition(vNo) ;
	}

	
	
}
