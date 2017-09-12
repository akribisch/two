package com.web.biz.impl;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.OrderInformationBiz;
import com.web.dao.OrderInformationDao;
import com.web.entity.OrderInformation;

@Service
public class OrderInformationBizImpl extends CommonBizImpl<OrderInformation> implements OrderInformationBiz {
	
	
	OrderInformationDao orderInformationDao;
	
	
	@Resource(name="orderInformationDaoImpl")
	public void setOrderInformationDao(OrderInformationDao orderInformationDao){
		
		this.orderInformationDao=orderInformationDao;
		super.setCommonDao(orderInformationDao);
	}
		

}
