package com.web.entity;
/**
 * 订购信息记录
 * @author orange
 *
 */

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
@Table(name="OrderInformation")
public class OrderInformation {
	/**
	 * 订购编号
	 */
	private int orderId;
	/**
	 * 订票日期
	 */
	private Date orderDate;
	/**
	 * 定购项目
	 */
	private Recreation recreation;
	/**
	 * vip卡号
	 */
	private Vip vip;
	/**
	 * 订票的游客
	 */
	private Tourist tourist;
	@Id//主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@ManyToOne
	@JoinColumn(name="rno")
	public Recreation getRecreation() {
		return recreation;
	}
	public void setRecreation(Recreation recreation) {
		this.recreation = recreation;
	}
	@OneToOne
	@JoinColumn(name="vId")
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	@OneToOne
	@JoinColumn(name="touId")
	public Tourist getTourist() {
		return tourist;
	}
	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}
	
}
