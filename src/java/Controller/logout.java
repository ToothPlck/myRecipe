package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set response type and printWriter
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //get session
        HttpSession session = request.getSession();

        //close the session
        session.invalidate();

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/messageBox.css\" />");

        out.println("<div class=\"alert\">");
        out.println("<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> ");
        out.println("<strong>Logged out successfully</strong>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        request.getRequestDispatcher("homePageServlet").include(request, response);
    }

}
