import com.sun.xml.internal.ws.util.StringUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class DisplayEmployees extends javax.swing.JFrame {

    private Connection con;
    HashMap<String, Integer> dept = new HashMap<>();
    HashMap<Integer, String> inv = new HashMap<>();
    String employeeList;

    /**
     * Creates new form DisplayEmployees
     */
    public DisplayEmployees() {
        initComponents();
    }

    DisplayEmployees(Connection con) throws SQLException {
        this.con = con;
        initComponents();
        
        departmentvalue.addItem("ALL");
        dept.put("ALL", -1);
        Statement st1 = con.createStatement();
        ResultSet r = st1.executeQuery("SELECT * FROM DEPARTMENT");
        while(r.next()){
            departmentvalue.addItem(r.getString("name"));
            dept.put(r.getString("name"), Integer.parseInt(r.getString("idDepartment")));
            inv.put(Integer.parseInt(r.getString("idDepartment")), r.getString("name"));
        }
        AutoCompletion.enable(departmentvalue);
        
        Statement st = con.createStatement();
        String query = "Select * from employee;";
        ResultSet rs = st.executeQuery(query);
        DefaultTableModel model = (DefaultTableModel)EmployeeTable.getModel();
        model.setRowCount(0);
        employeeList = "";
        while(rs.next()){
            String idEmployee = rs.getString("idEmployee");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String dob = rs.getString("dob");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String date_of_joining = rs.getString("date_of_joining");
            String position = rs.getString("position");
            String department_no = rs.getString("department_no");
            String salary = rs.getString("salary");
            String tax_bracket = rs.getString("tax_bracket");
            model.addRow(new Object[]{idEmployee, first_name, last_name, dob, address, phone, date_of_joining, position, department_no, salary, tax_bracket});
            employeeList = employeeList + ", " +  idEmployee;
        }
        rs.close();
        st.close();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        filterLabel = new javax.swing.JLabel();
        firstNamelabel = new javax.swing.JLabel();
        fnameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lnameField = new javax.swing.JTextField();
        PhoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        positionLabel = new javax.swing.JLabel();
        positionField = new javax.swing.JTextField();
        doblabel = new javax.swing.JLabel();
        dobfield = new org.jdesktop.swingx.JXDatePicker();
        dojlabel = new javax.swing.JLabel();
        dojfield = new org.jdesktop.swingx.JXDatePicker();
        departmentvalue = new javax.swing.JComboBox<>();
        departmentfield = new javax.swing.JLabel();
        salarylabel = new javax.swing.JLabel();
        salaryfield = new javax.swing.JTextField();
        taxbracketlabel = new javax.swing.JLabel();
        taxbracketfield = new javax.swing.JTextField();
        filterbutton = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        delentry = new javax.swing.JButton();
        updentry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Date Of Birth", "Address", "Phone No.", "Date Of Joining", "Position", "Department No.", "Salary", "Tax Bracket"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(EmployeeTable);

        filterLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        filterLabel.setText("Filter");
        filterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        firstNamelabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        PhoneLabel.setText("Phone No.");

        positionLabel.setText("Position");

        doblabel.setText("Date Of Birth");

        dojlabel.setText("Date Of Joining");

        departmentfield.setText("Department");

        salarylabel.setText("Salary");

        taxbracketlabel.setText("Tax Bracket");

        taxbracketfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxbracketfieldActionPerformed(evt);
            }
        });

        filterbutton.setText("FILTER");
        filterbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbuttonActionPerformed(evt);
            }
        });

        delete.setText("DELETE ALL");
        delete.setToolTipText("");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        delentry.setText("Delete Selected Entry");
        delentry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delentryActionPerformed(evt);
            }
        });

        updentry.setText("Update Selected Entry");
        updentry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updentryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(departmentfield)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(departmentvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addComponent(salarylabel)
                                        .addGap(24, 24, 24)
                                        .addComponent(salaryfield, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(firstNamelabel)
                                            .addComponent(PhoneLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneField)
                                            .addComponent(fnameField))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(positionLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                            .addComponent(positionField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doblabel)
                                        .addGap(23, 23, 23)
                                        .addComponent(dobfield, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dojlabel)
                                            .addComponent(taxbracketlabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dojfield, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(taxbracketfield)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updentry, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delentry, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filterbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNamelabel)
                            .addComponent(fnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doblabel)
                            .addComponent(dobfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PhoneLabel)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dojlabel)
                            .addComponent(dojfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(positionLabel)
                            .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salarylabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salaryfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(taxbracketlabel)
                        .addComponent(taxbracketfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departmentvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(departmentfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(filterbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delentry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updentry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taxbracketfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxbracketfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxbracketfieldActionPerformed

    private void filterbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbuttonActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String dob, doj, dept_no;
            String fname = "%"+fnameField.getText()+"%";
            String lname = "%"+lnameField.getText()+"%";
            try {
                dob = "%"+ft.format(dobfield.getDate())+"%";
            }catch (NullPointerException e) {
                dob = "%%";
            }
            String phone = "%"+phoneField.getText()+"%";
            try {
                doj = "%"+ft.format(dojfield.getDate())+"%";
            }catch (NullPointerException e) {
                doj = "%%";
            }
            String position = "%"+positionField.getText()+"%";
            String deptvalue = departmentvalue.getSelectedItem().toString();
            if(deptvalue.equals("ALL")){
                dept_no = "%%";
            }else{
                dept_no = "%"+dept.get(departmentvalue.getSelectedItem().toString())+"%";
            }
            String salary = "%"+salaryfield.getText()+"%";
            String taxbracket = "%"+taxbracketfield.getText()+"%";

            Statement st = con.createStatement();
            String query = String.format("SELECT * from employee WHERE first_name LIKE '%s' AND last_name LIKE '%s' AND "
                + "dob LIKE '%s' AND phone LIKE '%s' AND date_of_joining LIKE '%s' AND position LIKE '%s' AND "
                + "department_no LIKE '%s' AND salary LIKE '%s' AND tax_bracket LIKE '%s';", fname, lname, dob, phone, doj, position,
                dept_no, salary, taxbracket);
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)EmployeeTable.getModel();
            model.setRowCount(0);
            employeeList = "";
            while(rs.next()){
                String idEmployee = rs.getString("idEmployee");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String date_of_birth = rs.getString("dob");
                String address = rs.getString("address");
                String phone_no = rs.getString("phone");
                String date_of_joining = rs.getString("date_of_joining");
                String pos = rs.getString("position");
                String department_no = rs.getString("department_no");
                String sal = rs.getString("salary");
                String tax_bracket = rs.getString("tax_bracket");
                model.addRow(new Object[]{idEmployee, first_name, last_name, date_of_birth, address, phone_no, date_of_joining, pos, department_no, sal, tax_bracket});
                employeeList = employeeList + ", " +  idEmployee;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Something went Wrong");
        }
    }//GEN-LAST:event_filterbuttonActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            // TODO add your handling code here:
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete All Employees?", "Delete Employees", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){
                try {
                    Statement delq = con.createStatement();
                    String query = String.format("DELETE from employee WHERE idEmployee IN (" + employeeList.substring(2) + ");");
                    System.out.println(query);
                    delq.executeUpdate(query);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Deleted Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Something went Wrong");
                }
            }

            Statement newtable = con.createStatement();
            String query = "Select * from employee;";
            ResultSet rs = newtable.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel)EmployeeTable.getModel();
            model.setRowCount(0);
            employeeList = "";
            while(rs.next()){
                String idEmployee = rs.getString("idEmployee");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String date_of_joining = rs.getString("date_of_joining");
                String position = rs.getString("position");
                String department_no = rs.getString("department_no");
                String salary = rs.getString("salary");
                String tax_bracket = rs.getString("tax_bracket");
                model.addRow(new Object[]{idEmployee, first_name, last_name, dob, address, phone, date_of_joining, position, department_no, salary, tax_bracket});
                employeeList = employeeList + ", " +  idEmployee;
            }
            rs.close();
            newtable.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updentryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updentryActionPerformed
        // TODO add your handling code here:
        int rowIndex =  EmployeeTable.getSelectedRow();
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            AddEmployee ae;
            String fn, ln, dob, add, p_no, dept_no, doj, pos, sal, tb;
            try {
                int ed = Integer.parseInt(EmployeeTable.getValueAt(rowIndex, 0).toString());
                fn = EmployeeTable.getValueAt(rowIndex, 1).toString();
                ln = EmployeeTable.getValueAt(rowIndex, 2).toString();
                dob = EmployeeTable.getValueAt(rowIndex, 3).toString();
                add = EmployeeTable.getValueAt(rowIndex, 4).toString();
                p_no = EmployeeTable.getValueAt(rowIndex, 5).toString();
                try{
                    dept_no = inv.get(Integer.parseInt(EmployeeTable.getValueAt(rowIndex, 8).toString()));
                } catch (NullPointerException e) {
                    dept_no = "Production";
                }
                doj = EmployeeTable.getValueAt(rowIndex, 6).toString();
                pos = EmployeeTable.getValueAt(rowIndex, 7).toString();
                sal = EmployeeTable.getValueAt(rowIndex, 9).toString();
                tb = EmployeeTable.getValueAt(rowIndex, 10).toString();
                ae = new AddEmployee(con, 1, ed, fn, ln, dob, add, p_no, dept_no, doj, pos, sal, tb);
                ae.setVisible(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(f, "Something Went Wrong");
            }
        }
    }//GEN-LAST:event_updentryActionPerformed

    private void delentryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delentryActionPerformed
        // TODO add your handling code here:
        int rowIndex =  EmployeeTable.getSelectedRow();
        JFrame f = new JFrame();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(f, "Please Select an Entry To Perform This Operation");
        } else {
            try {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Do You Want to Delete This Employee?", "Delete Employee", JOptionPane.YES_NO_OPTION);
                if(YesOrNo == 0){
                    try {
                        Statement delq = con.createStatement();
                        int ed = Integer.parseInt(EmployeeTable.getValueAt(rowIndex, 0).toString());
                        String query = String.format("DELETE from employee WHERE idEmployee = '" + ed + "';");
                        System.out.println(query);
                        delq.executeUpdate(query);
                        JOptionPane.showMessageDialog(f, "Deleted Successfully");
                    } catch (SQLException ex) {
                        Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(f, "Something went Wrong");
                    }
                }

                try (Statement newtable = con.createStatement()) {
                    String query = "Select * from employee;";
                    ResultSet rs = newtable.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)EmployeeTable.getModel();
                    model.setRowCount(0);
                    employeeList = "";
                    while(rs.next()){
                        String idEmployee = rs.getString("idEmployee");
                        String first_name = rs.getString("first_name");
                        String last_name = rs.getString("last_name");
                        String dob = rs.getString("dob");
                        String address = rs.getString("address");
                        String phone = rs.getString("phone");
                        String date_of_joining = rs.getString("date_of_joining");
                        String position = rs.getString("position");
                        String department_no = rs.getString("department_no");
                        String salary = rs.getString("salary");
                        String tax_bracket = rs.getString("tax_bracket");
                        model.addRow(new Object[]{idEmployee, first_name, last_name, dob, address, phone, date_of_joining, position, department_no, salary, tax_bracket});
                        employeeList = employeeList + ", " +  idEmployee;
                    }
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayEmployees.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_delentryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(DisplayEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JButton delentry;
    private javax.swing.JButton delete;
    private javax.swing.JLabel departmentfield;
    private javax.swing.JComboBox<String> departmentvalue;
    private org.jdesktop.swingx.JXDatePicker dobfield;
    private javax.swing.JLabel doblabel;
    private org.jdesktop.swingx.JXDatePicker dojfield;
    private javax.swing.JLabel dojlabel;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JButton filterbutton;
    private javax.swing.JLabel firstNamelabel;
    private javax.swing.JTextField fnameField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lnameField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField positionField;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JTextField salaryfield;
    private javax.swing.JLabel salarylabel;
    private javax.swing.JTextField taxbracketfield;
    private javax.swing.JLabel taxbracketlabel;
    private javax.swing.JButton updentry;
    // End of variables declaration//GEN-END:variables
}
