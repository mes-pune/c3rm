
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="gray">
			<h1 align="center">Welcome to the World Of MicroServices</h1>
			<h2 align ="center">Please fill the following Details</h2>
            <center>
  			<form method="post" action="index.jsp">
					<b>Name of Container:</b>
					&nbsp;&nbsp;
					<input type="text" name="containerName" />
					<br>
					<br>
					<b>Instance Type:</b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name=instanceType>
						<option>High</option>
						<option>Medium</option>
						<option>Low</option>
					</select>
					<br>
					<br>
					<b>CPU % :</b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name=cpu>
						<option>10</option>
						<option>50</option>
						<option>60</option>
					</select>
					<br>
					<br>
					<b>Memory:</b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name=memory>
						<option>128</option>
						<option>256</option>
						<option>512</option>
					</select>
					<br>
					<br>
					<b>Storage:</b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name=storage>
						<option>1</option>
						<option>5</option>
						<option>10</option>
					</select>
					<br>
					<br>
					<b>Image Name:</b>
					<input type="text" name="imageName" size="15" />
					<br>
					<br>
					<input type="submit" name="submit" value="Submit" />
			 </form>
		   </center>
	       </body>
</html>