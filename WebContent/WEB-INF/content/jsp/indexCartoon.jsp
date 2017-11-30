<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="font/iconfont.css">
</head>
<body>
<!-- 动漫 -->
<ul class="area-menu clearfix">
	<!-- 遍历显示 -->
	<s:iterator value="cartoonList" var="item">
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

</ul>
</body>
</html>