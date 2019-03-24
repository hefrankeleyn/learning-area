<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-23
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spizza</title>
</head>
<body>
    <h2>Deliery Unavailable</h2>
    <p>
        The address is outside of our delivery area. You may
        still place the order, but you will need to pick it up
        yourseld.
    </p>
    <a href="${flowExecutionUrl}&_eventId=accept">Accept</a> |
    <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
</body>
</html>
