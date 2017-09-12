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
 * 游客玩项目信息
 * @author java201
 *
 */
@Entity
@Table(name="playGame")
public class PlayGame {

	/**
	 * 玩项目的编号
	 */
	private int playGameId;
	
	/**
	 * 游客
	 */
	private Tourist tourist;
	
	/**
	 * 游玩项目
	 */
	private Recreation recreation;
	
	/**
	 * 游玩的时间
	 */
	private Date playDate;
	
	/**
	 * 游玩价格
	 */
	private double playPrice;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//主键设置
	public int getPlayGameId() {
		return playGameId;
	}

	public void setPlayGameId(int playGameId) {
		this.playGameId = playGameId;
	}

	@ManyToOne
	@JoinColumn(name="touId")
	public Tourist getTourist() {
		return tourist;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	@ManyToOne
	@JoinColumn(name="rno")
	public Recreation getRecreation() {
		return recreation;
	}

	public void setRecreation(Recreation recreation) {
		this.recreation = recreation;
	}

	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	
	public double getPlayPrice() {
		return playPrice;
	}

	public void setPlayPrice(double playPrice) {
		this.playPrice = playPrice;
	}

	public PlayGame() {
		super();
	}

	public PlayGame(int playGameId, Tourist tourist, Recreation recreation, Date playDate, double playPrice) {
		super();
		this.playGameId = playGameId;
		this.tourist = tourist;
		this.recreation = recreation;
		this.playDate = playDate;
		this.playPrice = playPrice;
	}

}
