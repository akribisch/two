package com.web.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 收费记录控制器
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.ChargeBiz;
import com.web.entity.Charge;
import com.web.entity.Parking;
import com.web.util.Page;

@Controller
@RequestMapping(value="charge")
public class ChargeController {

	@Resource(name="chargeBizImpl")
	ChargeBiz chargeBiz;
	
	/**
	 * URL：http://localhost:8080/Amusement/charge/select.do
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(path="select")
	public ModelAndView select(ModelAndView mv,Integer page){
		Page<Charge> pageing = new Page<>();
		if(page != null){
			pageing.setCurrentPage(page);
		}
		Map<String, Object> map = new HashMap<>();
		chargeBiz.queryPaging(pageing, map);
		mv.addObject("pageing", pageing);
		mv.setViewName("select");
		return mv;
	}
	
	/*@RequestMapping(path="sendCwno")
	public ModelAndView sendCwno(ModelAndView mv,Integer cwno){
		mv.addObject(cwno);
		mv.setViewName("update");
		return mv;
	}
	
	@RequestMapping(path="update")
	public ModelAndView update(ModelAndView mv,Integer cwno,long carTime,Double moneyPay){
		Charge charge = chargeBiz.findById(Charge.class, cwno);
		charge.setCarTime(carTime);
		charge.setMoneyPay(moneyPay);
		boolean flag = chargeBiz.update(charge);
		mv.setViewName(flag ? "redirect:/car/selectMoner.do" : "losser");
		mv.setViewName("select");
		return mv;
	}*/
}
