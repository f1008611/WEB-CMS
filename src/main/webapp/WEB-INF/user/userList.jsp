<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-3-20
  Time: 上午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
name: <br>
         <c:if test="${not empty cmsUserList}">
              <c:forEach var="cmsUser" items="${cmsUserList}">
                     ${cmsUser.userName}<br>
              </c:forEach>
         </c:if>
</body>
</html>
