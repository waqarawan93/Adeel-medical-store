/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Waqar Ahmed
 */
public class Login extends javax.swing.JFrame {
        DBhandler db= new DBhandler();
              
              
       /**
        * Creates new form Login
        * @throws java.lang.ClassNotFoundException
        */
       public Login() throws ClassNotFoundException, SQLException {
             initComponents();
              setExtendedState(getExtendedState() | this.MAXIMIZED_BOTH);
        
              
       }

       /**
        * This method is called from within the constructor to initialize the
        * form. WARNING: Do NOT modify this code. The content of this method is
        * always regenerated by the Form Editor.
        */
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        t2 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setMinimumSize(new java.awt.Dimension(1365, 735));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 40, 120, 30);

        t1.setToolTipText("Enter your User Name");
        jPanel1.add(t1);
        t1.setBounds(120, 40, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 100, 110, 20);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("LOG IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 150, 250, 40);
        jPanel1.add(t2);
        t2.setBounds(120, 90, 200, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(470, 320, 372, 206);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharmacy/Medical-img.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1370, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

       private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
              try {
                     String x,y;
                     x=t1.getText();
                     y=t2.getText();
                     String a,b;
                     String query="select * from users";
                     db.executeResult(query);
                      home obj=null;                 
                     while (db.rs.next())
                     {
                       a=db.rs.getString("username");
                       b=db.rs.getString("password");
                      if(x.equals(a)&&y.equals(b))
                     {
                      obj= new home ();
                     obj.setVisible(true);
                     dispose();  
                    
                     }
                     
                     }
                     if(obj==null)
                     JOptionPane.showMessageDialog(this,"Incorrect Username or Password !");
              } catch (SQLException ex) {
                     Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
              }
       }//GEN-LAST:event_jButton1ActionPerformed

       /**
        * @param args the command line arguments
        */
       public static void main(String args[]) {
              
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
               * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
               */
              try {
                     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                   break;
                            }
                     }
              } catch (ClassNotFoundException ex) {
                     java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
        //</editor-fold>
        //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            try {
                                   DBhandler object = new DBhandler();
                                   new Login().setVisible(true);
                            } catch (ClassNotFoundException ex) {
                                   Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                   Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                     }
              });
       }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    // End of variables declaration//GEN-END:variables
}
