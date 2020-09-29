package Controller;

import Model.DAO;
import Model.recipe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class homePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        
        List<recipe> recipes = dao.recipeDetails();
        
        request.setAttribute("RECIPES", recipes);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("homePage2.jsp");
        dispatcher.include(request, response);
    }
}
