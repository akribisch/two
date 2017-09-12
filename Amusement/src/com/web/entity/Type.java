package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备种类
 * @author java201
 *
 */
@Entity
@Table(name="type")
public class Type {

	/**
	 * 设备种类主键
	 */
	private int typeId;
	
	/**
	 * 设备种类名称
	 */
	private String typeName;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Type(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public Type() {
		super();
	}
	
	
}
