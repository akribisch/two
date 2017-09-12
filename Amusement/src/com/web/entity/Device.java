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
 * 设备
 * @author java201
 *
 */
@Entity
@Table(name="device")
public class Device {

	/**
	 * 设备主键
	 */
	private int deviceId;
	
	/**
	 * 设备型号
	 */
	private String deviceTypeId;
	
	/**
	 * 设备名称
	 */
	private String deviceName;
	
	/**
	 * 设备类型
	 */
	private Type type;
	
	/**
	 * 设备状态
	 */
	private String deviceState;
	
	/**
	 * 设备价格
	 */
	private double price;
	
	/**
	 * 购买日期
	 */
	private Date buyDate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	@ManyToOne
	@JoinColumn(name="typeId")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Device() {
		super();
	}
	
}
