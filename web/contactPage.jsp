<%-- 
    Document   : contactPage
    Created on : Jul 21, 2020, 10:23:29 AM
    Author     : Ayeshmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Contact Us
        </title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/contactUs.css" />
    </head>
    <body>

        <header id="header">
            <div>
                <h1>My Recipes</h1>
            </div>
        </header>

        <section class="topnav">
            <a href="homePageServlet">Home</a>
            <a href="login.html">Submit a recipe</a>
            <a href="login.html">Login</a>
            <a href="register.html">Register</a>
            <a class="active" href="contactPage.jsp">Contact Us</a>
        </section>

        <div class="container">
            <div class="head">
                <h2><a class="headingButton" href="contactPage.jsp">Contact us</a></h2>
            </div>

            <form class="form" action="NewServlet" Method="GET">

                <input type="hidden" name="command" value="Contact"/>

                <div>
                    <label for="name">Name</label>
                    <input type="text" placeholder="Enter Name" name="name" required><br>
                </div>
                <br>
                <div>
                    <label for="email">Email</label>
                    <input type="text" placeholder="Enter Email" name="email" required><br>
                </div>
                <br>
                <div>
                    <label for="description">Message</label>
                    <textarea name="description" id="actions" placeholder="Describe your problem"></textarea><br><br>
                </div>
                <br>
                <div>
                    <button type="submit" class="submitMessageButton">SEND</button>
                </div>

            </form>

        </div>

        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="prins">My Recipes</p>
        </footer>

    </body>
</html>
