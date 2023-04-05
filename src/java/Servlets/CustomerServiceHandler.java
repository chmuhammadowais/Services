/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DB.DatabaseCon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Muhammad
 */
public class CustomerServiceHandler extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerServiceHandler</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet CustomerServiceHandler at " + request.getContextPath() + "</h1>");
            out.println("<h1>Feedback Submitted " + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String Full_name = request.getParameter("Full_name");
        String Email = request.getParameter("Email");
        Integer Contact = Integer.valueOf(request.getParameter("Contact"));
        String Feedback_Type = request.getParameter("Feedback_type");
        String Feedback = request.getParameter("Feedback");
        System.out.println(Full_name + " " + Email + " " + Contact + " " + Feedback_Type + " " + Feedback);
        try{
              Connection con = DatabaseCon.connection();
              PreparedStatement ps = con.prepareStatement("insert into CustomerService values(?,?,?,?,?,?);");
              ps.setString(1, Full_name);
              ps.setString(2, Email);
              ps.setInt(3, Contact);
              ps.setString(4, Feedback_Type);
              ps.setString(5, Feedback);
              LocalDate currentDate = LocalDate.now();
              String current_date = String.valueOf(currentDate);
              ps.setString(6, current_date);
              ps.executeUpdate();
              System.out.println("Feedback Submitted"); 
              processRequest(request, response);
        }
        catch(SQLException e){
            System.out.println("Exception : "+e);
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