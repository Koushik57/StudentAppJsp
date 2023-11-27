<%@page import="studentWithJsp.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%List<Student> students = (List)request.getAttribute("list"); %>


<table border="2px">
<tr>
<td>Id</td>
<td>Name</td>
<td>Email</td>
<td>Password</td>
<td>Address</td>
<td>Phone</td>
<td>Course</td>
<td>fees</td>
</tr>

<% for(Student student:students){%>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getPassword() %></td>
<td><%=student.getAddress() %></td>
<td><%=student.getPhone() %></td>
<td><%=student.getCourse() %></td>
<td><%=student.getFees() %></td>
<td><a href="delete?id=<%= student.getId() %>">Delete</a></td>
<td> <a href="update?id=<%= student.getId() %>">Update</a></td>
</tr>

<%} %>





</table>
</body>
</html>