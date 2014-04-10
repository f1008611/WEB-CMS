<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>test</title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/admin/cmsUserAction!login.action" method="post">
       userName:<input type="text" id="loginName" name="loginName"><br>
       password:<input type="password" id="password" name="password"> <br>
       <c:if test="${not empty loginErrorMessage}">
          <span style="color: red;">${loginErrorMessage}</span><br>
       </c:if>
       <input type="submit" value="submit">
   </form>
  </body>
</html>
