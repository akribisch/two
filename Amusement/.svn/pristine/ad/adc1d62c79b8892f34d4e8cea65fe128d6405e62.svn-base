package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 假期优惠活动表
 * @author orange
 *
 */
@Entity
@Table(name="vacation")
public class Vacation {
	/**
	 * 活动编号
	 */
	private int vacationId;
	/**
	 * 活动名称
	 */
	private String activeName;
	/**
	 * 活动项目
	 */
	private Recreation recreation;
	/**
	 * 折扣
	 */
	private double discount;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getVacationId() {
		return vacationId;
	}
	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}
	public String getActiveName() {
		return activeName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}
	@OneToOne
	@JoinColumn(name="rno")
	public Recreation getRecreation() {
		return recreation;
	}
	public void setRecreation(Recreation recreation) {
		this.recreation = recreation;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
