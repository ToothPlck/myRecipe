package Controller;

import Model.DAO;
import Model.ingredients;
import Model.recipe;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class addRecipeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        DAO dao = new DAO();

        int ID = dao.getNewID();

        String name = request.getParameter("recipeName");
        String type = request.getParameter("type");
        String des = request.getParameter("shortDescription");
        String time = request.getParameter("time");
        String vegNonVeg = request.getParameter("vegNonVeg");
        String steps = request.getParameter("steps");
        String uploadedBy = "Administrator";
        String status = "accepted";

        recipe addRecipe = new recipe(ID, name, type, des, vegNonVeg, time, steps, uploadedBy, status);
        dao.addRecipe(addRecipe);

        String ingredient = request.getParameter("ingredients");

        try {
            ingredient = ingredient.replaceAll(" ,", ",");
            ingredient = ingredient.replaceAll(", ", ",");
            ingredient = ingredient.replaceAll(" ,", ",");
            ingredient = ingredient.replaceAll(", ", ",");

            ingredient = ingredient.toLowerCase();

            String iingredient[] = ingredient.split("\\,");

            for (int i = 0; i < iingredient.length; i++) {
                int ingredientID = dao.getNewIngredientID();

                String singleIngredient = iingredient[i];

                ingredients ingredientt = new ingredients(ingredientID, ID, singleIngredient);

                dao.addIngredient(ingredientt);
            }
        } catch (Exception exception) {
            exception.getMessage();
        }

        response.sendRedirect("index.html");
    }
}
