<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
String message=(String)request.getAttribute("message");


if(message!=null)
{%>
	<h1><%=message%></h1>

<%}
%>

 <button onclick= "myFunction()"><a href="Logout.jsp">LogOut</a></button>



<script>
function myFunction() {
    alert("You are Logout");
}

</script>
 



<div align="center">
<h2>Select the option</h2>
<br>
<a href="photo.html"><button>Upload photo</button></a>
<br>
<br>
<button><a href="register.jsp">Register</a></button>
<img alt="" src="http://localhost:8080/uploadUserPhoto/images/upload/user.jpg" width=250px height=300px>

</div>
</body>
</html>