<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>播 放</title>
<link type="text/css" rel="stylesheet" href="css/demo.css">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	/* function check(){
		var name = document.getElementById("userName").value;
		var content = document.getElementById("conBox").value;
		if(name==null || name==''){
	        alert("请先登录！");
	        return false;
		}else if(content==null||content==''){
			alert("内容不能为空！");
	        return false;
		}
		return true;
	} */
	$(function(){
		window.document.getElementById('comm').onload=function(){
			var name = document.getElementById('movieIdOther').value;
			window.frames["comment"].document.getElementById('movieIdOther').value=name;
		}
		
	})
</script>
</head>
<body style="background:#f0f0f0;">
	<jsp:include page="../quoteTop.jsp"></jsp:include>

		<div id="site">
			<div id="videoBox" class="box" style="width:800px">
				<video width="500" height="444.5px" controls>
					<source src="<s:property value="nowMovie.filepath"/>" type="video/mp4" /> 
					你的浏览器不支持 HTML5 video
				</video>
			</div>

			<!-- 点赞 -->
		<div class="praise" style="margin-left: 5px;margin: 10px">
			<span id="praise" ><img src="images/zan.png" id="praise-img" /></span>
			<span id="praise-txt">
				<s:if test="nowMovie.goodCount==null">0</s:if>
				<s:else><s:property value="nowMovie.goodCount"/></s:else>
			</span>
			<span id="add-num"><em>+1</em></span>
		</div>
		<font size="+1" color="gray">
			片名：<s:property value="nowMovie.mvName"/><br>
			上传者：<s:property value="nowMovie.uploader.nickName"/><br>
			标签：<s:property value="nowMovie.label"/><br>
			内容介绍：<s:property value="nowMovie.mvDesc"/><br>
		</font>
		</div>
		 <s:hidden id="movieIdOther" value="%{nowMovie.id}" />

    
    <iframe id="comm"  frameborder="0" name="comment" src="${pageContext.request.contextPath}/commentForm" marginheight="0" 
				marginwidth="0" scrolling="no" width="100%" height="650px" >
					您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。
	</iframe>
    

<jsp:include page="../quoteButtom.jsp"/>

	<script src="js/jquery.min.js" type="text/javascript"></script>
	
	<script src="js/script.js"></script>
  <script src="js/sliderbox.js"></script>
  <script src="js/tab.js"></script>
 <%--  <script src="js/comment.js"></script> --%>
 <script>
	/* @author:Romey
	 * 动态点赞
	 * 此效果包含css3，部分浏览器不兼容（如：IE10以下的版本）
	*/
	$(function(){
		$("#praise").click(function(){
			var praise_img = $("#praise-img");
			var text_box = $("#add-num");
			var praise_txt = $("#praise-txt");
			var num=parseInt(praise_txt.text());
			var movieId = document.getElementById('movieIdOther').value;
			
			$(this).html("<img src='images/yizan.png' id='praise-img' class='animation' />");
			praise_txt.addClass("hover");
			text_box.show().html("<em class='add-animation'>+1</em>");
			$(".add-animation").addClass("hover");
			/* num +=1;
			praise_txt.text(num) */
			$.ajax({
                url : "./do_like",
                type : 'post',
                data : {id:movieId,goodCount:num},
                dataType : 'json',
                success : function(data){
                  	praise_txt.text(data.goodCount);
                  	if(data.goodCount==num){
                  		alert("请勿重复点赞！");
                  	}
                },
                error : function() {
                    alert("请求失败")
                }
            })
			
		});
	})
</script>
</body>
</html>