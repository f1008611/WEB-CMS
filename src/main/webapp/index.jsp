<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>test</title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/admin/cmsUserAction!login.action" method="post">
       userName:<input name="userName"><br>
       password:<input name="password"> <br>
       <input type="submit" value="submit">
   </form>
  </body>
</html>