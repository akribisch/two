package com.web.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Vip")
public class Vip {
	/**
	 * 卡编号
	 */
	private int vId;
	
	/**
	 * 卡号
	 */
	private String vNo;
	
	/**
	 * 发卡日期
	 */
	private Date vDate;
	/**
	 * 到期时间
	 */
	private Date overDate;
	/**
	 * 剩余次数
	 */
	private int vCount;
	/**
	 * 总次数
	 */
	private int vWholenumber;
	/**
	 * 卡级别
	 */
	private double remaining;
	private VipLevel vipLevel;
	/**
	 * 用户信息
	 */
	private User user;

	public String getvNo() {
		return vNo;
	}
	public void setvNo(String vNo) {
		this.vNo = vNo;
	}
	
	
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	public int getvCount() {
		return vCount;
	}
	public void setvCount(int vCount) {
		this.vCount = vCount;
	}
	public int getvWholenumber() {
		return vWholenumber;
	}
	public void setvWholenumber(int vWholenumber) {
		this.vWholenumber = vWholenumber;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	@ManyToOne
	@JoinColumn(name="levelId")
	public VipLevel getVipLevel() {
		return vipLevel;
	}
	
	public void setVipLevel(VipLevel vipLevel) {
		this.vipLevel = vipLevel;
	}
	@OneToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getOverDate() {
		return overDate;
	}
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	public double getRemaining() {
		return remaining;
	}
	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}
	
}
