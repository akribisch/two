<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="common/commoncss.jsp" %>
<%@ include file="common/commonjs.jsp" %>
</head>
<body  class="easyui-layout">
      <div class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'north'" style="height:50px">
            上边
        </div>
        
        <div data-options="region:'south',split:true" style="height:50px;">
          底部  
        </div>
        
        
        <div data-options="region:'west',split:true" title="West" style="width:150px;">
             <ul id="tt" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/searchMenu.action',method:'get',animate:true,dnd:true"></ul>
             
        </div>
        <div  data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
            <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                  
            </div>
        </div>
    </div>
    <script type="text/javascript">
         $(function(){
        	 $('#tt').tree({
        			onClick: function(node){//点击事件
        				
        				var titleContent = node.text;//标题
        				var url = node.url;//访问地址
          				
        				if(node.url != null){
        					var content = "<iframe src='"+url+"' width='100%' style='width:100%;height:100%;' frameborder='0'></iframe>";
        	                
        				   if ($('#tabs').tabs('exists', titleContent)){//如果存在那个标签
									$('#tabs').tabs('select', titleContent);//选中那个标签
						   }else{
							   //添加一个新的标签页
	        					$("#tabs").tabs('add',{
	        					    title:titleContent,
	        					    content:content,
	        					    closable:true
	        					});
						   }
        				}
        			}
        		});
         })
    </script>
</body>
</html>