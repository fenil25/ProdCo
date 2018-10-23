/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author parth
 */
public class DisplayEmpIssue extends javax.swing.JFrame {
    
    private Connection con;
    String issues_Id;
    String type;

    /**
     * Creates new form DisplayEmpIssue
     */
    public DisplayEmpIssue() {
        initComponents();
    }
    
    public DisplayEmpIssue(Connection con, String type) throws SQLException {
        initComponents();
        this.con = con;
        this.type = type;
        
        if (this.type.equals("employee")) {
        
    //        issue_status.addItem("ALL");
            raised_by.addItem("ALL");
            assigned_to.addItem("ALL");
            AutoCompletion.enable(issue_status);
            Statement st1 = con.createStatement();
            ResultSet r1 = st1.executeQuery("SELECT * FROM employee;");
            while(r1.next()) {
                assigned_to.addItem(r1.getString("idEmployee") + ": " + r1.getString("first_name") + " " + r1.getString("last_name"));
                raised_by.addItem(r1.getString("idEmployee") + ": " + r1.getString("first_name") + " " + r1.getString("last_name"));
            }

            Statement st2 = con.createStatement();
            ResultSet r2 = st2.executeQuery("SELECT * FROM employee_issue, employee as raiser, employee as assignee WHERE raiser.idEmployee=raised_by AND assignee.idEmployee=assigned_to;");
            DefaultTableModel model = (DefaultTableModel) issues_table.getModel();
            model.setRowCount(0);
            issues_Id = "";
            while (r2.next()) {
                String id = r2.getString("idEmployee_Issue");
                String name = r2.getString("name");
                String status = r2.getString("status");
                String description = r2.getString("description");
                String raiser = r2.getString("raised_by") + ": " + r2.getString("raiser.first_name") + " " + r2.getString("raiser.last_name");
                String assignee = r2.getString("assigned_to") + ": " + r2.getString("assignee.first_name") + " " + r2.getString("assignee.last_name");
                model.addRow(new Object[]{id, name, status, raiser, assignee, description});
                issues_Id = issues_Id + ", " + id;
            }
            r1.close();
            r2.close();
        } else {
            raised_by.addItem("ALL");
            assigned_to.addItem("ALL");
            AutoCompletion.enable(issue_status);
            Statement st1 = con.createStatement();
            ResultSet r1 = st1.executeQuery("SELECT * FROM employee;");
            while(r1.next()) {
                assigned_to.addItem(r1.getString("idEmployee") + ": " + r1.getString("first_name") + " " + r1.getString("last_name"));
            }
            Statement st3 = con.createStatement();
            ResultSet r3 = st3.executeQuery("SELECT * FROM orders;");
            while(r3.next()) {
                raised_by.addItem(r3.getString("idOrder") + ": " + r3.getString("order_name"));
            }
            Statement st2 = con.createStatement();
            ResultSet r2 = st2.executeQuery("SELECT * FROM order_issue, orders as raiser, employee as assignee WHERE raiser.idOrder=raised_for AND assignee.idEmployee=assigned_to;");
            DefaultTableModel model = (DefaultTableModel) issues_table.getModel();
            model.setRowCount(0);
            issues_Id = "";
            while (r2.next()) {
                String id = r2.getString("idOrder_Issue");
                String name = r2.getString("name");
                String status = r2.getString("status");
                String description = r2.getString("description");
                String raiser = r2.getString("raised_for") + ": " + r2.getString("raiser.order_name");
                String assignee = r2.getString("assigned_to") + ": " + r2.getString("assignee.first_name") + " " + r2.getString("assignee.last_name");
                model.addRow(new Object[]{id, name, status, raiser, assignee, description});
                issues_Id = issues_Id + ", " + id;
            }
            r1.close();
            r2.close();
            r3.close();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        raised_by = new javax.swing.JComboBox<>();
        assigned_to = new javax.swing.JComboBox<>();
        issue_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        issues_table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        update_button = new javax.swing.JButton();
        delete_single = new javax.swing.JButton();
        delete_all = new javax.swing.JButton();
        filter_button = new javax.swing.JButton();
        issue_status = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Filter By");

        jLabel2.setText("Issue Name");

        jLabel3.setText("Issue Status");

        jLabel4.setText("Raised By");

        jLabel5.setText("Assigned To");

        issues_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name ", "Status", "Raised By", "Assigned To", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issues_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(issues_table);

        jLabel6.setText("Description");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane3.setViewportView(desc);

        update_button.setText("Update Selected Entry");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        delete_single.setText("Delete Selected Entry");
        delete_single.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_singleActionPerformed(evt);
            }
        });

        delete_all.setText("Delete All");
        delete_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_allActionPerformed(evt);
            }
        });

        filter_button.setText("Filter");
        filter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_buttonActionPerformed(evt);
            }
        });

        issue_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Raised", "Resolved" }));
        issue_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(15, 15, 15)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(issue_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(issue_name))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(assigned_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(raised_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(filter_button, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete_single, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(delete_all, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(raised_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issue_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(assigned_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(filter_button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_button)
                            .addComponent(delete_single)
                            .addComponent(delete_all)))
                    .addComponent(issue_status, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        
        if(this.type.equals("employee")) {
            int rowIndex = issues_table.getSelectedRow();
            JFrame jf = new JFrame();
            if (rowIndex == -1) {
                JOptionPane.showMessageDialog(jf, "Please Select an Entry To Perform This Operation");
            } else {
                AddIssue ai;
                String in, is, idesc, irby, iassto;
                try {
                    int id = Integer.parseInt(issues_table.getValueAt(rowIndex, 0).toString());
                    in = issues_table.getValueAt(rowIndex, 1).toString();
                    is = issues_table.getValueAt(rowIndex, 2).toString();
                    irby = issues_table.getValueAt(rowIndex, 3).toString().split(": ")[1];
                    iassto = issues_table.getValueAt(rowIndex, 4).toString().split(": ")[1];
                    idesc = issues_table.getValueAt(rowIndex, 5).toString();
                    try {
                        ai = new AddIssue(con, "employee", 1, id, in, idesc, is, irby, iassto);
                        ai.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(jf, "Something Went Wrong");
                }
            }
        } else {
            int rowIndex = issues_table.getSelectedRow();
            JFrame jf = new JFrame();
            if (rowIndex == -1) {
                JOptionPane.showMessageDialog(jf, "Please Select an Entry To Perform This Operation");
            } else {
                AddIssue ai;
                String in, is, idesc, irby, iassto;
                try {
                    int id = Integer.parseInt(issues_table.getValueAt(rowIndex, 0).toString());
                    in = issues_table.getValueAt(rowIndex, 1).toString();
                    is = issues_table.getValueAt(rowIndex, 2).toString();
                    irby = issues_table.getValueAt(rowIndex, 3).toString().split(": ")[1];
                    iassto = issues_table.getValueAt(rowIndex, 4).toString().split(": ")[1];
                    idesc = issues_table.getValueAt(rowIndex, 5).toString();
                    try {
                        ai = new AddIssue(con, "customer", 1, id, in, idesc, is, irby, iassto);
                        ai.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(jf, "Something Went Wrong");
                }
            }
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void filter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_buttonActionPerformed
        
        if(this.type.equals("employee")) {
        try {
            // TODO add your handling code here:
            String name = "%" + issue_name.getText() + "%";
            String status = "%" + issue_status.getSelectedItem().toString() + "%";
            if (status.equals("%ALL%"))
                status = "%%";
            String description = "%" + desc.getText() + "%";
            String raiser;
            raiser = "%" + raised_by.getSelectedItem().toString().split(":")[0] + "%";
            System.out.println(raiser);
            System.out.println(raised_by.getSelectedItem().toString().split(":")[0]);
            if (raiser.equals("%ALL%"))
                raiser = "%%";
            String assignee = "%" + assigned_to.getSelectedItem().toString().split(":")[0] + "%";
            if (assignee.equals("%ALL%"))
                assignee = "%%";
            
            Statement st = con.createStatement();
            String query = String.format("SELECT * FROM employee_issue, employee AS raiser, employee AS assignee WHERE name LIKE '%s' AND status LIKE '%s' AND description LIKE '%s' AND "
                    + "raised_by LIKE '%s' AND assigned_to LIKE '%s' AND raiser.idEmployee=raised_by AND assignee.idEmployee=assigned_to;", name, status, description, raiser, assignee); 
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) issues_table.getModel();
            model.setRowCount(0);
            issues_Id = "";
            while (rs.next()) {
                String id = rs.getString("idEmployee_Issue");
                String row_name = rs.getString("name");
                String row_status = rs.getString("status");
                String row_description = rs.getString("description");
                String row_raiser = rs.getString("raised_by") + ": " + rs.getString("raiser.first_name") + " " + rs.getString("raiser.last_name");
                String row_assignee = rs.getString("assigned_to") + ": " + rs.getString("assignee.first_name") + " " + rs.getString("assignee.last_name");
                model.addRow(new Object[]{id, row_name, row_status, row_raiser, row_assignee, row_description});
                issues_Id = issues_Id + ", " + id;
            }
            rs.close();
                    
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
        }
      } else {
            try {
            // TODO add your handling code here:
            String name = "%" + issue_name.getText() + "%";
            String status = "%" + issue_status.getSelectedItem().toString() + "%";
            if (status.equals("%ALL%"))
                status = "%%";
            String description = "%" + desc.getText() + "%";
            String raiser;
            raiser = "%" + raised_by.getSelectedItem().toString().split(":")[0] + "%";
            System.out.println(raiser);
            System.out.println(raised_by.getSelectedItem().toString().split(":")[0]);
            if (raiser.equals("%ALL%"))
                raiser = "%%";
            String assignee = "%" + assigned_to.getSelectedItem().toString().split(":")[0] + "%";
            if (assignee.equals("%ALL%"))
                assignee = "%%";
            
            Statement st = con.createStatement();
            String query = String.format("SELECT * FROM order_issue, orders AS raiser, employee AS assignee WHERE name LIKE '%s' AND status LIKE '%s' AND description LIKE '%s' AND "
                    + "raised_for LIKE '%s' AND assigned_to LIKE '%s' AND raiser.idOrder=raised_for AND assignee.idEmployee=assigned_to;", name, status, description, raiser, assignee); 
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) issues_table.getModel();
            model.setRowCount(0);
            issues_Id = "";
            while (rs.next()) {
                String id = rs.getString("idOrder_Issue");
                String row_name = rs.getString("name");
                String row_status = rs.getString("status");
                String row_description = rs.getString("description");
                String row_raiser = rs.getString("raised_for") + ": " + rs.getString("raiser.order_name");
                String row_assignee = rs.getString("assigned_to") + ": " + rs.getString("assignee.first_name") + " " + rs.getString("assignee.last_name");
                model.addRow(new Object[]{id, row_name, row_status, row_raiser, row_assignee, row_description});
                issues_Id = issues_Id + ", " + id;
            }
            rs.close();
                                                                            
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_filter_buttonActionPerformed

    private void issue_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issue_statusActionPerformed

    private void delete_singleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_singleActionPerformed
        // TODO add your handling code here:
        if(this.type.equals("employee")) {
            int rowIndex = issues_table.getSelectedRow();
            JFrame f = new JFrame();
            if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please select an entry to perform this operation.");
            } else {
                try {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete This Employee Issue?", "Delete Employee Issue", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        int ed = Integer.parseInt(issues_table.getValueAt(rowIndex, 0).toString());
                        String query = String.format("DELETE from employee_issue WHERE idEmployee_Issue = '" + ed + "';");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                }
                else {return;}
                try {
                    this.setVisible(false);
                    DisplayEmpIssue ei = new DisplayEmpIssue(con, "employee");
                    ei.setVisible(true);
                } catch (SQLException e) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, e);
                }
               } catch (Exception ex) {
                   Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
                int rowIndex = issues_table.getSelectedRow();
                JFrame f = new JFrame();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(f, "Please select an entry to perform this operation.");
                } else {
                try {
                    int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete This Customer Issue?", "Delete Customer Issue", JOptionPane.YES_NO_OPTION);
                    if(YesOrNo == 0){
                        try {
                            Statement delq = con.createStatement();
                            int ed = Integer.parseInt(issues_table.getValueAt(rowIndex, 0).toString());
                            String query = String.format("DELETE from order_issue WHERE idOrder_Issue = '" + ed + "';");
                            System.out.println(query);
                            delq.executeUpdate(query);
                            JOptionPane.showMessageDialog(f, "Deleted Successfully");
                        } catch (SQLException ex) {
                            Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(f, "Something went Wrong");
                        }
                    }
                    else {return;}
                    try {
                        this.setVisible(false);
                        DisplayEmpIssue ei = new DisplayEmpIssue(con, "order");
                        ei.setVisible(true);
                    } catch (SQLException e) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, e);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_delete_singleActionPerformed

    private void delete_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_allActionPerformed
        // TODO add your handling code here:
        if(this.type.equals("employee")) {
                try {
                // TODO add your handling code here:
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete All Issues?", "Delete Issues", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        String query = String.format("DELETE from employee_issue WHERE idEmployee_Issue IN (" + issues_Id.substring(2) + ");");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                } else {
                    return;
                }
                try {
                    this.setVisible(false);
                    DisplayEmpIssue ei = new DisplayEmpIssue(con, "employee");
                    ei.setVisible(true);
                } catch (SQLException e) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, e);
                }
            } catch (Exception ex) {
                Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
                try {
                // TODO add your handling code here:
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete All Issues?", "Delete Issues", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        String query = String.format("DELETE from order_issue WHERE idOrder_Issue IN (" + issues_Id.substring(2) + ");");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                } else {
                    return;
                }
                try {
                    this.setVisible(false);
                    DisplayEmpIssue ei = new DisplayEmpIssue(con, "order");
                    ei.setVisible(true);
                } catch (SQLException e) {
                    Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, e);
                }
            } catch (Exception ex) {
                Logger.getLogger(DisplayEmpIssue.class.getName()).log(Level.SEVERE, null, ex);
            }

        }   
    }//GEN-LAST:event_delete_allActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayEmpIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayEmpIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayEmpIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayEmpIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayEmpIssue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> assigned_to;
    private javax.swing.JButton delete_all;
    private javax.swing.JButton delete_single;
    private javax.swing.JTextArea desc;
    private javax.swing.JButton filter_button;
    private javax.swing.JTextField issue_name;
    private javax.swing.JComboBox<String> issue_status;
    private javax.swing.JTable issues_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> raised_by;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
