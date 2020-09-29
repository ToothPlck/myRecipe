package Controller;

import Model.DAO;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MyCom
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set response type and printWriter
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //get email and password variables from index.html
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //create new user object with email and password (Using constructor with email and password from users class)
        Users User = new Users(email, password);

        DAO dao = new DAO();

        String role = null;
        try {
            role = dao.authenticateUser(User);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //check the role of the user returned by the DAO class
        switch (role) {
            case "Administrator": {
                //create new session
                HttpSession session = request.getSession();
                //set the response attribute
                session.setAttribute("email", email);
                //set session attribute. Send users to the specific servlet according to his/her role
                response.sendRedirect("adminHomePage");
                break;
            }
            case "user": {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("userHomePageServlet");
                break;
            }
            default: {
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/signInError.css\" />");

                out.println("<div class=\"alert\">");
                out.println("<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> ");
                out.println("<strong>Entered values are incorrect! Try again or Register.</strong>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                request.getRequestDispatcher("index.html").include(request, response);
                break;
            }
        }
    }

}
