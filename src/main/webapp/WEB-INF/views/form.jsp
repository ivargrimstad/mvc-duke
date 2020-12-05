<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jakarta MVC Hello Form</title>
</head>
<body>
<h1>Simple Form</h1>

<form method="post" action="hello">
    Name: <input type="text" name="name"/>
    <input type="submit"/>
    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
    <font color="red">${mvc.encoders.html(errors)}</font>
</form>
</body>
</html>
