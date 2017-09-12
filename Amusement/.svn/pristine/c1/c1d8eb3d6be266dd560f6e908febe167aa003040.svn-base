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

/**
 * 薪酬工资表实体类
 * @author java201
 *
 */
@Entity
@Table(name="salary")
public class Salary {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 用户角色
	 */
	private User user;
	/**
	 * 早退、迟到次数
	 */
	private int unnormal;
	/**
	 * 出勤次数
	 */
	private int normal;
	/**
	 * 总的工资
	 */
	private double monthMoney;
	/**
	 * 当月的时间
	 */
	private Date month;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne  
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUnnormal() {
		return unnormal;
	}
	public void setUnnormal(int unnormal) {
		this.unnormal = unnormal;
	}
	public int getNormal() {
		return normal;
	}
	public void setNormal(int normal) {
		this.normal = normal;
	}
	public double getMonthMoney() {
		return monthMoney;
	}
	public void setMonthMoney(double monthMoney) {
		this.monthMoney = monthMoney;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public Salary(int id, User user, int unnormal,int normal, double monthMoney, Date month) {
		super();
		this.id = id;
		this.user = user;
		this.normal = normal;
		this.monthMoney = monthMoney;
		this.month = month;
	}
	public Salary() {
		super();
	}
}
