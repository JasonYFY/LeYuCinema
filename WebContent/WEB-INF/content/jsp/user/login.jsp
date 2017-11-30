<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登 录</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="font/iconfont.css">
<script type="text/javascript">
    var errorl ='<%=request.getAttribute("errorL")%>';
    if(errorl=='yes'){
    	alert("登录失败!用户名或密码错误！");
    }
    var msg = '<%=session.getAttribute("notLogin")%>';
  	if(msg!='null'){
  		  alert(msg);
  		  <%session.removeAttribute("notLogin");%>
  	}
</script>
</head>
<body>
	<div id="login">

		<h2>
			<i style="font-size: 30px" class="iconfont icon-denglu"></i>&nbsp;登&nbsp;&nbsp;录
		</h2>

		<form action="${pageContext.request.contextPath}/login_user" method="POST">

			<fieldset>

				<p>
					<label for="username">用户名</label>
				</p>
				<p>
					<s:textfield id="text" name="name" required="true" placeholder="请输入您的账号" />
				</p>
				<!-- JS because of IE support; better: placeholder="mail@address.com" -->

				<p>
					<label for="password">密 码</label>
				</p>
				<p>
					<input type="password" id="password" required="true" name="pass"
						placeholder="请输入您的密码" />
				</p>

				<p>
				<div style="text-align: center; margin-top: 30px">
					<s:submit value="登 录" />&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="${pageContext.request.contextPath}/index_form"><input type="button" value="返 回" ></a>
				</div>
				</p>

			</fieldset>

		</form>

	</div>
</body>
</html>