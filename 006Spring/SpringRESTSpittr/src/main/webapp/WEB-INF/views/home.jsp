<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 使用Spring的通用模板 --%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Spitter</h1>

    <%--<a href="<c:url value="/spittles" />">Spittles</a> | --%>
    <a href="<c:url value="/spitters.json" />">find all spitters</a><br/>
    <a href="<c:url value="/spitters/findSpitterById" />">find one ById</a>
  </body>
</html>
