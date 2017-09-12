package com.web.biz.impl;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.VacationBiz;
import com.web.dao.VacationDao;
import com.web.entity.Vacation;

@Service
public class VacationBizImpl extends CommonBizImpl<Vacation> implements VacationBiz {
	VacationDao vacationDao;
	
	@Resource(name="vacationDaoImpl")
	public void setVacationDao(VacationDao vacationDao) {
		this.vacationDao = vacationDao;
		super.commonDao=vacationDao;
	}
	
	
	

}
