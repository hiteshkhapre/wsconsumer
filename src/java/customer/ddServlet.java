/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import customer.DirectDebitWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author hiteshkhapre
 */
public class ddServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/DirectDebitWebService.wsdl")
    private DirectDebitWebService_Service service;

    private int accountNumber;
    private double amount;
    private int custID;
    
    public class DirectDebitTask extends TimerTask
{

    public void run()
    {
        debitDDAmount();
    }
}
    
    
    protected void debitDDAmount(){
        //call directdebit operation
        
        
    }
    
    
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
           
            accountNumber = Integer.valueOf(request.getParameter("accountNumber"));
            amount = Double.valueOf(request.getParameter("amount"));
            custID = Integer.valueOf(request.getSession().getAttribute("CustID").toString());
            
            String dateString = request.getParameter("scheduledate");
           DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd
           Date date = format.parse(dateString);
           
           GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(date);
           
           XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
           
            //call insertDDData operation and insert the data into the DB
           String successString = insertDDData(accountNumber,amount,calendar);
           
           String msg = "Direct Debit instruction Successful.";
                    
            //Start the time on the reciept of successful insertion of data.
           if(successString.equals("Inserted"))
           {
             //  Timer timer = new Timer();
           // TimerTask ddTimerTask = new DirectDebitTask();
           // timer.scheduleAtFixedRate(ddTimerTask, 0, 600000);
            
             out.println("<script type=\"text/javascript\">");  
             out.println("alert(\"" +msg+ "\")");
             out.println("location='setupDD.jsp';");
            out.println("</script>");
            
           }else
           {
               out.println("<script type=\"text/javascript\">");  
            out.println("alert('Direct Debit instruction unsuccessful due to some problems. Please try again.');");  
             out.println("location='setupDD.jsp';");
            out.println("</script>");
           }
          
           // timer.schedule(ddTimerTask, date);
            
            
        } catch (Exception ex) {
            Logger.getLogger(ddServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private String insertDDData(int accountNumber, double amount, javax.xml.datatype.XMLGregorianCalendar date) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        customer.DirectDebitWebService port = service.getDirectDebitWebServicePort();
        return port.insertDDData(accountNumber, amount, date);
    }

  
}
