package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 收费记录表实体类
 * @author java201
 *
 */
@Entity
@Table(name="charge")
public class Charge {

	/**
	 * 收费编号
	 */
	private int cwno;
	/**
	 * 车辆信息
	 */
	private Car car;
	/**
	 * 停车时间
	 */
	private long carTime;
	/**
	 * 费用
	 */
	private double moneyPay;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCwno() {
		return cwno;
	}

	public void setCwno(int cwno) {
		this.cwno = cwno;
	}

	

	@ManyToOne
	@JoinColumn(name="carId")
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public long getCarTime() {
		return carTime;
	}

	public void setCarTime(long carTime) {
		this.carTime = carTime;
	}

	public double getMoneyPay() {
		return moneyPay;
	}

	public void setMoneyPay(double moneyPay) {
		this.moneyPay = moneyPay;
	}



	public Charge(int cwno,Car car, long carTime, double moneyPay) {
		super();
		this.cwno = cwno;
		this.car = car;
		this.carTime = carTime;
		this.moneyPay = moneyPay;
	}

	public Charge() {
		super();
	}
	
	
}
