<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All Orders</title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <c:if test="${!empty orders}">
                <h3>Orders</h3>
                <table border = "1", style="border: solid black 1px;">
                    <thead>
                    <tr>
                        <th>Id Name</th>
                        <th>Seller Name</th>
                        <th>Customer Name</th>
                        <th>totalAmount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${map.get(order.sellerId)}</td>
                            <td>${map.get(order.customerId)}</td>
                            <td>${order.totalAmount}</td>
                            <td>
                                <form action="/order/edit/${order.id}">
                                    <input type="submit" value="Update">
                                </form>
                            </td>
                            <td>
                                <form action="/order/delete/${order.id}">
                                    <input type="submit" value="Delete">
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br>
                <br>
            </c:if>
            <a href="/order/new"> New Order </a>
        </div>
    </div>
</div>
</body>
</html>