/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Change_Password;
import Layout.Alternatif;
import Layout.Perangkingan;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    
//    public void process(Perangkingan view) {
//        
//        int eigen = view.jTable5.getRowCount();
//        int assessment = view.jTable3.getRowCount();
//
//        for (int h = 0; h < assessment; h++) {
//            double plus = 0.0;
//            double kali = 0.0;
//            double geteigen = 0.0;
//            double getassessment = 0.0;
//
//            for (int i = 0; i < eigen; i++) {
//                geteigen = Double.parseDouble(view.jTable5.getValueAt(i, 2).toString());
//                getassessment = Double.parseDouble(view.jTable3.getValueAt(h, i + 3).toString());
//                kali = geteigen * getassessment;
//                plus += kali;
//            }
//            view.jTable3.setValueAt(batas.format(plus), h, eigen + 3);
//
//        }
//
//        double[] Array = new double[assessment];
//        int asc = 0;
//        for (int i = 0; i < assessment; i++) {
//            Array[i] = Double.parseDouble(view.jTable3.getValueAt(i, eigen + 3).toString());
//        }
//
//        int rank[] = getRanksArray(Array);
//        for (int i = 0; i < view.jTable3.getRowCount(); i++) {
//            view.jTable3.setValueAt(rank[i], i, eigen + 4);
//        }
//
//        int index = 1;
//        for (int i = 0; i < assessment; i++) {
//            int rangking = Integer.parseInt(view.jTable3.getValueAt(i, eigen + 4).toString());
//            if (rangking < 3) {
//                view.jTable3.setValueAt("Lulus", i, eigen + 5);
//            } else {
//                view.jTable3.setValueAt("Tidak Lulus", i, eigen + 5);
//            }
//        }
//
//        saveData(view);
//    }
//
//    public static int[] getRanksArray(double[] array) {
//        int[] result = new int[array.length];
//        
//        for (int i = 0; i < array.length; i++) {
//            int count = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (array[j] > array[i]) {
//                    count++;
//                }
//            }
//            result[i] = count + 1;
//        }
//        return result;
//    }
//    
//    public void saveData(Final_Result view) {
//        Calendar cal = Calendar.getInstance();
//        int tahun = cal.get(Calendar.YEAR);
//        
//        try {
//            for (int i = 0; i < view.jTable3.getRowCount(); i++) {
//
//                String query = "SELECT\n"
//                        + "student.seq,\n"
//                        + "student.student_nim,\n"
//                        + "student.student_name,\n"
//                        + "student.majors_code,\n"
//                        + "student.student_semester,\n"
//                        + "student.student_generation\n"
//                        + "FROM\n"
//                        + "student\n"
//                        + "WHERE student_nim = '" + view.jTable3.getValueAt(i, 1) + "'\n"
//                        + "AND student_name = '" + view.jTable3.getValueAt(i, 2) + "'";
//
//                Statement st = c.createStatement();
//                ResultSet r = st.executeQuery(query);
//
//                String seq = "";
//
//                while (r.next()) {
//                    seq = r.getString("seq");
//
//                    String sqlq = "DELETE from result WHERE student_seq = '" + seq + "'"
//                            + "AND DATE_FORMAT(datenow,'%Y')= '"+tahun+"'";
//
//                    PreparedStatement t = c.prepareStatement(sqlq);
//                    t.executeUpdate();
//                    t.close();
//
//                    String sql = "insert into result set student_seq ='"+seq+"',"
//                            + "value_results = '"+view.jTable3.getValueAt(i, 7)+"',"
//                            + "rangking = '"+view.jTable3.getValueAt(i, 8)+"',"
//                            + "status = '"+view.jTable3.getValueAt(i, 9)+"',"
//                            + "datenow = CURDATE()";
//
//                    PreparedStatement p22 = c.prepareStatement(sql);
//                    p22.executeUpdate();
//                    p22.close();
//                }
//            }
//            
//            JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
//
//            getDataSave(view);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
