/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes.coba;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author Mr Papang
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
        initTable();
    }
    
    private void initTable() {
        List<DomainCheckBox> listCk = new ArrayList<DomainCheckBox>();
        List<JRadioButton> listCheckBox = new ArrayList<JRadioButton>();
        for (int i = 0; i < 10; i++) {
            JRadioButton chk1 = new JRadioButton("K 1 B " + i);
//            chk1.addActionListener(getActionListener("K 1 B " + i, chk1, jTable1));
            JRadioButton chk2 = new JRadioButton("K 2 B " + i);
//            chk2.addActionListener(getActionListener("K 2 B " + i, chk2));
            
            JRadioButton chk3 = new JRadioButton("Irawan " + i);
//            chk3.addActionListener(getActionListener("Irawan " + i, chk3));
            JRadioButton chk4 = new JRadioButton("Papang " + i);
//            chk4.addActionListener(getActionListener("Papang " + i, chk4));

            listCheckBox.add(chk1);
            listCheckBox.add(chk2);
            listCheckBox.add(chk3);
            listCheckBox.add(chk4);

            DomainCheckBox dc = new DomainCheckBox(chk1, chk2, chk3, chk4);
            listCk.add(dc);
        }

        jTable1.setModel(new TableModelDomainCheckBox(listCk));
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new CheckBoxRenderer(listCk));
        jTable1.getColumnModel().getColumn(0).setCellEditor(new CheckBoxEditor(listCk));
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new CheckBoxRenderer(listCk));
        jTable1.getColumnModel().getColumn(1).setCellEditor(new CheckBoxEditor(listCk));
    }

    private ActionListener getActionListener(final String message, final JCheckBox chk, final JTable table) {
        ActionListener actionListener = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();
                if ((Boolean) table.getValueAt(selectedRow, 0)) {
                    for (int i = 0; i < table.getRowCount(); i++) {
                        if (i != selectedRow) {
                            table.setValueAt("K 1 B " + i, i, 0);
                        }
                    }
                }
//                if (chk.isSelected()) {
//                    System.out.println("Message From [selected] : " + message);
////                    int selectedRow = jTable1.getSelectedRow();
////                    if ((Boolean) jTable1.getValueAt(selectedRow, 1)) {
////                        for (int i = 0; i < jTable1.getRowCount(); i++) {
////                            if (i != selectedRow) {
////                                jTable1.setValueAt(false, i, 1);
////                            }
////                        }
////                    }
//                } else {
//                    System.out.println("Message From [unselected] : " + message);
//                }
//                int selectedRow = table.getSelectedRow();
//                if ((Boolean)table.getValueAt(selectedRow , 1)) {
//                    for (int i = 0; i < table.getRowCount(); i++) {
//                    if ( i != selectedRow) {
//                       table.setValueAt(false, i, 1);
//                    }
//                  }
                }
        };

        return actionListener;
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if ((Boolean) jTable1.getValueAt(selectedRow, 0)) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (i != selectedRow) {
                    jTable1.setValueAt(false, i, 0);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
