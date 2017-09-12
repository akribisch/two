
package com.web.entity;

/**
 * 业务类型表实体类
 * @author Administrator
 *
 */
public class Service {
	/**
	 * 业务类型编号
	 */
	private int serId;
	/**
	 * 业务类型名
	 */
	private String serName;
	
	
	public Service() {
		super();
	}
	public Service(int serId, String serName) {
		super();
		this.serId = serId;
		this.serName = serName;
	}
	/**
	 * @return the serId
	 */
	public int getSerId() {
		return serId;
	}
	/**
	 * @param serId the serId to set
	 */
	public void setSerId(int serId) {
		this.serId = serId;
	}
	/**
	 * @return the serName
	 */
	public String getSerName() {
		return serName;
	}
	/**
	 * @param serName the serName to set
	 */
	public void setSerName(String serName) {
		this.serName = serName;
	}
	
}

