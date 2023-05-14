<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%String path = request.getContextPath();%>

<!doctype html>
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path %>/css/qiantai.css">
    <link rel="stylesheet" href="<%=path %>/css/list.css">
    <script type='text/javascript' src='<%=path %>/js/lunbo.js'></script>


    <script type="text/javascript">
		function yudingAdd(chewei_id)
        {
            <c:if test="${sessionScope.userType !=1}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.userType ==1}">
                var url="<%=path %>/qiantai/yuding/yudingAdd.jsp?chewei_id="+chewei_id;
				var ret = window.open(url,"","dialogWidth:800px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
            </c:if>
        } 
    </script>
</head>
  
<body>
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<div class="tzFirArticle1">
				<table margin-left="200px" width="100%" align="center">
				    <tr>
				        <td width="70%"  valign="top">
				            <div style="width:70%;margin-top: 1px;padding-bottom:10px;">
							    <div style="height:26px;background:url(<%=path %>/images/guangguang.PNG);font-size: 14px;color:black;">
							       <span style="float:left;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;margin-left: 10px;">系统帮助</span>
							       <span style="float:right;font-family: 微软雅黑;font-size: 12px;margin-top: 3px;margin-right: 15px;"><a href="<%=path %>/zhengce?type=zhengceAll">更多</a></span>
							    </div>
							    <div style="height: 150px;border:1px solid #D3D3D3;">
							       <c:forEach items="${sessionScope.zhengceList }" var="zhengce" varStatus="ss">
									   <div class="c1-bline" style="padding:7px 0px;margin-top: 3px;">
									       <div class="f-left" style="margin-left: 10px;">
										       <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
									           <a style="color: black" href="<%=path %>/zhengce?type=zhengceDetailQian&id=${zhengce.id}">${zhengce.biaoti}</a>
									       </div>
									      <div class="f-right" style="margin-right: 10px;">${zhengce.shijian}</div>
									      <div class="clear"></div>
									   </div>
				                   </c:forEach>
				                </div>
				            </div>
				        </td>
				        <td width="30%"  valign="top">
					        <div id="imgADPlayer" style="margin-left: 5px;"></div>
							<script>
								PImgPlayer.addItem( "test1", "#", "<%=path %>/img/11.jpg");
								PImgPlayer.addItem( "test2", "#", "<%=path %>/img/12.jpg");
								PImgPlayer.init( "imgADPlayer", 495, 180 );
							</script>
				        </td>
				    </tr>
				</table>
		</div>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		<%-- <div class="tzFirArticle2">
			<div class="clearfix wrapper txFirDiv">
				<div class="fl borderR">
					<div class="tzFirContent">
						<div class="title clearfix">
							<h3>新闻动态</h3>
							<a href="<%=path %>/xinwen?type=xinwenAll">More>></a>
						</div>
						<ul>
						    <c:forEach items="${requestScope.xinwenList}" var="xinwen" varStatus="ss">
							<li class="clearfix"><a href="<%=path %>/xinwen?type=xinwenDetailQian&id=${xinwen.id }">${xinwen.biaoti }</a><span>[${xinwen.fabushi }]</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="fr">
					<div class="tzFirContent2 tzFirContent">
						<div class="title clearfix">
							<h3>通知公告</h3>
							<a href="<%=path %>/guanggao?type=guanggaoAll">More>></a>
						</div>
						<ul>
						    <c:forEach items="${requestScope.guanggaoList}" var="guanggao" varStatus="ss">
							<li class="clearfix"><a href="<%=path %>/guanggao?type=guanggaoDetailQian&id=${guanggao.id }">${guanggao.biaoti }</a><span>[${guanggao.shijian }]</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div> --%>
		
		
		<!-- 其他版块 -->
		<div class="tzFirArticle2">
			<div class="clearfix wrapper txFirDiv">
					<div class="tzFirContent">
						<%-- <div class="title clearfix" style="width: 1000px;">
							<h3 style="margin-left: 20px;">车位信息</h3>
							<a href="<%=path %>/xinwen?type=xinwenAll">More>></a>
						</div> --%>
						<div style="width: 1000px;line-height:20px">
						    <div style="margin-top: -5px;">
							    <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
									<tr align="center" bgcolor="#FAFAF1" height="22">
										<td width="5%">序号</td>
										<td width="20%">车位编号</td>
										<td width="20%">车位分区</td>
										<td width="20%">状态</td>
							        </tr>	
									<c:forEach items="${sessionScope.cheweiList}" var="chewei" varStatus="ss">
									<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										<td bgcolor="#FFFFFF" align="center">
											${ss.index+1}
										</td>
										<td bgcolor="#FFFFFF" align="center">
											${chewei.bianhao}
										</td>
										<td bgcolor="#FFFFFF" align="center">
											${chewei.quyu}
										</td>
										<td bgcolor="#FFFFFF" align="center">
											<c:if test="${chewei.zt=='已占用'}">
											    <span style="color: red">${chewei.zt}</span>
											</c:if>
											<c:if test="${chewei.zt=='空闲中'}">
											    <span>${chewei.zt}</span>
											    <input type="button" value="预订" style="width: 60px;" onclick="yudingAdd(${chewei.id})">
											</c:if>
										</td>
									</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
			</div>
		</div>
		<!-- 其他版块 -->
		<!-- 详细页面 1-->
		<!-- <div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;">
				<div class="section">
					<h3>张贵春教授受聘为职业教育学院客座教授</h3><p>2019-12-01</p>
					<img src="images/img10.jpg" alt="">
					<p class="tzWzyP">
					   11月27日上午，辽宁师范大学张桂春教授受聘为华南师范大学职业教育共同见证了座，并与师生进行了广泛、热烈的互动。
					</p>
				</div>
			</div>
		</div> -->
		<!-- 详细页面1 -->
		
		<div class="tzFooter" style="height: 30px;">
			<div>
				<p><jsp:include flush="true" page="/qiantai/down.jsp"></jsp:include></p>
			</div>
		</div>
	</body>
</html>
