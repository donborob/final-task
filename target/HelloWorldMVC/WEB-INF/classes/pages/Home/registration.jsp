<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>User Registration</title>
</head>
<body>
<H1>
    User Registration
</H1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <br>
    <tr>
        <td>First Name:</td>
        </td>
        <td><form:input path="firstname" value="" /></td>
        <form:errors path="firstname" element="div"/>
    </tr>
    <tr>
        <td>Last Name</td>
        </td>
        <td><form:input path="lastname" value="" /></td>
        <form:errors path="lastname" element="div" />
    </tr>
    <tr>
        <td>Age:</td>
        </td>
        <td><form:input path="age" value="" /></td>
        <form:errors path="age" element="div" />
    </tr>
    <tr>
        <td>Username:</td>
        </td>
        <td><form:input path="username" value="" /></td>
        <form:errors path="username" element="div" />
    </tr>
    <tr>
        <td>Password:</td>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <tr>
        <td>Confirm Password</td>
        </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    <button type="submit">
        Confirm
    </button>
</form:form>
<br>
<a href="<c:url value="login.jsp" />">
   Log in
</a>
</body>
</html>