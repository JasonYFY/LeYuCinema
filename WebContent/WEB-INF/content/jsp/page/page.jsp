<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 分页处理 -->
<table style="width: 100%;height: 80px;font-size: 14px">
	<tr>
		<td style="text-align: center;width: 100%;padding-top: 25px">
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
			</c:choose> &nbsp;跳转到&nbsp;
			<input type="text" id="pager_jump_page_size" style='text-align: center; width:43px;height:19px;border:groove;'/> &nbsp;
			<input type="button" style='text-align: center;border:groove;background:silver;padding: 0 5px' value='确定' id='pager_jump_btn' onclick="pagerJump()"/>
		</td>
	</tr>
</table>
</body>
</html>