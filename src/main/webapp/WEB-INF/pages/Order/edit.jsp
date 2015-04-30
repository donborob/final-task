<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Order</title>
</head>
<body>
<h2>Edit Order</h2>
<br>
<form:form method="post" modelAttribute="order">
    <table>
        <tr><form:errors path="sellerId" cssClass="label label-important" /></tr>
        <tr>
            <td>Seller Id:</td>

            <td><form:input path="sellerId" /></td>
        </tr>
        <br>
        <tr><form:errors path="customerId" cssClass="label label-important" /></tr>
        <br>
        <tr>
            <td>Customer Id:</td>

            <td><form:input path="customerId" /></td>
        </tr>
        <tr><form:errors path="totalAmount" cssClass="label label-important" /></tr>
        <tr>
            <td>Total Amount:</td>
            <td><form:input path="totalAmount" /></td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="Save changes" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
