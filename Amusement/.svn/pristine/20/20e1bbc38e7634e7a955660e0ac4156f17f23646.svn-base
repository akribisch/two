package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 车位信息表实体类
 * @author java201
 *
 */
@Entity
@Table(name="parking")
public class Parking {

	/**
	 * 车位编号
	 */
	private int cwno;
	/**
	 * 车位状态（0有车 / 1空闲）
	 */
	private int cwType;
	
	/**
	 * 车辆信息 
	 */
	private Car car;
	
	/**
	 * 车位当前金额
	 */
	private double carMon;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCwno() {
		return cwno;
	}
	public void setCwno(int cwno) {
		this.cwno = cwno;
	}
	
	public int getCwType() {
		return cwType;
	}
	public void setCwType(int cwType) {
		this.cwType = cwType;
	}
	@ManyToOne
	@JoinColumn(name="carId")
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	

	public double getCarMon() {
		return carMon;
	}
	public void setCarMon(double carMon) {
		this.carMon = carMon;
	}
	public Parking(int cwno, int cwType, Car car, double carMon) {
		super();
		this.cwno = cwno;
		this.cwType = cwType;
		this.car = car;
		this.carMon = carMon;
	}
	public Parking() {
		super();
	}
	
}
