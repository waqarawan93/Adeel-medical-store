/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import static java.lang.Thread.sleep;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class DBhandler {
    Connection con;
    ResultSet rs;
    Statement st;
    
    public DBhandler(){
       getconnected();
     }
    
    public void getconnected(){
       
       try{
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           con=(Connection) DriverManager.getConnection("jdbc:ucanaccess://medical.accdb");
            st= con.createStatement();
           //String sql="select * from stock";
           //rs=st.executeQuery(sql);
         // JOptionPane.showMessageDialog(null,"Connection Established");
    
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
          
       }
           
    }
    
    public void executequery(String sql, String msg){
    
         try{
                         
            if ( st.executeUpdate(sql)==1) {
                
                JOptionPane.showMessageDialog(null, "Data "+ msg+ " Successfully ");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not "+ msg);
            }
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
         
    }
    
    public void executeResult (String sql)    {
         
       try{
           
          if( st.executeQuery(sql)!=null)
          { 
            // JOptionPane.showMessageDialog(null, "Data Found ");
              rs= st.executeQuery(sql);
           // return rs;
          }
          else  JOptionPane.showMessageDialog(null, "Data Not Found ");
             
              
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           // return null;
         }
       }
    
    public void updatetable (String table , JTable jtable){
        String t=table;
        String sql= "select * from "+ t ;
        try{
        rs= st.executeQuery(sql);
        jtable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
           
        }
    }
    
    
    
    
     public void  CurrentDate(JTextField  t)
    {
       
        
        Thread clock=new Thread(){
        public void run()
        {
        for(;;)
        {
        Calendar cal= new GregorianCalendar();
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        
        int second=cal.get(Calendar.SECOND);
        int minute=cal.get(Calendar.MINUTE);
        int hour=cal.get(Calendar.HOUR);
        t.setText(day+"-"+(month+1)+"-"+year+"  "+hour+":"+(minute)+":"+second);
        
       
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        };
        clock.start();
    }}