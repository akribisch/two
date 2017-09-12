package com.web.entity;
import java.util.Date;
/**
 * 金融产品记录
 * @author akri
 *
 */
public class FinalRecord {

	/**
	 * 购买记录编号
	 */
	private int finRecordId;
	
	/**
	 * 存储卡卡号
	 */
	private Savings savings;
	
	/**
	 * 购买的理财产品
	 */
	private Financial financial;
	
	/**
	 * 购买时间
	 */
	private Date finFirstDate;
	
	/**
	 * 购买金额
	 */
	private double finMoney;
	
	/**
	 * 赎回日期
	 */
	private Date finEndDate;

	public int getFinRecordId() {
		return finRecordId;
	}

	public void setFinRecordId(int finRecordId) {
		this.finRecordId = finRecordId;
	}

	public Date getFinFirstDate() {
		return finFirstDate;
	}

	public void setFinFirstDate(Date finFirstDate) {
		this.finFirstDate = finFirstDate;
	}

	public double getFinMoney() {
		return finMoney;
	}

	public void setFinMoney(double finMoney) {
		this.finMoney = finMoney;
	}

	public Date getFinEndDate() {
		return finEndDate;
	}

	public void setFinEndDate(Date finEndDate) {
		this.finEndDate = finEndDate;
	}

	public Savings getSavings() {
		return savings;
	}

	public void setSavings(Savings savings) {
		this.savings = savings;
	}

	public Financial getFinancial() {
		return financial;
	}

	public void setFinancial(Financial financial) {
		this.financial = financial;
	}

}
