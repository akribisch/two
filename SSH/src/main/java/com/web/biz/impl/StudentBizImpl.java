package com.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.StudentBiz;
import com.web.dao.StudentDao;
import com.web.entity.Student;

@Service //业务逻辑层
public class StudentBizImpl extends CommonBizImpl<Student> implements StudentBiz{

	
	StudentDao studentDao;

	@Resource(name="studentDaoImpl")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		super.setCommonDao(studentDao);
	}
	
	
}
