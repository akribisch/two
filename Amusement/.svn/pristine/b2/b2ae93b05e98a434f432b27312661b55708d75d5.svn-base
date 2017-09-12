package com.web.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户考勤管理类
 * @author java201
 *
 */
@Entity
@Table(name="attendance")
public class Attendance {
	/**
	 * 主键
	 */
	private int aid;
	/**
	 * 用户名
	 */
	private User user;
	/**
	 * 上班打卡时间
	 */
	private Date beginTime;
	/**
	 * 开始状态
	 */
	private String beginState;
	/**
	 * 下班打卡时间
	 */
	private Date endTime;
	/**
	 * 结束状态
	 */
	private String endState;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public String getBeginState() {
		return beginState;
	}
	public void setBeginState(String beginState) {
		this.beginState = beginState;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getEndState() {
		return endState;
	}
	public void setEndState(String endState) {
		this.endState = endState;
	}
	public Attendance(int aid, User user, Date beginTime, String beginState, Date endTime, String endState) {
		super();
		this.aid = aid;
		this.user = user;
		this.beginTime = beginTime;
		this.beginState = beginState;
		this.endTime = endTime;
		this.endState = endState;
	}
	public Attendance() {
		super();
	}
	public String getTimeToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(date);
		return time;
	}
	
}
