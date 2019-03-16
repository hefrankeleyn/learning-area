<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-11
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%-- 使用Spring的通用模板 --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
    <h1><s:message code="spittr.welcome"></s:message></h1>
<s:url value="/spittles" var="spittlesURL"/>
<s:url value="/spitter/register" var="register"/>

<a href="<s:url value="/spittles"/>">Spittles</a>
<a href="<s:url value="/spitter/register"/>">Register</a>

