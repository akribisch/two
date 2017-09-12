package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 游客
 * @author java201
 *
 */

@Entity
@Table(name="tourist")
public class Tourist {

	/**
	 * 游客主键
	 */
	private int touId;
	
	/**
	 * 游客账户
	 */
	private String tourCount;
	
	/**
	 * 游客名称
	 */
	private String tourName;
	
	/**
	 * 游客性别
	 */
	private int tourSex;
	
	/**
	 * 游客电话
	 */
	private String tourPhone;
	
	/**
	 * 游客电子邮箱
	 */
	private String tourEmail;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTouId() {
		return touId;
	}

	public void setTouId(int touId) {
		this.touId = touId;
	}

	public String getTourCount() {
		return tourCount;
	}

	public void setTourCount(String tourCount) {
		this.tourCount = tourCount;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public int getTourSex() {
		return tourSex;
	}

	public void setTourSex(int tourSex) {
		this.tourSex = tourSex;
	}

	public String getTourPhone() {
		return tourPhone;
	}

	public void setTourPhone(String tourPhone) {
		this.tourPhone = tourPhone;
	}

	public String getTourEmail() {
		return tourEmail;
	}

	public void setTourEmail(String tourEmail) {
		this.tourEmail = tourEmail;
	}

	public Tourist(int touId, String tourCount, String tourName, int tourSex, String tourPhone, String tourEmail) {
		super();
		this.touId = touId;
		this.tourCount = tourCount;
		this.tourName = tourName;
		this.tourSex = tourSex;
		this.tourPhone = tourPhone;
		this.tourEmail = tourEmail;
	}

	public Tourist() {
		super();
	}
	
}
