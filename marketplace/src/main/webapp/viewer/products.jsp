<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>List of products</h3>
<br/>
<ul>
    <c:forEach items="${products}" var="product">
        <li>${product.name} (price $${product.price}) <a href="<c:url value='/product?id=${product.id}' />">Buy</a></li>
    </c:forEach>
</ul>
<br/>
<br/>
<a href="<c:url value='/' />">Main menu</a>
</body>
</html>
