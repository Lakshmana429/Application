<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    <%
    String firstName = (String) session.getAttribute("firstName");
    String lastName = (String) session.getAttribute("lastName");
    String email = (String) session.getAttribute("email");
    String phoneNumber = (String) session.getAttribute("phoneNumber");
%>
    
    <p>First Name: <%= firstName %></p>
    <p>Last Name: <%= lastName %></p>
    <p>Email: <%= email %></p>
    <p>Phone Number: <%= phoneNumber %></p>
</body>
</html>
