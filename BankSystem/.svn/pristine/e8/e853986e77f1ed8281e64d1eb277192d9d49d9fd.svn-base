package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.StaffBiz;
import com.web.dao.StaffDao;
import com.web.entity.Staff;
import com.web.util.Page;

/**
 * 员工表实体类的业务逻辑层
 * @author java201
 *
 */
@Service
public class StaffBizImpl implements StaffBiz {
	@Resource
	StaffDao staffdao;
	
	@Override
	public int insert(Staff staff) {
		return staffdao.insert(staff);
	}

	@Override
	public int deleteById(int staffId) {
		return staffdao.deleteById(staffId);
	}

	@Override
	public int updateById(Staff staff) {
		return staffdao.updateById(staff);
	}

	@Override
	public Staff login(Staff staff) {
		return staffdao.login(staff);
	}

	@Override
	public int selectCount(Page<Staff> page) {
		return staffdao.selectCount(page);
	}

	@Override
	public List<Staff> select(Page<Staff> page) {
		return staffdao.select(page);
	}

	@Override
	public Staff selectById(int staffId) {
		return staffdao.selectById(staffId);
	}

}
