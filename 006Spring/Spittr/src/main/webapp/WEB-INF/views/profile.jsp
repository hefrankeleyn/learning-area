<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-12
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <%@ page isELIgnored="false" %>
</head>
<body>
    <c:if test="${spitter!=null}">
        <table>
            <tr>
                <td>
                    <span><c:out value="${spitter.sId}"></c:out></span>
                </td>
                <td>
                    <span><c:out value="${spitter.username}"></c:out></span>
                </td>
                <td>
                    <span>(<c:out value="${spitter.firstName}"></c:out>,<c:out value="${spitter.lastName}"></c:out>)</span>
                </td>
            </tr>
        </table>
    </c:if>


</body>
</html>
