package com.web.biz;

import java.util.Map;

import com.web.entity.Salary;

public interface SalaryBiz extends CommonBiz<Salary> {
	/**
	 * 根据用户名和时间修改
	 * @param salary
	 * @return
	 */
	public int updateSalary(Salary salary);
	/**
	 * 根据时间和用户名查找
	 * @param salary
	 * @return
	 */
	public Salary findByUser(Map<String,Object> map);
	/**
	 * 查询条数
	 * @return
	 */
	public int queryCount(Map<String,Object> map);
}
