<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>test</title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/admin/cmsUserAction!login.action" method="post">
       userName:<input type="text" name="userName"><br>
       password:<input type="password" name="password"> <br>
       <c:if test="${not empty loginErrorMessage}">
          <span style="color: red;">${loginErrorMessage}</span><br>
       </c:if>

       <input type="submit" value="submit">
   </form>
  </body>
</html>