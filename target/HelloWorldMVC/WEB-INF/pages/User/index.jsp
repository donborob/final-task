<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>All Users</title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <c:if test="${!empty users}">
                <h3>Users</h3>
                <table border = "1", style="border: solid black 1px;">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.lastname} ${user.firstname}</td>
                            <td>${user.age}</td>
                            <td>
                                <form action="/user/edit/${user.id}">
                                    <input type="submit" value="Update">
                                </form>
                            </td>
                            <td>
                                <form action="/user/delete/${user.id}">
                                    <input type="submit" class="btn btn-danger btn-mini" value="Delete"/>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <br>
            <br>
            <a href="/user/new"> New User </a>
        </div>
    </div>
</div>
</body>
</html>