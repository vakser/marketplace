<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<h1><%= "Welcome to marketplace!" %></h1>
<br/>
<ul>
    <li><a href="<c:url value='/customers' />">Customers</a></li>
    <li><a href="<c:url value='/products' />">Products</a></li>
</ul>
</body>
</html>