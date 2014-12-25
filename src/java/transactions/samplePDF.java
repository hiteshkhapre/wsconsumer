import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.*;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
public class samplePDF {  
        public static void main(String[] args) throws Exception{
               try
               {
                    /* Create Connection objects */
                Class.forName ("com.mysql.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ABC Bank?zeroDateTimeBehavior=convertToNull",
                        "abcbank", "abcbank");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
                ResultSet query_set = stmt.executeQuery("SELECT Transaction_ID,Account_Number,Transaction_Type,Timestamp,Transaction_Amount FROM `ABC Bank`.Transaction");
                   System.out.println("Connected and got the query result");
                   
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                my_pdf_report.open();            
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(5);
                //create a cell object
                PdfPCell table_cell;
               
                while (query_set.next()) {                
                                String dept_id = String.valueOf(query_set.getInt("Transaction_ID"));
                                table_cell=new PdfPCell(new Phrase(dept_id));
                                my_report_table.addCell(table_cell);
                                String dept_name=String.valueOf(query_set.getInt("Account_Number"));
                                table_cell=new PdfPCell(new Phrase(dept_name));
                                my_report_table.addCell(table_cell);
                                String manager_id=query_set.getString("Transaction_Type");
                                table_cell=new PdfPCell(new Phrase(manager_id));
                                my_report_table.addCell(table_cell);
                                
                                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse (query_set.getTimestamp("Timestamp").toString());
                                
                                String location_id= date.toString();
                                table_cell=new PdfPCell(new Phrase(location_id));
                                my_report_table.addCell(table_cell);
                                
                                
                                table_cell=new PdfPCell(new Phrase(String.valueOf(query_set.getDouble("Transaction_Amount"))));
                                my_report_table.addCell(table_cell);
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();      
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
        }
}