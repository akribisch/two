package com.web.entity;

/**
 * 部门表实体类
 * @author Administrator
 *
 */
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
	 * 部门职能
	 */
	private String depFunc;
	/**
	 * 所属银行
	 */
	private Bank bank;
	
	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Department() {
		super();
	}
	
	public Department(int depId, String depName, int depNum, String depFunc,Bank bank) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depNum = depNum;
		this.depFunc = depFunc;
		this.bank = bank;
	}
	
	/**
	 * @return the depId
	 */
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
	/**
	 * @return the depFunc
	 */
	public String getDepFunc() {
		return depFunc;
	}
	/**
	 * @param depFunc the depFunc to set
	 */
	public void setDepFunc(String depFunc) {
		this.depFunc = depFunc;
	}
	
}
