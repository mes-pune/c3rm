	<html>
		<h2>
		<center>
			<marquee align="top" bgcolor="red">
				Welcome to the World of Containers
			</marquee>
		</center><br><br>
		</h2>
		<element>
			<body bgcolor="green">
				<form method="post">
					<table align="center">
						<tr>
							<th align="left">
								<a href="form1.jsp">
									<input type="button" name="add1"
										value="Host/Add"></a>
							</th>
							<th align="center">
								Start/Stop
								<select name=cmstate>
									<option>Start</option>
									<option>Stop</option>
								</select>
							</th>
							<th align="right">
								<input type="button" name="del1"
									value="Delete/Remove"></th>
						</tr>
					</table>
					<table border=2 width=50 height=50 align="center"
						cellpadding=5 cellspacing=2>
						<tr>
							<th>ContainerId</th>
							<th>Name of Container</th>
							<th>Instance Type</th>
							<th>CPU(%)</th>
							<th>Memory</th>
							<th>Storage</th>
							<th>IP Address</th>
							<th>Status</th>
							<th>Image Name</th>
						</tr>
						<tr rowspan=2>
							<td>34875njfddkv</td>
							<td>
						<%= request.getParameter("containerName") %> 
							
                              </td>
							<td>
								<%
									out.println(request.getParameter("instanceType"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("cpu"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("memory"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("storage"));
								%>
							</td>
							<td>null</td>
							<td>null</td>
							<td>
								<%
									out.println(request.getParameter("imageName"));
								%>
							</td>
						</tr>
						<tr rowspan=2>
							<td>2365gbvcjje</td>
							<td>
								<%
									out.println(request.getParameter("containerName"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("instanceType"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("cpu"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("memory"));
								%>
							</td>
							<td>
								<%
									out.println(request.getParameter("storage"));
								%>
							</td>
							<td>null</td>
							<td>null</td>
							<td>
								<%
									out.println(request.getParameter("imageName"));
								%>
							</td>
						</tr>
						<!--  <tr>
							<td>null</td>
							<td><% out.println(request.getParameter("uname")); %></td>
							<td><% out.println(request.getParameter("cminst"));%></td>
							<td><% out.println(request.getParameter("cmcpu")); %></td>
							<td><% out.println(request.getParameter("cmmem")); %></td>
							<td><% out.println(request.getParameter("cmstor"));%></td>
							<td>null</td>
							<td>null</td>
							<td><% out.println(request.getParameter("imgname")); %></td>
							</tr>
							!-->

					</table>

				</form>
		</body>
		</element>
	</html>
