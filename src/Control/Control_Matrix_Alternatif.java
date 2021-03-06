/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Alternatif;
import Layout.Matrix_Alternatif;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Matrix_Alternatif {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;

    public void resetData(Matrix_Alternatif view) {
        buatKolomSesuai(view.jTable1);
    }
    
    public void getData(Matrix_Alternatif view) {
        view.jTabbedPane1.setEnabledAt(1, false);
        view.jTabbedPane1.setSelectedIndex(0);
        view.jTabbedPane1.setEnabledAt(0, true);
        view.jComboBox1.setSelectedItem("-PILIH-");
        view.jComboBox2.setSelectedItem("-PILIH-");
        view.jScrollPane2.setVisible(false);
        view.buttonGroup1.clearSelection();
        view.jLabel7.setVisible(false);
        view.jLabel8.setVisible(false);
        view.jLabel10.setVisible(false);
        view.jLabel9.setVisible(false);
        view.panelGlass2.setVisible(false);
        view.jButton3.setVisible(false);
        view.jButton4.setEnabled(false);
        view.jLabel2.setVisible(false);
        view.jComboBox1.setVisible(false);
        comboKriteria(view);
        comboKategori(view);
        getDataAlternatif(view);
        Matrix(view);
        getPerbandinganAlternatif(view);
    }

    public void comboKriteria(Matrix_Alternatif view) {

        String query2 = "SELECT\n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "kriteria";
        
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query2);

            for (int i = view.jComboBox2.getItemCount() - 1; i >= 1; i--) {
                view.jComboBox2.removeItemAt(i);
            }

            while (r.next()) {
                view.jComboBox2.addItem(r.getString("kriteria.kriteria_name"));
            }
        } catch (Exception e) {
        }
    }
    
    public void KriteriaCode(Matrix_Alternatif view) {
        
        String sub = (String) view.jComboBox2.getSelectedItem();
        String query = "SELECT\n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "kriteria "
                + "WHERE kriteria.kriteria_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("kriteria.seq");
            }
            view.jLabel9.setText(id + "");
        } catch (Exception e) {
        } finally {
            getPerbandinganAlternatif(view);
            view.jComboBox1.setSelectedItem("-PILIH-");
            view.jLabel2.setVisible(true);
            view.jComboBox1.setVisible(true);
        }
    }

    public void comboKategori(Matrix_Alternatif view) {
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
    
    public void KategoriCode(Matrix_Alternatif view) {
        String sub = (String) view.jComboBox1.getSelectedItem();
        String query = "select * from kategori_alternatif where kategori_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("kategori_alternatif.seq");
            }
            view.jLabel10.setText(id + "");
        } catch (Exception e) {
        } finally {
            getDataAlternatif(view);
            Matrix(view);
            getPerbandinganAlternatif(view);
            view.jButton4.setEnabled(true);
        }
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

    private DefaultTableModel model;
    private JTable headerTable;

    public void tablematrik(Matrix_Alternatif view) {

        model = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return view.jTable1.getRowCount();
            }

            @Override
            public Class<?> getColumnClass(int colNum) {
                switch (colNum) {
                    case 0:
                        return String.class;
                    default:
                        return super.getColumnClass(colNum);
                }
            }
        };
        headerTable = new JTable(model);
        List<HashMap<String, Object>> df = getDataAlternatif(view);
        for (int i = 0; i < getJumlah(view); i++) {
            String aa = df.get(i).get("nama").toString();
            headerTable.setValueAt(aa, i, 0);
            headerTable.setValueAt("Jumlah", i + 1, 0);
        }
        headerTable.setPreferredScrollableViewportSize(new Dimension(100, 0));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                boolean selected = view.jTable1.getSelectionModel().isSelectedIndex(row);
                Component component = view.jTable1.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(view.jTable1, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.black);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
        view.jScrollPane1.setRowHeaderView(headerTable);
        view.jTable1.setPreferredScrollableViewportSize(view.jTable1.getPreferredSize());
    }

    public void tablematrik2(Matrix_Alternatif view) {
        model = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return view.jTable3.getRowCount();
            }

            @Override
            public Class<?> getColumnClass(int colNum) {
                switch (colNum) {
                    case 0:
                        return String.class;
                    default:
                        return super.getColumnClass(colNum);
                }
            }
        };
        headerTable = new JTable(model);
        List<HashMap<String, Object>> df = getDataAlternatif(view);
        for (int i = 0; i < getJumlah(view); i++) {
            String aa = df.get(i).get("nama").toString();
            headerTable.setValueAt(aa, i, 0);
        }
        headerTable.setPreferredScrollableViewportSize(new Dimension(100, 0));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                boolean selected = view.jTable3.getSelectionModel().isSelectedIndex(row);
                Component component = view.jTable3.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(view.jTable3, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.black);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
        view.jScrollPane3.setRowHeaderView(headerTable);
        view.jTable3.setPreferredScrollableViewportSize(view.jTable3.getPreferredSize());
    }

    public int getJumlah(Matrix_Alternatif view) {

        int jumlah = 0;
        
        try {
            String sql = "SELECT\n"
                    + "alternatif.seq, \n"
                    + "alternatif.alternatif_name, \n"
                    + "alternatif.kategori_seq, \n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "INNER JOIN\n"
                    + "kategori_alternatif\n"
                    + "ON \n"
                    + "alternatif.kategori_seq = kategori_alternatif.seq\n"
                    + "WHERE alternatif.kategori_seq = '"+view.jLabel10.getText()+"'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                jumlah++;
            }

        } catch (Exception e) {
        }
        return jumlah;
    }

    public List<HashMap<String, Object>> getDataAlternatif(Matrix_Alternatif view) {

        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();

        try {
            String sql = "SELECT\n"
                    + "alternatif.seq, \n"
                    + "alternatif.alternatif_name, \n"
                    + "alternatif.kategori_seq, \n"
                    + "kategori_alternatif.kategori_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "INNER JOIN\n"
                    + "kategori_alternatif\n"
                    + "ON \n"
                    + "alternatif.kategori_seq = kategori_alternatif.seq\n"
                    + "WHERE alternatif.kategori_seq = '"+view.jLabel10.getText()+"'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", r.getString("alternatif.seq"));
                map.put("nama", r.getString("alternatif.alternatif_name"));
                map.put("idKategori", r.getString("alternatif.kategori_seq"));

                maps.add(map);
            }

        } catch (Exception e) {
        }
        return maps;
    }

    public void Matrix(Matrix_Alternatif view) {

        int a = getJumlah(view);

        String[] cs = new String[a];

        List<HashMap<String, Object>> df = getDataAlternatif(view);

        for (int i = 0; i < a; i++) {
            cs[i] = df.get(i).get("nama").toString();
        }

        setttablematrix(view.jTable1, a + 1, cs);
        tablematrik(view);

        for (int y1 = 0; y1 < a; y1++) {
            view.jTable1.setValueAt(1, y1, y1);
        }

        String[] c2 = new String[a + 1];
        String[] c1 = new String[a + 1 + 1];
        for (int i = 0; i < a; i++) {
            c2[i] = df.get(i).get("nama").toString();
            c2[i + 1] = "Eigen Vector Normalisasi";
            c1[i] = "";
            c1[i + 1] = "Jumlah";
            c1[i + 2] = "Lamda Max Tiap Baris";
        }

        setttablematrix(view.jTable3, a, c2);
        tablematrik2(view);
        setttablematrix(view.jTable2, a, c1);

        int rCon = view.jTable1.getRowCount() - 1;
        for (int i = 0; i < rCon; i++) {
            for (int j = i + 1; j < rCon; j++) {
                try {

                    String sql = "SELECT\n"
                            + "	perbandingan_alternatif.seq, \n"
                            + "	perbandingan_alternatif.alternatif1_seq, \n"
                            + "	perbandingan_alternatif.alternatif2_seq, \n"
                            + "	perbandingan_alternatif.kategori_seq, \n"
                            + "	perbandingan_alternatif.pilihan_alternatif_seq, \n"
                            + "	perbandingan_alternatif.kriteria_seq, \n"
                            + "	perbandingan_alternatif.nilai, \n"
                            + "	alternatif.alternatif_name\n"
                            + "FROM\n"
                            + "	perbandingan_alternatif\n"
                            + "	INNER JOIN alternatif ON perbandingan_alternatif.pilihan_alternatif_seq = alternatif.seq\n"
                            + "WHERE perbandingan_alternatif.kategori_seq = '" + view.jLabel10.getText() + "'\n"
                            + "AND perbandingan_alternatif.kriteria_seq = '" + view.jLabel9.getText() + "'\n"
                            + "AND perbandingan_alternatif.alternatif1_seq = '" + df.get(i).get("id").toString() + "'\n"
                            + "AND perbandingan_alternatif.alternatif2_seq ='" + df.get(j).get("id").toString() + "'";
                            
                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(sql);

                    BigDecimal nilai = BigDecimal.ONE;
                    int alternatif1_seq = 0;
                    int alternatif2_seq = 0;
                    int pilihan_alternatif_seq = 0;

                    while (r.next()) {

                        nilai = new BigDecimal(r.getString("perbandingan_alternatif.nilai"));
                        alternatif1_seq = r.getInt("perbandingan_alternatif.alternatif1_seq");
                        alternatif2_seq = r.getInt("perbandingan_alternatif.alternatif2_seq");
                        pilihan_alternatif_seq = r.getInt("perbandingan_alternatif.pilihan_alternatif_seq");

                    }
                    
                    System.out.println("kriteria1_seq : "+alternatif1_seq);
                    System.out.println("kriteria2_seq : "+alternatif2_seq);
                    System.out.println("pilihan_kriteria_seq : "+pilihan_alternatif_seq);
                    System.out.println("nilai : "+nilai);
                    
                    DecimalFormat format = new DecimalFormat("#.###");
                    
                    BigDecimal hasilnilai = BigDecimal.ZERO;
                    
                    if (alternatif1_seq == pilihan_alternatif_seq) {
                        hasilnilai = nilai.divide(new BigDecimal(BigInteger.ONE), 15, RoundingMode.HALF_EVEN);
                        hasilnilai.setScale(6, RoundingMode.HALF_EVEN);
                    }else if (alternatif2_seq == pilihan_alternatif_seq){
                        hasilnilai = new BigDecimal(BigInteger.ONE).divide(nilai, 15, RoundingMode.HALF_EVEN);
                        hasilnilai.setScale(6, RoundingMode.HALF_EVEN);
                    }
                    
                    System.out.println("hasilnilai : "+format.format(hasilnilai));
                    
                    view.jTable1.setValueAt(format.format(hasilnilai), i, j);
                } catch (SQLException ex) {
                    Logger.getLogger(Control_Matrix_Alternatif.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        view.buttonGlass1.setText("...");
        view.buttonGlass2.setText("...");
        view.buttonGlass3.setText("...");
    }

    public void processData(Matrix_Alternatif view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        List<HashMap<String, Object>> df = getDataAlternatif(view);

        view.jScrollPane3.setRowHeader(null);
        int a1 = getJumlah(view);
        
        String[] c2 = new String[a1 + 1];
        String[] c1 = new String[a1 + 1 + 1];
        for (int i = 0; i < a1; i++) {
            c2[i] = df.get(i).get("nama").toString();
            c2[i + 1] = "Eigen Vector Normalisasi";
            c1[i] = "";
            c1[i + 1] = "Jumlah";
            c1[i + 2] = "Lamda Max Tiap Baris";
        }

        setttablematrix(view.jTable3, a1, c2);
        tablematrik2(view);

        if (view.jTable1.getRowCount() == 2) {
            JOptionPane.showMessageDialog(view, "Data Can Not Be Calculated", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            int rCon = view.jTable1.getRowCount() - 1;
            for (int i = 0; i < rCon; i++) {
                double x = Double.parseDouble(view.jTable1.getValueAt(i, i).toString());
                for (int j = i + 1; j < rCon; j++) {
                    double s = Double.parseDouble(view.jTable1.getValueAt(i, j).toString());
                    double hasil = 0.0;
                    hasil = x / s;
                    view.jTable1.setValueAt(batas.format(hasil), j, i);
                }
            }

            double hs = 0;
            int t = 0;
            double q = 0;
            double s = 0;
            double hasil = 0.0;
            int rCon1 = view.jTable1.getRowCount() - 1;
            for (int xx = 0; xx < rCon1; xx++) {
                for (t = 0; t < rCon1; t++) {
                    q = Double.parseDouble(view.jTable1.getValueAt(t, xx).toString());
                    hs = hs + q;
                }
                view.jTable1.setValueAt(batas.format(hs) + "", t, xx);
                hs = 0;
            }

            int p = 0;
            int rcount = view.jTable1.getRowCount() - 1;
            for (int r = 0; r < rcount; r++) {
                for (p = 0; p < rcount; p++) {
                    double hitung = 0.0;
                    double hasilBagi = 0.0;
                    double pembagi = Double.parseDouble(view.jTable1.getValueAt(rcount, r).toString());
                    hitung = Double.parseDouble(view.jTable1.getValueAt(p, r).toString());
                    hasilBagi = hitung / pembagi;
                    view.jTable3.setValueAt(batas.format(hasilBagi), p, r);
                }
            }

            int a = getJumlah(view);
            double baris = 0.0;
            double eigen = 0.0;
            double q1 = 0.0;
            int t1 = 0;
            int xx = 0;
            int row = view.jTable3.getRowCount();
            for (xx = 0; xx < row; xx++) {
                for (t1 = 0; t1 < row; t1++) {
                    q1 = Double.parseDouble(view.jTable3.getValueAt(xx, t1).toString());
                    baris = baris + q1;
                    eigen = baris / a;
                }
                view.jTable3.setValueAt(batas.format(eigen), xx, t1);
                baris = 0;
            }

            double jumlah = 0.0;
            double hitung2 = 0.0;
            double hitung3 = 0.0;
            double hasilkali = 0.0;
            double hasiljumlah = 0.0;
            int rcount2 = view.jTable1.getRowCount() - 1;
            for (int r2 = 0; r2 < rcount2; r2++) {
                jumlah = Double.parseDouble(view.jTable3.getValueAt(r2, rcount2).toString());
                for (int p2 = 0; p2 < rcount2; p2++) {
                    hitung2 = Double.parseDouble(view.jTable1.getValueAt(p2, r2).toString());
                    hasilkali = hitung2 * jumlah;
                    view.jTable2.setValueAt(batas.format(hasilkali), p2, r2);
                }
            }

            double baris5 = 0.0;
            double eigen5 = 0.0;
            double q15 = 0.0;
            int t15 = 0;
            int row5 = view.jTable2.getRowCount();
            for (int xx5 = 0; xx5 < row5; xx5++) {
                for (t15 = 0; t15 < row5; t15++) {
                    q15 = Double.parseDouble(view.jTable2.getValueAt(xx5, t15).toString());
                    baris5 = baris5 + q15;
                }
                view.jTable2.setValueAt(batas.format(baris5), xx5, t15);
                baris5 = 0;
            }

            double q155 = 0.0;
            double baris55 = 0.0;
            double eigen55 = 0.0;
            int xx55 = 0;
            int t155 = 0;
            int row55 = view.jTable2.getRowCount();
            for (xx55 = 0; xx55 < row55; xx55++) {
                for (t155 = 0; t155 < row55; t155++) {
                    q155 = Double.parseDouble(view.jTable2.getValueAt(xx55, t155 + 1).toString());
                    eigen55 = Double.parseDouble(view.jTable3.getValueAt(xx55, t155 + 1).toString());
                    baris5 = q155 / eigen55;
                }
                view.jTable2.setValueAt(batas.format(baris5), xx55, t155 + 1);
            }

            double baris7 = 0.0;
            double baris8 = 0.0;
            double q17 = 0.0;
            int row7 = view.jTable2.getRowCount();
            for (int xx7 = 0; xx7 < row7; xx7++) {
                q17 = Double.parseDouble(view.jTable2.getValueAt(xx7, row7 + 1).toString());
                baris7 = baris7 + q17;
                baris8 = baris7 / a;
                view.buttonGlass1.setText("Lamda Max : " + batas.format(baris8));

                double CI = (Double.parseDouble(view.buttonGlass1.getText().replaceAll("Lamda Max : ", "")) - a) / (a - 1);
                view.buttonGlass2.setText("Consistency Index : " + batas.format(CI));
            }
            CR(view);
        }
    }

    public void CR(Matrix_Alternatif view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        double hasilCI = 0.0;
        int elemen = getJumlah(view);
        double CR = Double.parseDouble(view.buttonGlass2.getText().replaceAll("Consistency Index : ", ""));
        String query = "select random_consistency from random_index where size_matrics = '" + elemen + "'";
        try {
            PreparedStatement prepare = c.prepareStatement(query);
            ResultSet rs = prepare.executeQuery();
            String Random_Consistency = "";
            while (rs.next()) {
                Random_Consistency = rs.getString("random_consistency");
            }
            hasilCI = CR / Double.parseDouble(Random_Consistency);
            view.buttonGlass3.setText("Consistency Rasio : " + batas.format(hasilCI) + " < 0.1");
        } catch (SQLException ex) {
        } finally {
            int jum = getJumlah(view);
            if (jum == 2) {
                JOptionPane.showMessageDialog(view, "CR Value Is Consistent!", "Correct", JOptionPane.INFORMATION_MESSAGE);
            } else if (jum == 1) {
                JOptionPane.showMessageDialog(view, "CR Value Is Consistent!", "Correct", JOptionPane.INFORMATION_MESSAGE);
            } else if (hasilCI < 0.1) {
                view.buttonGlass3.setForeground(Color.BLUE);
                JOptionPane.showMessageDialog(view, "CR value is Consistent!\nThat is : " + view.buttonGlass3.getText() + "", "Correct", JOptionPane.INFORMATION_MESSAGE);
                saveProccess(view);
            } else {
                JOptionPane.showMessageDialog(view, "CR value not consistent!", "Wrong", JOptionPane.ERROR_MESSAGE);

                view.jTabbedPane1.setEnabledAt(1, false);
                view.jTabbedPane1.setSelectedIndex(0);
                view.jTabbedPane1.setEnabledAt(0, true);
                view.jButton4.setEnabled(false);
            }
        }
    }

    public void saveProccess(Matrix_Alternatif view) {

        try {
            double eigen551 = 0.0;
            int xx551 = 0;
            int t1551 = 0;
            int row551 = view.jTable3.getRowCount();

            String sqlq = "DELETE FROM eigen_alternatif\n"
                    + "WHERE kategori_seq = '"+view.jLabel10.getText()+"' AND kriteria_seq = '"+view.jLabel9.getText()+"'";

            PreparedStatement p22 = c.prepareStatement(sqlq);
            p22.executeUpdate();
            p22.close();

            List<HashMap<String, Object>> df = getDataAlternatif(view);

            for (xx551 = 0; xx551 < row551; xx551++) {

                int id = Integer.parseInt(df.get(xx551).get("id").toString());
                int idKategori = Integer.parseInt(df.get(xx551).get("idKategori").toString());
                
                for (t1551 = 0; t1551 < row551; t1551++) {
                    eigen551 = Double.parseDouble(view.jTable3.getValueAt(xx551, t1551 + 1).toString());
                }

                String sql = "insert into eigen_alternatif set \n"
                        + "eigen_value ='" + eigen551 + "',\n"
                        + "date = CURDATE(),"
                        + "alternatif_seq = '"+id+"',"
                        + "kriteria_seq = '"+view.jLabel9.getText()+"',"
                        + "kategori_seq ='" + view.jLabel10.getText() + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

            }

        } catch (SQLException e) {
        }
    }

    public void getPerbandinganAlternatif(Matrix_Alternatif view) {

        try {

            DefaultTableModel tabelKej = new DefaultTableModel();
            tabelKej.addColumn("No");
            tabelKej.addColumn("Seq 1");
            tabelKej.addColumn("Nama Alternatif 1");
            tabelKej.addColumn("Seq 2");
            tabelKej.addColumn("Nama Alternatif 2");
            tabelKej.addColumn("Seq Pilihan");
            tabelKej.addColumn("Alternatif Pilihan");
            tabelKej.addColumn("Nilai");

            int a = getJumlah(view);

            List<HashMap<String, Object>> df = getDataAlternatif(view);

            int no = 0;

            for (int j = 0; j < a; j++) {
                for (int i = j + 1; i < a; i++) {

                    Vector vector = new Vector();

                    no++;
                    vector.addElement(no);
                    vector.addElement(df.get(j).get("id").toString());
                    vector.addElement(df.get(j).get("nama").toString());
                    vector.addElement(df.get(i).get("id").toString());
                    vector.addElement(df.get(i).get("nama").toString());

                    String sql = "SELECT\n" 
                            + "	perbandingan_alternatif.seq, \n"
                            + "	perbandingan_alternatif.alternatif1_seq, \n"
                            + "	perbandingan_alternatif.alternatif2_seq, \n"
                            + "	perbandingan_alternatif.kategori_seq, \n"
                            + "	perbandingan_alternatif.pilihan_alternatif_seq, \n"
                            + "	perbandingan_alternatif.kriteria_seq, \n"
                            + "	perbandingan_alternatif.nilai, \n"
                            + "	alternatif.alternatif_name\n"
                            + "FROM\n"
                            + "	perbandingan_alternatif\n"
                            + "	INNER JOIN alternatif ON perbandingan_alternatif.pilihan_alternatif_seq = alternatif.seq\n"
                            + "WHERE perbandingan_alternatif.kategori_seq = '" + view.jLabel10.getText() + "'\n"
                            + "AND perbandingan_alternatif.kriteria_seq = '" + view.jLabel9.getText() + "'\n"
                            + "AND perbandingan_alternatif.alternatif1_seq = '" + df.get(j).get("id").toString() + "'\n"
                            + "AND perbandingan_alternatif.alternatif2_seq ='" + df.get(i).get("id").toString() + "'";
                    
                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(sql);

                    int idPilihan = 0;
                    String namaPilihan = "";
                    BigDecimal nilai = BigDecimal.ONE;

                    while (r.next()) {

                        idPilihan = r.getInt("perbandingan_alternatif.pilihan_alternatif_seq");
                        namaPilihan = r.getString("alternatif.alternatif_name");
                        nilai = new BigDecimal(r.getString("perbandingan_alternatif.nilai"));

                    }

                    vector.addElement(idPilihan);
                    vector.addElement(namaPilihan);
                    vector.addElement(nilai);

                    tabelKej.addRow(vector);
                }
            }

            view.jTable4.setModel(tabelKej);

        } catch (Exception e) {
        } finally {
            view.jTable4.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable4.getColumnModel().getColumn(3).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(3).setMaxWidth(0);
            view.jTable4.getColumnModel().getColumn(5).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(5).setMaxWidth(0);
            buatKolomSesuai(view.jTable4);
        }
    }

    public void saveProccessMatrix(Matrix_Alternatif view) {

        try {

            String idTerpilih = null;

            if (view.jRadioButton1.isSelected() == false && view.jRadioButton2.isSelected() == false) {
                JOptionPane.showMessageDialog(view, "Please your choice", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (view.jTextField3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (view.jRadioButton1.isSelected() == true) {
                    idTerpilih = view.jLabel7.getText();
                } else {
                    idTerpilih = view.jLabel8.getText();
                }
            }

            String sqls = "SELECT\n"
                    + "	perbandingan_alternatif.seq, \n"
                    + "	perbandingan_alternatif.alternatif1_seq, \n"
                    + "	perbandingan_alternatif.alternatif2_seq, \n"
                    + "	perbandingan_alternatif.kategori_seq, \n"
                    + "	perbandingan_alternatif.pilihan_alternatif_seq, \n"
                    + "	perbandingan_alternatif.kriteria_seq, \n"
                    + "	perbandingan_alternatif.nilai, \n"
                    + "	alternatif.alternatif_name\n"
                    + "FROM\n"
                    + "	perbandingan_alternatif\n"
                    + "	INNER JOIN alternatif ON perbandingan_alternatif.pilihan_alternatif_seq = alternatif.seq\n"
                    + "WHERE perbandingan_alternatif.kategori_seq = '" + view.jLabel10.getText() + "'\n"
                    + "AND perbandingan_alternatif.kriteria_seq = '" + view.jLabel9.getText() + "'\n"
                    + "AND perbandingan_alternatif.alternatif1_seq = '" + view.jLabel7.getText() + "'\n"
                    + "AND perbandingan_alternatif.alternatif2_seq ='" + view.jLabel8.getText() + "'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sqls);

            int idPilihan = 0;

            while (r.next()) {
                idPilihan = r.getInt("perbandingan_alternatif.pilihan_alternatif_seq");
            }
            
            if (idPilihan == 0) {
                
                String sql = "insert into perbandingan_alternatif set \n"
                        + "alternatif1_seq ='" + view.jLabel7.getText() + "',\n"
                        + "alternatif2_seq = '" + view.jLabel8.getText() + "',"
                        + "kriteria_seq = '" + view.jLabel9.getText() + "',"
                        + "kategori_seq = '" + view.jLabel10.getText() + "',"
                        + "pilihan_alternatif_seq = '" + idTerpilih + "',"
                        + "nilai ='" + view.jTextField3.getText() + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

                JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                getData(view);
            
            }else{
                
                String sql = "update perbandingan_alternatif \n"
                        + "set pilihan_alternatif_seq='" + idTerpilih + "', \n"
                        + "kriteria_seq='" + view.jLabel9.getText() + "',\n"
                        + "kategori_seq='" + view.jLabel10.getText() + "',\n"
                        + "nilai='" + view.jTextField3.getText() + "'\n"
                        + "WHERE perbandingan_alternatif.kategori_seq = '" + view.jLabel10.getText() + "'\n"
                        + "AND perbandingan_alternatif.kriteria_seq = '" + view.jLabel9.getText() + "'\n"
                        + "AND perbandingan_alternatif.alternatif1_seq = '" + view.jLabel7.getText() + "'\n"
                        + "AND perbandingan_alternatif.alternatif2_seq ='" + view.jLabel8.getText() + "'";

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();
                
                JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
//                getData(view);
                getDataAlternatif(view);
                Matrix(view);
                getPerbandinganAlternatif(view);
            }
            
            

        } catch (SQLException e) {
        }
    }
    
    public void openForm(Matrix_Alternatif view){
        int row = view.jTable4.getSelectedRow();
        view.jLabel7.setText(view.jTable4.getValueAt(row, 1) + "");
        view.jLabel8.setText(view.jTable4.getValueAt(row, 3) + "");
        view.jTextField3.setText(view.jTable4.getValueAt(row, 7) + "");
        view.jRadioButton1.setText(view.jTable4.getValueAt(row, 2).toString());
        view.jRadioButton2.setText(view.jTable4.getValueAt(row, 4).toString());
        
        if (view.jTable4.getValueAt(row, 2).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {
            view.jRadioButton1.setSelected(true);
        } else if (view.jTable4.getValueAt(row, 4).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {
            view.jRadioButton2.setSelected(true);
        } else {
            view.buttonGroup1.clearSelection();
        }
        view.panelGlass2.setVisible(true);
    }
    
    public void saveProccessMatrixAll(Matrix_Alternatif view) {

        try {

            String sqsl = "DELETE FROM perbandingan_alternatif\n"
                    + "WHERE kategori_seq = '"+view.jLabel10.getText()+"' AND kriteria_seq = '"+view.jLabel9.getText()+"'";

            PreparedStatement p221s = c.prepareStatement(sqsl);
            p221s.executeUpdate();
            p221s.close();
            
            for (int i = 0; i < view.jTable4.getRowCount(); i++) {
                
                String sql = "insert into perbandingan_alternatif set \n"
                        + "alternatif1_seq ='" + view.jTable4.getValueAt(i, 1) + "',\n"
                        + "alternatif2_seq = '" + view.jTable4.getValueAt(i, 3) + "',"
                        + "kriteria_seq = '" + view.jLabel9.getText() + "',"
                        + "kategori_seq = '" + view.jLabel10.getText() + "',"
                        + "pilihan_alternatif_seq = '" + view.jTable4.getValueAt(i, 5) + "',"
                        + "nilai ='" + view.jTable4.getValueAt(i, 7) + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();
                
            }

        } catch (SQLException e) {
        } finally {
            Matrix(view);
            view.panelGlass2.setVisible(false);
            getPerbandinganAlternatif(view);
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
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }
}
