<%-- 
    Document   : userhomePage
    Created on : Aug 23, 2020, 3:49:17 PM
    Author     : USER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/homepage4css.css" />
        <title>Home</title>
    </head>
    <body>
        <header>
            <div class="header">
                <h1 class="head">My Recipes</h1>
            </div>
        </header>

        <section class="topnav">
            <a class="active" href="homePageServlet">Home</a>
            <a href="addRecipeUser.jsp">Submit a recipe</a>
            <a href="contactPage.jsp">Contact Us</a>
            <a href="logout">Logout</a>
        </section>

        <div class="container">

            <c:forEach var="recipes" items="${RECIPES}">

                <div class="section-wrapper">
                    <section class="section">
                        <!--the section-->
                        <div class="recipeImage">
                            <img id="imageDisplay" src="images/${recipes.imageName}" style="width: 250px; height: 200px;">
                        </div>
                        <div class="recipeInfo">
                            <h3 class="recipeName">${recipes.name}</h3>
                            <div class="recipeInfo-description">
                                <p class="description">${recipes.des}</p>
                            </div>
                            <div class="recipeInfo-user">
                                <p class="user">${recipes.uploadedBy}</p>
                            </div>
                        </div>


                        <!-- Trigger/Open The Modal -->
                        <button id="myBtn" class="modal-button" href="#myModal${recipes.ID}">${recipes.name}</button>

                        <!-- The Modal -->
                        <div id="myModal${recipes.ID}" class="modal">

                            <!-- Modal content -->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <span class="close">×</span>
                                    <h2>Modal Header</h2>
                                </div>
                                <div class="modal-body">
                                    <p>${recipes.name}</p>
                                    <p>${recipes.ID}</p>
                                </div>
                                <div>
                                    <img src="images/${recipes.imageName}" style="width: 250px; height: 200px;">
                                </div>
                                <div class="modal-footer">
                                    <h3>Modal Footer</h3>
                                </div>
                            </div>

                        </div>
                    </section>
                </div>
            </c:forEach>

        </div>

        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="prins">My Recipes</p>
        </footer>

    </body>

    <script>

        // Get the button that opens the modal
        var btn = document.querySelectorAll("button.modal-button");

        // All page modals
        var modals = document.querySelectorAll('.modal');

        // Get the <span> element that closes the modal
        var spans = document.getElementsByClassName("close");

        // When the user clicks the button, open the modal
        for (var i = 0; i < btn.length; i++) {
            btn[i].onclick = function (e) {
                e.preventDefault();
                modal = document.querySelector(e.target.getAttribute("href"));
                modal.style.display = "block";
            };
        }

        // When the user clicks on <span> (x), close the modal
        for (var i = 0; i < spans.length; i++) {
            spans[i].onclick = function () {
                for (var index in modals) {
                    if (typeof modals[index].style !== 'undefined')
                        modals[index].style.display = "none";
                }
            };
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target.classList.contains('modal')) {
                for (var index in modals) {
                    if (typeof modals[index].style !== 'undefined')
                        modals[index].style.display = "none";
                }
            }
        };

    </script>

</html>