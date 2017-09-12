package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VipLevel")
public class VipLevel {
	/**
	 * 卡级别编号
	 */
	private int levelId;
	/**
	 * 卡级别
	 */
	private String level;
	/**
	 * 卡的总价
	 */
	private double cPrice;
	/**
	 * 有效时间
	 */
	private int validDate;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getcPrice() {
		return cPrice;
	}
	public void setcPrice(double cPrice) {
		this.cPrice = cPrice;
	}
	public int getValidDate() {
		return validDate;
	}
	public void setValidDate(int validDate) {
		this.validDate = validDate;
	}
	
	
}
