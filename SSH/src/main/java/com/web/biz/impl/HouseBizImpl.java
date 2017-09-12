package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.HouseBiz;
import com.web.dao.HouseDao;
import com.web.entity.House;

@Service
public class HouseBizImpl implements HouseBiz {
	
	@Resource(name="houseDaoImpl")
	HouseDao houseDao;

	public boolean add(House house) {
		return houseDao.add(house);
	}
	
	public boolean update(House house){
		return houseDao.update(house);
	}

	public List<House> query() {
		return houseDao.query();
	}

	public House findById(int id) {
		// TODO Auto-generated method stub
		return houseDao.findById(id);
	}

}
