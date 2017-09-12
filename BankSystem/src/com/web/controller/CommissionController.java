package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.web.biz.impl.CommissionBizImpl;
import com.web.entity.Commission;
import com.web.util.Page;

/**
 * 提成表控制器
 * @author java201
 *
 */
@Controller
@RequestMapping(value="Commission/")
public class CommissionController {

	@Resource(name="commissionBizImpl")
	CommissionBizImpl commissionbizimpl;
	
	/**
	 * 查询全部提成
	 * url:http://localhost:8080/BankSystem/Commission/showCommission.do
	 * @param mv
	 * @return
	 */
	@RequestMapping(path="showCommission")
	public ModelAndView select(ModelAndView mv,Integer page,Integer commissionId ){
		//查询提成类型
		Commission com = new Commission();
		com.setCommissionId(commissionId != null ? commissionId : 0);
		
		//决定跳转的页数
		Page<Commission> pg = new Page<>();
		pg.setCurrentPage(page != null ? page : 1);
		pg.setObj(com);
		int totalPage = commissionbizimpl.selectCount(pg);
		pg.setTotalRecord(totalPage);
		
		List<Commission> list1 = commissionbizimpl.select(pg);
		
		pg.setList(list1);
		mv.addObject("Pageing", pg);
		mv.setViewName("showCommission");
		return mv;
	}
	
	/**
	 * 添加提成信息
	 * url:http://localhost:8080/BankSystem/Commission/insertCommission.jsp
	 * @return
	 */
	@RequestMapping(path="insertCommission")
	public ModelAndView insert(ModelAndView mv,Commission commission){
		int count = commissionbizimpl.insertCommission(commission);
		if(count == 1){
			//redirect:
			mv.setViewName("redirect:/Commission/showCommission.do");
		}else{
			mv.setViewName("loser");
		}
		return mv;
	}
	
	/**
	 * 修改提成信息
	 * url:http://localhost:8080/BankSystem/Commission/updateCommission.jsp
	 * @return
	 */
	@RequestMapping(path="updateCommission")
	public ModelAndView update(ModelAndView mv,Commission commission){
		int count = commissionbizimpl.updateCommissionById(commission);
		if(count == 1){
			mv.setViewName("redirect:/Commission/showCommission.do");
		}else{
			mv.setViewName("loser");
		}
		return mv;
	}
	
	/**
	 * 删除提成信息
	 * url:http://localhost:8080/BankSystem/Commission/deleteService.jsp
	 * @return
	 */
	@RequestMapping(path="deleteService")
	public ModelAndView dalete(ModelAndView mv,Integer CommissionID){
		int count = commissionbizimpl.deleteById(CommissionID);
		if(count == 1){
			mv.setViewName("redirect:/Commission/showCommission.do");
		}else{
			mv.setViewName("loser");
		}
		return mv;
	}
}
