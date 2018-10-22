
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lenovo
 */
public class AddIssue extends javax.swing.JFrame {

    private Connection con;
    HashMap<String, Integer> emp = new HashMap<>();
    HashMap<String, Integer> cust = new HashMap<>();
    private String caller;
    private int updateFlag, issueId;
    

    /**
     * Creates new form AddIssue
     */
    public AddIssue() {
        initComponents();
    }
    
    public AddIssue(Connection con, String issueCall, int updateFlag, int issid, String name, String desc, 
            String status, String rby, String assto) throws SQLException {
        this.con = con;
        this.caller = issueCall;
        this.updateFlag = updateFlag;
        this.issueId = issid;
        initComponents();
        
        Statement st1 = con.createStatement();
        ResultSet r = st1.executeQuery("SELECT * FROM Employee");
        while(r.next()){
            assignedToField.addItem(r.getString("first_name") + " " + r.getString("last_name"));
            emp.put(r.getString("first_name") + " " + r.getString("last_name"), Integer.parseInt(r.getString("idEmployee")));
        }
       
        if(issueCall.equals("employee")){
            headLabel.setText("Employee Issue");
            Statement st2 = con.createStatement();
            ResultSet r2 = st2.executeQuery("SELECT * FROM Employee");
            while(r2.next()){
                reportedByField.addItem(r2.getString("first_name") + " " + r2.getString("last_name"));
            }
        }else{
            headLabel.setText("Customer Issue");
            Statement st3 = con.createStatement();
            ResultSet r3 = st3.executeQuery("SELECT * FROM Customer");
            while(r3.next()){
                reportedByField.addItem(r3.getString("first_name") + " " + r3.getString("last_name"));
                cust.put(r3.getString("first_name") + " " + r3.getString("last_name"), Integer.parseInt(r3.getString("idCustomer")));
            }
        }
        
        AutoCompletion.enable(assignedToField);
        AutoCompletion.enable(reportedByField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        statusField = new javax.swing.JComboBox<>();
        reportedByLabel = new javax.swing.JLabel();
        reportedByField = new javax.swing.JComboBox<>();
        assignedToLabel = new javax.swing.JLabel();
        assignedToField = new javax.swing.JComboBox<>();
        headLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setText("Issue Name");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        descriptionLabel.setText("Description");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        statusLabel.setText("Status");

        statusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Raised", "Started Working", "Mildly Completed", "Left Uncompleted", "Closed" }));

        reportedByLabel.setText("Reported By");

        assignedToLabel.setText("Assigned To");

        headLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headLabel.setText("EMPLOYEE ISSUES");

        addButton.setText("Add Issue");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assignedToLabel)
                    .addComponent(reportedByLabel)
                    .addComponent(statusLabel)
                    .addComponent(descriptionLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(assignedToField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportedByField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(descriptionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportedByLabel)
                    .addComponent(reportedByField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assignedToLabel)
                    .addComponent(assignedToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if(caller.equals("employee")){
            String name = nameField.getText();
            String description = descriptionField.getText();
            String reported_by_id = emp.get(reportedByField.getSelectedItem().toString())+"";
            String assigned_to_id = emp.get(assignedToField.getSelectedItem().toString())+"";
            String status = statusField.getSelectedItem().toString()+"";

            String query1, query2;
            query1 = String.format("INSERT INTO employee_issue (name, description, raised_by, assigned_to, status) VALUES('%s', '%s', %s, %s, '%s');", 
                    name, description, reported_by_id, assigned_to_id, status);
            query2 = String.format("UPDATE employee_issue SET name = '%s', description = '%s', status = '%s', raised_by = %s, assigned_to = %s"
                    + " WHERE idEmployee_Issue = %s;",
                     name, description, status, reported_by_id, assigned_to_id, issueId);
            
            System.out.println(query1);
            System.out.println(query2);

            try {
                Statement addq = con.createStatement();
                JFrame f = new JFrame();
                if(updateFlag == 0){
                    addq.executeUpdate(query1);
                    JOptionPane.showMessageDialog(f, "Issue added successfully");
                } else {
                    addq.executeUpdate(query2);
                    JOptionPane.showMessageDialog(f, "Issue updated successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
        }
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddIssue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> assignedToField;
    private javax.swing.JLabel assignedToLabel;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel headLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> reportedByField;
    private javax.swing.JLabel reportedByLabel;
    private javax.swing.JComboBox<String> statusField;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
