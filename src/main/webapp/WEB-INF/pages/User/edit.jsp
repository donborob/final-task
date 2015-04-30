<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>
<br>
<form:form method="post" modelAttribute="user">
    <table>
        <tr><form:errors path="firstname" cssClass="label label-important" /></tr>
        <tr>
            <td>First Name:</td>

            <td><form:input path="firstname" /></td>
        </tr>
        <br>
        <tr><form:errors path="lastname" cssClass="label label-important" /></tr>
        <br>
        <tr>
            <td>Last Name:</td>

            <td><form:input path="lastname" /></td>
        </tr>
        <tr><form:errors path="age" cssClass="label label-important" /></tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age" /></td>
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
