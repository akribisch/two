package com.web.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 学生
 * @author java201
 *
 */
@Entity
@Table(name="t_student")
public class Student implements Serializable {

	private int sid;
	private String sname;
	private School school;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@ManyToOne
	@JoinColumn(name="schoolId")
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Student(int sid, String sname, School school) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.school = school;
	}
	public Student() {
		super();
	}
	
}
