/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Graphh;
import Layout.Saaty_Detail;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Graph {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    
    public void getData(Graphh view){
        view.jLabel3.setVisible(false);
        comboKategori(view);
        getDataSaaty(view);
    }
    
    public void getDataSaaty(Graphh view) {
        
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Intensitas Kepentingan");
        tabelKej.addColumn("Definisi");
        tabelKej.addColumn("Penjelasan");
        try {
            String sql = "SELECT\n"
                    + "skala_saaty.id_saaty,\n"
                    + "skala_saaty.Intensitas_Kepentingan,\n"
                    + "skala_saaty.Definisi,\n"
                    + "skala_saaty.Penjelasan\n"
                    + "FROM\n"
                    + "skala_saaty";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {

                tabelKej.addRow(new Object[]{n++, r.getString("skala_saaty.id_saaty"),
                    r.getString("skala_saaty.Intensitas_Kepentingan"),
                    r.getString("skala_saaty.Definisi"), 
                    r.getString("skala_saaty.Penjelasan")});
            }

            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        }
    }

    public void detail_saaty(Graphh view) {

        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "skala_saaty.id_saaty,\n"
                + "skala_saaty.Intensitas_Kepentingan,\n"
                + "skala_saaty.Definisi,\n"
                + "skala_saaty.Penjelasan\n"
                + "FROM\n"
                + "skala_saaty\n"
                + "WHERE skala_saaty.id_saaty = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String Intensitas_Kepentingan = "";
            String Definisi = "";
            String Penjelasan = "";

            while (r.next()) {
                Intensitas_Kepentingan = r.getString("skala_saaty.Intensitas_Kepentingan");
                Definisi = r.getString("skala_saaty.Definisi");
                Penjelasan = r.getString("skala_saaty.Penjelasan");
            }

            Saaty_Detail detail = new Saaty_Detail(null, true);
            
            detail.jLabel2.setText(Intensitas_Kepentingan);
            detail.jTextArea2.setText(Definisi);
            detail.jTextArea1.setText(Penjelasan);
            
            detail.setVisible(true);
            detail.jScrollPane1.getViewport();
            detail.jScrollPane2.getViewport();
        } catch (Exception e) {
        }finally{
        }
    }
    
    public void comboKategori(Graphh view) {
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
    
    public void KategoriCode(Graphh view) {
        String sub = (String) view.jComboBox1.getSelectedItem();
        String query = "select * from kategori_alternatif where kategori_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("kategori_alternatif.seq");
            }
            view.jLabel3.setText(id + "");
        } catch (Exception e) {
        } finally {
//            grafikbar(view);
        }
    }
    
//    public void grafikbar(Graphh view) {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            String query = "SELECT\n"
//                    + "alternatif.alternatif_name,\n"
//                    + "hasil_rangking.`value`\n"
//                    + "FROM\n"
//                    + "hasil_rangking\n"
//                    + "INNER JOIN alternatif ON hasil_rangking.alternatif_seq = alternatif.seq\n"
//                    + "WHERE hasil_rangking.kategori_seq = '"+view.jLabel3.getText()+"'";
//
//            JDBCCategoryDataset data = new JDBCCategoryDataset("jdbc:mysql://localhost/tugas_akhir_agasta", "com.mysql.jdbc.Driver", "root", "");
//            data.executeQuery(query);
//            JFreeChart chart = ChartFactory.createBarChart("Grafik", "Alternatif", "Jumlah Nilai", data, PlotOrientation.HORIZONTAL, true, true, false);
//            CategoryPlot bar = chart.getCategoryPlot();
////            bar.setBackgroundPaint(Color.WHITE);
////            bar.setRangeGridlinePaint(Color.BLACK);
//
//            final NumberAxis rangeAxis = (NumberAxis) bar.getRangeAxis();
//            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//
//            BarRenderer renderer = (BarRenderer) bar.getRenderer();
//            renderer.setDrawBarOutline(false);
//
//            final GradientPaint gp0 = new GradientPaint(
//                    0.0f, 0.0f, Color.red,
//                    0.0f, 0.0f, Color.black
//            );
//
//            renderer.setSeriesPaint(0, gp0);
//
//            ChartPanel barpanel = new ChartPanel(chart);
//            view.jPanel1.setVisible(true);
//            view.jPanel1.removeAll();
//            view.jPanel1.add(barpanel, BorderLayout.CENTER);
//            view.jPanel1.validate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }
//    }
}
