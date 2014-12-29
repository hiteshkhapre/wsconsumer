/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.SQLException_Exception;

/**
 *
 * @author hiteshkhapre
 */
public class deleteCustomerServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/CustomerWebService.wsdl")
    private ws.CustomerWebService_Service service;

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
            
            int custID = Integer.valueOf(request.getParameter("customerID"));
            try {
                //Send redirect to login page directly as the customer is deleted so there wouldnt be any record left for that
                //customer in the database.
                String successString = deleteCustomer(custID);
                
                if(successString.equals("Deleted"))
                {
                     out.println("<script type=\"text/javascript\">");  
            out.println("alert('Customer details are deleted Successfully');");
             out.println("location='deleteCustomerForm.jsp';");
            out.println("</script>");
                }else if(successString.equals("No Customer Found."))
                {
                    out.println("<script type=\"text/javascript\">");  
            out.println("alert('No Customer found with the entered customer ID. Please try again.');");
             out.println("location='deleteCustomerForm.jsp';");
            out.println("</script>");
                } else
                {
                     out.println("<script type=\"text/javascript\">");  
            out.println("alert('Customer Details were not deleted due to some problems. Please try again.');");
             out.println("location='deleteCustomerForm.jsp';");
            out.println("</script>");
                }
                
            } catch (SQLException_Exception ex) {
                Logger.getLogger(deleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private String deleteCustomer(int custID) throws ws.SQLException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CustomerWebService port = service.getCustomerWebServicePort();
        return port.deleteCustomer(custID);
    }

}
