<%-- 
    Document   : homePage
    Created on : Aug 9, 2020, 12:37:11 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/homepagecss.css" />

    </head>
    <body>

        <header>
            <div class="header">
                <h1 class="head">My recipes</h1>
            </div>
        </header>

        <div class="container">

            <c:forEach var="recipes" items="${RECIPES}">

                <button class="collapsible">${recipes.name}</button>
                <div class="content">
                    <div class="modal-recipeImage">
                        <img src="images/placeholder-image.png" width="250" height="200" id="imageDisplay">
                    </div>
                    <div class="model-recipeDetails">
                        <p class="recipeName">Recipe name: ${recipes.name}</p>
                        <p class="recipeType">${recipes.type}</p>
                        <p class="recipeDes">${recipes.des}</p>
                        <p class="recipevegNonveg">${recipes.vegNonveg}</p>
                        <p class="recipeTime">Time to prepare: ${recipes.time}</p>
                        <p class="recipeSteps">How to make : ${recipes.steps}</p>
                        <p class="recipeUploadedby">By: ${recipes.uploadedBy}</p>
                    </div>

                </div>


            </c:forEach>



        </div>
        <br>
        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="prins">Prins</p>
        </footer>

        <script>
            var coll = document.getElementsByClassName("collapsible");
            var i;

            for (i = 0; i < coll.length; i++) {
                coll[i].addEventListener("click", function () {
                    this.classList.toggle("active");
                    var content = this.nextElementSibling;
                    if (content.style.maxHeight) {
                        content.style.maxHeight = null;
                    } else {
                        content.style.maxHeight = content.scrollHeight + "px";
                    }
                });
            }
        </script>

    </body>
</html>