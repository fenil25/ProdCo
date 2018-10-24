
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class DisplayOrders extends javax.swing.JFrame {

    private Connection con;
    HashMap<String, Integer> cust = new HashMap<>();
    HashMap<Integer, String> inv = new HashMap<>();
    String orderList;

    /**
     * Creates new form DisplayOrders
     */
    public DisplayOrders() {
        initComponents();
    }
    
    public DisplayOrders(Connection con) throws SQLException {
        initComponents();
        this.con = con;
        
        customerField.addItem("All");
        cust.put("All", -1);
        
        Statement st1 = con.createStatement();
        ResultSet r = st1.executeQuery("SELECT * FROM customer");
        while(r.next()){
            customerField.addItem(r.getString("first_name")+" "+r.getString("last_name"));
            cust.put(r.getString("first_name")+" "+r.getString("last_name"), Integer.parseInt(r.getString("idCustomer")));
        }
        AutoCompletion.enable(customerField);
        
        try (Statement st = con.createStatement()) {
            String query = "Select * from orders, customer where customer_id = idCustomer;";
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
            model.setRowCount(0);
            orderList = "";
            while(rs.next()){
                String id = rs.getString("idOrder");
                String name = rs.getString("order_name");
                String deadline = rs.getString("deadline");
                String placed_on = rs.getString("placed_on");
                String customer_id = rs.getString("customer_id");
                String customer_name = rs.getString("first_name") + " " + rs.getString("last_name");
                model.addRow(new Object[]{id, name, deadline, placed_on, customer_id, customer_name});
                orderList = orderList + ", " +  id;
            }
            rs.close();
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

        customerLabel = new javax.swing.JLabel();
        filterButton = new javax.swing.JButton();
        deadlineLabel = new javax.swing.JLabel();
        deadlineField = new org.jdesktop.swingx.JXDatePicker();
        customerField = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        placedOnLabel = new javax.swing.JLabel();
        placedOnField = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        deleteEntry = new javax.swing.JButton();
        updateEntry = new javax.swing.JButton();
        deleteAll = new javax.swing.JButton();
        moreInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        customerLabel.setText("Customer");

        filterButton.setText("Filter");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        deadlineLabel.setText("Deadline");

        filterLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        filterLabel.setText("Filter");
        filterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameLabel.setText("Order Name");

        placedOnLabel.setText("Placed On");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Name", "Deadline", "Placed On", "Customer ID", "Customer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);

        deleteEntry.setText("Delete Single Order");
        deleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryActionPerformed(evt);
            }
        });

        updateEntry.setText("Update Single Order");
        updateEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEntryActionPerformed(evt);
            }
        });

        deleteAll.setText("Delete All");
        deleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllActionPerformed(evt);
            }
        });

        moreInfo.setText("More Info About Products");
        moreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deadlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField)
                            .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placedOnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(placedOnField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(customerField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(89, 89, 89))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(placedOnLabel)
                            .addComponent(placedOnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deadlineLabel)
                            .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String pon, cid, deadl;
            String name = "%"+nameField.getText()+"%";
            try {
                pon = "%"+ft.format(placedOnField.getDate())+"%";
            }catch (NullPointerException e) {
                pon = "%%";
            }
            try {
                deadl = "%"+ft.format(deadlineField.getDate())+"%";
            }catch (NullPointerException e) {
                deadl = "%%";
            }
            String cf = customerField.getSelectedItem().toString();

            Statement st = con.createStatement();
            String query;
            if(cf.equals("All")){
                query = String.format("SELECT * from orders, customer WHERE order_name LIKE '%s' AND placed_on LIKE '%s' AND "
                    + "deadline LIKE '%s' AND customer_id = idCustomer;", name, pon, deadl);
            }
            else{
                cid = "%"+cust.get(customerField.getSelectedItem().toString())+"%";
                query = String.format("SELECT * from orders, customer WHERE order_name LIKE '%s' AND placed_on LIKE '%s' AND "
                    + "deadline LIKE '%s' AND customer_id LIKE '%s' AND customer_id = idCustomer;", name, pon, deadl, cid);
            }
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
            model.setRowCount(0);
            orderList = "";
            while(rs.next()){
                String id = rs.getString("idOrder");
                String oname = rs.getString("order_name");
                String deadline = rs.getString("deadline");
                String placed_on = rs.getString("placed_on");
                String customer_id = rs.getString("customer_id");
                String customer_name = rs.getString("first_name") + " " + rs.getString("last_name");
                model.addRow(new Object[]{id, oname, deadline, placed_on, customer_id, customer_name});
                orderList = orderList + ", " +  id;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisplayCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Something went Wrong");
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    private void updateEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEntryActionPerformed
        // TODO add your handling code here:
        int rowIndex =  orderTable.getSelectedRow();
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            RegisterOrder ao;
            String oname, odeadline, oplacedon, ocustomer;
            try {
                int oid = Integer.parseInt(orderTable.getValueAt(rowIndex, 0).toString());
                oname = orderTable.getValueAt(rowIndex, 1).toString();
                odeadline = orderTable.getValueAt(rowIndex, 2).toString();
                oplacedon = orderTable.getValueAt(rowIndex, 3).toString();
                ocustomer = orderTable.getValueAt(rowIndex, 5).toString();
                
                ao = new RegisterOrder(con, 1, oid, oname, oplacedon, odeadline, ocustomer);
                ao.setVisible(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(f, "Something Went Wrong");
            }
        }
    }//GEN-LAST:event_updateEntryActionPerformed

    private void deleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryActionPerformed
        // TODO add your handling code here:
        int rowIndex =  orderTable.getSelectedRow();
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            try {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete This Order?", "Delete Order", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        int d = Integer.parseInt(orderTable.getValueAt(rowIndex, 0).toString());
                        String query = String.format("DELETE from orders WHERE idOrder = " + d + ";");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayOrders.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                }

                try (Statement newtable = con.createStatement()) {
                    String query = "Select * from orders, customer where customer_id = idCustomer;";
                    ResultSet rs = newtable.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
                    model.setRowCount(0);
                    orderList = "";
                    while(rs.next()){
                        String id = rs.getString("idOrder");
                        String name = rs.getString("order_name");
                        String deadline = rs.getString("deadline");
                        String placed_on = rs.getString("placed_on");
                        String customer_id = rs.getString("customer_id");
                        String customer_name = rs.getString("first_name") + " " + rs.getString("last_name");
                        model.addRow(new Object[]{id, name, deadline, placed_on, customer_id, customer_name});
                        orderList = orderList + ", " +  id;
                    }
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(f, "Something went wrong while Deleting Entry");
            }
        }
    }//GEN-LAST:event_deleteEntryActionPerformed

    private void deleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllActionPerformed
        // TODO add your handling code here:
        try {
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete All Departments?", "Delete Departments", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){
                try {
                    Statement delq = con.createStatement();
                    String query = String.format("DELETE from orders WHERE idOrder IN (" + orderList.substring(2) + ");");
                    System.out.println(query);
                    delq.executeUpdate(query);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "All Entries Deleted Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Something went Wrong");
                }
            }

            try (Statement newtable = con.createStatement()) {
                String query = "Select * from orders, customer where customer_id = idCustomer;";
                ResultSet rs = newtable.executeQuery(query);
                DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
                model.setRowCount(0);
                orderList = "";
                while(rs.next()){
                    String id = rs.getString("idOrder");
                    String name = rs.getString("order_name");
                    String deadline = rs.getString("deadline");
                    String placed_on = rs.getString("placed_on");
                    String customer_id = rs.getString("customer_id");
                    String customer_name = rs.getString("first_name") + " " + rs.getString("last_name");
                    model.addRow(new Object[]{id, name, deadline, placed_on, customer_id, customer_name});
                    orderList = orderList + ", " +  id;
                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteAllActionPerformed

    private void moreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreInfoActionPerformed
        // TODO add your handling code here:
        int rowIndex =  orderTable.getSelectedRow();
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            int d = Integer.parseInt(orderTable.getValueAt(rowIndex, 0).toString());
            DisplayOrderProduct dop;
            try {
                dop = new DisplayOrderProduct(con, d);
                dop.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(DisplayOrders.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_moreInfoActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customerField;
    private javax.swing.JLabel customerLabel;
    private org.jdesktop.swingx.JXDatePicker deadlineField;
    private javax.swing.JLabel deadlineLabel;
    private javax.swing.JButton deleteAll;
    private javax.swing.JButton deleteEntry;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton moreInfo;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable orderTable;
    private org.jdesktop.swingx.JXDatePicker placedOnField;
    private javax.swing.JLabel placedOnLabel;
    private javax.swing.JButton updateEntry;
    // End of variables declaration//GEN-END:variables
}
