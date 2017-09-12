package com.web.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户表实体类
 * @author java201
 *
 */
@Entity
@Table(name="user")
public class User {
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户岗位角色
	 */
	private Station station;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 用户性别
	 */
	private int sex;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 用户状态（正常：0/禁用：1）
	 */
	private int state;
	/**
	 * @return the userId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the station
	 */
	@OneToOne  
	@JoinColumn(name="stationid")
	public Station getStation() {
		return station;
	}
	/**
	 * @param station the station to set
	 */
	public void setStation(Station station) {
		this.station = station;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	public User(int userId, String userName, String password, Station station, String phone, int sex, Date birthday,
			int state) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.station = station;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.state = state;
	}
	
	public User() {
		super();
	}
	
}
