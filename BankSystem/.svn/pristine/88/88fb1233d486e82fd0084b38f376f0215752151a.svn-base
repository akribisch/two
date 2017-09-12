package com.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.SavingsBiz;
import com.web.biz.ServiceBiz;
import com.web.biz.UserBiz;
import com.web.entity.Bank;
import com.web.entity.Interest;
import com.web.entity.SavState;
import com.web.entity.Savings;
import com.web.entity.Service;
import com.web.entity.Staff;
import com.web.entity.User;
import com.web.util.Page;

@Controller
@RequestMapping(value="Savings/")
public class SavingsController {
	

	@Resource(name="savingsBizImpl")
	SavingsBiz sb;
	@Resource(name="userBizImpl")
	UserBiz sn;
	
	@Resource(name="serviceBizImpl")
	ServiceBiz serb;
	
	/**
	 * 动态分页查询
	 * //http://localhost:8080/BankSystem/Savings/querySavings.do
	 * @param mv
	 * @param page
	 * @param savingsNum
	 * @return
	 */
	//http://localhost:8080/BankSystem/Savings/querySavings.do
	@RequestMapping("querySavings")
	public ModelAndView querySavings(ModelAndView mv,Integer page,String savingsNum){
		
		Page<Savings> pg = new Page<>();
		
		Savings stu = new Savings();
		stu.setSavingsNum(savingsNum);
		
		pg.setCurrentPage(page != null ? page : 1);
		
		pg.setObj(stu);//设置对象
		
		sb.queryPage(pg);//分页查询
		
		mv.addObject("Paging", pg);
		//跳转页面
		mv.setViewName("querySavings");
		return mv;
	}
	/**
	 * 添加
	 * @param mv
	 * @param savingsNum
	 * @return
	 */
	//http://localhost:8080/BankSystem/Savings/addSavings.do
	@RequestMapping("addSavings")
	public ModelAndView addSavings(ModelAndView mv,HttpServletRequest req,User user,String savingsNum,String password,String interestName){
		HttpSession session = req.getSession();
		int count = sn.addUser(user);
		if(count>0){//用户添加成功
			Staff staff = (Staff)session.getAttribute("Staff");
			Savings savings = new Savings();
			savings.setSavingsNum(savingsNum);
			savings.setPassword(password);
			savings.setStaff(staff);
			savings.setBalance(0);
			savings.setBank(staff.getStation().getDepartment().getBank());
			SavState savState = new SavState(0,"正常");
			savings.setSavState(savState);
			Interest interest = new Interest(0,interestName,0,0);
			savings.setInterest(interest);
			int a = sb.add(savings);
			if(a>0){//添加储蓄卡成功
				mv.setViewName("success");//跳转到添加成功页面
			}else{
				mv.setViewName("fail");//跳转到添加失败的页面
			}
		}else{
			mv.setViewName("fail");//跳转添加失败的页面
		}
		
		
		return mv;
	}
	
	/**
	 * 修改
	 * @param mv
	 * @param savingsId
	 * @return
	 */
	//http://localhost:8080/BankSystem/Savings/updateSavings.do
	@RequestMapping(path="updateSavings")
	public ModelAndView updateSavings(ModelAndView mv,Integer savingsId, String savingsNum,Integer userId,String password,double balance,Integer bankId,Integer staffId,Integer savId,Integer interestId){
		Savings savings = new Savings();
		savings.setSavingsId(savingsId);
		savings.setSavingsNum(savingsNum);
		savings.setUser(new User(userId,null,null,null,0,null));
		savings.setPassword(password);
		savings.setBalance(balance);
		savings.setBank(new Bank(bankId,null));
		savings.setStaff(new Staff(staffId, null, null, 0,  null, null, null, null));
		savings.setSavState(new SavState(savId,null));
		savings.setInterest(new Interest(interestId,null,0,0));
		
		int count = sb.updateSavings(savings);
		if (count == 1) {
			mv.setViewName("updateSavings");//修改成功跳转的页面
		}else{
			mv.setViewName("failupdateSavings");//修改失败跳转的页面
		}
		return mv;
	}
	/**
	 * 删除
	 * @param mv
	 * @param savingsId
	 * @return
	 */
	//http://localhost:8080/BankSystem/Savings/deleteSavings.do
	@RequestMapping(path="deleteSavings")
	public ModelAndView deleteSavings(ModelAndView mv,Integer savingsId){
		int count = sb.deleteSavings(savingsId);
		if (count == 1) {
			mv.setViewName("deleteSavings");//删除成功跳转的页面
		}else{
			mv.setViewName("faildeleteSavings");//删除失败跳转的页面
		}
		return mv;
	
	}
	/**
	 * 保存登录卡号	
	 * @param mv
	 * @param savingsId
	 * @return
	 */
	@RequestMapping(path="sendLogin")
	public ModelAndView findBySavings(ModelAndView mv,Integer savingsId){
		String savingsNum = sb.findBySavingsid(savingsId);
		mv.addObject("savingsNum",savingsNum);
		mv.setViewName("/login/loginSavings");
		return mv;
	}
	/**
	 * 登录
	 * @param mv
	 * @param savingsNum
	 * @param password
	 * @return
	 */
	//http://localhost:8080/BankSystem/login/loginSavings.jsp
	@RequestMapping(path="login")
	public ModelAndView findBySavings(ModelAndView mv,HttpServletRequest req,String savingsNum,String password){
		Savings savings = new Savings(0,savingsNum,null,password,0,null,null,null,null);
		savings = sb.findBySavings(savings);
		HttpSession session = req.getSession();//实例化session
		if(savings!=null){
			session.setAttribute("savings", savings);
			//登录成功跳转的页面
			mv.addObject("savingsNum",savings.getSavingsNum());
			mv.addObject("savingsId",savings.getSavingsId());
			List<Service> list=serb.selectAll();
			mv.addObject("list", list);
			mv.setViewName("/Access/addAccess");
		}else{
			//登录失败跳转的页面
			mv.setViewName("redirect:/login/loginSavings.jsp");
		}
		return mv;
	}
	
}