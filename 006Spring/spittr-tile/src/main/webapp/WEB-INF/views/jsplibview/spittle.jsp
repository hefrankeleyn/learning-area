<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-12
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:if test="${spittle!=null}">
        <table>
            <tr>
                <td>
                    <span><c:out value="${spittle.id}"></c:out></span>
                </td>
                <td>
                    <span><c:out value="${spittle.message}"></c:out></span>
                </td>
                <td>
                    <span><c:out value="${spittle.time}"></c:out></span>
                </td>
                <td>
                    <span>(<c:out value="${spittle.latitude}"></c:out>,<c:out value="${spittle.longitude}"></c:out>)</span>
                </td>
            </tr>
        </table>
    </c:if>

