package com.web.biz;

import java.util.List;

import com.web.entity.House;

public interface HouseBiz {

	public boolean add(House house);
	public boolean update(House house);
	public List<House> query();
	public House findById(int id);
}
