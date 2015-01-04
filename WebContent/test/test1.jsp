<%@page import="java.util.ArrayList,com.mgang.page.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="mg" uri="/WEB-INF/MgPage.tld" %>
<!DOCTYPE html>
<html>
	<head>
		<title>MgPage的测试一</title>
	</head>
	<body>
		<%
			ArrayList data = new ArrayList();
			data.add("xiaogang");
			data.add("xiaoqiang");
			data.add("xiaoyao");
			data.add("xiaowen");
			
			Page p = new Page();
			p.setList(data);
			request.setAttribute("page", p);
		%>
		<mg:page list="${page.list }">
			
		</mg:page>

		
	</body>
</html>