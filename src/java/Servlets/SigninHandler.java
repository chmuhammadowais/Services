/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import Management.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Muhammad
 */
public class SigninHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("/Services");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SigninHandler</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SigninHandler at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

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
        processRequest(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean flag = Client.verify_client(email, password);
        if(flag){
              ArrayList client_info = Client.retrieve_info(email,password);
              System.out.println("======================");
              System.out.println("*** User logged in ***");
              System.out.println("======================");
            for (Object data : client_info) {
                System.out.println(data);
            }
            System.out.println("==============");
            
               HttpSession session = request.getSession();
               session.setAttribute("Full_name", client_info.get(0));
               session.setAttribute("Age", client_info.get(1));
               session.setAttribute("Gender", client_info.get(2));
               session.setAttribute("Contact", client_info.get(3));
               session.setAttribute("Email", client_info.get(4));
               session.setAttribute("Address", client_info.get(5));
               session.setAttribute("Contact_hrs_from", client_info.get(6));
               session.setAttribute("Contact_hrs_till", client_info.get(7));
               
               session.removeAttribute("errorMessage");
//               PrintWriter writer = response.getWriter();
//               writer.println("Session ID: " + session.getId());
//               writer.println("Creation Time: " + new Date(session.getCreationTime()));
//               writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
//               writer.println(session.getAttribute("Full_name"));
         //     processRequest(request, response);
         response.sendRedirect("/Services/Services.jsp");
        }
        else{
            HttpSession session = request.getSession();
           session.setAttribute("errorMessage", "Email or Password Invalid");
           response.sendRedirect("/Services/SigninSignup.jsp");
        
        }
      
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
