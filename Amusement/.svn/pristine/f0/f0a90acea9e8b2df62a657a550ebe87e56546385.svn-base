package com.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户岗位角色表实体类
 * @author java201
 *
 */
@Entity
@Table(name="station")
public class Station {
	/**
	 * 岗位角色编号
	 */
	private int statId;
	/**
	 * 岗位角色名称
	 */
	private String statName;
	/**
	 * 岗位角色人数
	 */
	private int statNum;
	/**
	 * 岗位底薪
	 */
	private double money;
	/**
	 * 岗位所属部门
	 */
	private Department department;
	/**
	 * 岗位权限所能操作的菜单集合
	 */
	private Set<Menu> menus;
	
	/**
	 * @return the menu
	 */
	//多对多   targetEntity:该实体类相关联的实体类
	//@JoinTable：中间表   joinColumns:该实体类的主键在中间表中的外键
	//inverseJoinColumns：该实体类相关联的实体类的主键在中间表中的外键
	@ManyToMany(targetEntity=com.web.entity.Menu.class)
	@JoinTable(name="station_menu",joinColumns={@JoinColumn(name="sid")},
	   inverseJoinColumns={@JoinColumn(name="mid")})
	public Set<Menu> getMenus() {
		return menus;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	/**
	 * @return the statId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStatId() {
		return statId;
	}
	/**
	 * @param statId the statId to set
	 */
	public void setStatId(int statId) {
		this.statId = statId;
	}
	/**
	 * @return the statName
	 */
	public String getStatName() {
		return statName;
	}
	/**
	 * @param statName the statName to set
	 */
	public void setStatName(String statName) {
		this.statName = statName;
	}
	/**
	 * @return the statNum
	 */
	public int getStatNum() {
		return statNum;
	}
	/**
	 * @param statNum the statNum to set
	 */
	public void setStatNum(int statNum) {
		this.statNum = statNum;
	}
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	/**
	 * @return the department
	 */
	@OneToOne  
	@JoinColumn(name="departmentid")
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Station(int statId, String statName, int statNum, double money, Department department,Set<Menu> menus) {
		super();
		this.statId = statId;
		this.statName = statName;
		this.statNum = statNum;
		this.money = money;
		this.department = department;
		this.menus = menus;
	}
	
	public Station() {
		super();
	}
	
}
