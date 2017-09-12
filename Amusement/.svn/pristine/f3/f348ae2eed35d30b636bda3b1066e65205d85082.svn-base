<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
$('.date').datetimepicker({
  language: 'zh-CN',//显示中文
  format: 'yyyy-mm-dd',//显示格式
  minView: "month",//设置只显示到月份
  initialDate: new Date(),//初始化当前日期
  autoclose: true,//选中自动关闭
  todayBtn: true//显示今日按钮
 })
 
 <script type="text/javascript">
    $("#datetimeStart").datetimepicker({
        format: 'yyyy-mm-dd',
        minView:'month',
        language: 'zh-CN',
        autoclose:true,
        startDate:new Date()
    }).on("click",function(){
        $("#datetimeStart").datetimepicker("setEndDate",$("#datetimeEnd").val())
    });
    $("#datetimeEnd").datetimepicker({
        format: 'yyyy-mm-dd',
        minView:'month',
        language: 'zh-CN',
        autoclose:true,
        startDate:new Date()
    }).on("click",function(){
        $("#datetimeEnd").datetimepicker("setStartDate",$("#datetimeStart".val()))
    });
    $(".form_datetime_2").
    datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm',
    autoclose: true,
    todayBtn: true,
    startView: 'year',
    minView:'year',
    maxView:'decade'
    });
</script>
</head>
<body>
<input size="16" type="text" id="datetimeStart" readonly class="form_datetime">
--
<input size="16" type="text" id="datetimeEnd" readonly class="form_datetime">

<input type="text"class="form-control form_datetime_2"readonly id="month_time"value=""/>
</body>
</html>