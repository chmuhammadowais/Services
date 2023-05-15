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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Muhammad
 */
public class HistoryHandler extends HttpServlet {

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
         HttpSession session = request.getSession();
         Integer contact = (Integer) session.getAttribute("Contact");
        if(contact == null){
            response.sendRedirect("/Services/SigninSignup.jsp");
        }
        else{
             try{
              
              Connection con = DatabaseCon.connection();
              PreparedStatement ps = con.prepareStatement("select Date_Time, Service, Address, Service_status, Total_cost from Services where contact = ?");
             
                ps.setInt(1, contact);
              ResultSet rs = ps.executeQuery();
              
              List<List<String>> listOfLists = new ArrayList<>();
              
              while(rs.next()){
                  String Date_Time = rs.getString("Date_Time");
                  String Service = rs.getString("Service");
                  String Address = rs.getString("Address");
                  String Service_status = rs.getString("Service_status");
                  int Total_cost = rs.getInt("Total_cost");
                  
                  listOfLists.add(new ArrayList<>(Arrays.asList(Date_Time,Service,Address, Service_status, String.valueOf(Total_cost))));
              }
  
               request.setAttribute("History", listOfLists);
              
                  RequestDispatcher rd =  request.getRequestDispatcher("ServiceHistory.jsp");
                  rd.forward(request, response);
              }
      catch(SQLException e){
          System.out.println("Exception : "+e);
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
        response.sendRedirect("/Services");
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
