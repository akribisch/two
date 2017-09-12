package com.web.entity;

import java.util.Date;

/**
 * 流水表实体类
 * @author Administrator
 *
 */
public class Flow {
	/**
	 * 流水表编号
	 */
	private int flowId;
	/**
	 * 储蓄卡
	 */
	private Savings savings;
	/**
	 * 业务类型
	 */
	private Service service;
	/**
	 * 办理员工
	 */
	private Staff staff;
	/**
	 * 办理时间
	 */
	private Date flowDate;
	/**
	 * 金额
	 */
	private double money;
	/**
	 * 提成类型
	 */
	private Commission commission;
	
	public Flow() {
		super();
	}
	
	public Flow(int flowId, Savings savings, Service service, Staff staff, Date flowDate, double money,
			Commission commission) {
		super();
		this.flowId = flowId;
		this.savings = savings;
		this.service = service;
		this.staff = staff;
		this.flowDate = flowDate;
		this.money = money;
		this.commission = commission;
	}
	/**
	 * @return the flowId
	 */
	public int getFlowId() {
		return flowId;
	}
	/**
	 * @param flowId the flowId to set
	 */
	public void setFlowId(int flowId) {
		this.flowId = flowId;
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
	 * @return the flowDate
	 */
	public Date getFlowDate() {
		return flowDate;
	}
	/**
	 * @param flowDate the flowDate to set
	 */
	public void setFlowDate(Date flowDate) {
		this.flowDate = flowDate;
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
	 * @return the commission
	 */
	public Commission getCommission() {
		return commission;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Commission commission) {
		this.commission = commission;
	}
	
}
