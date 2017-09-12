package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门表实体类
 * @author java201
 *
 */
@Entity
@Table(name="department")
public class Department {
	/**
	 * 部门编号
	 */
	private int depId;
	/**
	 * 部门名称
	 */
	private String depName;
	/**
	 * 部门人数
	 */
	private int depNum;
	/**
	 * @return the depId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDepId() {
		return depId;
	}
	/**
	 * @param depId the depId to set
	 */
	public void setDepId(int depId) {
		this.depId = depId;
	}
	/**
	 * @return the depName
	 */
	public String getDepName() {
		return depName;
	}
	/**
	 * @param depName the depName to set
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}
	/**
	 * @return the depNum
	 */
	public int getDepNum() {
		return depNum;
	}
	/**
	 * @param depNum the depNum to set
	 */
	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}
	
	public Department(int depId, String depName, int depNum) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depNum = depNum;
	}
	
	public Department() {
		super();
	}
	
}
