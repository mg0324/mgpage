<%@page import="java.util.ArrayList,com.mgang.page.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="mg" uri="http://room.mgang.util.page" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>MgPage的测试一</title>
		<link href="${pageContext.request.contextPath}/css/mg-page.1.0.css" type="text/css" rel="stylesheet"/>
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
			p.paging(1, 1, 4);
			request.setAttribute("page", p);
		%>
		<!-- 显示数据 -->
		<c:forEach items="${page.list }" var="p">
			${p }<br/>
		</c:forEach>
		<!-- 显示分页导航 -->
		<mg:page page="${page }" url="${pageContext.request.contextPath}/xx.do?action=toDo">
			
		</mg:page>
	</body>
</html>