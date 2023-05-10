/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Management.ServiceForm;
import jakarta.servlet.RequestDispatcher;
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
public class ServiceFormHandler extends HttpServlet {

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
//                       response.sendRedirect("/Services");
//            /* TODO output your page here. You may use following sample code. */
//             out.println("<!DOCTYPE html>");
//             out.println("<html>");
//             out.println("<head>");
//             out.println("<title>Servlet ServiceFormHandler</title>");    
//             out.println("</head>");
//             out.println("<body>");
//             out.println("<h1>Servlet ServiceFormHandler at " + request.getContextPath() + "</h1>");        
//             out.println("</body>");
//             out.println("</html>");
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
             HttpSession session = request.getSession();
             
             session.setAttribute("service_code", null);
            //processRequest(request, response);
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ServiceForm.jsp");
        try{
             int Contact = Integer.parseInt( request.getParameter("contact"));
        String Address = request.getParameter("address");
        String Service = (String)session.getAttribute("Service");
        String Payment_method = request.getParameter("payment_opt");
        String Insurance = request.getParameter("insurance");
        String Ownership = request.getParameter("ownership");
        String Description = request.getParameter("description");
        String Service_status = "Initialize";
        
     //   System.out.println(Full_name+Email+Contact+Address+Service+Payment_method+Insurance+Ownership+Description);
        ServiceForm srcvfrm = new ServiceForm(Contact,Address,Service,0,Payment_method,Insurance,Ownership,Description, Service_status);
        String code = srcvfrm.add_srvc(srcvfrm);

        if(code != null){
             System.out.println("Current Service Code: "+code);
             session.setAttribute("service_code", code);
             dispatcher.forward(request, response);
        }
        else{
              session.setAttribute("form_error", "Submission_Error");
              dispatcher.forward(request, response);
        }
       
        }
        catch(ServletException | IOException | NumberFormatException e){
            System.out.println("Exception: "+e);
            session.setAttribute("form_error", "Submission_Error");
            dispatcher.forward(request, response);
        }
       
   //  processRequest(request, response);
       
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
