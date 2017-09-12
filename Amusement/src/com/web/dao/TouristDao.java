package com.web.dao;

import java.util.List;

import com.web.entity.Tourist;

public interface TouristDao extends CommonDao<Tourist> {

	
	public Tourist findByTourCount(String name);
	
	public List<Tourist> findBycondition(String tourPhone);
}
