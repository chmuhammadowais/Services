/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import Management.Client;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(request.getReader());
            System.out.println(jsonData);
            
            String email = (String) jsonData.get("em");
            String password = (String) jsonData.get("pw");
            System.out.println(email + " " + password);

            boolean flag = Client.verify_client(email, password);
            if (flag) {
                ArrayList<Object> client_info = Client.retrieve_info(email, password);
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
                
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("redirectUrl", "/Services/Services.jsp");
                
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(jsonResponse.toJSONString());
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Email or Password Invalid");

                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("redirectUrl", "/Services/SigninSignup.jsp");
                
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(jsonResponse.toJSONString());
            }
        } catch (IOException | ParseException e) {
            System.out.println("Exception: " + e);
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
