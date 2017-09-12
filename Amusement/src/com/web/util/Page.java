package com.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * @author java201
 *
 * @param <T>
 */
public class Page<T> {
	/**
	 * 查询的结果集返回的实体类对象集合
	 */
	private List<T> list;
	/**
	 * 查询条件组成的实体类对象
	 */
	private T obj;
	/**
	 * 查询条件组成的键值对集合
	 */
	private Map<String, Object> map;
	/**
	 * 当前页码
	 */
	private int currentPage=1;
	/**
	 * 总页码
	 */
	private int totalPage;
	/**
	 * 每页展示条数
	 */
	private int pageSize=5;
	/**
	 * 开始位置的条数
	 */
	private int startIndex=0;
	/**
	 * 结束位置的条数
	 */
	private int endIndex;
	/**
	 * 总的条数
	 */
	private int totalRecord;
	/**
	 * 上一页
	 */
	private int prePage;
	/**
	 * 下一页
	 */
	private int nextPage;
	
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getStartIndex(){
		this.startIndex=(this.currentPage-1)*this.getPageSize();
		return this.startIndex;
	}
	public int getEndIndex(){
		this.endIndex=this.currentPage*this.getPageSize();
		return this.endIndex;
	}
	public int getPrePage(){
		if (this.getCurrentPage()<=1) {
			this.prePage=1;
		}else{
			this.prePage=this.currentPage-1;
		}
		return this.prePage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.getTotalPage();
	}
	public int getNextPage(){
		if (this.getCurrentPage()>=this.getTotalPage()) {
			this.nextPage =this.totalPage;
		}else{
			this.nextPage=this.currentPage+1;
		}
		return this.nextPage;
	}
	public int getTotalPage(){
		if (this.totalRecord%this.getPageSize()==0) {
			this.totalPage=this.totalRecord/this.getPageSize();
		}else{
			this.totalPage=this.totalRecord/this.getPageSize()+1;
		}
		return this.totalPage;
	}
	public String getNav(){
		StringBuffer sb=new StringBuffer();
		sb.append("<input type=\"hidden\" name=\"page\" id=\"myPage\">");
		sb.append("<ul class=\"pagination pagination-lg\">");
		//判断是否有上一页按钮
		if (this.currentPage>1) {
			sb.append("<li><a pagedata='"+(this.currentPage-1)+"' href=\"javascript:void(0);\">«</a></li>");
		}
		int start=1;
		
		if (this.totalPage > 5) {//总页数大于5页时
			if((this.currentPage+5)%5 > 3 || this.currentPage >= 5 && this.currentPage + 2 <= this.totalPage){
				start=this.currentPage - 2;
			}
			if(this.currentPage+1 > this.totalPage){
				start=this.currentPage - 4;
			}
			if(this.currentPage+1 == this.totalPage){
				start=this.currentPage - 3;
			}
			for(int i=1;i<=5;i++){
				if(this.currentPage == start){
					sb.append("<li class=\"active\"><a pagedata='"+start+"' href=\"javascript:void(0);\">"+start+"</a></li>");
				}else{
					sb.append("<li><a pagedata='"+start+"' href=\"javascript:void(0);\">"+start+"</a></li>");
				}
				start++;
			}
		}else{//总页数小于5页
			for(int i=1;i<=this.totalPage;i++){
				if(this.currentPage == i){
					sb.append("<li class=\"active\"><a pagedata='"+start+"' href=\"javascript:void(0);\">"+start+"</a></li>");
				}else{
					sb.append("<li><a pagedata='"+start+"' href=\"javascript:void(0);\">"+start+"</a></li>");
				}
				start++;
			}
		}
		
		//判断是否有下一页按钮
		if(this.currentPage<this.totalPage){
			sb.append(" <li><a  pagedata='"+(this.currentPage+1)+"' href=\"javascript:void(0);\">»</a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	/**
	 * 倒序时间转换为yyyy-MM-dd HH:mm:ss字符串
	 * @param date
	 * @return
	 */
	public String getTimeToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(date);
		return time;
	}
	
}
