<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h3>List of customers</h3>
<br/>
<ul>
    <c:forEach items="${customers}" var="customer">
        <li>${customer.firstName} ${customer.lastName} (amount of money $${customer.moneyAmount})</li>
    </c:forEach>
</ul>
<br/>
<br/>
<a href="<c:url value='/' />">Main menu</a>
</body>
</html>
