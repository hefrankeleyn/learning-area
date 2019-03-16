<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-11
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 使用Spring的通用模板 --%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html lang="zh">
<head>
    <title><s:message code="spittr.welcome"/></title>
</head>
<body>
    <h1><s:message code="spittr.welcome"></s:message></h1>
    <a href="<c:url value="/spittles" />">Spittles</a>
    <a href="<c:url value="/spitter/register"/> ">Register</a>
</body>
</html>
