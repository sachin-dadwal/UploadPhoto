<html>
<body>
<%@page import="java.util.*" %>

<%
response.setHeader("Cache-Control", "no-cache,no-store,private,must-reavalidate,max-stale=0,post-check=0,pre-check=0");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires","0");%>
<%session.invalidate();
//request.getRequestDispatcher("login.jsp").forward(request, response);
%>
 You have logged out. Plese
<a href="login.jsp"><b>Login</b></a> 

</body>
</html>