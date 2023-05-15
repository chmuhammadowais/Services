/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Muhammad
 */
public class LogoutHandler extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();       
          if(session != null){
                    String Full_name  = (String)  session.getAttribute("Full_name");
                    Integer Age  = (Integer)   session.getAttribute("Age");
                    String Gender  = (String)  session.getAttribute("Gender");
                    Integer Contact  = (Integer)  session.getAttribute("Contact");
                    String Email  = (String)  session.getAttribute("Email");
                    String Address  = (String)  session.getAttribute("Address");
                    String Contact_hrs_from  = (String)   session.getAttribute("Contact_hrs_from");
                    String Contact_hrs_till = (String)    session.getAttribute("Contact_hrs_till");

                    System.out.println(Full_name+" "+Age+" "+Gender+" "+Contact+" "+Email+" "+Address+" "+Contact_hrs_from+" "+Contact_hrs_till);
                session.invalidate();
                response.sendRedirect("/Services/");
          }
  else{

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Error</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<script>");
    out.println("alert('Error Logging out. Please Try again later');");
    out.println("</script>");

    out.println("</body>");
    out.println("</html>");
  }

  
        }
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
        processRequest(request, response);
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
