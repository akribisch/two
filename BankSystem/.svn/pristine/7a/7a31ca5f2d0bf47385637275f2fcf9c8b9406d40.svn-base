package com.web.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.CreditBiz;
import com.web.biz.FlowBiz;
import com.web.biz.InterestBiz;
import com.web.biz.RateBiz;
import com.web.entity.Bank;
import com.web.entity.Commission;
import com.web.entity.Credit;
import com.web.entity.Department;
import com.web.entity.Flow;
import com.web.entity.Interest;
import com.web.entity.Rate;
import com.web.entity.Savings;
import com.web.entity.Service;
import com.web.entity.Staff;
import com.web.entity.Station;
import com.web.util.Page;

@Controller
@RequestMapping(value="credit/")
public class RateController {
	
	@Resource(name="rateBizImpl")
	RateBiz rb;
	
	@Resource(name="creditBizImpl")
	CreditBiz cb;
	
	@Resource(name="interestBizImpl")
	InterestBiz ib;
	
	@Resource(name="flowBizImpl")
	FlowBiz flowBiz;
	
	@RequestMapping(value="query")
	public ModelAndView query(ModelAndView mv,Integer page){
		Page<Rate> pages=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			pages.setCurrentPage(page);
		}
		pages=rb.findByCondtion(pages, map);
		mv.addObject("page", pages);
		mv.setViewName("rate");
		return mv;
	}
	
	@RequestMapping(value="queryCredit")
	public ModelAndView queryCredit(Integer savingsId, ModelAndView mv,Integer page,HttpServletRequest req){
		HttpSession session = req.getSession();//实例化session
		Savings sav = (Savings)session.getAttribute("savings");
		Page<Credit> pages=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			pages.setCurrentPage(page);
		}
		pages=cb.findBySavings(sav.getSavingsId(), pages, map);
		mv.addObject("page", pages);
		mv.setViewName("credit");
		return mv;
	}
	
	@RequestMapping(value="sendInsertCredit")
	public ModelAndView sendInsertCredit(ModelAndView mv,HttpServletRequest req){
		HttpSession session = req.getSession();//实例化session
		Savings sav = (Savings)session.getAttribute("savings");
		mv.addObject("savingsNum", sav.getSavingsNum());
		String interestName="%贷款%";
		List<Interest> creditList=ib.findCredit(interestName);
		mv.addObject("creditList", creditList);
		mv.setViewName("insertCredit");
		return mv;
	}
	
	@RequestMapping(value="insertCredit")
	public ModelAndView insertCredit(ModelAndView mv,HttpServletRequest req,String savingsNum,Integer interestId,Double money){
		HttpSession session = req.getSession();//实例化session
		Staff staff = (Staff)session.getAttribute("Staff");//读取session中保存的员工信息
		Station station = staff.getStation();
		Department department = station.getDepartment();
		Bank bank = department.getBank();
		Savings sav = (Savings)session.getAttribute("savings");
		Interest interest= ib.sendUpdateInterest(interestId.intValue());
		Date totalTime=addDate(new Date(), interest.getInterestCycle());
		Credit credit=new Credit(0, sav, money, new Date(), totalTime, bank, staff, interest, money);
		int count=cb.insertCredit(credit);
		if(count!=0){
			Flow flow = new Flow(0, sav, new Service(3, null), staff, new Date(), money, new Commission(3, null, 0));
			int count3 = flowBiz.insertFlow(flow);//添加员工流水记录
			if (count3 == 0) {//添加员工流水记录成功
				mv.setViewName("redirect:/credit/sendInsertCredit.do");//添加成功跳转的页面
			}
		}
		mv.setViewName("redirect:/credit/queryCredit.do");
		return mv;
	}
	
	@RequestMapping(value="datailCredit")
	public ModelAndView datailCredit(ModelAndView mv,Integer creditId,Integer interestId,double money){
		Interest interest= ib.sendUpdateInterest(interestId);
		List<Map<String, Object>> list=new ArrayList<>();
		int cycle= interest.getInterestCycle();
		for (int i = 1; i <= cycle; i++) {
			Map<String, Object> map=new HashMap<>();
			map.put("month", "第"+i+"个月");
			map.put("money", money*(1+interest.getInterest())/cycle);
			list.add(map);
		}
		mv.addObject("list", list);
		mv.setViewName("insertCredit");
		return mv;
	}
	
	@RequestMapping(value="returnCredit")
	public ModelAndView returnCredit(ModelAndView mv,Integer creditId){
		Credit credit=cb.findById(creditId);
		
		if(credit!=null){
			mv.addObject("credit", credit);
			mv.setViewName("returnCredit");
		}
		return mv;
	}
	
	@RequestMapping(value="updateCredit")
	public ModelAndView updateCredit(ModelAndView mv,Integer creditId,Double remoney,HttpServletRequest req){
		Credit credit=cb.findById(creditId);
		HttpSession session = req.getSession();//实例化session
		Staff staff = (Staff)session.getAttribute("Staff");//读取session中保存的员工信息
		Savings sav = (Savings)session.getAttribute("savings");
		if(credit!=null){
			credit.setMoney(credit.getMoney()-remoney);
			int count=cb.updateCredit(credit);
			if(count==1){
				Flow flow = new Flow(0, sav, new Service(3, null), staff, new Date(), credit.getMoney(), new Commission(3,null,0));
				int count3 = flowBiz.insertFlow(flow);//添加员工流水记录
				if (count3 == 0) {//添加员工流水记录成功
					mv.setViewName("redirect:/credit/returnCredit.do");//添加成功跳转的页面
				}
			}
			mv.setViewName("redirect:/credit/queryCredit.do");
		}
		return mv;
	}
	public Date addDate(Date date,int cycle){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, cycle);
		date =c.getTime();
		return date;
	}
}
