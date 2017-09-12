package com.web.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工作时间类
 * @author java201
 *
 */
@Entity
@Table(name="worktime")
public class WorkTime {
	/**
	 * 主键
	 */
	private int wid;
	/**
	 * 上班时间
	 */
	private Date start;
	/**
	 * 下班时间
	 */
	private Date end;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public WorkTime(int wid, Date start, Date end) {
		super();
		this.wid = wid;
		this.start = start;
		this.end = end;
	}
	public WorkTime() {
		super();
	}
	
	
}
