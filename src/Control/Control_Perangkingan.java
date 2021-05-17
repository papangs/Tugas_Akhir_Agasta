/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Alternatif_Kriteria;
import Layout.Perangkingan;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
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
public class Control_Perangkingan {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    int jum11 = 0;
    
    public void resetData(Perangkingan view) {
        buatKolomSesuai(view.jTable2);
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
    
    public void setttablematrix(JTable table, int row, String[] namakolom) {
        int lenghtnamakolom = namakolom.length;
        String[] data = new String[lenghtnamakolom];

        for (int j = 0; j < data.length; j++) {
        }
        DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(new Object[][]{data}, namakolom);
        table.setModel(tableModel);

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < data.length; j++) {
            }
            ((DefaultTableModel) table.getModel()).addRow(data);
        }
    }
    
    public void getData(Perangkingan view){
        view.jLabel2.setVisible(false);
        view.jButton6.setVisible(false);
        comboKategori(view);
        getDataEigenKriteria(view);
    }
    
    public void comboKategori(Perangkingan view) {
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
    
    public void KategoriCode(Perangkingan view) {
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
        } finally {
            getDataAlternatif(view);
        }
    }

    public void getDataEigenKriteria(Perangkingan view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Kriteria");
        tabelKej.addColumn("Nilai Eigen");
        try {
            String sql = "SELECT\n"
                    + "	eigen_kriteria.seq, \n"
                    + "	eigen_kriteria.eigen_value, \n"
                    + "	eigen_kriteria.date, \n"
                    + "	eigen_kriteria.kriteria_seq, \n"
                    + "	kriteria.kriteria_name\n"
                    + "FROM eigen_kriteria\n"
                    + "	INNER JOIN kriteria ON eigen_kriteria.kriteria_seq = kriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getString("eigen_kriteria.seq"),
                    r.getString("kriteria.kriteria_name"),
                    r.getString("eigen_kriteria.eigen_value")});
            }
            view.jTable3.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable3.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable3.getColumnModel().getColumn(1).setMaxWidth(0);
            buatKolomSesuai(view.jTable3);
        }
    }

    public void getDataAlternatif(Perangkingan view) {

        String query = "SELECT\n"
                + "	eigen_alternatif.seq, \n"
                + "	eigen_alternatif.eigen_value, \n"
                + "	eigen_alternatif.date, \n"
                + "	eigen_alternatif.alternatif_seq, \n"
                + "	eigen_alternatif.kategori_seq, \n"
                + "	eigen_alternatif.kriteria_seq, \n"
                + "	alternatif.alternatif_name, \n"
                + "	kriteria.kriteria_name, \n"
                + "	kategori_alternatif.kategori_name\n"
                + "FROM\n"
                + "	eigen_alternatif\n"
                + "	INNER JOIN alternatif ON eigen_alternatif.alternatif_seq = alternatif.seq\n"
                + "	INNER JOIN kriteria ON eigen_alternatif.kriteria_seq = kriteria.seq\n"
                + "	INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq AND eigen_alternatif.kategori_seq = kategori_alternatif.seq\n"
                + "WHERE eigen_alternatif.kategori_seq = '"+view.jLabel2.getText()+"'\n"
                + "GROUP BY eigen_alternatif.alternatif_seq";

        jum11 = 0;
        
        try {
            
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }
            
            int aa = Integer.parseInt(jum11 + "");
            int aaa = view.jTable3.getRowCount();
            
            String[] c1 = new String[aaa + 1 + 1 + 1 + 1 + 1];
            
            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif";
                    c1[i1 + 1 + 1 + 1] = (String) view.jTable3.getValueAt(i1, 2);
                    c1[i1 + 1 + 1 + 1 + 1] = "Hasil";
                    c1[i1 + 1 + 1 + 1 + 1 + 1] = "Rangking";
                }
            }
            
            setttablematrix(view.jTable2, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable2.setValueAt(i3 + 1, i3, 0);
            }
            
            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("eigen_alternatif.alternatif_seq");
                    view.jTable2.setValueAt(seq, e1++, 1);
                }
            } catch (SQLException f) {
            }
            
            //set nama
            String nama = "";
            int e = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    nama = res11.getString("alternatif.alternatif_name");
                    view.jTable2.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

            //nilai
            for (int i2 = 0; i2 < aaa; i2++) {
                
                String nilai = "";
                String taun = "";

                String sql2 = "SELECT\n"
                        + "eigen_alternatif.seq, \n"
                        + "eigen_alternatif.eigen_value, \n"
                        + "eigen_alternatif.date, \n"
                        + "eigen_alternatif.alternatif_seq, \n"
                        + "eigen_alternatif.kategori_seq, \n"
                        + "eigen_alternatif.kriteria_seq, \n"
                        + "alternatif.alternatif_name, \n"
                        + "kriteria.kriteria_name, \n"
                        + "kategori_alternatif.kategori_name\n"
                        + "FROM\n"
                        + "eigen_alternatif\n"
                        + "INNER JOIN alternatif ON eigen_alternatif.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN kriteria ON eigen_alternatif.kriteria_seq = kriteria.seq\n"
                        + "INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq AND eigen_alternatif.kategori_seq = kategori_alternatif.seq\n"
                        + "WHERE eigen_alternatif.kategori_seq = '" + view.jLabel2.getText() + "'\n"
                        + "AND eigen_alternatif.kriteria_seq = '" + view.jTable3.getValueAt(i2, 1) + "'\n"
                        + "GROUP BY eigen_alternatif.alternatif_seq";
                
                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql2);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("eigen_alternatif.eigen_value");
                        dd = dd + 1;
                        
                        view.jTable2.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }
        } catch (SQLException e) {
        }finally{
            buatKolomSesuai(view.jTable2);
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }

    }
    
    public void process(Perangkingan view) {
        
        DecimalFormat batas = new DecimalFormat("#.###");
        if (view.jComboBox1.getSelectedItem().equals("") | view.jComboBox1.getSelectedItem().equals("-Choose-")) {
            JOptionPane.showMessageDialog(view, "Pilih Kategori Dulu!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int eigen = view.jTable3.getRowCount();
            int assessment = view.jTable2.getRowCount();

            for (int h = 0; h < assessment; h++) {
                double plus = 0.0;
                double kali = 0.0;
                double geteigen = 0.0;
                double getassessment = 0.0;

                for (int i = 0; i < eigen; i++) {
                    geteigen = Double.parseDouble(view.jTable3.getValueAt(i, 3).toString());
                    getassessment = Double.parseDouble(view.jTable2.getValueAt(h, i + 3).toString());
                    kali = geteigen * getassessment;
                    plus += kali;
                }
                view.jTable2.setValueAt(batas.format(plus), h, eigen + 3);

            }
            
            double[] Array = new double[assessment];
            int asc = 0;
            for (int i = 0; i < assessment; i++) {
                Array[i] = Double.parseDouble(view.jTable2.getValueAt(i, eigen + 3).toString());
            }

            int rank[] = getRanksArray(Array);
            for (int i = 0; i < view.jTable2.getRowCount(); i++) {
                view.jTable2.setValueAt(rank[i], i, eigen + 4);
            }
            
        }
        saveData(view);

    }

    public static int[] getRanksArray(double[] array) {
        int[] result = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    count++;
                }
            }
            result[i] = count + 1;
        }
        return result;
    }
    
    public class tableColor extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            String numero = (String) table.getValueAt(row, 10);
            if (numero.equals("1")) {
                setBackground(Color.BLUE);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.BLACK);
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }

//    public void setColor(Perangkingan view) {
//
//        view.jTable2.setDefaultRenderer(Object.class, new Control_Perangkingan.tableColor());
//    }

//    public int getJumlah() {
//
//        int jumlah = 0;
//
//        try {
//            String sql = "SELECT\n"
//                    + "kriteria.seq,\n"
//                    + "kriteria.kriteria_name\n"
//                    + "FROM\n"
//                    + "kriteria";
//
//            Statement st = c.createStatement();
//            ResultSet r = st.executeQuery(sql);
//
//            while (r.next()) {
//                jumlah++;
//            }
//
//        } catch (Exception e) {
//        }
//        return jumlah;
//    }
    
    public void saveData(Perangkingan view) {

        try {
            int eigen = view.jTable3.getRowCount();

            String sqlq = "DELETE from hasil_rangking WHERE kategori_seq = '" + view.jLabel2.getText() + "'";
            PreparedStatement t = c.prepareStatement(sqlq);
            t.executeUpdate();
            t.close();

            for (int i = 0; i < view.jTable2.getRowCount(); i++) {

                String sql = "insert into hasil_rangking set alternatif_seq ='" + view.jTable2.getValueAt(i, 1) + "',"
                        + "value = '" + view.jTable2.getValueAt(i, eigen + 3) + "',"
                        + "rangking = '" + view.jTable2.getValueAt(i, eigen + 4) + "',"
                        + "kategori_seq = '" + view.jLabel2.getText() + "'";

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();
            }

//            JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);

            getDataSave(view);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getDataSave(Perangkingan view) {
        String query = "SELECT\n"
                + "	hasil_rangking.seq, \n"
                + "	hasil_rangking.alternatif_seq, \n"
                + "	hasil_rangking.`value`, \n"
                + "	hasil_rangking.rangking, \n"
                + "	hasil_rangking.kategori_seq, \n"
                + "	alternatif.alternatif_name, \n"
                + "	kategori_alternatif.kategori_name\n"
                + "FROM\n"
                + "	hasil_rangking\n"
                + "	INNER JOIN\n"
                + "	alternatif\n"
                + "	ON \n"
                + "		hasil_rangking.alternatif_seq = alternatif.seq\n"
                + "	INNER JOIN\n"
                + "	kategori_alternatif\n"
                + "	ON \n"
                + "		alternatif.kategori_seq = kategori_alternatif.seq AND\n"
                + "		hasil_rangking.kategori_seq = kategori_alternatif.seq\n"
                + "	WHERE hasil_rangking.kategori_seq = '"+view.jLabel2.getText()+"'\n"
                + "	ORDER BY hasil_rangking.rangking ASC";

        jum11 = 0;

        try {

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }

            int aa = Integer.parseInt(jum11 + "");
            int aaa = view.jTable3.getRowCount();

            String[] c1 = new String[aaa + 1 + 1 + 1 + 1 + 1];

            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif";
                    c1[i1 + 1 + 1 + 1] = (String) view.jTable3.getValueAt(i1, 2);
                    c1[i1 + 1 + 1 + 1 + 1] = "Hasil";
                    c1[i1 + 1 + 1 + 1 + 1 + 1] = "Rangking";
                }
            }

            setttablematrix(view.jTable2, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable2.setValueAt(i3 + 1, i3, 0);
            }

            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("hasil_rangking.alternatif_seq");
                    view.jTable2.setValueAt(seq, e1++, 1);
                }
            } catch (SQLException f) {
            }

            //set nama
            String nama = "";
            int e = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    nama = res11.getString("alternatif.alternatif_name");
                    view.jTable2.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

            //nilai
            for (int i2 = 0; i2 < aaa; i2++) {

                String nilai = "";
                String taun = "";

                String sql2 = "SELECT\n"
                        + "eigen_alternatif.seq, \n"
                        + "eigen_alternatif.eigen_value, \n"
                        + "eigen_alternatif.date, \n"
                        + "eigen_alternatif.alternatif_seq, \n"
                        + "eigen_alternatif.kategori_seq, \n"
                        + "eigen_alternatif.kriteria_seq, \n"
                        + "alternatif.alternatif_name, \n"
                        + "kriteria.kriteria_name, \n"
                        + "kategori_alternatif.kategori_name\n"
                        + "FROM\n"
                        + "eigen_alternatif\n"
                        + "INNER JOIN alternatif ON eigen_alternatif.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN kriteria ON eigen_alternatif.kriteria_seq = kriteria.seq\n"
                        + "INNER JOIN kategori_alternatif ON alternatif.kategori_seq = kategori_alternatif.seq AND eigen_alternatif.kategori_seq = kategori_alternatif.seq\n"
                        + "WHERE eigen_alternatif.kategori_seq = '" + view.jLabel2.getText() + "'\n"
                        + "AND eigen_alternatif.kriteria_seq = '" + view.jTable3.getValueAt(i2, 1) + "'\n"
                        + "GROUP BY eigen_alternatif.alternatif_seq";

                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql2);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("eigen_alternatif.eigen_value");
                        dd = dd + 1;

                        view.jTable2.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }
            
            //set nilai rangking
            String nilairangking = "";
            int fs = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    nilairangking = res11.getString("hasil_rangking.value");
                    view.jTable2.setValueAt(nilairangking, fs++, aaa + 3);
                }
            } catch (SQLException f) {
            }
            
            //set rangking
            int rangking = 0;
            int g = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    rangking = res11.getInt("hasil_rangking.rangking");
                    view.jTable2.setValueAt(rangking, g++, aaa + 4);
                }
            } catch (SQLException f) {
            }
        } catch (SQLException e) {
        } finally {
            buatKolomSesuai(view.jTable2);
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }

    }
}
