<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首 页</title>

</head>
<body>
	<jsp:include page="quoteTop.jsp"/>
	
	<!---------- 主体内容 ---------->
	<div id="main" style="margin: 0px 30px;background-color: white;">
		<div class="auto-width clearfix">

			<!-- 幻灯片部分 -->
			<section class="area clearfix area-slider">
			<div id="sliderBox" class="slider-box fl">
				<ul class="slider">
					<li data-title="Picture 1" class="slider-item"><img
						src="images/cont/slider-1.jpg" alt="#"></li>
					<li data-title="Picture 2" class="slider-item"><img
						src="images/cont/slider-2.jpg" alt="#"></li>
					<li data-title="Picture 3" class="slider-item"><img
						src="images/cont/slider-3.jpg" alt="#"></li>
					<li data-title="Picture 4" class="slider-item"><img
						src="images/cont/slider-4.jpg" alt="#"></li>
					<li data-title="Picture 5" class="slider-item"><img
						src="images/cont/slider-5.jpg" alt="#"></li>
				</ul>
				<div class="btn-box">
					<a href="javascript:;" class="btn-item btn-item__active"></a> <a
						href="javascript:;" class="btn-item"></a> <a href="javascript:;"
						class="btn-item"></a> <a href="javascript:;" class="btn-item"></a>
					<a href="javascript:;" class="btn-item"></a>
				</div>
			</div>
			
			<ul class="slider-menu fl">
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__1.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__2.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__3.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__4.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__6.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
				<li class="slider-menu__item"><a href="#" class="item"> <img
						src="images/cont/slider-menu__5.jpg" alt="#">
						<div class="mask-gradient">
							<p>嗨呀！好气啊！OW堡傻缺集锦</p>
							<div class="text-box">
								<em>UP: AcFun出品</em> <span class="info"> <i
									class="iconfont icon-collect">14.9万</i> <i
									class="iconfont icon-collect">165</i>
								</span>
							</div>
						</div>
				</a></li>
			</ul>
			</section>

			<!-- 电影 -->
			<section class="area clearfix area-recommend"> 
				<header class="area-header">
					<h2 class="title">
						<img src="images/dianying.png" alt="电影"> <b>电 影</b> <em>十分好评快来看啦</em>
					</h2>
					
					<form action="${pageContext.request.contextPath}/indexFilm" method="post" target="indexFilm">
					<button type="submit" id="filmRefresh"  class="change"><i class="iconfont icon-rank"></i>
						换一批
					</button> 
					<!-- <input type="hidden" value="0" id="filmPage"  name="filmPage" /> -->
					</form>
					<a href="${pageContext.request.contextPath}/film_form" class="more" style="margin-right: 24%">More ></a>
				</header>
		<div class="area-cont">
			<div class="area-main fl">
				<iframe frameborder="0" name="indexFilm" src="${pageContext.request.contextPath}/indexFilm" marginheight="0" 
				marginwidth="0" scrolling="no" width="100%" >
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
				</iframe>
				
			</div>
			<div class="area-side fr">
				<a href="#"><img src="images/cont/slider-menu__6.jpg" alt="#"></a>
			</div>
		</div>
	</section>
	
	<!-- 动漫 -->
	<section class="area clearfix area-game">
		<div class="area-cont">
			<div class="area-main fl">
				<header class="area-header">
					<h2 class="title">
						<img src="images/area-title__7.gif" alt="#"> <b>动  漫</b> <em>大力喂蕉不要停</em>
					</h2>
					<a href="${pageContext.request.contextPath}/indexCartoon" class="change" target="indexCartoon"> <i class="iconfont icon-rank"></i>
						换一批
					</a>
					<a href="${pageContext.request.contextPath}/cartoon_form" class="more">More ></a> 
				</header>
				
				<iframe frameborder="0" name="indexCartoon" src="${pageContext.request.contextPath}/indexCartoon" marginheight="0" 
				marginwidth="0" scrolling="no" width="100%" height="300px">
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
				</iframe>
			</div>
				<!-- 动漫排行榜 -->
			<div class="area-side fr" JS-tab="true">
				<iframe frameborder="0" name="indexCartoonRanking" src="${pageContext.request.contextPath}/indexCartoonRanking" marginheight="0" 
					marginwidth="0" scrolling="no" width="100%" height="360px">
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
				</iframe>
				
			</div> 
		</div>
		</section>
		
		<!-- 音乐 -->
		<section class="area clearfix area-game">
		<div class="area-cont">
			<div class="area-main fl">
				<header class="area-header">
				<h2 class="title">
					<img src="images/area-title__8.gif" alt="#"> <b>MTV</b>
				</h2>
				<a href="${pageContext.request.contextPath}/mtv_refresh"  class="change" target="indexMVT"> 
					<i class="iconfont icon-rank"></i>
					换一批
				</a>
				<a href="${pageContext.request.contextPath}/mtv_form" class="more">More ></a> 
				</header>
				
				<iframe frameborder="0" name="indexMVT" src="${pageContext.request.contextPath}/mtv_refresh" marginheight="0" 
					marginwidth="0" scrolling="no" width="100%" height="450px">
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
				</iframe>
				
			</div>
			<div class="area-side fr" JS-tab="true">
				<!-- MTV排行榜 -->
				<iframe frameborder="0" name="indexMTVRanking" src="${pageContext.request.contextPath}/mtv_ranking" marginheight="0" 
					marginwidth="0" scrolling="no" width="100%" height="510px">
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
				</iframe>
			
			</div>
		</div>
		</section>

			
			</div>
	<jsp:include page="./quoteButtom.jsp"/>

	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/sliderbox.js"></script>
	<script src="js/tab.js"></script>
	<script src="js/json2.js"></script>
	<script src="js/jquery-migrate-1.2.1.min.js"></script>
	
</body>
</html>