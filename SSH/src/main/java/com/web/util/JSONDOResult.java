package com.web.util;

/**
 * 用于添加，删除，修改操作执行的结果
 * @author java201
 *
 */
public class JSONDOResult {

	private boolean flag;//标志操作成功与否    true:成功    false:失败
	private String message;//操作结果信息
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
