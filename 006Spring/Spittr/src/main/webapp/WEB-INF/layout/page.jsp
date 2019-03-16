<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-14
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spittr</title>
    <%@ page session="false" %>
    <%@ page isELIgnored="false" %>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/registerForm.css">
</head>
<body>
<div id="header">
<t:insertAttribute name="header" />
</div>
<div id="body">
<t:insertAttribute name="body" />
</div>
<div id="footer">
<t:insertAttribute name="footer" />
</div>
</body>
</html>
