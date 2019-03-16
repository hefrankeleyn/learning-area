<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-12
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:if test="${spittleList!=null}">
        <ul>
            <c:forEach items="${spittleList}" var="spittle">
                <li id="spittle_<c:out value="spittle.id"/>">
                    <div class="spittleMessage">
                        <c:out value="${spittle.message}"></c:out>
                    </div>
                    <div>
                        <span class="spittleTime"><c:out value="${spittle.time}"></c:out></span>
                        <span class="location">
                        (<c:out value="${spittle.latitude}"></c:out>,<c:out value="${spittle.longitude}"></c:out>)
                    </span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </c:if>
