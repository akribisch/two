package com.web.biz;

import java.util.List;

import com.web.entity.Department;
import com.web.util.Page;

/**
 * 部门表实体类的业务逻辑层实现类
 * @author java201
 *
 */
public interface DepartmentBiz {
	
	/**
	 * 动态分页查询
	 * @param page
	 * @return
	 */
	public List<Department> select(Page<Department> page);
	
	/**
	 * 动态分页查询的总条目数
	 * @param page
	 * @return
	 */
	public int selectCount(Page<Department> page);
	
	/**
	 * 根据主键查询
	 * @param depId
	 * @return
	 */
	public Department selectById(int depId);
	
	/**
	 * 添加
	 * @param department
	 * @return
	 */
	public int insert(Department department);
	
	/**
	 * 删除
	 * @param depId
	 * @return
	 */
	public int deleteById(int depId);
	
	/**
	 * 修改
	 * @param department
	 * @return
	 */
	public int updateById(Department department);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Department> selectAll();
}
