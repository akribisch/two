package com.web.controller;

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

import com.web.biz.AccessBiz;
import com.web.biz.FlowBiz;
import com.web.biz.SavingsBiz;
import com.web.entity.Access;
import com.web.entity.Bank;
import com.web.entity.Commission;
import com.web.entity.Credit;
import com.web.entity.Department;
import com.web.entity.Flow;
import com.web.entity.Savings;
import com.web.entity.Service;
import com.web.entity.Staff;
import com.web.entity.Station;
import com.web.util.Page;
import com.web.util.StringUtil;

/**
 * 存取款表实体类的控制层
 * URL:http://localhost:8080/BankSystem/Access/
 * @author java201
 *
 */
@Controller
@RequestMapping(value="Access/")
public class AccessController {
	@Resource(name="accessBizImpl")
	AccessBiz accessBiz;
	
	@Resource(name="savingsBizImpl")
	SavingsBiz savingsBiz;
	
	@Resource(name="flowBizImpl")
	FlowBiz flowBiz;
	
	/**
	 * 动态分页查询
	 * URL:http://localhost:8080/BankSystem/Access/selectAccess.do
	 * @param mv
	 * @param page
	 * @param savingsNum
	 * @param serId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(path="selectAccess")
	public ModelAndView select(ModelAndView mv,Integer page,String savingsNum,Integer serId,String beginDate,String endDate){
		System.out.println("进入selectAccess控制器");
		Page<Access> pg = new Page<>();
		
		//查询的卡号
		Savings sav = new Savings();
		Integer savingsId = null;
		if (savingsNum != null) {
			sav.setSavingsNum(String.valueOf(savingsNum));
			savingsId = savingsBiz.findByNumForId(savingsNum);
		}
		sav.setSavingsId(savingsId != null ? savingsId : 0);
		
		//查询的业务类型
		Service ser = new Service();
		ser.setSerId(serId != null ? serId : 0);
		
		//组装存取款表实体类
		Access ac = new Access();
		ac.setSavings(sav);
		ac.setService(ser);
		
		//查询的开始和结束时间
		Map<String,Object> map = new HashMap<>();
		map.put("beginDate", (beginDate == null || beginDate == "") ? beginDate : StringUtil.StringToDate(beginDate + " 00:00:00") );
		map.put("endDate", (endDate == null || endDate == "") ? endDate : StringUtil.StringToDate(endDate + " 00:00:00") );
		
		//决定跳转的页数
		pg.setCurrentPage(page != null ? page : 1);
		System.out.println("page:"+page);
		System.out.println("进入页面:"+pg.getCurrentPage());
		pg.setObj(ac);
		pg.setMap(map);
		
		//动态查询的结果集总条目数
		int totalPage = accessBiz.selectCount(pg);
		pg.setTotalRecord(totalPage);
		
		//动态查询、分页的结果集，返回对象集合
		List<Access> list = accessBiz.select(pg);
		pg.setList(list);
		
		mv.addObject("Paging", pg);
		//跳转页面
		mv.setViewName("selectAccess");
		return mv;
	}
	
	/**
	 * 提交添加Access的控制器
	 * URL:http://localhost:8080/BankSystem/Access/sendaddAccess.do
	 * @param mv
	 * @param access
	 * @return
	 */
	@RequestMapping(path="sendaddAccess")
	public ModelAndView addAccess(ModelAndView mv,HttpServletRequest req,Integer savingsId,String savingsNum,Integer serId,double money){
		HttpSession session = req.getSession();//实例化session
		Staff staff = (Staff)session.getAttribute("Staff");//读取session中保存的员工信息
		Station station = staff.getStation();
		Department department = station.getDepartment();
		Bank bank = department.getBank();
		
		Date nowTime = new Date();//读取系统当前时间
		
		if(serId==1||serId==2){
			
			Access access = new Access();
			access.setSavings(new Savings(savingsId, null, null, null, 0, null, null, null, null));
			access.setService(new Service(serId, null));
			access.setMoney(money);
			access.setCurrentTime(nowTime);
			access.setStaff(staff);
			access.setBank(bank);
			
			int count1 = accessBiz.insert(access);//添加存取款记录
			if (count1 == 1) {//添加存取款记录成功
				Savings savings = savingsBiz.selectById(savingsId);
				double balance = savings.getBalance() + money;//储蓄卡表应剩余额
				
				//修改储蓄卡表余额
				int count2 = savingsBiz.updateSavings(new Savings(savingsId, null, null, null, balance, null, null, null, null));
				if (count2 == 1) {//修改储蓄卡表余额成功
					Service service = new Service(serId, null);
					Commission commission = new Commission(serId, null, 0);
					
					Flow flow = new Flow(0, savings, service, staff, nowTime, money, commission);
					int count3 = flowBiz.insertFlow(flow);//添加员工流水记录
					if (count3 == 1) {//添加员工流水记录成功
						mv.setViewName("/login/loginSavings");//添加成功跳转的页面
					}else{//添加员工流水记录失败
						mv.setViewName("failAccess");//添加失败跳转的页面
					}
				}else {//修改储蓄卡表余额成功
					mv.setViewName("failAccess");//添加失败跳转的页面
				}
			}else{//添加存取款记录失败
				mv.setViewName("failAccess");//添加失败跳转的页面
			}
		}else{
			Credit cred=new Credit(0, null, money, null, null, bank, staff, null, 0);
			mv.addObject("credit", cred);
			mv.setViewName("redirect:/credit/sendInsertCredit.do");
		}
		
		return mv;
	}
	
	/**
	 * 修改
	 * URL:http://localhost:8080/BankSystem/Access/updateAccess.do
	 * @param mv
	 * @param access
	 * @return
	 */
	@RequestMapping(path="updateAccess")
	public ModelAndView updateAccess(ModelAndView mv,Integer accessId,Integer savingsId,Integer serId,double money,String currenttime,Integer bankId,Integer staffId){
		Access access = new Access();
		access.setAccessId(accessId);
		access.setSavings(new Savings(savingsId, null, null, null, 0, null, null, null, null));
		access.setService(new Service(serId, null));
		access.setMoney(money);
		access.setCurrentTime(StringUtil.StringToDate(currenttime));
		access.setStaff(new Staff(staffId, null, null, 0, null, null, null,null));
		access.setBank(new Bank(bankId, null));
		
		int count = accessBiz.updateById(access);
		if (count == 1) {
			mv.setViewName("updateAccess");//修改成功跳转的页面
		}else{
			mv.setViewName("failAccess");//修改失败跳转的页面
		}
		return mv;
	}
	
	/**
	 * 删除
	 * URL:http://localhost:8080/BankSystem/Access/deleteAccess.do
	 * @param mv
	 * @param access
	 * @return
	 */
	@RequestMapping(path="deleteAccess")
	public ModelAndView deleteAccess(ModelAndView mv,int accessId){
		int count = accessBiz.deleteById(accessId);
		if (count == 1) {
			mv.setViewName("deleteAccess");//修改成功跳转的页面
		}else{
			mv.setViewName("failAccess");//修改失败跳转的页面
		}
		return mv;
	}
}
