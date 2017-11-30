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
<jsp:include page="./import.jsp"></jsp:include>
<div class="area-side fr" JS-tab="true">
	<header class="area-header">
		<h2 class="title">
			<b>MTV排行榜</b>
		</h2>
		<!-- <div class="tab-rank tab fr">
			<a href="javascript:;" class="tab-rank__item active">总排行</a> 
			<a href="javascript:;" class="tab-rank__item">周榜</a>
		</div> -->
	</header>
	<div class="side-rank">
		<ul class="tab-cont tab-cont__active">
			<!-- 遍历显示 -->
			<s:iterator value="mtvIndexRanking" var="item" status="i">
				<s:if test="#i.count<4">
					<li class="has-img">
						<s:url action="play_form" var="play">
			                <s:param name="id"><s:property value="#item.id"/></s:param>
						</s:url>
						<s:a href="%{#play}" class="img fl" target="_top"> 
							<img src="<s:property value="#item.filepic" />" alt="#"> 
							<span class="rank"><s:property value="#i.count"/></span>
						</s:a>
						<div class="info fr">
							<font  class="text-overflow"><s:property value="#item.mvName"/></font>
							<p>
								<a href="#">UP主:<s:property value="#item.uploader.nickName"/></a>
							</p>
							<p>
								<i class="iconfont icon-bofangliang fl">
									<s:if test="#item.playTimes==null">0</s:if>
									<s:else><s:property value="#item.playTimes"/></s:else>
								</i> 
								<i class="iconfont icon-zan1 fr">
									<s:if test="#item.goodCount==null">0</s:if>
									<s:else><s:property value="#item.goodCount"/></s:else>
								</i>
							</p>
						</div>
					</li>
				</s:if>
				<s:else>
					<li>
						<s:url action="play_form" var="play">
			                <s:param name="id"><s:property value="#item.id"/></s:param>
						</s:url>
						<s:a href="%{#play}" class="rank-item text-overflow" target="_top"> 
						<span class="rank-num"><s:property value="#i.count"/></span>
							<s:property value="#item.mvName"/>
						</s:a>
					</li>
				</s:else>
			</s:iterator>
		
		</ul>
		
	</div>
	<a href="javascript:return false;" class="more">查看完整榜单 ></a>
</div>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/sliderbox.js"></script>
	<script src="js/tab.js"></script>
</body>
</html>