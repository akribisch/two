package com.web.entity;

/**
 * 提成表实体类
 * @author Administrator
 *
 */
public class Commission {
	/**
	 * 提成表编号
	 */
	private int commissionId;
	/**
	 * 提成类型
	 */
	private String commissionType;
	/**
	 * 提成率
	 */
	private double commissionRate;
	
	public Commission() {
		super();
	}
	public Commission(int commissionId, String commissionType, double commissionRate) {
		super();
		this.commissionId = commissionId;
		this.commissionType = commissionType;
		this.commissionRate = commissionRate;
	}
	public int getCommissionId() {
		return commissionId;
	}
	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}
	public String getCommissionType() {
		return commissionType;
	}
	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	
	
}
