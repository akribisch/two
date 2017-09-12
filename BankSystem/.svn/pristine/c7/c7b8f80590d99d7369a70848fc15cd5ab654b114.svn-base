package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.DepartmentBiz;
import com.web.dao.DepartmentDao;
import com.web.entity.Department;
import com.web.util.Page;

/**
 * 部门表实体类的业务逻辑层实现类
 * @author java2depDao.1
 *
 */
@Service
public class DepartmentBizImpl implements DepartmentBiz {
	@Resource
	DepartmentDao depDao;

	@Override
	public List<Department> select(Page<Department> page) {
		return depDao.select(page);
	}

	@Override
	public int selectCount(Page<Department> page) {
		return depDao.selectCount(page);
	}

	@Override
	public Department selectById(int depId) {
		return depDao.selectById(depId);
	}

	@Override
	public int insert(Department department) {
		return depDao.insert(department);
	}

	@Override
	public int deleteById(int depId) {
		return depDao.deleteById(depId);
	}

	@Override
	public int updateById(Department department) {
		return depDao.updateById(department);
	}

	@Override
	public List<Department> selectAll() {
		return depDao.selectAll();
	}
	
}
