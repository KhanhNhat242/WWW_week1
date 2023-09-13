<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form action="ControllerServlet" method="post">
    <label>ID:</label>
    <input name="id" type="text" />
    <br />
    <label>Full name:</label>
    <input name="fullName" type="text" />
    <br />
    <label>Password:</label>
    <input name="password" type="text" />
    <br />
    <label>Email:</label>
    <input name="email" type="text" />
    <br />
    <label>Phone:</label>
    <input name="phone" type="text" />
    <br />
    <label>Status:</label>
    <input name="status" type="text" />
    <br />
    <button type="submit">Add</button>
</form>

</body>
</html>