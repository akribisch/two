package com.web.dao;

import java.util.List;

import com.web.entity.House;

public interface HouseDao {

	public boolean add(House house);
	
	public boolean update(House house);
	
	public List<House> query();
	
	public House findById(int id);
}
