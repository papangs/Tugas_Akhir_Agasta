/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Alternatif;
import Layout.UserAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irawan Papang S
 */
public class Control_UserAdmin {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    
    public void getData(UserAdmin view){
        view.jTextField1.setText("");
        view.jPasswordField1.setText("");
        view.jComboBox1.setSelectedItem("-PILIH-");
        view.jButton1.setText("Save");
        view.jButton2.setVisible(false);
        view.jLabel1.setVisible(false);
        getDataUserAdmin(view);
    }
    
    public void getDataUserAdmin(UserAdmin view) {
        
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Username");
        tabelKej.addColumn("Password");
        tabelKej.addColumn("Akses");
        try {
            String sql = "SELECT\n"
                    + "`user`.user_seq,\n"
                    + "`user`.username,\n"
                    + "`user`.`password`,\n"
                    + "`user`.`akses`\n"
                    + "FROM\n"
                    + "`user`";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {

                byte[] decodedBytes = Base64.getDecoder().decode(r.getString("user.password"));
                String decodedString = new String(decodedBytes);

                if (!r.getString("user.akses").equals("Superadmin")) {

                    tabelKej.addRow(new Object[]{n++, r.getString("user.user_seq"),
                        r.getString("user.username"),
                        decodedString, r.getString("user.akses")});
                }
            }

            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        }
    }
    
    public void saveData(UserAdmin view) {
        try {
            if (view.jTextField1.getText().equals("") || view.jPasswordField1.getText().equals("") || view.jComboBox1.getSelectedItem().equals("-PILIH-")) {
                JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                
                String password = Base64.getEncoder().encodeToString(view.jPasswordField1.getText().getBytes());
                
                if (view.jButton1.getText().equals("Save")) {

                    String sql = "insert into user set "
                            + "username='" + view.jTextField1.getText() + "',"
                            + "password='" + password + "',"
                            + "akses='" + view.jComboBox1.getSelectedItem()+ "'";
                    
                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                
                }else if (view.jButton1.getText().equals("Update")){
                    
                    String sql = "update user set \n"
                            + "username='" + view.jTextField1.getText() + "',"
                            + "password='" + password + "',"
                            + "akses='" + view.jComboBox1.getSelectedItem() + "'"
                            + "where user_seq ='" + view.jLabel1.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Update", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                    
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Password Not Successful in Replace", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readDataKategori(UserAdmin view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "user.user_seq, \n"
                + "user.username, \n"
                + "user.password, \n"
                + "user.akses\n"
                + "FROM\n"
                + "user\n"
                + "WHERE user.user_seq = '"+view.jTable1.getValueAt(a, 1)+"'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            int user_seq = 0;
            String username = "";
            String password = "";
            String akses = "";

            while (r.next()) {
                user_seq = r.getInt("user.user_seq");
                username = r.getString("user.username");
                password = r.getString("user.password");
                akses = r.getString("user.akses");
            }

            view.jLabel1.setText(user_seq+"");
            view.jTextField1.setText(username);
            view.jPasswordField1.setText(password);
            view.jComboBox1.setSelectedItem(akses);
        } catch (Exception e) {
        }finally{
            view.jButton1.setText("Update");
        view.jButton2.setVisible(true);
        }
    }
    
    public void deleteDataUser(UserAdmin view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from user where user_seq='" + view.jLabel1.getText() + "'";
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
}
