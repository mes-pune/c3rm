<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mes.c3rm.resources.ResourceManagerImpl"%>
<%@page import="com.mes.c3rm.common.resources.ResourceManager"%>
<%@page import="com.mes.c3rm.common.model.ContainerModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List containers</title>
</head>
<body>
	<div style="width:300px;">
	<table cellspacing="1" cellpadding="1">
		<tr>
			<td><a href="AddContainer.html">Add</a></td>
			<td><a href="remove">Remove</a></td>
		</tr>
	</table>
	</div>
	<div style="width:300px;">
		<table cellspacing="1" cellpadding="1">
			<tr>
				<td>Select</td>
				<td>Name</td>
				<td>Image</td>
				<td>Type</td>
				<td>CPU(MHz)</td>
				<td>Memory(MB)</td>
				<td>Storage(MB)</td>
				<td>Status</td>
				<td>Action</td>
			</tr>
		<c:forEach items="${containers}" var="p">
			<tr>
				<td><input type="checkbox" name="selectbox" value="${p.id}"></td>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.imageName}" /></td>
				<td><c:out value="${p.instanceType}" /></td>
				<td><c:out value="${p.cpu}" /></td>
				<td><c:out value="${p.memory}" /></td>
				<td><c:out value="${p.storage}" /></td>
				<td><c:out value="${p.status}" /></td>
				<td>
					<a href="stop?id=${p.id}">Stop</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>