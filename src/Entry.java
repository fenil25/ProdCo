import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Entry extends javax.swing.JFrame {
    
    Connection con;

    /**
     * Creates new form Entry
     */
    public Entry() {
        try {
            initComponents();
            Class.forName("java.sql.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/prodco2", "root", "pass@123");
        } catch (Exception ex) {
            Logger.getLogger(Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmployeeEntry = new javax.swing.JButton();
        DepartmentEntry = new javax.swing.JButton();
        CustomerEntry = new javax.swing.JButton();
        IssueEntry = new javax.swing.JButton();
        OrderEntry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        EmployeeEntry.setText("Employee");
        EmployeeEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeEntryActionPerformed(evt);
            }
        });

        DepartmentEntry.setText("Department");
        DepartmentEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentEntryActionPerformed(evt);
            }
        });

        CustomerEntry.setText("Customer");
        CustomerEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerEntryActionPerformed(evt);
            }
        });

        IssueEntry.setText("Issue");

        OrderEntry.setText("Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DepartmentEntry)
                    .addComponent(EmployeeEntry, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CustomerEntry, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderEntry)
                            .addComponent(IssueEntry))
                        .addGap(14, 14, 14)))
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(EmployeeEntry)
                .addGap(28, 28, 28)
                .addComponent(DepartmentEntry)
                .addGap(33, 33, 33)
                .addComponent(CustomerEntry)
                .addGap(27, 27, 27)
                .addComponent(IssueEntry)
                .addGap(26, 26, 26)
                .addComponent(OrderEntry)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeEntryActionPerformed
        // TODO add your handling code here:
        Employee e = new Employee(con);
        e.setVisible(true);
    }//GEN-LAST:event_EmployeeEntryActionPerformed

    private void DepartmentEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentEntryActionPerformed
        // TODO add your handling code here:
        Department d = new Department(con);
        d.setVisible(true);
    }//GEN-LAST:event_DepartmentEntryActionPerformed

    private void CustomerEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerEntryActionPerformed
        // TODO add your handling code here:
        Customer c = new Customer(con);
        c.setVisible(true);
    }//GEN-LAST:event_CustomerEntryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomerEntry;
    private javax.swing.JButton DepartmentEntry;
    private javax.swing.JButton EmployeeEntry;
    private javax.swing.JButton IssueEntry;
    private javax.swing.JButton OrderEntry;
    // End of variables declaration//GEN-END:variables
}
