package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.BankMenu;

public interface BankMenuDao {

	/**
	 * 查找父级菜单
	 * @param parentId
	 * @return
	 */
	public List<BankMenu> findParent(Integer parentId);
	
	/**
	 * 通过岗位id来查找对应的menuid
	 * @param statid
	 * @return
	 */
	public List<Integer> findMenu(Integer statid);
	
	/**
	 * 给岗位添加权限
	 * @param statid
	 * @return
	 */
	public int insertMenu(Map<String, Object> map);
	
	/**
	 * 清空岗位权限
	 * @param statid
	 * @return
	 */
	public int deleteMenu(Integer statid);
	
	/**
	 * 添加菜单
	 * @param bankMenu
	 * @return
	 */
	public int insertBankMenu(BankMenu bankMenu);
}
