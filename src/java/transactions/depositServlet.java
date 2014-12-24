/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author hiteshkhapre
 */
public class depositServlet extends HttpServlet {
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
            Double depositAmount = (Double.valueOf(request.getParameter("depositAmount").toString()));
            
            //Call the deposit web service operation 
            String successString = depositMoney(depositAmount, custID);
            Account account = getAccountDetails(custID);
            Double newBalance = account.getAccountBalance();
            String msg = "Deposit Successful. Your new Balance is ".concat(newBalance.toString());
                    
                    
             if(successString.equals("Deposited"))
            {
            out.println("<script type=\"text/javascript\">");  
             out.println("alert(\"" +msg+ "\")");
             out.println("location='depositMoney.jsp';");
            out.println("</script>");
            }
            else
            {
                out.println("<script type=\"text/javascript\">");  
            out.println("alert('Deposit is unsuccessful due to some problems. Please try again.');");  
             out.println("location='depositMoney.jsp';");
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

    private String depositMoney(java.lang.Double amount, int custID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactions.TransactionWebService port = service.getTransactionWebServicePort();
        return port.depositMoney(amount, custID);
    }

    private Account getAccountDetails(int custID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactions.TransactionWebService port = service.getTransactionWebServicePort();
        return port.getAccountDetails(custID);
    }

    
    
}
