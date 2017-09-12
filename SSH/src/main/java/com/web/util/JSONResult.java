package com.web.util;

import java.util.List;

/**
 * easyui分页查询需要得到的数据
 * @author java201
 *
 */
public class JSONResult<T> {

	private int total;//总的条数
	private List<T> rows;//数据
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
