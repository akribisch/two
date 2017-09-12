package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单表实体类
 * @author java201
 *
 */
@Entity
@Table(name="menu")
public class Menu implements Comparable<Menu>{
	/**
	 * 菜单编号
	 */
	private int menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 父级菜单编号
	 */
	private int parentInt;
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	
	/**
	 * @return the menuId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the parentInt
	 */
	public int getParentInt() {
		return parentInt;
	}
	/**
	 * @param parentInt the parentInt to set
	 */
	public void setParentInt(int parentInt) {
		this.parentInt = parentInt;
	}
	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}
	/**
	 * @param menuUrl the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public Menu(int menuId, String menuName, int parentInt, String menuUrl) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.parentInt = parentInt;
		this.menuUrl = menuUrl;
	}
	
	public Menu() {
		super();
	}
	
	@Override
	public int compareTo(Menu m) {
		int i = this.menuId - m.menuId;
		return i;
	}
	
}
