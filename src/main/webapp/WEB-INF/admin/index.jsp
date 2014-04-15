<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>admin/test</title>
  </head>
  <body>

       this is admin page!
       <form action="${pageContext.request.contextPath}/admin/user/query.do" method="post">
           <c:if test="${not empty loginErrorMessage}">
               <span style="color: red;">${loginErrorMessage}</span><br>
           </c:if>
           <input type="submit" value="submit">
       </form>
  </body>
</html>