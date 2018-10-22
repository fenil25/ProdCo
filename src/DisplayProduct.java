
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DisplayProduct extends javax.swing.JFrame {

    private Connection con;

    /**
     * Creates new form DisplayProduct
     */
    public DisplayProduct() {
        initComponents();
    }
    
    DisplayProduct(Connection con) throws SQLException {
        this.con = con;
        initComponents();        
        try (Statement st = con.createStatement()) {
            String query = "Select * from product;";
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)productTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                String id = rs.getString("idProduct");
                String n = rs.getString("name");
                String d = rs.getString("description");
                model.addRow(new Object[]{id, n, d});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        searcgButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setText("Search By Name");

        searcgButton.setText("Search");
        searcgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searcgButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete Selected Product");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searcgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searcgButton))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searcgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searcgButtonActionPerformed
        // TODO add your handling code here:
        String namesearch = "%"+nameField.getText()+"%";
        try {
            Statement st = con.createStatement();
            String query = String.format("Select * from product where name LIKE '%s';", namesearch);
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)productTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                String id = rs.getString("idProduct");
                String n = rs.getString("name");
                String d = rs.getString("description");
                model.addRow(new Object[]{id, n, d});
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisplayProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searcgButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int rowIndex =  productTable.getSelectedRow();
        
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            try {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete This Product?", "Delete Product", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        int d = Integer.parseInt(productTable.getValueAt(rowIndex, 0).toString());
                        String query = String.format("DELETE from product WHERE idProduct = '" + d + "';");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                }

                try (Statement newtable = con.createStatement()) {
                    String query = "Select * from product;";
                    ResultSet rs = newtable.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)productTable.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        String id = rs.getString("idProduct");
                        String n = rs.getString("name");
                        String d = rs.getString("description");
                        model.addRow(new Object[]{id, n, d});
                    }
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(f, "Something went wrong while Deleting Entry");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable productTable;
    private javax.swing.JButton searcgButton;
    // End of variables declaration//GEN-END:variables
}
