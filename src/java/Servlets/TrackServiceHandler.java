/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DB.DatabaseCon;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Muhammad
 */
public class TrackServiceHandler extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.removeAttribute("status");
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
        HttpSession session = request.getSession();
        String srvc_code = request.getParameter("srvc_code");
         Integer contact = (Integer) session.getAttribute("Contact");
        System.out.println(srvc_code);
        
        try{
            Connection con = DatabaseCon.connection();
            PreparedStatement ps = con.prepareStatement("select Service_Status from services where Service_code = ? and Contact=?;");
            ps.setString(1, srvc_code);
            ps.setInt(2, contact);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String status = rs.getString("Service_Status");
          
            session.setAttribute("status", status);
            
            System.out.println(status);
            response.sendRedirect("/Services/TrackService.jsp");
        }
        catch(SQLException e){    
        System.out.println("Exception : "+e);
        session.setAttribute("SQLError", "Error Retrieving the information of the provided code.");
        String error = (String) session.getAttribute("SQLError");
        System.out.println(error);
        RequestDispatcher rd = request.getRequestDispatcher("TrackService.jsp");
        rd.forward(request, response);
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
