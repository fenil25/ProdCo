
import java.sql.Connection;
import java.sql.SQLException;
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
public class Issues extends javax.swing.JFrame {

    private Connection con;

    /**
     * Creates new form Issues
     */
    public Issues() {
        initComponents();
    }
    
    public Issues(Connection con) {
        initComponents();
        this.con = con;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cst_issue = new javax.swing.JButton();
        emp_issue = new javax.swing.JButton();
        displayEmpIssues = new javax.swing.JButton();
        dispOrderIssue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cst_issue.setText("Report Issue With Customer");
        cst_issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cst_issueActionPerformed(evt);
            }
        });

        emp_issue.setText("Report Issue With Employee");
        emp_issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_issueActionPerformed(evt);
            }
        });

        displayEmpIssues.setText("See All Employee Issues");
        displayEmpIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayEmpIssuesActionPerformed(evt);
            }
        });

        dispOrderIssue.setText("See All Order Issues");
        dispOrderIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispOrderIssueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displayEmpIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cst_issue, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(emp_issue, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(dispOrderIssue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(emp_issue, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(displayEmpIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cst_issue, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(dispOrderIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emp_issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_issueActionPerformed
        // TODO add your handling code here:
        AddIssue ae;
        try {
            ae = new AddIssue(con, "employee", 0, -1, "", "", "", "", "");
            ae.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Issues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_emp_issueActionPerformed

    private void cst_issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cst_issueActionPerformed
        // TODO add your handling code here:
        AddIssue ae;
        try {
            ae = new AddIssue(con, "customer", 0, -1, "", "", "", "", "");
            ae.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Issues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cst_issueActionPerformed

    private void displayEmpIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayEmpIssuesActionPerformed
        // TODO add your handling code here:
        DisplayEmpIssue ei;
        try {
            ei = new DisplayEmpIssue(con, "employee");
            ei.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Issues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_displayEmpIssuesActionPerformed

    private void dispOrderIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispOrderIssueActionPerformed
        // TODO add your handling code here:
        DisplayEmpIssue ei;
        try {
            ei = new DisplayEmpIssue(con, "order");
            ei.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Issues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dispOrderIssueActionPerformed

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
            java.util.logging.Logger.getLogger(Issues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cst_issue;
    private javax.swing.JButton dispOrderIssue;
    private javax.swing.JButton displayEmpIssues;
    private javax.swing.JButton emp_issue;
    // End of variables declaration//GEN-END:variables
}
