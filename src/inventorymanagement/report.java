package inventorymanagement;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.print.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class report extends javax.swing.JPanel implements Printable {
    
    private static final int HEADER_HEIGHT = 50;
    private static final int FOOTER_HEIGHT = 50;
    private static final int LINE_HEIGHT = 20;
    private static final int MARGIN = 50;
    
    public report() {
        initComponents();
    }

    public void load_bill() {
        try {
            String inv_id = inid_tb.getText();
            if (inv_id.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an invoice number!");
                return;
            }

            // Load sale details for customer info and status
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM sale WHERE INID = '" + inv_id + "'");
            if (rs.next()) {
                cus_name.setText(rs.getString("Customer_Name"));
                status.setText(rs.getString("Status"));
            } else {
                JOptionPane.showMessageDialog(null, "Invoice not found!");
                return;
            }

            // Load cart items and calculate totals
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0); // Clear existing rows

            double totalQty = 0;
            double totalBill = 0;

            rs = s.executeQuery("SELECT * FROM cart WHERE INID = '" + inv_id + "'");
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("product_name"));
                v.add(rs.getString("barcode"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("Unit_price"));
                v.add(rs.getString("Total_price"));
                dt.addRow(v);

                // Calculate totals
                totalQty += Double.parseDouble(rs.getString("qty"));
                totalBill += Double.parseDouble(rs.getString("Total_price"));
            }

            // Update total labels
            tot_qty.setText(String.format("%.2f", totalQty));
            tot_bill.setText(String.format("%.2f", totalBill));

            // Calculate balance from sale table
            rs = s.executeQuery("SELECT Balance FROM sale WHERE INID = '" + inv_id + "'");
            if (rs.next()) {
                balance.setText(rs.getString("Balance"));
            }

        } catch (SQLException e) {
            System.out.println("Error loading bill: " + e);
            JOptionPane.showMessageDialog(null, "Error loading bill details!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inid_tb = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cus_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tot_bill = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Invoice No:");

        inid_tb.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid_tb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inid_tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Customer:");

        cus_name.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cus_name.setText("---");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Total Qty:");

        tot_qty.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        tot_qty.setText("0");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Total Bill:");

        tot_bill.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        tot_bill.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Status:");

        status.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        status.setText("---");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Balance:");

        balance.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        balance.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cus_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cus_name)
                    .addComponent(jLabel3)
                    .addComponent(tot_qty)
                    .addComponent(jLabel4)
                    .addComponent(tot_bill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(status)
                    .addComponent(jLabel6)
                    .addComponent(balance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Product Name", "Barcode", "Quantity", "Unit Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        load_bill();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            if (job.printDialog()) {
                job.print();
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "Error printing: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Set font for the entire document
        Font titleFont = new Font("Arial", Font.BOLD, 16);
        Font headerFont = new Font("Arial", Font.BOLD, 12);
        Font normalFont = new Font("Arial", Font.PLAIN, 12);
        g2d.setFont(normalFont);

        int y = MARGIN;
        int width = (int) pageFormat.getImageableWidth();
        int height = (int) pageFormat.getImageableHeight();

        // Print company header
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Aayam's Inventory Management System", width/2 - 180, y);
        y += HEADER_HEIGHT;

        // Print header
        g2d.setFont(titleFont);
        g2d.drawString("INVOICE", width/2 - 30, y);
        y += HEADER_HEIGHT;

        // Print invoice details
        g2d.setFont(headerFont);
        g2d.drawString("Invoice No: " + inid_tb.getText(), MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()), MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("Customer: " + cus_name.getText(), MARGIN, y);
        y += LINE_HEIGHT * 2;

        // Print table header
        g2d.setFont(headerFont);
        String[] headers = {"Product", "Barcode", "Qty", "Price", "Total"};
        int[] columnWidths = {180, 60, 120, 100, 100}; // Further adjusted column widths
        int x = MARGIN;
        
        for (int i = 0; i < headers.length; i++) {
            g2d.drawString(headers[i], x, y);
            x += columnWidths[i];
        }
        y += LINE_HEIGHT;

        // Print table data
        g2d.setFont(normalFont);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            x = MARGIN;
            for (int j = 0; j < model.getColumnCount(); j++) {
                String value = model.getValueAt(i, j).toString();
                // Truncate long values if necessary
                if (j == 0 && value.length() > 20) { // Product name
                    value = value.substring(0, 20) + "...";
                } else if (j == 1 && value.length() > 8) { // Barcode
                    value = value.substring(0, 8) + "...";
                }
                g2d.drawString(value, x, y);
                x += columnWidths[j];
            }
            y += LINE_HEIGHT;
        }

        // Print totals
        y += LINE_HEIGHT;
        g2d.setFont(headerFont);
        g2d.drawString("Total Quantity: " + tot_qty.getText(), MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("Total Amount: " + tot_bill.getText(), MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("Status: " + status.getText(), MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("Balance: " + balance.getText(), MARGIN, y);

        // Print footer
        y = height - FOOTER_HEIGHT;
        g2d.setFont(normalFont);
        g2d.drawString("Thank you for your business!", width/2 - 80, y);
        y += LINE_HEIGHT;
        g2d.drawString("Printed on: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), 
                      width/2 - 100, y);
        y += LINE_HEIGHT;
        g2d.drawString("For any queries or suggestions, email me: aayambajaj4@gmail.com", 
                      width/2 - 200, y);

        return PAGE_EXISTS;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JLabel cus_name;
    private javax.swing.JTextField inid_tb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tot_bill;
    private javax.swing.JLabel tot_qty;
    // End of variables declaration//GEN-END:variables
} 