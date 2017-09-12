package com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.CarBiz;
import com.web.biz.ChargeBiz;
import com.web.biz.ParkingBiz;
import com.web.entity.Car;
import com.web.entity.Charge;
import com.web.entity.Parking;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="car/")
public class CarController {

	@Resource(name="carBizImpl")
	CarBiz carbiz;
	
	@Resource(name="parkingBizImpl")
	ParkingBiz parkingbiz;
	
	@Resource(name="chargeBizImpl")
	ChargeBiz chargeBiz;
	
	/**
	 * URL：http://localhost:8080/Amusement/car/select.do
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(path="select")
	public ModelAndView insert(ModelAndView mv,Integer page){
		Page<Car> pageing = new Page<>();
		if (page != null) {
			pageing.setCurrentPage(page);
		}
		Map<String, Object> map = new HashMap<>();
		carbiz.queryPaging(pageing, map);
		mv.addObject("pageing", pageing);
		mv.setViewName("select");
		return mv;
	}
	
	@RequestMapping(path="insert")
	public ModelAndView insert(ModelAndView mv,String plateNumber,String color){
		List<Parking> list1 = parkingbiz.queryNull();
		int count = 0;
		for (Parking p : list1) {
			if(p.getCar().getCarId() == 1){
				count += 1;
			}
		}
		if(count > 1){
			Date carIn = new Date();
			Car car = new Car(0,plateNumber, color, 0, carIn, null);
			Charge charge = new Charge(0,car, 0, 0);
			boolean flag = carbiz.add(car);
			boolean flag2 = chargeBiz.add(charge);
			List<Parking> list = parkingbiz.queryNull();
			list.get(0).setCar(car);
			boolean flag1 =  parkingbiz.update(list.get(0));
			mv.setViewName(flag && flag1 && flag2 ? "redirect:/car/select.do" : "losser");
		}else{
			mv.setViewName("max");
		}
		return mv;
	}
	
	@RequestMapping(path="selectMoner")
	public ModelAndView selectMoner(ModelAndView mv,String plateNumber){
		Date carOut = new Date();
		Car car = carbiz.queryCar(plateNumber);
		Parking parking = parkingbiz.queryParking(car.getCarId());
		long date = 1;
		date += StringUtil.getCountTime(car.getCarIn(), carOut);
		double carMon = 6;
		if(date > 3 && date < 6){
			carMon += date * 6;
		}else if(date > 6 && date < 12){
			carMon += date * 10;
		}else if(date > 12){
			carMon += date * 15;
		}
		car.setCarOut(carOut);
		Charge charge1 = chargeBiz.selectCharge(car.getCarId());
		charge1.setCarTime(date);
		charge1.setMoneyPay(carMon);
		car.setCarAt(1);
		parking.setCar(car);
		parking.setCar(new Car(1, null, null, 3, null, null));
		boolean flag2 = chargeBiz.update(charge1);
		mv.addObject("car", car);
		mv.addObject("charge", charge1);
		mv.setViewName(flag2 ? "garage" : "losser");
		return mv;
	}
	
	@RequestMapping(path="yes")
	public ModelAndView yes(ModelAndView mv,Integer carAt,String plateNumber){
		Car car = carbiz.queryCar(plateNumber);
		car.setCarAt(1);
		mv.setViewName("redirect:/car/select.do");
		return mv;
	}
	
	@RequestMapping(path="delete")
	public ModelAndView delete(ModelAndView mv,Integer carId){
		Car car = carbiz.findById(Car.class, carId);
		Parking parking =  parkingbiz.findById(Parking.class, carId);
		boolean f = parkingbiz.delete(parking);
		if(f == true){
			boolean flag = carbiz.delete(car);
			mv.setViewName(flag ? "redirect:/car/select.do" : "losser");
		}else{
			mv.setViewName("losser");
		}
		
		return mv;
	}
	
	@RequestMapping(path="sendCarId")
	public ModelAndView sendCarId(ModelAndView mv,Integer carId){
		Car car = carbiz.findById(Car.class, carId);
		mv.addObject(car);
		mv.setViewName("update");
		return mv;
	}
	
	
	@RequestMapping(path="update")
	public ModelAndView update(ModelAndView mv, Integer carId,String plateNumber,String color,Integer cwno,Integer carAt,String carIns,String carOuts){
		if(carOuts != null){
			Date carIn = StringUtil.StringToDate(carIns);
			Car car = new Car(0, plateNumber, color, carAt, carIn, null);
			boolean flag = carbiz.update(car);
			mv.setViewName(flag ? "redirect:/car/select.do" : "losser");
		}else{
			Date carIn = StringUtil.StringToDate(carIns);
			Date carOut = StringUtil.StringToDate(carOuts);
			Car car = new Car(0, plateNumber, color, carAt, carIn, carOut);
			boolean flag = carbiz.update(car);
			mv.setViewName(flag ? "redirect:/car/select.do" : "losser");
		}
		return mv;
	}
}
