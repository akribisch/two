package com.web.biz;

import java.util.List;

import com.web.entity.Parking;

public interface ParkingBiz extends CommonBiz<Parking>{

	public Parking queryParking(int carId);
	
	public List<Parking> queryNull();
}
