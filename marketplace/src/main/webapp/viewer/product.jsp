<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping</title>
</head>
<body>
<h3>Shopping details</h3>
<form method="post" action="cart">
<table>
    <tr>
        <td>Product: </td>
        <td>${item.product.getName()}</td>
    </tr>
    <tr>
        <td>User ID: </td>
        <td>
            <input type='hidden' name='id' value="${item.product.id}" />
            <label>
                <input name="userid" />
            </label>
        </td>
    <td><input type='submit' value='Buy'/></td>
    </tr>
    <tr>
        <td colspan='2'>
            <a href='products'>Product List</a>
        </td>
    </tr>
</table>
</form>
</body>
</html>
