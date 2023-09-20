<%@ page import="models.Account" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/20/2023
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>Update Account Information</h1>
    <form action="update" method="post">
        <label>Accouont ID:</label>
        <input type="text" name="id">
        <br />
        <label>Full name:</label>
        <input type="text" name="fullName">
        <br />
        <label>Phone:</label>
        <input type="text" name="phone">
        <br />
        <label>Email:</label>
        <input type="text" name="email">
        <br />
        <br />
        <button type="submit">Update</button>
        <button type="reset">Clear</button>
        <input type="hidden" name="action" value="updateAccount">
    </form>
</body>
</html>
