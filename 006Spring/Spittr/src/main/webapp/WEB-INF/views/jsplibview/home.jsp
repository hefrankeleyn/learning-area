<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-11
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%-- 使用Spring的通用模板 --%>
<%@ page session="false" %>
    <h1><s:message code="spittr.welcome"></s:message></h1>
    <s:url value="/spittles/spittles2" var="spittlesURL"/>
    <s:url value="/spitter/register2" var="registerURL"/>
    <a href="${spittlesURL}">Spittles</a>
    <a href="${registerURL}">Register</a>

