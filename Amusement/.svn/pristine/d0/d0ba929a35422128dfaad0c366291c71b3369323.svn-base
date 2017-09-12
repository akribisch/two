package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.ParkingBiz;
import com.web.dao.CarDao;
import com.web.dao.ParkingDao;
import com.web.entity.Parking;

@Service
public class ParkingBizImpl extends CommonBizImpl<Parking> implements ParkingBiz{

	ParkingDao parkingdao;
	
	@Resource(name="parkingDaoImpl")
	public void setCardao(ParkingDao parkingdao) {
		this.parkingdao = parkingdao;
		super.setCommonDao(parkingdao);
	}

	@Override
	public Parking queryParking(int carId) {
		return  parkingdao.queryParking(carId);
	}

	@Override
	public List<Parking> queryNull() {
		return parkingdao.queryNull();
	}
}
