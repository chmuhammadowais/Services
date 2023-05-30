/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Management.Client;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Muhammad
 */
public class AccountInfoHandler extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            Integer curr_cont = (Integer) session.getAttribute("Contact");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            int contact = Integer.parseInt(request.getParameter("contact"));
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String contact_hrs_from = request.getParameter("time1");
            String contact_hrs_till = request.getParameter("time2");
          
          System.out.println(name+age+contact_hrs_from+contact_hrs_till);
          Client c = new Client(name,age,gender,contact,email,password,address,contact_hrs_from,contact_hrs_till);
          RequestDispatcher rs = request.getRequestDispatcher("AccountInfo.jsp");
          boolean flag = c.update_info(c,curr_cont);

          if(flag){
              session.setAttribute("update_status", "success");
              session.removeAttribute("Contact");
               rs.forward(request, response);
          }
          else{
                session.setAttribute("update_err", "unsuccess");
               rs.forward(request, response);
          }
        }
        catch(NumberFormatException e){
            System.out.println("Exception: "+e);
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
