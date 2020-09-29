<%-- 
    Document   : viewedComplainHandler
    Created on : May 23, 2020, 11:18:59 PM
    Author     : Ayeshmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/contactUs.css" />
        <title>View Complaints</title>
    </head>

    <body>

        <header id="header">
            <div>
                <h1>My Recipes</h1>
            </div>
        </header>

        <section class="topnav">
            <a href="adminsHomePageServlet">Home</a>
            <a href="addRecipe.jsp">Submit a recipe</a>
            <a class="active" href="viewContactDetails.jsp">Respond users</a>
            <a href="viewRegUsers.jsp">Handle users</a>
            
        </section>

        <div class="container">
            
            <div class="head">
                <h2><a class="headingButton" href="viewContactDetails.jsp">Contact us</a></h2>
            </div>

            <table id="customers">
                <tr>
                    <th>User name</th>
                    <th>Date</th>
                    <th>Email</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>

                <c:forEach var="tempUser" items="${Contact_List}">
                    <c:url var="viewLink" value="NewServlet">
                        <c:param name="command" value="DELETECONTACT"/>
                        <c:param name="name" value="${tempUser.getName()}" />
                        <c:param name="date" value="${tempUser.getDate()}" />
                    </c:url>
                    <c:url var="answerLink" value="NewServlet">
                        <c:param name="command" value="ANSWERCONTACT1"/>
                        <c:param name="name" value="${tempUser.getName()}" />
                        <c:param name="date" value="${tempUser.getDate()}" />
                    </c:url>
                    <tr>
                        <td>${tempUser.getName()}</td>
                        <td>${tempUser.getDate()}</td>   
                        <td>${tempUser.getEmail()}</td>
                        <td>${tempUser.getDescription()}</td>
                        <td><a class="answer" href=${answerLink}>Answer</a><br><a href=${viewLink}>Delete</a></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        
        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="prins">My Recipes</p>
        </footer>
        
    </body>
</html>
