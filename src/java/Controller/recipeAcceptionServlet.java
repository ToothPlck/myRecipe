package Controller;

import Model.DAO;
import Model.recipe;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class recipeAcceptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "LIST";
            }
            switch (command) {
                case "LIST":
                    viewPending(request, response);
                    break;
                case "ACCEPT":
                    acceptRecipe(request, response);
                    break;
                case "REJECT":
                    rejectRecipe(request, response);
                    break;
                default:
                    viewPending(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewPending(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            DAO dao = new DAO();

            List<recipe> pendingRecipes = dao.pendingRecipes();

            request.setAttribute("PENDING", pendingRecipes);

            RequestDispatcher dispatcher = request.getRequestDispatcher("recipeApproval.jsp");
            dispatcher.include(request, response);
        } catch (Exception exception) {
            exception.toString();
        }
    }

    private void acceptRecipe(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = new DAO();

        int ID = Integer.parseInt(request.getParameter("ID"));
        dao.acceptRecipe(ID);

        viewPending(request, response);
    }

    private void rejectRecipe(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = new DAO();

        int ID = Integer.parseInt(request.getParameter("ID"));
        dao.rejectComplaint(ID);
        
        viewPending(request, response);
    }
}
