package com.web.entity;
/**
 * 汇率
 * @author akri
 *
 */
public class Rate {

	/**
	 * 汇率编号
	 */
	private int rateId;
	
	/**
	 * 货币名称
	 */
	private String coin;
	
	/**
	 * 假设美元为100，对应的各国货币值
	 */
	private double rate;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
