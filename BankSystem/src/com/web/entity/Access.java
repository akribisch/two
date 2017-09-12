package com.web.entity;

import java.util.Date;

/**
 * 存取款表实体类
 * @author Administrator
 *
 */
public class Access {
	/**
	 * 存取款表编号
	 */
	private int accessId;
	/**
	 * 储蓄卡
	 */
	private Savings savings;
	/**
	 * 业务类型
	 */
	private Service service;
	/**
	 * 存取款金额
	 */
	private double money;
	/**
	 * 存取款时间
	 */
	private Date currentTime;
	/**
	 * 办理银行
	 */
	private Bank bank;
	/**
	 * 办理员工
	 */
	private Staff staff;
	
	public Access() {
		super();
	}
	
	public Access(int accessId, Savings savings, Service service, double money, Date currentTime, Bank bank,
			Staff staff) {
		super();
		this.accessId = accessId;
		this.savings = savings;
		this.service = service;
		this.money = money;
		this.currentTime = currentTime;
		this.bank = bank;
		this.staff = staff;
	}
	
	/**
	 * @return the accessId
	 */
	public int getAccessId() {
		return accessId;
	}
	/**
	 * @param accessId the accessId to set
	 */
	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}
	/**
	 * @return the savings
	 */
	public Savings getSavings() {
		return savings;
	}
	/**
	 * @param savings the savings to set
	 */
	public void setSavings(Savings savings) {
		this.savings = savings;
	}
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
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
	 * @return the currentTime
	 */
	public Date getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
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
	/**
	 * @return the staff
	 */
	public Staff getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
