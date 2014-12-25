/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.*;
import java.util.Date;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.text.SimpleDateFormat;
import ws.Account;
import ws.CustomerWebService_Service;


/**
 *
 * @author hiteshkhapre
 */
public class downloadStatServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsRate/CustomerWebService.wsdl")
    private CustomerWebService_Service service_1;
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
        try (OutputStream os = response.getOutputStream()) {
          
            int custID = Integer.valueOf(request.getParameter("custID").toString());
            
            Account account = getAccountDetails(custID);
            
            
            int accountNumber = account.getAccountNumber();//Integer.valueOf(request.getSession().getAttribute("AccountNumber").toString());
            String accountStatus = account.getAccountStatus();
            String accountType = account.getAccountType();
            Double accountBalance = account.getAccountBalance();
            
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            // System.out.println(format.format(date)); //2014/08/06 15:59:48
            
            
            String firstName = request.getSession().getAttribute("FirstName").toString();
            String lastName = request.getSession().getAttribute("LastName").toString();
            
            
            List<Transactions> transactionList = getTransactions(accountNumber);
           
            
            try
            {
                /*Initialize PDF documents - logical objects */
                Document pdf_stat = new Document();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter.getInstance(pdf_stat, baos);
                pdf_stat.open();  
                
                pdf_stat.addTitle("Statement for Account");
               // pdf_stat.add(new Paragraph("Statment of Account", Font.getFamily("BOLD")));
                 pdf_stat.add(new Paragraph(String.format("                                                             Statement Of Account ")));
                 pdf_stat.add(new Paragraph(String.format(" ")));
                 pdf_stat.add(new Paragraph(String.format(" ")));
                 pdf_stat.add(new Paragraph(String.format(" ")));
                pdf_stat.add(new Paragraph(String.format("Customer ID: %s", custID)));
                pdf_stat.add(new Paragraph(String.format("Name: %s %s", firstName,lastName)));
                pdf_stat.add(new Paragraph(String.format("Account Number: %s", accountNumber)));
                pdf_stat.add(new Paragraph(String.format("Account Type: %s", accountType)));
                pdf_stat.add(new Paragraph(String.format("Account Status: %s", accountStatus)));
                pdf_stat.add(new Paragraph(String.format("Account Balance as on %s : %s", format.format(date),accountBalance)));
                pdf_stat.add(new Paragraph(String.format(" ")));
                
                
                //we have ** columns in our table
                PdfPTable pdf_Table = new PdfPTable(4);
                //create a cell object
                PdfPCell table_cell;
                
                 table_cell = new PdfPCell(new Phrase("TransactionID"));
                    pdf_Table.addCell(table_cell);
                    // table_cell = new PdfPCell(new Phrase("AccountNumber"));
                    //  pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase("TransactionType"));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase("TimeStamp"));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase("Trans Amount"));
                    pdf_Table.addCell(table_cell);
                
                
                for(Transactions trans : transactionList)
                {
                    table_cell = new PdfPCell(new Phrase(String.valueOf(trans.getTransactionID())));
                    pdf_Table.addCell(table_cell);
                    // table_cell = new PdfPCell(new Phrase(String.valueOf(accountNumber)));
                    //  pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getTransactionType()));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getDateTime().toString()));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getTransactionAmount().toString()));
                    pdf_Table.addCell(table_cell);
                    
                }
                //pdf_stat.add(new Paragraph(String.format("Account Balance: %s", accountNumber)));
                
                pdf_stat.add(new Paragraph(String.format("Statement: ")));
                pdf_stat.add(new Paragraph(String.format(" ")));
                   /* Attach report table to PDF */
                pdf_stat.add(pdf_Table); 
                //pdf_stat.open();
                pdf_stat.close();
                
                // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            //OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
                
              //  response.sendRedirect("statement.pdf");
            }catch(Exception e)
            {
                e.printStackTrace();
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

    private java.util.List<transactions.Transactions> getTransactions(int accountNumber) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactions.TransactionWebService port = service.getTransactionWebServicePort();
        return port.getTransactions(accountNumber);
    }

    private Account getAccountDetails(int custID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.getAccountDetails(custID);
    }

}
