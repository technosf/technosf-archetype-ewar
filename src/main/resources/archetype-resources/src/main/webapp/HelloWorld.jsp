#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="${package}.MyApp"%>
<jsp:useBean id="myapp" class="${package}.MyApp" scope="application" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>Hello World</title>
<link href="favicon.ico" type="image/x-icon" rel="icon">
<link rel="stylesheet" href="style.css">
<script src="webjars/jquery/${jquery.version}/jquery.js" type="text/javascript"></script>
<script src="webjars/jquery-cookie/${jquery-cookie.version}/jquery.cookie.js" type="text/javascript"></script>
</head>
<body>
  <div id="heading">
    <h1>Hello World</h1>
    The date is ${myapp.helloDate}
  </div>
</body>
</html>
