package com.web.biz.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.ChargeBiz;
import com.web.dao.ChargeDao;
import com.web.entity.Charge;

@Service
public class ChargeBizImpl extends CommonBizImpl<Charge> implements ChargeBiz {

	ChargeDao chargedao;
	@Resource(name="chargeDaoImpl")
	public void setChargeDao(ChargeDao chargedao){
		this.chargedao = chargedao;
		super.setCommonDao(chargedao);
	}
	@Override
	public Charge selectCharge(int catId) {
		return chargedao.selectCharge(catId);
	}
	
	
}
