package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Comment;
import Model.Contact;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ayeshmi
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, Exception {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//             out.println("hello");
//            mail1 mail=new mail1();
//           
//            mail.sendmail("ayeshmi177samaraa@gmail.com");
//            out.println("hello");
//           
//           
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        try {
            String command = request.getParameter("command");
            if (command == null) {
                PrintWriter out = response.getWriter();
                out.println("hello");

            }
            switch (command) {

                case "Contact":
                    AddContactDetails(request, response);
                    break;
                case "VIEWCONATCT":
                    ViewOwnComplains(request, response);
                    break;
                case "DELETECONTACT":
                    DeleteContact(request, response);
                    break;
                case "ANSWERCONTACT1":
                    answerConatct1(request, response);
                    break;
                case "ANSWERCONTACT2":
                    answerConatct2(request, response);
                    break;
                case "ADDCOMMENT":
                    AddComment(request, response);
                    break;
            }
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception ex) {
            System.out.println("Error is occured.");
        }
    }

    private void AddContactDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date1 = formatter.format(date);
//          PrintWriter out=response.getWriter();
//          out.print(name);
//          out.print(email);
//          out.print(description);
        Contact contact = new Contact(name, email, description, date1);

        dao.contact(contact);

        RequestDispatcher dispacher = request.getRequestDispatcher("/contactPage.jsp");
        dispacher.forward(request, response);
    }

    private void ViewOwnComplains(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            DAO dao = new DAO();
            List<Contact> contacts = dao.getAllContactDetails();
            request.setAttribute("Contact_List", contacts);

            if (contacts.isEmpty()) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/handlerComplainsError.jsp");
                dispacher.forward(request, response);
            } else {
                //  PrintWriter out=response.getWriter();
                // out.println(contacts);
                RequestDispatcher dispacher = request.getRequestDispatcher("/viewContactDetails.jsp");
                dispacher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date1 = formatter.format(date);
//  PrintWriter out=response.getWriter();
//          out.print(name);
//          out.print(email);
//        out.print(description);
        Comment comment = new Comment(name, message, date1);

        dao.comment(comment);

        PrintWriter out = response.getWriter();
        out.print("Your comment is successfully added");

        //  RequestDispatcher dispacher = request.getRequestDispatcher("/contactPage.jsp");
        //  dispacher.forward(request, response);
    }

    private void answerConatct1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            DAO dao = new DAO();
            String name = request.getParameter("name");
            String date = request.getParameter("date");

            ArrayList<Contact> searchcontact = dao.AnswerContact(name, date);
            PrintWriter out = response.getWriter();
            out.print(searchcontact);
            if (searchcontact.isEmpty()) {
                //   RequestDispatcher dispacher = request.getRequestDispatcher("/updateUserError.jsp");
                // dispacher.forward(request, response); 
            } else {
                request.setAttribute("Contact_List", searchcontact);
                //  out.print("hello");

                RequestDispatcher dispacher = request.getRequestDispatcher("/AnswerContact.jsp");
                dispacher.forward(request, response);
                //  String answer = request.getParameter("answer");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void answerConatct2(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String answer = request.getParameter("answer");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();

        if (answer == null) {
            RequestDispatcher dispacher = request.getRequestDispatcher("/message1.jsp");
            dispacher.forward(request, response);
        } else {
            mail1 mail = new mail1();
            mail.sendmail(email, answer);
            RequestDispatcher dispacher = request.getRequestDispatcher("/message2.jsp");
            dispacher.forward(request, response);
        }

    }

    private void DeleteContact(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        dao.delete(name, date);
        RequestDispatcher dispacher = request.getRequestDispatcher("/message.jsp");
        dispacher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
