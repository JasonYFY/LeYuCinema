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
<ul class="area-menu fl clearfix">
				
			<!-- 遍历显示 -->
			<s:iterator value="filmList" var="item" status="i">
				<li class="area-menu__item">
					<s:url action="play_form" var="play">
                     		 	<s:param name="id"><s:property value="#item.id"/></s:param>
					</s:url>
					<s:a href="%{#play}" class="img" target="_top"> 
						<img id="filmImg<s:property value="#i.index" />" src="<s:property value="#item.filepic" />" alt=""> 
						<span class="mask"> <em class="time">4:47</em></span>
					</s:a>
					<div class="info">
						<a href="#" id="filmName<s:property value="#i.index" />" class="title"><s:property value="#item.mvName" /></a> 
						<a href="#" id="filmUser<s:property value="#i.index" />" class="userName">UP主:<s:property value="#item.uploader.nickName" /></a>
					</div>
				</li>
			</s:iterator>
			<s:if test="filmList==null">
				<!-- for循环 -->
				<s:bean name="org.apache.struts2.util.Counter" >
				    <s:param name="first" value="1" />
				    <s:param name="last" value="5" />
				    <s:iterator>
				       <li class="area-menu__item"><a href="#" class="img"> 
							<img src="" alt="#"> 
							<span class="mask"> <em class="time">4:47</em>
							</span>
							</a>
							<div class="info">
								<a href="#" class="title">这只喵技能树突破天际啦!</a> 
								<a href="#" class="userName">UP: iphone猫</a>
							</div>
						</li>
				    </s:iterator>
				</s:bean>
			</s:if>
					
				</ul>
</body>
</html>