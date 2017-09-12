package com.web.entity;
/**
 * 娱乐项目表
 * @author liudong
 *
 */



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Recreation")
public class Recreation {
	/**
	 * 项目编号
	 */
	private int rno;
	/**
	 * 项目名称
	 */
	private String rname ;
	/**
	 * 地址
	 */
	private String raddress ;
	/**
	 * 价格
	 */
	private float rpice;
	/**
	 * 简介
	 */
	private String rintroducion ;
	/**
	 * 注意事项
	 */
	private String rattention ;
	/**
	 * 获取项目编号
	 * @return
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//主键设置
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public float getRpice() {
		return rpice;
	}
	public void setRpice(float rpice) {
		this.rpice = rpice;
	}
	public String getRintroducion() {
		return rintroducion;
	}
	public void setRintroducion(String rintroducion) {
		this.rintroducion = rintroducion;
	}
	public String getRattention() {
		return rattention;
	}
	public void setRattention(String rattention) {
		this.rattention = rattention;
	}
	
	
}
