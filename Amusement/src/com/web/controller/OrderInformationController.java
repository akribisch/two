package com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.OrderInformationBiz;
import com.web.biz.RecreationBiz;
import com.web.biz.RepairBiz;
import com.web.biz.TouristBiz;
import com.web.biz.VipBiz;
import com.web.entity.OrderInformation;
import com.web.entity.Recreation;
import com.web.entity.Tourist;
import com.web.entity.Vip;
import com.web.util.Page;
import com.web.util.StringUtil;


@Controller
@RequestMapping(value="OrderInformation")
public class OrderInformationController {
	
	@Resource(name="orderInformationBizImpl")
	OrderInformationBiz orderInformationImpl;
	
	@Resource(name="vipBizImpl")
	VipBiz vipBizImpl;
	
	
	
	@Resource(name="touristBizImpl")
	TouristBiz touristBizImpl;
	
	@Resource(name="recreationBizImpl")
	RecreationBiz recreationBiz;
	
	
	/**
	 * 查询娱乐项目到订单页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="sendAddOrder")
	public ModelAndView sendAddOrder(ModelAndView mv){
		List<Recreation> list=recreationBiz.queryAll();
		mv.addObject("list",list);
		mv.setViewName("addOrder");
		return mv;
	}//localhost:8080/Amusement/OrderInformation/sendAddOrder.do
	/**
	 * 添加订单
	 * @param mv
	 * @param tourName
	 * @param tourSex
	 * @param tourPhone
	 * @param tourEmail
	 * @param vNo
	 * @param recreationId
	 * @return
	 */
	@RequestMapping(value="addOrderInformation")
	public ModelAndView addOrderInformation(ModelAndView mv,String tourName,Integer tourSex,String tourPhone,String tourEmail,String vNo,Integer recreationId){
		List<Vip> vip=vipBizImpl.findBycondition(vNo);
		if(vip.size()!=0){//vip卡存在才能订票
			Tourist tourist=new Tourist();
			
			tourist.setTourName(tourName);
			tourist.setTourSex(tourSex);
			tourist.setTourPhone(tourPhone);
			tourist.setTourEmail(tourEmail);
			List<Tourist> result3=touristBizImpl.findBycondition(tourPhone);
			boolean result1=true;
			if(result3.size()==0){
				
				 result1=touristBizImpl.add(tourist);//根据手机号码查询，如果游客信息已存在就不添加游客信息
			}else{
				tourist.setTouId(result3.get(0).getTouId());
			}
			
			
			
			
			Vip vip1=new Vip();
			vip1.setvId(vip.get(0).getvId());
			
			Recreation recreation=new Recreation();
			
			recreation.setRno(recreationId);
			
			OrderInformation order=new OrderInformation();
			
			order.setRecreation(recreation);
			order.setTourist(tourist);
			order.setVip(vip1);
			order.setOrderDate(new Date());
			if(result1){//游客信息已存在就添加订票信息
				boolean result2=orderInformationImpl.add(order);
				
				
				if(result2){
					Recreation re=recreationBiz.findById(Recreation.class,recreationId);//订单生产后要修改vip卡的余额;
					double remaining=vip.get(0).getRemaining()-re.getRpice();
					Vip vip2=vip.get(0);
					vip2.setRemaining(remaining);
					vipBizImpl.update(vip2);
					mv.setViewName("queryOrder");
				}
			}
											
		}
		
		
		
		return mv;
	}//localhost:8080/OrderInformation/addOrderInformation.do

	/**
	 * 查询订单
	 * @param mv
	 * @param page
	 * @param tourName
	 * @param tourPhone
	 * @param vNo
	 * @return
	 */
	@RequestMapping(value="queryOrder")
	public ModelAndView queryOrder(ModelAndView mv,Integer page,String tourName,String tourPhone,String vNo){
		Page<OrderInformation> pageUtil=new Page<>();//创建分页查询工具对象
		
		if(page!=null){
			pageUtil.setCurrentPage(page);
		}//设置当前页
		
		Map<String, Object> map=new HashMap<>();//创建组装参数集合
		
		if(!StringUtil.isEmpty(tourName)){
			map.put("tourName",tourName);
		}//向集合中添加游客参数
		if(!StringUtil.isEmpty(tourPhone)){
			map.put("tourPhone",tourPhone);
		}//向集合中添加电话参数
		if(!StringUtil.isEmpty(vNo)){
			map.put("vNo",vNo);
		}//向集合中添加娱乐项目编号参数
		
		
		int prev=(pageUtil.getCurrentPage()-1)*pageUtil.getPageSize();//计算limit排除的总页数
				
		map.put("prev", prev);//添加排除总页数参数
		
		map.put("pageSize", pageUtil.getPageSize());//添加每页显示记录条数的参数
					
		orderInformationImpl.queryPaging(pageUtil, map);
		
		String nav=pageUtil.getNav();
		
		mv.addObject("nav",nav);
		mv.addObject("map",map);
		mv.addObject("pageUtil", pageUtil);
		
		mv.setViewName("queryOrder");
		return mv;//localhost:8080/Amusement/OrderInformation/queryOrder.do
		
		
	}
	@RequestMapping(value="deleteOrder")
	public ModelAndView deleteOrder(ModelAndView mv,OrderInformation order){
		
		boolean result=orderInformationImpl.delete(order);
		if(result){
			mv.setViewName("redirect:/OrderInformation/queryOrder.do");
		}
		return mv;
	}
}
