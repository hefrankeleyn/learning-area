<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-12
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
    <%@ page isELIgnored="false" %>
</head>
<body>
    <h1>Register</h1>
    <form method="POST" enctype="multipart/form-data">
        First Name: <input type="text" name="firstName"/><br/>
        Last Name: <input type="text" name="lastName"/><br/>
        Username: <input type="text" name="username"/><br/>
        Password: <input type="text" name="password"/><br/>
        <label>Profile Picture:</label>
        <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif"/><br/>

        <input type="submit" value="Register"/>
    </form>
</body>
</html>
