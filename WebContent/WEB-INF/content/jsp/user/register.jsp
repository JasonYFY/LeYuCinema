<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注 册</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="font/iconfont.css">
<script type="text/javascript">
      var errori ='<%=request.getAttribute("errorA")%>';
      if(errori=='yes'){
         alert("注册失败!");
      }else if(errori=='no'){
    	  var is = confirm("注册成功!是否跳转到登录页？");
    	  if(is){
    		  window.location.href="${pageContext.request.contextPath}/login_form"
    	  }
      }
</script>
</head>
<body>
	<div id="login">
		<h2><i style="font-size:30px" class="iconfont icon-zhuce"></i>&nbsp;注&nbsp;&nbsp;册</h2>
		<form action="${pageContext.request.contextPath}/add_user" method="POST">
			<fieldset>

				<p><label for="username">用户名</label></p>
				<p><input type="text" name="name" id="text" required="true"  placeholder="请输入您的账号"></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->

				<p><label for="username">昵 称</label></p>
				<p><input type="text" name="nickName" id="text" required="true"  placeholder="请输入您的昵称"></p>
				
				<p><label for="password">密 码</label></p>
				<p><input type="password" name="pass" id="password" required="true" placeholder="请输入您的密码"></p> <!-- JS because of IE support; better: placeholder="password" -->

				<p><label for="username">地 址</label></p>
				<p><input type="text" name="address" id="text" required="true"  placeholder="请输入您的地址"></p>
				
				<p>
					<div style="text-align:center;margin-top:30px">
					<input type="submit" value="注 册">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/index_form"><input type="button" value="返 回"></a>
					</div>
				</p>

			</fieldset>

		</form>

	</div> 
</body>
</html>