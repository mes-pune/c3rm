<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/c3rm.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List containers</title>
</head>
<body>
	<h1>Microservice Manager</h1>
	<div style="width:300px;">
	<table cellspacing="1" cellpadding="1">
		<tr>
			<td><input type="button" class="button" onclick="location.href='AddContainer.html';" value="Add" /></td>
		</tr>
	</table>
	</div>
	<div class="datagrid">
		<table>
			<thead>
				<tr>
					<th>Select</th>
					<th>Name</th>
					<th>Image</th>
					<th>Used CPU(%)</th>
					<th>Used Memory(MB)</th>
					<th>Available Memory(MB)</th>
					<th>Total Memory(MB)</th>
					<th>IP Address</th>
					<th>MAC Address</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>			
			<tbody>	
				<c:forEach items="${containers}" var="p">
					<tr>
						<td><input type="checkbox" name="selectbox" value="${p.id}"></td>
						<td><c:out value="${p.name}" /></td>
						<td><c:out value="${p.imageName}" /></td>
						<td><c:out value="${p.cpuPercent}" /></td>
						<td><c:out value="${p.usedMemory}" /></td>
						<td><c:out value="${p.availableMemory}" /></td>
						<td><c:out value="${p.totalMemory}" /></td>
						<td><c:out value="${p.ipAddress}" /></td>
						<td><c:out value="${p.macAddress}" /></td>
						<td>
							<c:choose>
								<c:when test="${p.running}">
									Started
								</c:when>
								<c:otherwise>
									Stopped
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="/res-web?action=remove&id=<c:out value='${p.id}'/>">Remove</a>
							<c:choose>
								<c:when test="${p.running}">
									<a href="/res-web?action=stop&id=<c:out value='${p.id}'/>">Stop</a>
								</c:when>
								<c:otherwise>
									<a href="/res-web?action=start&id=<c:out value='${p.id}'/>">Start</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>				
		</table>
	</div>
</body>
</html>