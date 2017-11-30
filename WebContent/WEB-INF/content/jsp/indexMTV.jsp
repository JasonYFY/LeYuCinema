<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="import.jsp"></jsp:include>
<div class="area-big">
	<a href="#" style="width: 340px;height: 290px" class="img"> 
		<img height="290px" width="340px" src="images/cont/area-menu__big.jpg" alt="#"> 
		<!-- <i class="iconfont icon-play"></i>  -->
		<span class="mask"><em class="time">4:47</em></span>
	</a>
</div>
	<ul class="area-menu clearfix">
		
			<s:iterator value="mtvList" var="item">
				<li class="area-menu__item">
					<s:url action="play_form" var="play">
		                <s:param name="id"><s:property value="#item.id"/></s:param>
					</s:url>
					<s:a href="%{#play}" class="img" target="_top"> 
						<img src="<s:property value="#item.filepic" />" alt="#">
						<span class="mask"> <em class="time">4:47</em></span> 
						<span class="icon-recommend">推荐</span>
					</s:a>
					<div class="info">
						<a href="#" class="change-title"><s:property value="#item.mvName"/></a> 
						<span class="play-info clearfix">
							<i class="iconfont icon-bofangliang fl">
								<s:if test="#item.playTimes==null">0</s:if>
								<s:else><s:property value="#item.playTimes"/></s:else>
							</i> 
							<i class="iconfont icon-zan1 fr">
								<s:if test="#item.goodCount==null">0</s:if>
								<s:else><s:property value="#item.goodCount"/></s:else>
							</i>
						</span>
					</div>
				</li>
			</s:iterator>
		
		<%-- <s:else>
			<!-- for循环 -->
				<s:bean name="org.apache.struts2.util.Counter" >
				    <s:param name="first" value="1" />
				    <s:param name="last" value="5" />
				    <s:iterator>
				    	<li class="area-menu__item">
							<a href="#" class="img"> 
								<img src="images/cont/area-menu__1.jpg" alt="#"> 
								<span class="mask"><em class="time">4:47</em></span> 
								<span class="icon-recommend">推荐</span>
							</a>
							<div class="info">
								<a href="#" class="change-title">抢来的感情究竟能不能感到幸福？!</a> 
								<span class="play-info clearfix"> 
									<i class="iconfont icon-play fl">2372</i> 
									<i class="iconfont icon-collect fr">999</i>
								</span>
							</div>
						 </li>
					</s:iterator>
				</s:bean>
		</s:else>
		 --%>
		
	</ul>
</body>
</html>