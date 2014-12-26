/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hiteshkhapre
 */
public class ddServlet extends HttpServlet {

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
           
            accountNumber = Integer.valueOf(request.getParameter("accountNumber").toString());
            amount = Double.valueOf(request.getParameter("amount").toString());
            custID = Integer.valueOf(request.getSession().getAttribute("CustID").toString());
            
            String dateString = request.getParameter("scheduledate").toString();
           DateFormat format = new SimpleDateFormat("DD MM yyyy");//yyyy-MM-dd
           Date date = format.parse(dateString);
            
            //call insertDDData operation and insert the data into the DB
           
           
           //Start the time on the reciept of successful insertion of data.
           
           
            Timer timer = new Timer();
            TimerTask ddTimerTask = new DirectDebitTask();
            timer.scheduleAtFixedRate(ddTimerTask, 0, 600000);
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

}
