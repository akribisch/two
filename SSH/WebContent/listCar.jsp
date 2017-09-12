<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="common/commoncss.jsp" %>
<%@ include file="common/commonjs.jsp" %>

<script type="text/javascript">

	function formatSchoolID(value1){
		return value1.scid;
	};

    function formatSchool(value){
	        return value.scname;
	    };
	    
	  function doSearch(){
	    	$('#dg').datagrid('load',{
	    		snames: $('#sname').val(),
	    		schoolNames: $('#schoolName').val(),
	    		schoolId:$('#schoolId').val()
	    	});
	    }
</script>
</head>
<body  class="easyui-layout">
<!-- url:访问后台的路径          toolbar:工具条      pagination：是否允许分页      rownumbers：行的编号 fitColumns：是否填充列    singleSelect：选中行-->
 <table id="dg" title="学生管理" class="easyui-datagrid" 
            url="${pageContext.request.contextPath }/queryCar.action"
            toolbar="#toolbar" pagination="true"   pageList="[2, 3, 4, 5]"  pageSize="3"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">编号</th>
                <th field="name" width="50">车名</th>
                <th field="color" width="50">颜色</th>、
                <th field="price" width="50">价格</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
	    <span>学生姓名:</span>
		<input id="sname" name="sname" style="line-height:26px;border:1px solid #ccc">
		<span>学校名称:</span>
		<input id="schoolName" name="schoolName" style="line-height:26px;border:1px solid #ccc">
		<span>请选择学校:</span>
         <input id="schoolId" class="easyui-combobox" name="schoolId" 
                 data-options="valueField:'scid',textField:'scname',url:'${pageContext.request.contextPath }/querySchool.action'">
		
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a><br>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加学生</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑学生</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除学生</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">学生信息</div>
            <div style="margin-bottom:10px">
                <input name="sname" class="easyui-textbox" required="true" label="学生姓名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
               <input id="cc" class="easyui-combobox" name="schoolId"  label="学校:"
                 data-options="valueField:'scid',textField:'scname',url:'${pageContext.request.contextPath }/querySchool.action'">
            </div>
            
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
        var url;
        
        //添加学生的事件
        function newUser(){
        	//找id名称为dlg的对象以对话框的形式打开，对话框要居中，设置了标题为添加学生
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加学生');
            $('#fm').form('clear');//表单数据清空
            url = '${pageContext.request.contextPath }/insertStudent.action';
        }
        
        //编辑学生的事件
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            
            if (row){//判断是否选中了某一行
            	
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑学生');
                $('#fm').form('load',row);//表单要加载行的数据
                
                
              //   $("#cc").combobox("select", "CMCC");  
                
                url = '${pageContext.request.contextPath }/updateStudent.action?sid='+row.sid;//注意更改传过去的id
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');//解析
                    console.log(result.flag);
                    if (!result.flag){
                        $.messager.show({
                            title: 'Error',
                            msg: result.message
                        });
                    } else {
                    	 $.messager.show({
                             title: 'msg',
                             msg: result.message
                         });
                       $('#dlg').dialog('close');
                       console.log(1111)// 关闭对话框
                      //$('#dg').datagrid('reload');    //刷新表格中的数据
                    }
                }
            });
        }
        
        //删除学生
        function destroyUser(){
        	
            var row = $('#dg').datagrid('getSelected');//获取选中的行数据
            
            if (row){//判断是否选中了表格中的某一行
            	
                $.messager.confirm('确认框','你确认要删除该学生吗？',function(r){
                	
                    if (r){//选择了要删除
                    	
                        $.post('${pageContext.request.contextPath }/deleteStudent.action',{sid:row.sid},function(result){
                        	
                            if (result.flag){//操作成功
                            	
                                $('#dg').datagrid('reload');    //刷新表格中的数据
                                
                            } else {
                                $.messager.show({    //显示错误的提示信息
                                    title: 'Error',
                                    msg: result.message
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
</body>
</html>