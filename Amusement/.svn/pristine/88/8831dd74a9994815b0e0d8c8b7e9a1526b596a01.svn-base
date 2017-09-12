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
 * 设备调拨
 * @author java201
 *
 */
@Entity
@Table(name="transtion")
public class Transtion {

	/**
	 * 调拨主键
	 */
	private int transId;
	
	/**
	 * 设备
	 */
	private Device device;
	
	/**
	 * 部门
	 */
	private Department depart;
	
	/**
	 * 使用人员
	 */
	private String usePeople;
	
	/**
	 * 调拨时间
	 */
	private Date beginDate;
	
	/**
	 * 使用几个月
	 */
	private int useOfMonth;
	
	/**
	 * 备注
	 */
	private String remark;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	@ManyToOne
	@JoinColumn(name="deviceId")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@ManyToOne
	@JoinColumn(name="departmentId")
	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public String getUsePeople() {
		return usePeople;
	}

	public void setUsePeople(String usePeople) {
		this.usePeople = usePeople;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public int getUseOfMonth() {
		return useOfMonth;
	}

	public void setUseOfMonth(int useOfMonth) {
		this.useOfMonth = useOfMonth;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Transtion(int transId, Device device, Department depart, String usePeople, Date beginDate, int useOfMonth,
			String remark) {
		super();
		this.transId = transId;
		this.device = device;
		this.depart = depart;
		this.usePeople = usePeople;
		this.beginDate = beginDate;
		this.useOfMonth = useOfMonth;
		this.remark = remark;
	}

	public Transtion() {
		super();
	}
	
}
