/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Alternatif;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Alternatif {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    
    public void resetData(Alternatif view) {
        view.jTextField1.setText("");
        view.jTextField2.setText("");
        view.jTextField3.setText("");
        view.jButton1.setText("Save");
        view.jButton2.setText("Save");
        view.jLabel7.setVisible(false);
        view.jLabel1.setVisible(false);
        view.jLabel2.setVisible(false);
        view.jButton3.setVisible(false);
        view.jButton6.setVisible(false);
        view.jComboBox1.setSelectedItem("-PILIH-");
        buatKolomSesuai(view.jTable1);
        buatKolomSesuai(view.jTable2);
    }
    
    public void getData(Alternatif view) {
        getDataAlternatif(view);
        getDataKategori(view);
        comboKategori(view);
    }
    
    public void buatKolomSesuai(JTable t) {
        TableColumnModel modelKolom = t.getColumnModel();

        for (int kol = 0; kol < modelKolom.getColumnCount(); kol++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < t.getRowCount(); baris++) {
                TableCellRenderer rend = t.getCellRenderer(baris, kol);
                Object nilaiTablel = t.getValueAt(baris, kol);
                Component comp = rend.getTableCellRendererComponent(t, nilaiTablel, false, false, baris, kol);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn kolom = modelKolom.getColumn(kol);
            kolom.setPreferredWidth(lebarKolomMax);
        }
    }
    
    public void comboKategori(Alternatif view) {
        String query2 = "SELECT\n"
                + "kategori_alternatif.seq,\n"
                + "kategori_alternatif.kategori_name\n"
                + "FROM\n"
                + "kategori_alternatif";
        
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query2);

            for (int i = view.jComboBox1.getItemCount() - 1; i >= 1; i--) {
                view.jComboBox1.removeItemAt(i);
            }

            while (r.next()) {
                view.jComboBox1.addItem(r.getString("kategori_alternatif.kategori_name"));
            }
        } catch (Exception e) {
        }
    }
    
    public void KategoriCode(Alternatif view) {
        String sub = (String) view.jComboBox1.getSelectedItem();
        String query = "select * from kategori_alternatif where kategori_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("kategori_alternatif.seq");
            }
            view.jLabel2.setText(id + "");
        } catch (Exception e) {
        }
    }
    
    public void getDataKategori(Alternatif view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Kategori");
        try {
            String sql = "SELECT\n"
                    + "kategori_alternatif.seq,\n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "kategori_alternatif";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getString("kategori_alternatif.seq"),
                    r.getString("kategori_alternatif.kategori_name")});
            }
            view.jTable2.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
            buatKolomSesuai(view.jTable2);
            resetData(view);
        }
    }
    
    public void getDataAlternatif(Alternatif view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Alternatif");
        tabelKej.addColumn("Kategori Seq");
        tabelKej.addColumn("Nama Kategori");
        try {
            String sql = "SELECT\n"
                    + "alternatif.seq,\n"
                    + "alternatif.alternatif_name,\n"
                    + "alternatif.kategori_seq,\n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getString("alternatif.seq"),
                    r.getString("alternatif.alternatif_name"),
                    r.getString("alternatif.kategori_seq"),
                    r.getString("kategori_alternatif.kategori_name")});
            }
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable1.getColumnModel().getColumn(3).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
            buatKolomSesuai(view.jTable1);
            resetData(view);
            view.jTable1.setDefaultRenderer(Object.class, new tableColor());
        }
    }

    public void saveDataKategori(Alternatif view) {
        try {
            if (view.jButton2.getText().equals("Save")) {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "insert into kategori_alternatif set "
                            + "kategori_name='" + view.jTextField2.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }

            } else {

                if (view.jTextField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "update kategori_alternatif set "
                            + "kategori_name='" + view.jTextField2.getText() + "'"
                            + "where seq = '" + view.jLabel1.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void saveDataAlternatif(Alternatif view) {
        try {
            if (view.jButton1.getText().equals("Save")) {

                if (view.jTextField1.getText().equals("") || view.jComboBox1.getSelectedItem().equals("-PILIH-")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "insert into alternatif set "
                            + "alternatif_name='" + view.jTextField1.getText() + "',"
                            + "kategori_seq='" + view.jLabel2.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }

            } else {

                if (view.jTextField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "update alternatif set "
                            + "alternatif_name='" + view.jTextField1.getText() + "',"
                            + "kategori_seq='" + view.jLabel2.getText() + "'"
                            + "where seq = '" + view.jLabel7.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readDataAlternatif(Alternatif view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "alternatif.seq,\n"
                + "alternatif.alternatif_name,\n"
                + "alternatif.kategori_seq,\n"
                + "kategori_alternatif.kategori_name\n"
                + "FROM\n"
                + "alternatif\n"
                + "INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq\n"
                + "WHERE alternatif.seq = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String company_code = "";
            String description = "";
            String company_code2 = "";
            String description2 = "";

            while (r.next()) {
                company_code = r.getString("alternatif.seq");
                description = r.getString("alternatif.alternatif_name");
                company_code2 = r.getString("alternatif.kategori_seq");
                description2 = r.getString("kategori_alternatif.kategori_name");
            }
            
            view.jLabel7.setText(company_code);
            view.jTextField1.setText(description);
            view.jLabel1.setText(company_code2);
            view.jComboBox1.setSelectedItem(description2);
        } catch (Exception e) {
        }finally{
            view.jButton1.setText("Update");
            view.jButton3.setVisible(true);
        }
    }
    
    public void readDataKategori(Alternatif view) {
        int a = view.jTable2.getSelectedRow();
        String query = "SELECT\n"
                + "kategori_alternatif.seq,\n"
                + "kategori_alternatif.kategori_name\n"
                + "FROM\n"
                + "kategori_alternatif\n"
                + "WHERE kategori_alternatif.seq = '" + view.jTable2.getValueAt(a, 1) + "'";
        try {
            
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String company_code = "";
            String description = "";

            while (r.next()) {
                company_code = r.getString("kategori_alternatif.seq");
                description = r.getString("kategori_alternatif.kategori_name");
            }
            
            view.jLabel1.setText(company_code);
            view.jTextField2.setText(description);
        } catch (Exception e) {
        }finally{
            view.jButton2.setText("Update");
            view.jButton6.setVisible(true);
        }
    }
    
    public void deleteDataAlternatif(Alternatif view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from alternatif where seq='" + view.jLabel7.getText() + "'";
            try {
                
                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                getData(view);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Data Not Succeed in Delete", "ERROR", JOptionPane.ERROR_MESSAGE);

            } finally {
            }
        } else {
            getData(view);
        }
    }
    
    public void deleteDataKategori(Alternatif view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from kategori_alternatif where seq='" + view.jLabel1.getText() + "'";
            try {
                
                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                getData(view);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Data Not Succeed in Delete", "ERROR", JOptionPane.ERROR_MESSAGE);

            } finally {
            }
        } else {
            getData(view);
        }
    }
    
    public void searchDataAlternatif(Alternatif view) {
        String search = String.valueOf(view.jTextField3.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "alternatif.seq,\n"
                    + "alternatif.alternatif_name,\n"
                    + "alternatif.kategori_seq,\n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq\n"
                    + "where alternatif.alternatif_name like '%" + search + "%' "
                    + "or kategori_alternatif.kategori_name like '%" + search + "%'";

            Statement statement = (Statement) c.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) view.jTable1.getModel();
                int i = 0;
                int n = 1;
                while (i < view.jTable1.getRowCount()) {
                    tableModel.removeRow(i);
                }
                rs.beforeFirst();
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.addElement(n++);
                    vector.addElement(rs.getString("alternatif.seq"));
                    vector.addElement(rs.getString("alternatif.alternatif_name"));
                    vector.addElement(rs.getString("alternatif.kategori_seq"));
                    vector.addElement(rs.getString("kategori_alternatif.kategori_name"));

                    tableModel.addRow(vector);
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void searchDataKategori(Alternatif view) {
        String search = String.valueOf(view.jTextField4.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "kategori_alternatif.seq,\n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "kategori_alternatif\n"
                    + "where kategori_alternatif.seq like '%" + search + "%' "
                    + "or kategori_alternatif.kategori_name like '%" + search + "%'";

            Statement statement = (Statement) c.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) view.jTable2.getModel();
                int i = 0;
                int n = 1;
                while (i < view.jTable2.getRowCount()) {
                    tableModel.removeRow(i);
                }
                rs.beforeFirst();
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.addElement(n++);
                    vector.addElement(rs.getString("alternatif.seq"));
                    vector.addElement(rs.getString("alternatif.alternatif_name"));

                    tableModel.addRow(vector);
                }
            }
        } catch (Exception e) {
        }
    }
    
    public class tableColor extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            String numero = (String) table.getValueAt(row, 2);

            if (numero.equals("NVIDIA GTX1660 Super")) {
                setBackground(Color.BLUE);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.BLACK);
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }
}
