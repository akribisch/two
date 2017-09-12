package com.web.util;

import java.util.List;

/**
 * 分页工具类
 * @author java201
 *
 * @param <T>
 */
public class PageUtil<T> {

	private int currentPage=1;//当前页码
	private int pageSize=3;//每页显示的条数
	private int totalCount;//总的条数    select count(*) from t
	private int totalPage;//总的页码
	private List<T> data;//数据
	
	private int prev;//分页查询排除前面多少条数据   getPrev
	
	private String nav;///导航条
	
	public void setNav(String nav) {
		this.nav = nav;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 获取总的页码
	 * @return
	 */
	public int getTotalPage() {
		return (int)Math.ceil((totalCount * 1.0) / pageSize);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPrev() {
		return (this.currentPage-1) * this.pageSize;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	
	/**
	 * 是否有上一页
	 * @return
	 */
	public boolean IsFirst(){
		
	     return this.getCurrentPage() > 1 ? true : false;
	}
	
	/**
	 * 判断是否有下一页
	 * @return
	 */
	public boolean IsLast(){
		
		return this.getCurrentPage() < this.getTotalPage() ? true : false;
	}
	
	/**
	 * 导航条
	 * @return
	 */
	public String getNav(){
		/**
		 * 
		 * <ul class="pagination pagination-lg">
                  <li><a href="#">«</a></li>
                  <li class="active"><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                  <li><a href="#">»</a></li>
                </ul>
		 */
		
		//计算要显示的页码
		int start =1;
		int end = 5;
		
		if(this.getCurrentPage() > 4){
			start = this.getCurrentPage() + 4;
			end = start + 4;
		}
		if(end > this.getTotalPage()){
			end = this.getTotalPage();
			start = end -4;
			
			if(start < 1){
				start = 1;
			}
		}
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"hidden\" name=\"page\" id=\"myPage\">");
		sb.append("<ul class=\"pagination pagination-lg\">");
		
		//上一页
		if(!IsFirst()){
			sb.append("<li><a pdata='1' href=\"javascript:void(0);\">«</a></li>");
		}else{
			sb.append("<li><a style='color:green;' pdata='"+(this.currentPage-1)+"' href=\"javascript:void(0);\">«</a></li>");
		}
		
		for(int i = start;i <= end;i++){
			if(i==this.getCurrentPage()){
				sb.append("<li class=\"active\"><a pdata='"+this.getCurrentPage()+"' href=\"javascript:void(0);\">"+i+"</a></li>");
			}else{
				sb.append("<li><a pdata='"+i+"' href=\"javascript:void(0);\">"+i+"</a></li>");
			}
		}
		
		
		//下一页
		if(IsLast()){
			sb.append("<li><a style='color:green;' pdata='"+(this.getCurrentPage()+1)+"' href=\"#\">»</a></li>");
		}else{
			sb.append("<li><a pdata='"+this.getTotalPage()+"' href=\"#\">»</a></li>");
		}
		
		sb.append("</ul>");
		
		return sb.toString();
	}

}
