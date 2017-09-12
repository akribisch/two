package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.BankBiz;
import com.web.biz.DepartmentBiz;
import com.web.biz.StaffBiz;
import com.web.biz.StationBiz;
import com.web.entity.Staff;
import com.web.entity.Station;
import com.web.util.Page;
import com.web.util.StringUtil;

/**
 * 员工表实体类的控制层
 * URL:http://localhost:8080/BankSystem/staff/
 * @author java201
 *
 */
@Controller
@RequestMapping(value="staff/")
public class StaffController {
	@Resource(name="staffBizImpl")
	StaffBiz staffBiz;
	
	@Resource(name="stationBizImpl")
	StationBiz stationBiz;
	
	@Resource(name="departmentBizImpl")
	DepartmentBiz departmentBiz;
	
	@Resource(name="bankBizImpl")
	BankBiz bankBiz;
	
	/**
	 * 登陆验证
	 * URL:http://localhost:8080/BankSystem/staff/login.do
	 * @param mv
	 * @param staffId
	 * @param password
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(path="login")
	public ModelAndView login(ModelAndView mv,String staffName,String password,HttpServletRequest req){
		Staff staff = new Staff(0, staffName, null, 0, null, null, null,password);
		staff = staffBiz.login(staff);//登陆验证
		
		if (staff != null) {//登陆成功，进入主页
			HttpSession session = req.getSession();
			session.setAttribute("Staff", staff);//员工信息存入session中
			mv.setViewName("redirect:/menu/showMenu.do");
		}else {//登陆失败,返回登陆页
			mv.setViewName("redirect:/login/login.jsp");
		}
		
		return mv;
	}
	
	/**
	 * 查询所有岗位，然后进入注册员工页
	 * URL:http://localhost:8080/BankSystem/staff/addStaff.do
	 * @param mv
	 * @return
	 */
	@RequestMapping(path="addStaff")
	public ModelAndView addStaff(ModelAndView mv){
		List<Station> list = stationBiz.selectAll();
		mv.addObject("StatList",list);//岗位列表
		mv.setViewName("addStaff");
		return mv;
	}
	
	/**
	 * 添加员工
	 * URL:http://localhost:8080/BankSystem/staff/sendaddStaff.do
	 * @param mv
	 * @param staffName
	 * @param sPhone
	 * @param ssex
	 * @param sbirthday
	 * @param sidcard
	 * @param statId
	 * @param password
	 * @return
	 */
	@RequestMapping(path="sendaddStaff")
	public ModelAndView sendaddStaff(ModelAndView mv,String staffName,String sPhone,Integer ssex,String sbirthday,String sidcard,Integer statId,String password){
		Staff staff = new Staff(0, staffName, sPhone, ssex, StringUtil.StringToDateYMD(sbirthday), sidcard, new Station(statId, null, 0, null), password);
		int count = staffBiz.insert(staff);
		if (count == 1) {//添加员工成功
			mv.setViewName("redirect:/staff/selectStaff.do");//重定向员工查询页
		}else{//添加员工失败
			mv.setViewName("redirect:/staff/addStaff.do");//返回添加页面
		}
		return mv;
	}
	
	/**
	 * 分页查询员工
	 * URL:http://localhost:8080/BankSystem/staff/selectStaff.do
	 * @param mv
	 * @param page
	 * @param staffName
	 * @param ssex
	 * @param sidcard
	 * @param statId
	 * @param depId
	 * @param bankId
	 * @return
	 */
	@RequestMapping(path="selectStaff")
	public ModelAndView selectStaff(ModelAndView mv,Integer page,String staffName,Integer ssex,String sidcard,Integer statId,Integer depId,Integer bankId){
		Page<Staff> pg = new Page<>();
		//跳转的页数
		pg.setCurrentPage(page != null ? page : 1);//跳转的页数
		
		//组装查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("staffName", staffName);
		map.put("ssex", ssex != null ? ssex : -1);
		map.put("sidcard", sidcard);
		map.put("statId", statId != null ? statId : -1);
		map.put("depId", depId != null ? depId : -1);
		map.put("bankId", bankId != null ? bankId : -1);
		pg.setMap(map);
		
		//动态查询的结果集总条目数
		pg.setTotalRecord(staffBiz.selectCount(pg));
		
		List<Staff> list = staffBiz.select(pg);
		pg.setList(list);
		
		mv.addObject("Paging", pg);
		mv.addObject("StatList",stationBiz.selectAll());
		mv.addObject("DepList",departmentBiz.selectAll());
		mv.addObject("BankList",bankBiz.selectAll());
		
		//跳转页面
		mv.setViewName("selectStaff");
		return mv;
	}
	
	/**
	 * 根据主键查询对象，传入修改页面
	 * @param mv
	 * @param staffId
	 * @return
	 */
	@RequestMapping(path="updateStaff")
	public ModelAndView updateStaff(ModelAndView mv,String staffId){
		Staff staff = staffBiz.selectById(Integer.parseInt(staffId));
		List<Station> list = stationBiz.selectAll();
		mv.addObject("selStaff",staff);
		mv.addObject("StatList",list);
		mv.setViewName("updateStaff");
		return mv;
	}
	
	
	@RequestMapping(path="sendUpdateStaff")
	public ModelAndView sendUpdateStaff(ModelAndView mv,Integer staffId,String staffName,String sPhone,Integer ssex,String sbirthday,String sidcard,Integer statId,String password){
		Staff staff = new Staff(staffId, staffName, sPhone, ssex, StringUtil.StringToDateYMD(sbirthday), sidcard, new Station(statId, null, 0, null), password);
		int count = staffBiz.updateById(staff);
		if (count == 1) {//修改员工成功
			mv.setViewName("redirect:/staff/selectStaff.do");//重定向员工查询页
		}else{//修改员工失败
			mv.setViewName("redirect:/staff/updateStaff.do");//返回修改页面
		}
		return mv;
	}
	
}
