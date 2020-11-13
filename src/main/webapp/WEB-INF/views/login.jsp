<%--
  Created by IntelliJ IDEA.
  User: ivar
  Date: 2020-09-16
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jakarta MVC Hello Form</title>
</head>
<body>
<h1>Simple Form</h1>

<form method="post" action="hello">
    <p>
        <label id="name">Name:</label>
        <input type="text" name="name"/>
    </p>
    <p>
        <label id="password">Password:</label>
        <input type="password" name="password" value=""/>
    </p>
    <input type="submit"/>
    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
    <font color="red">${mvc.encoders.html(errors)}</font>
</form>
</body>
</html>