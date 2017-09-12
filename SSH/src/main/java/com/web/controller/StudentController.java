package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.web.biz.SchoolBiz;
import com.web.biz.StudentBiz;
import com.web.entity.School;
import com.web.entity.Student;
import com.web.util.JSONDOResult;
import com.web.util.JSONResult;
import com.web.util.PageUtil;
import com.web.util.StringUtil;

@Controller
@Namespace("/")
@ParentPackage("json-default")
public class StudentController extends ActionSupport {
	
	@Resource(name="studentBizImpl")
	StudentBiz studentBiz;
	
	@Resource(name="schoolBizImpl")
	SchoolBiz schoolBiz;

	JSONResult<Student> arr = new JSONResult<>();
	JSONDOResult doResult = new JSONDOResult();//执行添加删除修改操作的结果
	
	private Integer page;//页码
	private Integer rows;//每页显示的条数
	
	/**接收条件查询的数据s **/
	private String snames;//学生姓名
	private String schoolNames;//学校名称
	private Integer schoolId;//学校id
	
	private Integer sid;
	
	@Action(value="queryStudent",results={@Result(name="success",type="json",params={"root","arr"})})
	public String queryStudent(){
		
		PageUtil<Student> paging = new PageUtil<>();
		Map<String, Object> map = new HashMap<>();
		
		if(page != null){
			paging.setCurrentPage(page);
		}
		
		if(rows != null){
			paging.setPageSize(rows);
		}
		
		if(!StringUtil.isEmpty(snames)){
    		map.put("sname", snames);//设置学生的姓名
    	}
    	
    	if(!StringUtil.isEmpty(schoolNames)){
    		map.put("schoolName", schoolNames);//设置学生的姓名
    	}
    	
    	if(schoolId != null){
    		map.put("schoolId", schoolId);
    	}
		
    	//分页查询
		this.studentBiz.queryPaging(paging, map);
		
		arr.setTotal(paging.getTotalCount());
		arr.setRows(paging.getData());
		
		return SUCCESS;
	}
	
	private String sname;
	
	@Action(value="insertStudent",results={@Result(name="success",type="json",params={"root","doResult"})})
	public String insertStudent(){
		School school= schoolBiz.findById(School.class, schoolId);
		Student stu=new Student(0, sname, school);
		boolean flag=studentBiz.add(stu);
		doResult.setFlag(flag);//设置操作的结果信息
    	doResult.setMessage(flag ? "操作成功!" : "操作失败");
		return SUCCESS;
	}

	@Action(value="updateStudent",results={@Result(name="success",type="json",params={"root","doResult"})})
	public String updateStudent(){
		School school= schoolBiz.findById(School.class, schoolId);
		Student stu=new Student(sid, sname, school);
		boolean flag=studentBiz.update(stu);
		doResult.setFlag(flag);//设置操作的结果信息
    	doResult.setMessage(flag ? "操作成功!" : "操作失败");
		return SUCCESS;
	}
	
	@Action(value="deleteStudent",results={@Result(name="success",type="json",params={"root","doResult"})})
	public String deleteStudent(){
		boolean flag=studentBiz.delete(new Student(sid, null, null));
		doResult.setFlag(flag);//设置操作的结果信息
    	doResult.setMessage(flag ? "操作成功!" : "操作失败");
		return SUCCESS;
	}
	public JSONResult<Student> getArr() {
		return arr;
	}

	public void setArr(JSONResult<Student> arr) {
		this.arr = arr;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSnames() {
		return snames;
	}

	public void setSnames(String snames) {
		this.snames = snames;
	}

	public String getSchoolNames() {
		return schoolNames;
	}

	public void setSchoolNames(String schoolNames) {
		this.schoolNames = schoolNames;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public JSONDOResult getDoResult() {
		return doResult;
	}

	public void setDoResult(JSONDOResult doResult) {
		this.doResult = doResult;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	
}
