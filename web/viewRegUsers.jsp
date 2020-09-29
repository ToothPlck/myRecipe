<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/login.css" />
        <title>Registered Users</title>
    </head>
    <body>
        <header id="header">
            <div>
                <h1>My Recipes</h1>
            </div>
        </header>
        
        <section class="topnav">
            <a href="homePageServlet">Home</a>
            <a href="addRecipe.jsp">Submit a recipe</a>
            <a href="viewContactDetails.jsp">Respond users</a>
            <a class="active" href="viewRegUsers.jsp">Handle users</a>
        </section>

        <div class="container">
            <div class="head">
                <h2><a class="headingButton" href="viewRegUsers.jsp">Registered Users</a></h2>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Email</th>

                        <th>Delete</th>
                    </tr>
                    <c:forEach var="users" items="${USERS}">
                        <c:url var="deleteUser" value="viewRegUsers">
                            <c:param name="command" value="DELETE" />
                            <c:param name="email" value="${users.email}"/>
                        </c:url>

                        <tr>
                            <td>${users.firstname}</td>
                            <td>${users.lastname}</td>
                            <td>${users.email}</td>

                            <td><a class="reject" href="${deleteUser}">Delete</a></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

        </div>

        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="recipes">My Recipes</p>
        </footer>
    </body>
</html>
