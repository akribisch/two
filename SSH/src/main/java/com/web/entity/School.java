package com.web.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 学校
 * @author java201
 *
 */
@Entity  //实体
@Table(name="t_school")  //表
public class School implements Serializable {

	private int scid;
	private String scname;
//	private Set<Student> students;//一对多     一个学校有多个学生
	
	
	@Id  //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //生成策略为自动增长
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	
//	@OneToMany //一对多
//	@JoinColumn(name="schoolId")  //外键字段
//	public Set<Student> getStudents() {
//		return students;
//	}
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}
	
	
}
