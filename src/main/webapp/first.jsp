<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! String message = null;%>
<% if(message !=null){ %>
	<%= message %>
<% }else{ %>
	<%= "the value is null so koushik is printing this" %>
<%} %>


</body>
</html>