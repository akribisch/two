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
 * 报修表
 * @author java201
 *
 */
@Entity
@Table(name="feedback")
public class Feedback {

	/**
	 * 报修主键
	 */
	private int feedId;
	
	/**
	 * 报修部门
	 */
	private Department depart;
	
	/**
	 * 报修人员
	 */
	private User user;
	
	/**
	 * 损坏时间
	 */
	private Date repairDate;
	
	/**
	 * 预约时间
	 */
	private Date orderDate;
	
	/**
	 * 设备
	 */
	private Device device;
	
	/**
	 * 问题描述
	 */
	private String question;
	
	/**
	 * 状态
	 */
	private int state;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	@ManyToOne
	@JoinColumn(name="depId")
	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@ManyToOne
	@JoinColumn(name="deviceId")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
