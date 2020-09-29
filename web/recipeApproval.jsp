<%-- 
    Document   : recipeApproval
    Created on : Aug 25, 2020, 9:42:54 AM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/homepage4css.css" />
        <title>Recipe Approval</title>
    </head>
    <body>

        <header>
            <div class="header">
                <h1 class="head">My Recipes</h1>
            </div>
        </header>

        <section class="topnav">
            <a href="homePageServlet">Home</a>
            <a href="addRecipe.jsp">Submit a recipe</a>
            <a href="viewContactDetails.jsp">Respond users</a>
            <a href="viewRegUsers.jsp">Handle users</a>
            <a class="active" href="recipeAcceptionServlet">Recipe approvals</a> 
            <a href="logout">Logout</a>
        </section>

        <div class="container">

            <c:forEach var="recipes" items="${PENDING}">

                <c:url var="acceptComplaint" value="recipeAcceptionServlet">
                    <c:param name="command" value="ACCEPT" />
                    <c:param name="ID" value="${recipes.ID}" />
                </c:url>

                <c:url var="rejectComplaint" value="recipeAcceptionServlet">
                    <c:param name="command" value="REJECT" />
                    <c:param name="ID" value="${recipes.ID}" />
                </c:url>


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
                                    <a class="acceptComplaint" href="${acceptComplaint}">Accept</a>
                                    <a onclick="rejectFunction()" class="rejectComplaint" href="${rejectComplaint}">Reject</a>
                                    <span class="close">x</span>
                                    <h2>Modal Header</h2>
                                </div>
                                <div class="modal-body">
                                    <p>${recipes.name}</p>
                                    <p>${recipes.ID}</p>
                                </div>
                                <div>
                                    <img id="imageDisplay" src="images/${recipes.imageName}" style="width: 250px; height: 200px;">
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

        function rejectFunction() {
            var rejectionMessage = prompt("Please enter the reason for rejecting the entry:");
            if (rejectionMessage !== null) {
                
            }
        }

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
