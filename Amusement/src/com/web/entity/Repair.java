package com.web.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 设备维修
 * @author java201
 *
 */
@Entity
@Table(name="repair")
public class Repair {

	/**
	 * 设备维修主键
	 */
	private int repairId;
	
	/**
	 * 设备
	 */
	private Device device;
	
	/**
	 * 维修人员
	 */
	private String repairPeople;
	
	/**
	 * 维修时间
	 */
	private Date beginDate;
	
	/**
	 * 维修价格
	 */
	private double repairPrice;
	
	/**
	 * 备注
	 */
	private String remark;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	@ManyToOne
	@JoinColumn(name="deviceId")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getRepairPeople() {
		return repairPeople;
	}

	public void setRepairPeople(String repairPeople) {
		this.repairPeople = repairPeople;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public double getRepairPrice() {
		return repairPrice;
	}

	public void setRepairPrice(double repairPrice) {
		this.repairPrice = repairPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Repair(int repairId, Device device, String repairPeople, Date beginDate, double repairPrice, String remark) {
		super();
		this.repairId = repairId;
		this.device = device;
		this.repairPeople = repairPeople;
		this.beginDate = beginDate;
		this.repairPrice = repairPrice;
		this.remark = remark;
	}

	public Repair() {
		super();
	}
	
}
