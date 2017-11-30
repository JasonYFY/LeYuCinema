<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上 传</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="font/iconfont.css">
<script type="text/javascript">
      var errorl ='<%=request.getAttribute("errorU")%>';
      if(errorl=='yes'){
    	  alert("上传失败！");
      }else if(errorl=='no'){
    	  alert("上传成功！");
      }
</script>
</head>
<body>

	<div id="login" style="width:40%;">

		<h2><i style="font-size:30px" class="iconfont icon-upload"></i>&nbsp;上&nbsp;&nbsp;传</h2>

		<s:form action="upload_file" method="POST" enctype="multipart/form-data">

			<fieldset>
				<p><label for="username">视频名称：</label><input type="text" name="mvName" id="text" required="true" maxlength="20" /></p> 

				<p style="line-height:30px;">
					<label style="float:left" for="username" >视频描述：</label>
					<textarea id="text" name="mvDesc" required="true" ></textarea>
				</p>
				
				<p>
					<label for="username" style="margin-left:27px">标 签：</label>
					<input type="text" name="label" id="text" required="true" />
				</p>
				
				<p>
					<label for="username" style="margin-left:27px">类  型：</label>
					<s:select list="categoryList" name="categoryId" listKey="id" listValue="categoryName"
					 style="width:125px;height:30px"	headerValue="--请选择类型--" headerKey="" required="true" />
				</p>
				<font color="red">
					<s:fielderror fieldName="uploadFile" />
				</font>
				<p>
					<label for="password" style="margin-left:27px">
						文  件：
					</label>
					<s:file name="uploadFile" id="password" required="true" />
					<!-- <input type="file" name="uploadFile" id="password" required="true" /> -->
				</p>
				<font color="red">
					<s:fielderror fieldName="uploadPic" />
				</font>
				<p>
					<label for="password" style="margin-left:15px"> 缩略图：</label>
					<input type="file" name="uploadPic" id="password" required="true" />
				</p>
				
				<p>
					<div style="text-align:center;margin-top:30px">
					<input type="submit" value="上 传">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/index_form"><input type="button" value="返 回"></a>
					</div>
				</p>

			</fieldset>

		</s:form>

	</div>
</body>
</html>