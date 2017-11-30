<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电  影</title>
<script src="js/jquery.min.js"></script>

</head>
<body>
<jsp:include page="../quoteTop.jsp"></jsp:include>
	
	<iframe id="filmR"  frameborder="0" name="filmResult" src="${pageContext.request.contextPath}/film_result" marginheight="0" 
	marginwidth="0" scrolling="no" width="100%" height="500px" >
		您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
	</iframe>
				
<jsp:include page="../quoteButtom.jsp"></jsp:include>
<script type="text/javascript">


$(function(){
	$("div>a").removeClass('nav-cur');
	$('#film').addClass('nav-item nav-cur');
	
	/* var a = true;
	window.document.getElementById('filmR').onload=function(){
		if(a){
			window.frames["filmResult"].document.getElementById('filmForm').submit();
			a = false;
		}
	} */
	
})

	
	
</script>
</body>
</html>