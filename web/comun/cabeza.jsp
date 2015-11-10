<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=request.getParameter("title")%></title>
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="css/comun.css" media="screen" />
        <script type="text/javascript" src="js/comun.js"></script>
<% 
    String includes[]=request.getParameterValues("include");
    for(String include:includes){
%>
        <link rel="stylesheet" type="text/css" href="css/<%=include%>.css" media="screen" />
        <script type="text/javascript" src="js/<%=include%>.js"></script>
<%
    }
%>
    </head>
    <body>