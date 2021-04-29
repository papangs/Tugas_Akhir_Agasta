/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Kriteria;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Main {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;

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
    
    public void showData() {
        String query = "SELECT\n"
                + "emitem.company_code,\n"
                + "emitem.description\n"
                + "FROM\n"
                + "emitem";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("company_code");

                String sqlq = "DELETE from data_finance WHERE company_code = '"+id+"'";

                PreparedStatement t = c.prepareStatement(sqlq);
                t.executeUpdate();
                t.close();
                
                int b = 1;
                String c = (String) "B" + id + ".JK";

                b = b * -1;

                Calendar from = Calendar.getInstance();
                Calendar to = Calendar.getInstance();
                from.add(Calendar.YEAR, b); // from 1 year ago

                Stock google = null;
                try {
                    google = YahooFinance.get(c);
                    List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);
                    String value = String.valueOf(googleHistQuotes);
                    String value1 = value.replace(id, "\n");
                    value1 = value1.replace("[", "");
                    value1 = value1.replace("]", "");
                    String[] g = value1.split("@");

                    for (int i = 1; i < g.length; i++) {
                        String string = g[i];
                        String[] g1 = string.split(":");
                        String part1 = g1[0];//Tanggal
                        String part2 = g1[1];
                        String[] g2 = part2.split("-");
                        String part3 = g2[0];//low
                        String part31 = part3.replace(".00", "");
                        String part4 = g2[1];
                        String part5 = g2[2];
                        part5 = part5.replace(">", "");
                        part5 = part5.replace(")", "");
                        String[] g3 = part4.split(",");
                        String part6 = g3[0];//high
                        String part61 = part6.replace(".00", "");
                        String part7 = g3[1];//open
                        String part71 = part7.replace(".00", "");
                        part5 = part5.replace("(", "-->");
                        String[] g4 = part5.split("-->");
                        String part8 = g4[0];//close
                        String part81 = part8.replace(".00", "");

//                    view.jTable1.setValueAt(i, i - 1, 0);
//                    view.jTable1.setValueAt(part1, i - 1, 1);
//                    view.jTable1.setValueAt(part71, i - 1, 2);
//                    view.jTable1.setValueAt(part61, i - 1, 3);
//                    view.jTable1.setValueAt(part31, i - 1, 4);
//                    view.jTable1.setValueAt(part81, i - 1, 5);
                        String sql = "insert into data_finance set \n"
                                + "company_code='" + id + "',\n"
                                + "date='" + part1 + "',"
                                + "open='" + Double.parseDouble(part71) + "',"
                                + "high='" + Double.parseDouble(part61) + "',"
                                + "low='" + Double.parseDouble(part31) + "',"
                                + "close='" + Double.parseDouble(part81) + "',"
                                + "datenow = CURDATE()";

                        Connection c1 = DBConnect.getKoneksi();
                        PreparedStatement p22 = c1.prepareStatement(sql);
                        p22.executeUpdate();
                        p22.close();
                    }

                } catch (IOException ex) {
                }
            }
        } catch (Exception e) {
        }
    }
    
}
