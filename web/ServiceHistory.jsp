<%-- 
    Document   : ServiceHistory
    Created on : Mar 7, 2023, 9:46:15 PM
    Author     : Muhammad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Service History</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="icon" href="./resources/history-icon.png">
</head>
<body>
<div class="back">
        <a href="/Services/Services.jsp"></a>
    </div>
  <div class="heading">
        Previous Services
    </div>

    <div class="servicesavatar"></div>

    <div class="prevservices">
        <table>
            <tr>
                <th>Date & Time</th>
                <th>Service</th>
                <th>Address</th>
                <th>Service Status</th>
                <th>Total Cost</th>
            </tr>
           <%
    List<List<String>> history = (List<List<String>>)request.getAttribute("History");
    for (List<String> row : history) {
%>
    <tr>
        <td><%=row.get(0)%></td>
        <td><%=row.get(1)%></td>
        <td><%=row.get(2)%></td>
        <td><%=row.get(3)%></td>
        <td><%=row.get(4)%></td>
    </tr>
<%
    }
%>

  
        </table>

    </div>
</body>
</html>