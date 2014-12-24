/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author hiteshkhapre
 */
public class withdrawServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/TransactionWebService.wsdl")
    private TransactionWebService_Service service;

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
            String accountNumber = request.getSession().getAttribute("AccountNumber").toString();
            int custID = Integer.valueOf(request.getParameter("custID").toString());
            Double withdrawAmount = (Double.valueOf(request.getParameter("withdrawAmount").toString()));
            
            //Call the withdraw money web service
            String successString = withdrawMoney(custID, withdrawAmount);
            
             Account account = getAccountDetails(custID);
            Double newBalance = account.getAccountBalance();
            
              String msg = "Withdraw Successful. Your new Balance is ".concat(newBalance.toString());
              
           
             if(successString.equals("Withdrawn"))
            {
            out.println("<script type=\"text/javascript\">");  
             out.println("alert(\"" +msg+ "\")");
             out.println("location='withdrawMoney.jsp';");
            out.println("</script>");
            }
             else if(successString.equals("Not Sufficient Balance."))
            {
                out.println("<script type=\"text/javascript\">");  
            out.println("alert('You do not have sufficient balance in your account.');");  
             out.println("location='withdrawMoney.jsp';");
            out.println("</script>");
            }else
             {
                   out.println("<script type=\"text/javascript\">");  
            out.println("alert('Withdraw is unsuccessful due to some problems. Please try again.');");  
             out.println("location='withdrawMoney.jsp';");
            out.println("</script>");
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

    private String withdrawMoney(int custID, double amount) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactions.TransactionWebService port = service.getTransactionWebServicePort();
        return port.withdrawMoney(custID, amount);
    }

    private Account getAccountDetails(int custID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactions.TransactionWebService port = service.getTransactionWebServicePort();
        return port.getAccountDetails(custID);
    }

}
