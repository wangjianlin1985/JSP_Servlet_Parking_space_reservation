<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%String path = request.getContextPath();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/houtai1.css" />
    <link rel="stylesheet" href="<%=path %>/css/houtai2.css" />
    
    <script type="text/javascript" src="<%=path %>/js/jquery1.9.0.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/sdmenu.js"></script>
   
    <script type="text/javascript">
		var myMenu;
		window.onload = function() 
		{
			myMenu = new SDMenu("my_menu");
			myMenu.init();
		};
		
		$(document).ready(function(e) {$(".Switch").click(function(){$(".left").toggle();});});
		
		function queding() 
        {
            if(window.confirm('您确定要退出吗？'))
            {
                top.location = '<%=path %>/login.jsp';
            }
        }  
    </script>

</head>
  
<body>
<div class="header">
	 <div class="logo" style="color: white;margin-top: 20px;font-size: 23px;margin-left: 20px;width: 700px;"><!-- <img  src="img/logo.png" /> -->基于JSP的火车站停车场车位自动管理系统</div>
	 <div class="header-right" style="color: white">
                              欢迎您：${sessionScope.user.xingming }
          &nbsp;&nbsp;&nbsp;&nbsp;
          <!-- <i class="icon-off icon-white"></i> 
          <a id="modal-973558" href="#" role="button" data-toggle="modal" onclick="queding()">注销退出</a> -->
          <a id="modal-973558" href="#" role="button" data-toggle="modal">&nbsp;</a>
          <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
			 <!-- <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">
					注销系统
				</h3>
			 </div>
			 <div class="modal-body">
				<p>
					您确定要注销退出系统吗？
				</p>
			 </div>
			 <div class="modal-footer">
				 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="登录.html" >确定退出</a>
			 </div> -->
          </div>
	</div>
</div>
  
            
<div id="middle">
     <div class="left">
		<div id="my_menu" class="sdmenu">
			<div class="collapsed">
				<span>查看我的信息</span>
				<a href="<%=path %>/admin/userinfo/userinfo.jsp" target="main">查看我的信息</a>
			</div>
			<div class="collapsed">
				<span>我的预订信息</span>
				<a href="<%=path %>/yuding?type=yudingMine" target="main">我的预订信息</a>
			</div>
			<%-- <div class="collapsed">
				<span>111</span>
				<a href="<%=path %>" target="main">11</a>
				<a href="<%=path %>" target="main">11</a>
			</div> --%>
		</div>
     </div>
     <div class="Switch"></div>
     

     <div class="right"  id="mainFrame">
         <iframe name="main" width="100%" height="700" frameborder="0" scrolling="auto" src="<%=path %>/admin/right.jsp"></iframe>
     </div> 
</div>



</body>
</html>
