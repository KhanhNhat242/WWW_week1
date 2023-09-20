<%@ page import="java.util.List" %>
<%@ page import="models.Account" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/14/2023
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Account Information</h1>
    <table>
        <tr>
            <th>Account Id</th>
            <th>Full name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Status</th>
        </tr>
        <%
            List<Account> accs = (List<Account>) request.getAttribute("accounts");
            for (Account account : accs)    {
        %>
        <tr>
            <td><%= account.getAccount_id() %></td>
            <td><%= account.getFull_name() %></td>
            <td><%= account.getEmail() %></td>
            <td><%= account.getPhone() %></td>
            <td><%= account.getStatus() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <br />
    <a href="update.jsp">Update Account Information</a>
    <br />
    <form action="update" method="post">
        <label>Enter Account ID you want to delete:</label>
        <input type="text" name="deleteId">
        <button type="submit">Delete</button>
        <input type="hidden" name="action" value="delete">
    </form>
</body>
</html>
