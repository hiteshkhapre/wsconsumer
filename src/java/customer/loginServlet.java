/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import ws.Account;
import ws.CustomerProfile;
import ws.CustomerWebService_Service;
import ws.RateWebService_Service;


/**
 *
 * @author hiteshkhapre
 */
public class loginServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/CustomerWebService.wsdl")
    private CustomerWebService_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/RateWebService.wsdl")
    private RateWebService_Service service;

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
            String username_input = request.getParameter("login");
            out.println("user input"+username_input);
            String password_input = request.getParameter("password");
            out.println("   user input"+password_input);
            
            String password_db = getPassword(username_input);
            out.println("    user input"+password_db);
            
            String typeOfUser = getTypeOfUser(username_input);
            out.println("    user type"+typeOfUser);
            
            CustomerProfile custProfile = getMyProfile(username_input);
            Account account = getAccountDetails(custProfile.getCustID());
            
            
            if(password_db.equals(password_input))
            {
                out.println("You are an authorised customer !!");
                ServletContext context = getServletContext();
                context.setAttribute("User", username_input);
                context.setAttribute("UserType", typeOfUser);
                String sessionID = UUID.randomUUID().toString();
                
                HttpSession session = request.getSession();
                session.setAttribute("User", username_input);
                session.setAttribute("UserType", typeOfUser);
                session.setAttribute("sessionID", sessionID);
                session.setAttribute("CustID", custProfile.getCustID());
                 session.setAttribute("FirstName", custProfile.getCustFirstname());
                 session.setAttribute("AccountNumber", account.getAccountNumber());
                 session.setAttribute("LastName", custProfile.getCustLastname());
                 session.setAttribute("AddressLine1", custProfile.getCustAddressline1());
                 session.setAttribute("AddressLine2", custProfile.getCustAddressline2());
                 session.setAttribute("City", custProfile.getCustCity());
                 
                
                if(typeOfUser.equals("customer"))
                {
                    response.sendRedirect("Welcome_Customer.jsp");
                }else
                {
                     response.sendRedirect("Welcome_Admin.jsp");
                }
                
            }else
            {
                
                response.sendRedirect("wrong_credentials.jsp");
                
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

    private String getPassword(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.RateWebService port = service.getRateWebServicePort();
        return port.getPassword(username);
    }
    private String getTypeOfUser(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.RateWebService port = service.getRateWebServicePort();
        return port.getTypeofUser(username);
    }

    private CustomerProfile getMyProfile(java.lang.String customerUsername) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.getMyProfile(customerUsername);
    }

    private Account getAccountDetails(int custID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.getAccountDetails(custID);
    }

}
