package Controller;

import Model.DAO;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MyCom
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();

        //read data from register.html
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "user";

        //check if the user is already registered in the system
        if (dao.existingUser(email)) {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/signInError.css\" />");

            out.println("<div class=\"alert\">");
            out.println("<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> ");
            out.println("<strong>User already registered!</strong>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            request.getRequestDispatcher("register.html").include(request, response);
        } else {
            //create new user object using the main contructor in users.java
            Users User = new Users(firstname, lastname, username, email, password, role);

            //send the data to the registerUser class in DAO.java to be added to the users database
            dao.registerUser(User);
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/corrRegistration.css\" />");

            out.println("<div class=\"alert\">");
            out.println("<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> ");
            out.println("<strong>Registration successful.</strong>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rs = request.getRequestDispatcher("/index.html");
            rs.include(request, response);
        }
    }
}
