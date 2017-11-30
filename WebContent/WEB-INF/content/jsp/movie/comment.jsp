<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function toPage(pageIndex)
  	{
  		$("#pageIndex").attr("value",pageIndex);
  	    $("#commentForm").attr("onsubmit", "");
  		$("#commentForm").submit();
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
  	 	 	$("#commentForm").attr("onsubmit", "");
   	    	$("#commentForm").submit();
   		}
  	}

	function check(){
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
	}
</script>
</head>
<body style="background:#f0f0f0;">
<jsp:include page="../import.jsp"></jsp:include>
<!-- <div id="msgBox" style="margin-left: 10px"> -->
<div id="msgBox">
   
        <font size="+2">评 论 区</font>
		
        <div>
            <s:hidden id="userName" name="name" class="f-text" value="%{#session.nowUser.name}" />
            <p id="face"><img style="display:none;" src="img/face1.gif" class="current" /></p>
        </div>
        	<!-- 电影id -->
        <s:form id="commentForm" action="insert_comment"  onsubmit="return check()" >
        <s:hidden id="movieIdOther"  name="movieIdOther" value="" />
        <s:hidden name="pageModel.pageIndex" id="pageIndex" />
        <div><textarea id="conBox" name="content" class="f-text" ></textarea></div>
        <div class="tr">
            <p>
                <%-- <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span> --%>

                <input id="sendBtn" type="submit" value="发 布" />
            </p>
        </div>
        </s:form>
<div class="list">
        <h3><span>全部评论</span></h3>
        <ul>
        	<s:if test="commentList.size==0">
        		<br/><br/>
        		<font style="color: gray;" size="+1">暂无评论</font>
        	</s:if>
        	<s:else>
        		<s:iterator value="commentList" var="comment">
        		<li>
	                <div class="userPic"><img src="img/face.gif" /></div>
	                <div class="content">
	                    <div class="userName"><s:property value="#comment.creator.nickName" />：</div>
	                    <div class="msgInfo"><s:property value="#comment.content" /></div>
	                    <div class="times"><span><s:date name="#comment.createDate" format="yyyy年MM月dd日  HH:mm"/></span><!-- <a class="del" href="javascript:;">删除</a> --></div>
	                </div>
            	</li>
            	</s:iterator>
        	</s:else>
        </ul>
        <!-- 分页处理 -->
<s:if test="commentList.size!=0">
<table style="width: 100%;height: 80px;font-size: 13px">
	<tr>
		<td style="text-align: right;width: 100%;padding-top: 25px">
			总页数:${pageModel.totalPageSum}&nbsp;
			<c:choose>
				<c:when test="${pageModel.pageIndex==1}">
					<span class='disabled'>上一页</span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a style="display: inline;color: blue;" href='#' onclick="toPage(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='current'><a style="display: inline;color: blue;" href='#'
						onclick="toPage(${pageModel.pageIndex+1})">下一页</a></span>
				</c:when>
				<c:when test="${pageModel.pageIndex==pageModel.totalPageSum}">
					<span class='current'><a style="display: inline;color: blue;" href='#'
						onclick="toPage(${pageModel.pageIndex-1})">上一页</a></span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a style="display: inline;color: blue;" href='#' onclick="toPage(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='disabled'>下一页</span>
				</c:when>
				<c:otherwise>
					<span class='current'><a style="display: inline;color: blue;" href='#' onclick="toPage(${pageModel.pageIndex-1})" >上一页</a></span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a style="display: inline;color: blue;" href='#' onclick="toPage(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='current'><a style="display: inline;color: blue;" href='#'
						onclick="toPage(${pageModel.pageIndex+1})">下一页</a></span>
				</c:otherwise>
			</c:choose> <!-- &nbsp;跳转到&nbsp;
			<input type="text" id="pager_jump_page_size" style='text-align: center; width:43px;height:19px;border:groove;'/> &nbsp;
			<input type="button" style='text-align: center;border:groove;background:silver;padding: 0 5px' value='确定' id='pager_jump_btn' onclick="pagerJump()"/> -->
		</td>
	</tr>
</table>
</s:if>
    </div>
   </div>
    <script src="js/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	
	<script src="js/script.js"></script>
  <script src="js/sliderbox.js"></script>
  <script src="js/tab.js"></script>
  <%-- <script src="js/comment.js"></script> --%>
</body>
</html>