<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-23
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spizza</title>
</head>
<body>
    <h2>Thank you for your order!</h2>
    <%--文本中包含“<"或“&”最好将其放到CDATA中，放到CDATA中的文本会被解析器忽略--%>
    <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
</body>
</html>
