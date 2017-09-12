package com.web.biz.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.CarBiz;
import com.web.dao.CarDao;
import com.web.entity.Car;

@Service
public class CarBizImpl extends CommonBizImpl<Car> implements CarBiz {

	CarDao cardao;
	
	@Resource(name="carDaoImpl")
	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
		super.setCommonDao(cardao);
	}

	@Override
	public Car queryCar(String plateNumber) {
		return cardao.queryCar(plateNumber);
	}

}
