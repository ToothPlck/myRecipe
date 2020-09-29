package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import Model.DAO;
import Model.Users;
import java.util.List;

/**
 *
 * @author MyCom
 */
public class viewRegUsers extends HttpServlet {

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
                    viewUsers(request, response);
                    break;
                case "DELETE":
                    deleteUser(request, response);
                    break;
                default:
                    viewUsers(request, response);
                    break;
            }
        } catch (Exception e) {
        }
    }

    private void viewUsers(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAO dao = new DAO();

        List<Users> userList = dao.viewUsersList();
        request.setAttribute("USERS", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("viewRegUsers.jsp");
        dispatcher.include(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        String email = request.getParameter("email");
        dao.deleteUser(email);

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/corrRegistration.css\" />");

        out.println("<div class=\"alert\">");
        out.println("<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> ");
        out.println("<strong>User Deleted.</strong>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        viewUsers(request, response);
    }

}
