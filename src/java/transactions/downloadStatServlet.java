/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 *
 * @author hiteshkhapre
 */
public class downloadStatServlet extends HttpServlet {
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
          
            int custID = Integer.valueOf(request.getParameter("custID").toString());
            int accountNumber = Integer.valueOf(request.getSession().getAttribute("AccountNumber").toString());
            
            ArrayList<Transactions> transactionList = (ArrayList) getTransactions(4);
            
            try
            {
                /*Initialize PDF documents - logical objects */
                Document pdf_stat = new Document();
                PdfWriter.getInstance(pdf_stat, new FileOutputStream("statement.pdf"));
                pdf_stat.open();            
                //we have ** columns in our table
                PdfPTable pdf_Table = new PdfPTable(5);
                //create a cell object
                PdfPCell table_cell;
                
                for(Transactions trans : transactionList)
                {
                    table_cell = new PdfPCell(new Phrase(trans.getTransactionID()));
                    pdf_Table.addCell(table_cell);
                     table_cell = new PdfPCell(new Phrase(accountNumber));
                      pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getTransactionType()));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getDateTime().toString()));
                    pdf_Table.addCell(table_cell);
                    table_cell = new PdfPCell(new Phrase(trans.getTransactionAmount().toString()));
                    pdf_Table.addCell(table_cell);
                    
                }
                   /* Attach report table to PDF */
                pdf_stat.add(pdf_Table); 
                //pdf_stat.open();
                pdf_stat.close();
                              
                response.sendRedirect("statement.pdf");
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

}
