package com.web.dao;


import com.web.entity.Charge;

public interface ChargeDao extends CommonDao<Charge> {

	public Charge selectCharge(int catId);
	
}
