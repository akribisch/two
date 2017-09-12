package com.web.entity;

import java.util.Date;

/**
 * 员工表实体类
 * @author Administrator
 *
 */
public class Staff {
	/**
	 * 员工编号
	 */
	private int staffId;
	/**
	 * 员工名称
	 */
	private String staffName;
	/**
	 * 员工电话
	 */
	private String sPhone;
	/**
	 * 员工性别
	 */
	private int ssex;
	/**
	 * 员工出生日期
	 */
	private Date sbirthday;
	/**
	 * 员工身份证号
	 */
	private String sidcard;
	/**
	 * 员工所在岗位
	 */
	private Station station;
	/**
	 * 登录密码
	 */
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public int getSsex() {
		return ssex;
	}
	public void setSsex(int ssex) {
		this.ssex = ssex;
	}
	public Date getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	public String getSidcard() {
		return sidcard;
	}
	public void setSidcard(String sidcard) {
		this.sidcard = sidcard;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Staff(int staffId, String staffName, String sPhone, int ssex, Date sbirthday, String sidcard,Station station,String password) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.sPhone = sPhone;
		this.ssex = ssex;
		this.sbirthday = sbirthday;
		this.sidcard = sidcard;
		this.station = station;
		this.password = password;
	}
	public Staff() {
		super();
	}
	
}