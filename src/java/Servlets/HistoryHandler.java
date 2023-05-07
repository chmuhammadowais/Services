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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HistoryHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoryHandler at " + request.getContextPath() + "</h1>");
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
           try{
               HttpSession session = request.getSession();
              Connection con = DatabaseCon.connection();
              PreparedStatement ps = con.prepareStatement("select Date_Time, Service, Date_Time,Service_status, Total_cost from Services where contact = ?");
              Integer contact = (Integer) session.getAttribute("Contact");
                ps.setInt(1, contact);
              ResultSet rs = ps.executeQuery();
              
              List<List<String>> listOfLists = new ArrayList<>();
              
              while(rs.next()){
                  String Date_Time = rs.getString("Date_Time");
                  String Service = rs.getString("Date_Time");
                  String Service_status = rs.getString("Service_status");
                  int Total_cost = rs.getInt("Total_cost");
                  
                  listOfLists.add(new ArrayList<>(Arrays.asList(Date_Time,Service, Service_status, String.valueOf(Total_cost))));
              }
               System.out.println("Starting Enhanced For Loop");
               for (List<String> listOfList : listOfLists) {
                   System.out.println(listOfList);
               }
        }
      catch(SQLException e){
          System.out.println("Exception : "+e);
      }
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
