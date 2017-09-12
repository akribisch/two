package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.smartcardio.Card;

import org.springframework.stereotype.Service;

import com.web.biz.CarBiz;
import com.web.dao.CarDao;
import com.web.entity.Car;

@Service //业务逻辑层
public class CarBizImpl extends CommonBizImpl<Car> implements CarBiz {
	
//	@Resource(name="carDaoImpl")
	CarDao carDao;

	@Resource(name="carDaoImpl")
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
		super.setCommonDao(carDao);
	}
	
	

//	public boolean add(Car car) {
//		// TODO Auto-generated method stub
//		return carDao.add(car);
//	}
//
//	public List<Car> query() {
//		// TODO Auto-generated method stub
//		return carDao.query();
//	}

}
