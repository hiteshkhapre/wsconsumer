/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.CustomerProfile;

/**
 *
 * @author hiteshkhapre
 */
public class updateCustomerServlet extends HttpServlet {

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
        CustomerProfile customerProfile = new CustomerProfile();
        
        try (PrintWriter out = response.getWriter()) {
           
            int custID = Integer.valueOf(request.getParameter("CustID"));
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String addressline1 = request.getParameter("addressline1");
            String addressline2 = request.getParameter("addressline2");
            String city = request.getParameter("city");
            String contactnumber = request.getParameter("contactnumber");
            String email = request.getParameter("email");
            
             
            customerProfile.setCustID(custID);
            customerProfile.setCustFirstname(firstname);
            customerProfile.setCustLastname(lastname);
            customerProfile.setCustAddressline1(addressline1);
            customerProfile.setCustAddressline2(addressline2);
            customerProfile.setCustCity(city);
            customerProfile.setCustContactnumber(contactnumber);
            customerProfile.setCustEmail(email);
            
            String successString = "";// addCustomer(customerProfile);
            
            if(successString.equals("Updated"))
            {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Customer Updated Successfully');");
             out.println("location='Welcome_Admin.jsp';");
            out.println("</script>");
           // response.sendRedirect("Welcome_Admin.jsp");
            }
            else
            {
                out.println("<script type=\"text/javascript\">");  
            out.println("alert('Customer Details were not updated due to some problems. Please try again.');");  
             //out.println("location='Welcome_Admin.jsp';");
            out.println("</script>");
           // response.sendRedirect("Welcome_Admin.jsp");
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
