<%@page import="com.mes.c3rm.resources.ResourceManagerImpl"%>
<%@page import="com.mes.c3rm.common.resources.ResourceManager"%>
<%@page import="com.mes.c3rm.common.model.ContainerModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		ContainerModel containerModel = new ContainerModel();
		containerModel.setName(name);
		
		ResourceManager resourceManager = new ResourceManagerImpl();
		resourceManager.createContainer(containerModel);
	%>

</body>
</html>