/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Matrix_Kriteria;
import com.lowagie.text.pdf.parser.Matrix;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Matrix_Kriteria {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;

    public void resetData(Matrix_Kriteria view) {
        buatKolomSesuai(view.jTable1);
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

    public void tablematrik(Matrix_Kriteria view) {

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
        List<HashMap<String, Object>> df = getDataKriteria();
        for (int i = 0; i < getJumlah(); i++) {
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

    public void tablematrik2(Matrix_Kriteria view) {
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
        List<HashMap<String, Object>> df = getDataKriteria();
        for (int i = 0; i < getJumlah(); i++) {
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

    public int getJumlah() {

        int jumlah = 0;

        try {
            String sql = "SELECT\n"
                    + "kriteria.seq,\n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "kriteria";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                jumlah++;
            }

        } catch (Exception e) {
        }
        return jumlah;
    }

    public List<HashMap<String, Object>> getDataKriteria() {
        
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();

        try {
            String sql = "SELECT\n"
                    + "kriteria.seq,\n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "kriteria";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", r.getString("kriteria.seq"));
                map.put("nama", r.getString("kriteria.kriteria_name"));
                
                maps.add(map);
            }

        } catch (Exception e) {
        }
        return maps;
    }

    public void Matrix(Matrix_Kriteria view) {
        
        int a = getJumlah();

        String[] c = new String[a];
        
        List<HashMap<String, Object>> df = getDataKriteria();

        for (int i = 0; i < a; i++) {
            c[i] = df.get(i).get("nama").toString();
        }
        
        setttablematrix(view.jTable1, a + 1, c);
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
                String[] saaty = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0.5", "0.333", "0.25", "0.2", "0.166", "0.142", "0.125", "0.111"};
                int random = (int) (Math.random() * 17);
                String setran = saaty[random];
                view.jTable1.setValueAt(setran, i, j);
            }
        }

        view.buttonGlass1.setText("...");
        view.buttonGlass2.setText("...");
        view.buttonGlass3.setText("...");
    }

    public void processData(Matrix_Kriteria view) {
        
        DecimalFormat batas = new DecimalFormat("#.###");
        
        List<HashMap<String, Object>> df = getDataKriteria();
        
        view.jScrollPane3.setRowHeader(null);
        int a1 = getJumlah();
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
                view.jTable1.setValueAt(batas.format(hs)+"", t, xx);
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

            int a = getJumlah();
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
                view.buttonGlass1.setText("Lamda Max : "+batas.format(baris8));

                double CI = (Double.parseDouble(view.buttonGlass1.getText().replaceAll("Lamda Max : ", "")) - a) / (a - 1);
                view.buttonGlass2.setText("Consistency Index : "+batas.format(CI));
            }
            CR(view);
        }
    }
    
    public void CR(Matrix_Kriteria view) {
        
        DecimalFormat batas = new DecimalFormat("#.###");
        
        double hasilCI = 0.0;
        int elemen = getJumlah();
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
            view.buttonGlass3.setText("Consistency Rasio : "+batas.format(hasilCI)+" < 0.1");
        } catch (SQLException ex) {
        } finally {
            int jum = getJumlah();
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
//                view.jButton5.doClick();
//                view.jButton3.doClick();
            }
        }
    }
    
    public void saveProccess(Matrix_Kriteria view) {
        
        try {
            double eigen551 = 0.0;
            int xx551 = 0;
            int t1551 = 0;
            int row551 = view.jTable3.getRowCount();

            String sqlq = "TRUNCATE TABLE eigen";

            PreparedStatement p22 = c.prepareStatement(sqlq);
            p22.executeUpdate();
            p22.close();

            List<HashMap<String, Object>> df = getDataKriteria();
        
            for (xx551 = 0; xx551 < row551; xx551++) {
                
                int id = Integer.parseInt(df.get(xx551).get("id").toString());
                for (t1551 = 0; t1551 < row551; t1551++) {
                    eigen551 = Double.parseDouble(view.jTable3.getValueAt(xx551, t1551 + 1).toString());
                }

                String sql = "insert into eigen set \n"
                        + "eigen_value ='" + eigen551 + "',\n"
                        + "date = CURDATE(),"
                        + "kriteria_seq ='" + id + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

            }
            
            JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
        }
    }
}
