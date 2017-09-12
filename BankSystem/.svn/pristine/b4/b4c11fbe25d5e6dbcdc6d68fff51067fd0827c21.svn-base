package com.web.dao;

import java.util.List;

import com.web.entity.Staff;
import com.web.util.Page;

/**
 * 员工表实体类的数据访问层
 * @author java201
 *
 */
public interface StaffDao {
	
	/**
	 * 添加
	 * @param staff
	 * @return
	 */
	public int insert(Staff staff);
	
	/**
	 * 根据主键删除
	 * @param staffId
	 * @return
	 */
	public int deleteById(int staffId);
	
	/**
	 * 根据主键修改
	 * @param staff
	 * @return
	 */
	public int updateById(Staff staff);
	
	/**
	 * 员工登陆
	 * @param staff
	 * @return
	 */
	public Staff login(Staff staff);
	
	/**
	 * 根据主键查询
	 * @param staffId
	 * @return
	 */
	public Staff selectById(int staffId);
	
	/**
	 * 动态分页查询的总条目数
	 * @param page
	 * @return
	 */
	public int selectCount(Page<Staff> page);
	
	/**
	 * 动态分页查询
	 * @param page
	 * @return
	 */
	public List<Staff> select(Page<Staff> page);
}
