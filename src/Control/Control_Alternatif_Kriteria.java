/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Alternatif_Kriteria;
import java.awt.Component;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Alternatif_Kriteria {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    int jum11 = 0;

    public void resetData(Alternatif_Kriteria view) {
        view.jLabel1.setVisible(false);
        view.jLabel1.setText("-");
        view.buttonGlass1.setText("---");
    }

    public void getData(Alternatif_Kriteria view) {
        getDataAlternatif(view);
        getDataKriteria(view);
        getDataAlternatifKriteria(view);
        resetData(view);
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

    public void getDataAlternatif(Alternatif_Kriteria view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Alternatif");
        try {
            String sql = "SELECT DISTINCT\n"
                    + "alternatif.seq,\n"
                    + "alternatif.alternatif_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "WHERE NOT EXISTS(SELECT * FROM alternatif_kriteria\n"
                    + "WHERE alternatif.seq = alternatif_kriteria.alternatif_seq\n"
                    + "GROUP BY alternatif_kriteria.alternatif_seq)";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getString("alternatif.seq"),
                    r.getString("alternatif.alternatif_name")});
            }
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            buatKolomSesuai(view.jTable1);
        }
    }

    public void getDataKriteria(Alternatif_Kriteria view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Kriteria");
        tabelKej.addColumn("Content");
        try {
            String sql = "SELECT\n"
                    + "kriteria.seq,\n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "kriteria";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getInt("kriteria.seq"),
                    r.getString("kriteria.kriteria_name")});
            }
            view.jTable2.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }
    }

    public void readData(Alternatif_Kriteria view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "alternatif.seq,\n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "alternatif\n"
                + "WHERE alternatif.seq = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String company_code = "";
            String description = "";

            while (r.next()) {
                company_code = r.getString("alternatif.seq");
                description = r.getString("alternatif.alternatif_name");
            }

            view.jLabel1.setText(company_code);
            view.buttonGlass1.setText(description);
        } catch (Exception e) {
        } finally{
            getDataKriteria(view);
            getDataAlternatifKriteria(view);
        }
    }

    public void saveData(Alternatif_Kriteria view) {

        try {
            
            String query = "SELECT\n"
                    + "alternatif_kriteria.content_name,\n"
                    + "alternatif_kriteria.alternatif_seq,\n"
                    + "alternatif.seq\n"
                    + "FROM\n"
                    + "alternatif_kriteria\n"
                    + "INNER JOIN alternatif ON alternatif_kriteria.alternatif_seq = alternatif.seq\n"
                    + "WHERE alternatif.seq = '" + view.jLabel1.getText() + "'\n"
                    + "GROUP BY alternatif.seq";

            String id = "";

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                id = rs.getString("alternatif_kriteria.alternatif_seq");
            }

            if (!view.jLabel1.getText().equals(id)) {
                
                if (view.jLabel1.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data can not be empty", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else {
                    String a1 = "";
                    String a = "";
                    String b = "";
                    int row551 = view.jTable2.getRowCount();

                    for (int t1551 = 0; t1551 < row551; t1551++) {

                        a1 = view.jLabel1.getText().toString();
                        a = view.jTable2.getValueAt(t1551, 1).toString();
                        b = view.jTable2.getValueAt(t1551, 3).toString();

                        String sql = "insert into alternatif_kriteria set \n"
                                + "kriteria_seq ='" + a + "',\n"
                                + "alternatif_seq ='" + a1 + "',"
                                + "content_name ='" + b + "'";

                        PreparedStatement p221 = c.prepareStatement(sql);
                        p221.executeUpdate();
                        p221.close();

                    }

                    JOptionPane.showMessageDialog(view, "Data successfully Entry", "It worked", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }
                
            }else{
                
                if (view.jLabel1.getText().equals(id)) {

                    if (view.jLabel1.getText().equals("")) {
                        JOptionPane.showMessageDialog(view, "Data can not be empty", "WARNING", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String a1 = "";
                        String a = "";
                        String b = "";
                        int row551 = view.jTable2.getRowCount();

                        String sql1 = "delete from alternatif_kriteria where alternatif_seq='" + view.jLabel1.getText() + "'";

                        PreparedStatement p221 = c.prepareStatement(sql1);
                        p221.executeUpdate();
                        p221.close();
                        
                        for (int t1551 = 0; t1551 < row551; t1551++) {

                            a1 = view.jLabel1.getText().toString();
                            a = view.jTable2.getValueAt(t1551, 1).toString();
                            b = view.jTable2.getValueAt(t1551, 3).toString();

                            String sql = "insert into alternatif_kriteria set \n"
                                    + "kriteria_seq ='" + a + "',\n"
                                    + "alternatif_seq ='" + a1 + "',"
                                    + "content_name ='" + b + "'";

                            PreparedStatement p22 = c.prepareStatement(sql);
                            p22.executeUpdate();
                            p22.close();

                        }

                        JOptionPane.showMessageDialog(view, "Data successfully Entry", "It worked", JOptionPane.INFORMATION_MESSAGE);
                        getData(view);
                    }

                }else{
                    
                    JOptionPane.showMessageDialog(view, "The data already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
                    getData(view);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getDataAlternatifKriteria(Alternatif_Kriteria view) {

        String query = "SELECT\n"
                + "alternatif.seq,\n"
                + "alternatif.alternatif_name,\n"
                + "alternatif_kriteria.alternatif_seq,\n"
                + "alternatif_kriteria.kriteria_seq\n"
                + "FROM\n"
                + "alternatif\n"
                + "INNER JOIN alternatif_kriteria ON alternatif_kriteria.alternatif_seq = alternatif.seq\n"
                + "GROUP BY alternatif_kriteria.alternatif_seq";

        jum11 = 0;
        
        try {
            
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }
            
            int aa = Integer.parseInt(jum11 + "");
            int aaa = view.jTable2.getRowCount();
            
            String[] c1 = new String[aaa + 1 + 1 + 1];
            
            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif Name";
                    c1[i1 + 1 + 1 + 1] = (String) view.jTable2.getValueAt(i1, 2);
                }
            }
            
            setttablematrix(view.jTable3, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable3.setValueAt(i3 + 1, i3, 0);
            }
            
            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("alternatif.seq");
                    view.jTable3.setValueAt(seq, e1++, 1);
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
                    view.jTable3.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

            //nilai
            for (int i2 = 0; i2 < aaa; i2++) {
                
                String nilai = "";
                String taun = "";

                String sql2 = "SELECT\n"
                        + "alternatif_kriteria.content_name,\n"
                        + "alternatif_kriteria.seq,\n"
                        + "alternatif.seq,\n"
                        + "alternatif.alternatif_name,\n"
                        + "kriteria.seq,\n"
                        + "kriteria.kriteria_name\n"
                        + "FROM\n"
                        + "alternatif_kriteria\n"
                        + "INNER JOIN alternatif ON alternatif_kriteria.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN kriteria ON alternatif_kriteria.kriteria_seq = kriteria.seq\n"
                        + "WHERE kriteria.seq = '"+view.jTable2.getValueAt(i2, 1)+"'\n"
                        + "GROUP BY alternatif.seq";
                
                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql2);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("alternatif_kriteria.content_name");
                        dd = dd + 1;
                        
                        view.jTable3.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }
        } catch (SQLException e) {
        }finally{
            view.jTable3.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable3.getColumnModel().getColumn(1).setMaxWidth(0);
        }

    }
    
    public void readDataAlternatifKriteria(Alternatif_Kriteria view) {
        
        int a = view.jTable3.getSelectedRow();
        
        String query = "SELECT\n"
                + "alternatif_kriteria.seq,\n"
                + "alternatif_kriteria.content_name,\n"
                + "alternatif.seq,\n"
                + "alternatif.alternatif_name,\n"
                + "kriteria.seq,\n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "alternatif_kriteria\n"
                + "INNER JOIN alternatif ON alternatif_kriteria.alternatif_seq = alternatif.seq\n"
                + "INNER JOIN kriteria ON alternatif_kriteria.kriteria_seq = kriteria.seq\n"
                + "WHERE alternatif.seq = '" + view.jTable3.getValueAt(a, 1) + "'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            int row = 0;
            String company_code = "";
            String description = "";

            while (r.next()) {
                row = row+1;
                company_code = r.getString("alternatif.seq");
                description = r.getString("alternatif.alternatif_name");
                view.jTable2.setValueAt(r.getString("alternatif_kriteria.content_name"), row-1, 3);
            }

            view.jLabel1.setText(company_code);
            view.buttonGlass1.setText(description);
        } catch (Exception e) {
        } finally{
            getDataAlternatif(view);
        }
    }
    
    public void clearData(Alternatif_Kriteria view) {

        try {

            String sql = "TRUNCATE TABLE alternatif_kriteria";

            PreparedStatement p221 = c.prepareStatement(sql);
            p221.executeUpdate();
            p221.close();

            JOptionPane.showMessageDialog(view, "Data successfully Clear", "It worked", JOptionPane.INFORMATION_MESSAGE);
            getData(view);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Clear", "ERROR", JOptionPane.ERROR_MESSAGE);
        }finally{
            resetData(view);
        }
    }
    
    public static Vector read(String fileName) {
        Vector cellVectorHolder = new Vector();
        try {
            FileInputStream myInput = new FileInputStream(fileName);
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();
            while (rowIter.hasNext()) {
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                //Vector cellStoreVector=new Vector();
                List list = new ArrayList();
                while (cellIter.hasNext()) {
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    list.add(myCell);
                }
                cellVectorHolder.addElement(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }

    public void saveToDatabase(Vector dataHolder) {

        try {
            String ClientAdd = "";
            String Page = "";
            String AccessDate = "";
            String ProcessTime = "";
            String Bytes = "";
            System.out.println(dataHolder);
            
            String sql = "TRUNCATE TABLE alternatif_kriteria;";
            
            PreparedStatement p221 = c.prepareStatement(sql);
            p221.executeUpdate();
            p221.close();
            
            for (Iterator iterator = dataHolder.iterator(); iterator.hasNext();) {
                List list = (List) iterator.next();
                ClientAdd = list.get(0).toString();
                Page = list.get(1).toString();
                AccessDate = list.get(2).toString();
                
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_akhir_agasta", "root", "");
                    System.out.println("connection made...");
                    
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO alternatif_kriteria(kriteria_seq,alternatif_seq,content_name) VALUES(?,?,?)");
                    stmt.setString(1, ClientAdd);
                    stmt.setString(2, Page);
                    stmt.setString(3, AccessDate);
                    stmt.executeUpdate();
                    
                    stmt.close();
                    con.close();
                    
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            
            JOptionPane.showMessageDialog(null, "Data successfully Import", "It worked", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alternatif_Kriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
}
