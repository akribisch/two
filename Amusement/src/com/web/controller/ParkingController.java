package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.CarBiz;
import com.web.biz.ParkingBiz;
import com.web.entity.Car;
import com.web.entity.Parking;
import com.web.util.Page;

/**
 * 车位信息控制器
 * @author java201
 *
 */
@Controller
@RequestMapping(value="parking/")
public class ParkingController {

	@Resource(name="carBizImpl")
	CarBiz carbiz;
	
	@Resource(name="parkingBizImpl")
	ParkingBiz parkingbiz;
	
	/**
	 * URL:http://localhost:8080/Amusement/parking/select.do
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(path="select")
	public ModelAndView select(ModelAndView mv,Integer page){
		Page<Parking> pageing = new Page<>();
		if(page != null){
			pageing.setCurrentPage(page);
		}
		Map<String, Object> map = new HashMap<>();
		parkingbiz.queryPaging(pageing, map);
		mv.addObject("pageing", pageing);
		mv.setViewName("select");
		return mv;
	}
	
	@RequestMapping(path="update")
	public ModelAndView update(ModelAndView mv,Integer cwno,Integer cwType,String plateNumber,String color,String userName,String carMons){
		
		double carMon = Double.valueOf(carMons.toString()) ;
		Parking parking = new Parking(cwno, cwType, null, carMon);
		
		boolean flag = parkingbiz.update(parking);
		mv.setViewName(flag ? "redirect:/parking/select.do" : "losser");
		return mv;
	}
	
	@RequestMapping(path="delete")
	public ModelAndView delete(ModelAndView mv,Integer cwno){
		Parking parking = parkingbiz.findById(Parking.class, cwno);
		boolean flag = parkingbiz.delete(parking);
		mv.setViewName(flag ? "redirect:/parking/select.do" : "losser");
		return mv;
	}
}
