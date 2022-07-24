<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bought items info </title>
    <style>table, td {border:1px solid green;}</style>
</head>
<body>
    <a href='products'>Product List</a>
    <h2>Shopping info</h2>
    <c:if test="${cart != null}" >
        <table>
            <tr>
                <td>Product</td>
                <td>Buyer(s)</td>
            </tr>
            <tr>
                <c:forEach items="${cart}" var="item">
                    <td>${item.product.name}</td>
                    <td>${item.buyers}</td>
                </c:forEach>
            </tr>
        </table>
    </c:if>
</body>
</html>
