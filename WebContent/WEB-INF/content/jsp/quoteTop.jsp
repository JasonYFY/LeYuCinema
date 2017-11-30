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
<!-- 顶部页面 -->
	<div id="header">

		<!-- 最顶部 -->
		<div class="header-top">
			<div class="auto-width">
				<h1 class="logo fl">
					<a href="index_form"><img width="278px" height="44px" src="images/logo.png" alt="#"></a>
				</h1>
				<div class="search-box fl">
					<s:form action="searchForm" >
						<s:textfield id="name" name="mvName" class="fl search-text" placeholder="点击搜索" />
						<button type="submit" class="fl search-btn">
							<i class="iconfont icon-search"></i>
						</button>
					</s:form>

				</div>
				<ul class="header-guide fr">
					<li class="guide-item download">

						<div class="guide-hover">
							<img src="images/app-download.png" alt="#">
						</div>
					</li>
					<s:if test="#session.nowUser==null">
						<li class="guide-item login"><a href="${pageContext.request.contextPath}/login_form"> <i
							class="iconfont icon-denglu"></i>登录</a>
						</li>
						<li class="guide-item login"><a href="${pageContext.request.contextPath}/register_form"> <i
								class="iconfont icon-zhuce"></i>注册</a>
						</li>
					</s:if>
					<s:else>
						<li class="guide-item login"><a href="#"> <i
							class="iconfont icon-denglu"></i>我的账号</a>
						</li>
						<li class="guide-item login"><a href="${pageContext.request.contextPath}/loginout_user">
							退出登录</a>
						</li>
					</s:else>
					<li class="guide-item upload"><a href="${pageContext.request.contextPath}/uploadFile_form"> 
						<i class="iconfont icon-upload"></i>上传</a>
					</li>

				</ul>
			</div>
		</div>

		<!-- 焦点图 -->
		<div class="header-banner"></div>
		<!-- 导航 -->
		<div class="header-nav">
			<div class="nav-wrap auto-width clearfix">
				<s:a href="index_form" class="nav-item nav-cur">
					<i class="iconfont icon-shouye"></i>首页
				</s:a> 
				<a id="film" href="${pageContext.request.contextPath}/film_form" class="nav-item">
					<i class="iconfont icon-dianying"></i>电影
				</a> 
				<a id="cartoon" href="${pageContext.request.contextPath}/cartoon_form" class="nav-item">
					<i class="iconfont icon-dongman"></i>动漫
				</a> 
				<a id="mtv" href="${pageContext.request.contextPath}/mtv_form" class="nav-item">
					<i class="iconfont icon-ccmtvshipin"></i>MTV
				</a>
			</div>

		</div>

	</div>
<script src="js/jquery.min.js"></script>

</body>
</html>