<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prova 1</title>
<%@ page import="java.util.ArrayList"%>
</head>
<body>
<%
	String n = (String)request.getSession().getAttribute("usuario");
%>
	
	<h1>Bem vindo <% out.print(n); %>!</h1>
	
	<br />
	<b>Acesso restrito!!!</b>



	

<form>
    <a href="./logout">
        <input type="button" value="logout">
    </a>
</form>
    	
    

			
			
</body>


</html>