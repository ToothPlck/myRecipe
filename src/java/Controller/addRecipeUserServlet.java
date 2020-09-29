package Controller;

import Model.DAO;
import Model.ingredients;
import Model.recipe;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author USER
 */
@MultipartConfig
public class addRecipeUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uploadedBy = (String) session.getAttribute("email");

        DAO dao = new DAO();

        int ID = dao.getNewID();

        String name = request.getParameter("recipeName");
        String type = request.getParameter("type");
        String des = request.getParameter("shortDescription");
        String time = request.getParameter("time");
        String vegNonVeg = request.getParameter("vegNonVeg");
        String steps = request.getParameter("steps");
        String status = "pending";

        Part filePart = request.getPart("recipeImage");

        String imageName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        System.out.println("Img name" + imageName);

        String imageSavePath = "D:\\APIIT\\2nd year\\Semester 2\\Assignments\\ESA2\\Sprints\\Sprint1\\addRecipes\\web\\images";

        FileOutputStream outputStream = null;

        InputStream fileContent = null;

        recipe addRecipe = new recipe(ID, name, type, des, vegNonVeg, time, steps, uploadedBy, status, imageName);
        dao.addRecipeUser(addRecipe);

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

            try {
                outputStream = new FileOutputStream(new File(imageSavePath + File.separator + imageName));

                fileContent = filePart.getInputStream();

                int readBytes = 0;
                byte[] readArray = new byte[1024];

                while ((readBytes = fileContent.read(readArray)) != -1) {
                    outputStream.write(readArray, 0, readBytes);
                }

            } catch (Exception ex) {
                System.out.println("Error writing File: " + ex);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }

        } catch (Exception exception) {
            exception.getMessage();
        }

        response.sendRedirect("userHomePageServlet");
    }

}
