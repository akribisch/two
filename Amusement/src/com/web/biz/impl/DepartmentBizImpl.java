package com.web.biz.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.web.biz.DepartmentBiz;
import com.web.dao.DepartmentDao;
import com.web.entity.Department;

@Service
public class DepartmentBizImpl extends CommonBizImpl<Department> implements DepartmentBiz {

	DepartmentDao departmentDao;
	
	@Resource(name="departmentDaoImpl")
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
		super.setCommonDao(departmentDao);
	}

}
