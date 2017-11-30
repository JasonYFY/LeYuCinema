<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.min.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="font/iconfont.css">
	<link rel="stylesheet" href="css/comment.css">
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
     

    function toPage(pageIndex)
  	{
  		$("#pageIndex").attr("value",pageIndex);
  	    <%-- $("#movieForm").attr("action", "<%=request.getContextPath()%>/user_query"); --%>
  		$("#filmForm").submit();
  	}
  	
  	function pagerJump()
  	{
  		
  		var page_size=$('#pager_jump_page_size').val();
  		
   		var regu = /^[1-9]\d*$/;
   			
   		if (!regu.test(page_size)||page_size < 1 || page_size >${pageModel.totalPageSum})
   		{
   			alert('请输入[1-'+ ${pageModel.totalPageSum} +']之间的页码！');	
   		}else
   		{
  	 		$("#pageIndex").attr("value",page_size);
   	       <%--  $("#movieForm").attr("action", "<%=request.getContextPath()%>/user_query"); --%>
   	    	$("#filmForm").submit();
   		}
  	}

</script>
</head>
<body>

<section class="area clearfix area-recommend" style="margin: 10px 30px;"> 
				<header class="area-header">
					<h2 class="title">
						<img src="images/dianying.png" alt=""> <b>电  影</b>
					</h2>
					<%-- <span href="#" class="more" style="margin-right: 24%;">
						<font size="+1">共找到<s:property value="count"/>条</font>
					</span> --%>
				</header>
				<s:form action="film_result" id="filmForm">
					<s:hidden name="pageModel.pageIndex" id="pageIndex" />
				</s:form>
	<div class="area-cont">
		<div class="area-main fl" style="height: 500px">
			<ul class="area-menu fl clearfix">
							
					<!-- 遍历显示 -->
					<s:iterator value="filmList" var="item" status="i">
						<li class="area-menu__item" >
							<s:url action="play_form" var="play">
			                    		 	<s:param name="id"><s:property value="#item.id"/></s:param>
							</s:url>
							<s:a href="%{#play}" class="img" target="_top"> 
								<img id="filmImg<s:property value="#i.index" />" src="<s:property value="#item.filepic" />" alt=""> 
								<span class="mask"> <em class="time">4:47</em></span>
							</s:a>
							<div class="info" style="height: 90px">
								<font size="2px" class="title"><s:property value="#item.mvName" /></font><br> 
								<font class="userName">UP主:<s:property value="#item.uploader.nickName" /><br>
									播放:<s:property value="#item.playTimes" /><br>
									发布:<s:date name="#item.createDate" format="yyyy-MM-dd"/>
								</font>
							</div>
						</li>
					</s:iterator>
			</ul>
			
			<jsp:include page="../page/page.jsp"></jsp:include>
		</div>
	</div>
</section>
</body>
</html>