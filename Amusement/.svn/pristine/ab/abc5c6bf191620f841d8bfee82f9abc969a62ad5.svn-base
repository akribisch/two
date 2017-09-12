
$(function(){
	
	//全选
	$("input[level='1']").click(function(){
		 
		//获取当前复选框的状态
		var a = $(this).prop("checked");
		
		//设置下面所有的复选框的状态为当前复选框的状态
		$("input[name='check']").prop("checked",a);
	})
	
	
	//第二级菜单的全选功能
	$("input[level='2']").click(function(){
		//获取当前复选框的状态
		var a = $(this).prop("checked");
		
		//首先找到它的父级节点 ，然后再去找父级节点下面的子节点(input[level='3'])
		$(this).parents("dl").find("input[level='3']").prop("checked",a);
	})
	
	$("input[level='3']").change(function(){
		var flag=false;
		var checks= $(this).parents("dl").find("input[level='3']");
		
		for(var i=0;i<checks.length;i++){
			if($(checks[i]).prop("checked")){
				flag=true;
				console.log(flag);
			}
		}
		$(this).parents("dl").find("input[level='2']").prop("checked",flag);
	})
})