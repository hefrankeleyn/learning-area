<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-04-21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
    <%@ page isELIgnored="false" %>
</head>
<body>
<div>
    <ul>
        <c:forEach items="${spitterList}" var="spitter">
            <li>
                <c:out value="${spitter.username}" /><br/>
                <c:out value="${spitter.fullName}" /><br/>
                <c:out value="${spitter.email}" />
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
