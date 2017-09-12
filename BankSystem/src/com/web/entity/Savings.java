package com.web.entity;

/**
 * 储蓄卡表实体类
 * @author Administrator
 *
 */
public class Savings {
	/**
	 * 储蓄卡表编号
	 */
	private int savingsId;
	/**
	 * 卡号
	 */
	private String savingsNum;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 卡内余额
	 */
	private double balance;
	/**
	 * 开户行
	 */
	private Bank bank;
	/**
	 * 办理员工
	 */
	private Staff staff;
	/**
	 * 储蓄卡当前状态
	 */
	private SavState savState;
	/**
	 * 利率
	 */
	private Interest interest;
	
	public Savings() {
		super();
	}
	
	public Savings(int savingsId, String savingsNum, User user, String password, double balance, Bank bank, Staff staff,
			SavState savState, Interest interest) {
		super();
		this.savingsId = savingsId;
		this.savingsNum = savingsNum;
		this.user = user;
		this.password = password;
		this.balance = balance;
		this.bank = bank;
		this.staff = staff;
		this.savState = savState;
		this.interest = interest;
	}
	
	/**
	 * @return the savingsId
	 */
	public int getSavingsId() {
		return savingsId;
	}
	/**
	 * @param savingsId the savingsId to set
	 */
	public void setSavingsId(int savingsId) {
		this.savingsId = savingsId;
	}
	/**
	 * @return the savingsNum
	 */
	public String getSavingsNum() {
		return savingsNum;
	}
	/**
	 * @param savingsNum the savingsNum to set
	 */
	public void setSavingsNum(String savingsNum) {
		this.savingsNum = savingsNum;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
	/**
	 * @return the savState
	 */
	public SavState getSavState() {
		return savState;
	}
	/**
	 * @param savState the savState to set
	 */
	public void setSavState(SavState savState) {
		this.savState = savState;
	}
	/**
	 * @return the interest
	 */
	public Interest getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	
}
