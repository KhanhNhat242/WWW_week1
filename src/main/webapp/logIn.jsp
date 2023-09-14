<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/14/2023
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
  <form action="log-in" method="post">
    <label>Account Id:</label>
    <input type="text" name="account_id">
    <br />
    <label>Password:</label>
    <input type="text" name="password">
    <br />
    <button type="submit">Log in</button>\
    <button type="reset">CLear</button>
  </form>
</body>
</html>
