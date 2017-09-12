package com.web.entity;

import java.sql.Date;

/**
 * 用户表实体类
 * @author Administrator
 *
 */
public class User {
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String uphone;
	/**
	 * 身份证
	 */
	private String uidcard;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 出生日期
	 */
	private Date birthday;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUidcard() {
		return uidcard;
	}
	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User() {
		super();
	}
	public User(int userId, String username, String uphone, String uidcard, int sex, Date birthday) {
		super();
		this.userId = userId;
		this.username = username;
		this.uphone = uphone;
		this.uidcard = uidcard;
		this.sex = sex;
		this.birthday = birthday;
	}
	
}