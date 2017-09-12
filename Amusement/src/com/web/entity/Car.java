package com.web.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 车辆信息实体类
 * @author java201
 *
 */
@Entity
@Table(name="t_car")
public class Car {

	/**
	 * 车辆id
	 */
	private int carId;
	
	/**
	 * 车牌号
	 */
	private String plateNumber;
	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 在位情况（0：在位/1：离开）
	 */
	private Integer carAt;
	/**
	 * 进入时间
	 */
	private Date carIn;
	/**
	 * 离开时间
	 */
	private Date carOut;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public Integer getCarAt() {
		return carAt;
	}

	public void setCarAt(Integer carAt) {
		this.carAt = carAt;
	}

	public Date getCarIn() {
		return carIn;
	}

	public void setCarIn(Date carIn) {
		this.carIn = carIn;
	}

	public Date getCarOut() {
		return carOut;
	}

	public void setCarOut(Date carOut) {
		this.carOut = carOut;
	}
	
	public Car(int carId, String plateNumber, String color, Integer carAt, Date carIn, Date carOut) {
		super();
		this.carId = carId;
		this.plateNumber = plateNumber;
		this.color = color;
		this.carAt = carAt;
		this.carIn = carIn;
		this.carOut = carOut;
	}

	public Car() {
		super();
	}
	
	
}
