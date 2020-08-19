<%-- 
    Document   : addRecipeUser
    Created on : Jul 21, 2020, 4:12:30 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/normalize.css" />
        <link type="text/css" rel="stylesheet" href="CSS/addRecipes.css" />
        <title>Submit recipe</title>
    </head>
    <body>
        <header>
            <div class="header">
                <h1 class="head">Prins and the rest</h1>
            </div>
        </header>
        <div class="container">
            <div class="pageName">
                <h2><a class="headingButton" href="addRecipe.jsp">Submit recipe</a></h2>
            </div>
            <form class="form" method="post" action="addRecipeUserServlet"> <!--enctype="multipart/form-data".......for some reason does not let any data to get added to the database--> 
                <div class="imageHolder">
                    <img src="images/placeholder-image.png" onclick="triggerClick()" id="imageDisplay">
                    <input type="file" name="recipeImage" onchange="displayImage(this)" id="recipeImage" style="display: none;">
                </div>
                <br>
                <div class="recipeInfoHolder">
                    <div>
                        <label>Enter recipe name:</label>
                        <input type="text" name="recipeName" required/>
                    </div>
                    <br>
                    <div>
                        <label>Select type:</label>
                        <select class="typeSelector" name="type" required>
                            <option value="">None selected</option>
                            <option value="Breakfast">Breakfast</option>
                            <option value="Brunch">Brunch</option>
                            <option value="Elevenses">Elevenses</option>
                            <option value="Lunch">Lunch</option>
                            <option value="Tea">Tea</option>
                            <option value="Supper">Supper</option>
                            <option value="Dinner">Dinner</option>
                            <option value="Appetizer">Appetizer</option>
                            <option value="Dessert">Dessert</option>
                            <option value="Side dish">Side dish</option>
                            <option value="Salad">Salad</option>
                            <option value="Toppings">Toppings</option>
                            <option value="Soup & stews">Soup & stews</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label>Enter short description:</label>
                        <textarea name="shortDescription" rows="1" required></textarea>
                    </div>
                    <br>
                    <div>
                        <select class="vegNonveg" name="vegNonVeg">
                            <option value="Non-veg" selected>Non-veg</option>
                            <option value="veg">Veg</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label>Time duration to prepare:</label>
                        <select class="timeSelector" name="time" required>
                            <option value="5 minutes">5 min</option>
                            <option value="10 minutes">10 min</option>
                            <option value="15 minutes">15 min</option>
                            <option value="20 minutes">20 min</option>
                            <option value="25 minutes">25 min</option>
                            <option value="30 minutes">30 min</option>
                            <option value="35 minutes">35 min</option>
                            <option value="40 minutes">40 min</option>
                            <option value="45 minutes">45 min</option>
                            <option value="50 minutes">50 min</option>
                            <option value="55 minutes">55 min</option>
                            <option value="1 hour" selected>1 h</option>
                            <option value="1 hour 5 minutes">1h 5 min</option>
                            <option value="1 hour 10 minutes">1h 10 min</option>
                            <option value="1 hour 15 minutes">1h 15 min</option>
                            <option value="1 hour 20 minutes">1h 20 min</option>
                            <option value="1 hour 25 minutes">1h 25 min</option>
                            <option value="1 hour 30 minutes">1h 30 min</option>
                            <option value="1 hour 35 minutes">1h 35 min</option>
                            <option value="1 hour 40 minutes">1h 40 min</option>
                            <option value="1 hour 45 minutes">1h 45 min</option>
                            <option value="1 hour 50 minutes">1h 50 min</option>
                            <option value="1 hour 55 minutes">1h 55 min</option>
                            <option value="2 hours">2 h</option>
                            <option value="2 hours 5 minutes">2 h 5 min</option>
                            <option value="2 hours 10 minutes">2 h 10 min</option>
                            <option value="2 hours 15 minutes">2 h 15 min</option>
                            <option value="2 hours 20 minutes">2 h 20 min</option>
                            <option value="2 hours 25 minutes">2 h 25 min</option>
                            <option value="2 hours 30 minutes">2 h 30 min</option>
                            <option value="2 hours 35 minutes">2 h 35 min</option>
                            <option value="2 hours 40 minutes">2 h 40 min</option>
                            <option value="2 hours 45 minutes">2 h 45 min</option>
                            <option value="2 hours 50 minutes">2 h 50 min</option>
                            <option value="2 hours 55 minutes">2 h 55 min</option>
                            <option value="3 hours">3 h</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label>Ingredients required:</label>
                        <textarea name="ingredients" placeholder="Separate ingredients with commas" rows="1" required></textarea>
                    </div>
                    <br>
                    <div>
                        <label>Methods and steps to prepare:</label>
                        <textarea name="steps" rows="1" required></textarea>
                    </div>
                    <br>
                    <div>
                        <input class="submit" type="submit" value="Submit recipe"/>
                    </div>
                </div>
            </form>
        </div>
        <br>
        <footer class="footer">
            <p class="footerPara">©2020 All rights Reserved</p>
            <p class="prins">Prins</p>
        </footer>

        <script>
            var slider = document.getElementById("myRange");
            var output = document.getElementById("demo");
            output.innerHTML = slider.value;

            slider.oninput = function () {
                output.innerHTML = this.value;
            };
        </script>
    </body>
    <script>
        function previewFile() {
            const preview = document.querySelector('img');
            const file = document.querySelector('input[type=file]').files[0];
            const reader = new FileReader();

            reader.addEventListener("load", function () {
                // convert image file to base64 string
                preview.src = reader.result;
            }, false);

            if (file) {
                reader.readAsDataURL(file);
            }
        }

        function triggerClick() {
            document.querySelector('#recipeImage').click();
        }

        function displayImage(e) {
            if (e.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    document.querySelector('#imageDisplay').setAttribute('src', e.target.result);
                };
                reader.readAsDataURL(e.files[0]);
            }
        }
    </script>
</html>
