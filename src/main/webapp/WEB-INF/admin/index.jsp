<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>admin/test</title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/cmsUserAction!login.action" method="post">
       this is admin page!
       <br>
       userName:<input name="userName"><br>
       password:<input name="password"> <br>
       <input type="submit" value="submit">
   </form>
  </body>
</html>