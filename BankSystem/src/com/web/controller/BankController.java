package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.BankBiz;
import com.web.entity.Bank;
import com.web.util.Page;

/**
 * 银行表实体类的控制层
 * URL:http://localhost:8080/BankSystem/bank/
 * @author java201
 *
 */
@Controller
@RequestMapping(value="bank/")
public class BankController {
	@Resource(name="bankBizImpl")
	BankBiz bankBiz;
	
	/**
	 * 动态分页查询
	 * URL:http://localhost:8080/BankSystem/bank/selectBank.do
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(path="selectBank")
	public ModelAndView select(ModelAndView mv,Integer page){
		Page<Bank> pg = new Page<>();
		pg.setCurrentPage(page != null ? page : 1);
		
		int totalPage = bankBiz.selectCount();
		pg.setTotalRecord(totalPage);
		
		List<Bank> list = bankBiz.select(pg);
		pg.setList(list);
		
		mv.addObject("Paging",pg);
		mv.setViewName("selectBank");
		return mv;
	}
	
	/**
	 * 添加
	 * URL:http://localhost:8080/BankSystem/bank/sendAddBank.do
	 * @param mv
	 * @param bankName
	 * @return
	 */
	@RequestMapping(path="sendAddBank")
	public ModelAndView addBank(ModelAndView mv,String bankName){
		Bank bank = new Bank(0, bankName);
		
		int count = bankBiz.insert(bank);//添加操作
		if (count == 1) {//添加成功
			mv.setViewName("redirect:selectBank.do");
		}else {//添加失败
			mv.setViewName("addBank");
		}
		return mv;
	}
	
	/**
	 * 根据主键查询要修改的对象，返回到修改页面
	 * @param mv
	 * @param bankId
	 * @return
	 */
	@RequestMapping(path="updateBank")
	public ModelAndView updateBank(ModelAndView mv,Integer bankId){
		Bank bank = bankBiz.selectById(bankId);//查询要修改的对象
		mv.addObject("bank",bank);
		mv.setViewName("updateBank");
		return mv;
	}
	
	/**
	 * 提交修改的对象
	 * @param mv
	 * @param bankId
	 * @param bankName
	 * @return
	 */
	@RequestMapping(path="sendUpdateBank")
	public ModelAndView sendUpdateBank(ModelAndView mv,Integer bankId,String bankName){
		Bank bank = new Bank(bankId, bankName);
		int count = bankBiz.updateById(bank);
		if (count == 1) {
			mv.setViewName("redirect:selectBank.do");
		}else {
			mv.setViewName("updateBank");
		}
		return mv;
	}
	
}
