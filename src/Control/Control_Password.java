/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.DBConnect;
import Layout.Change_Password;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Irawan Papang S
 */
public class Control_Password {

    Connection c = DBConnect.getKoneksi();
    ResultSet r;
    Statement s;
    
    public void getData(Change_Password view) {
        try {
            String sql = "SELECT\n"
                    + "`user`.user_seq,\n"
                    + "`user`.username,\n"
                    + "`user`.`password`\n"
                    + "FROM\n"
                    + "`user`";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int user_seq = 0;
            String username = "";
            String password = "";
            
            while (r.next()) {
                user_seq = r.getInt("user.user_seq");
                username = r.getString("user.username");
                password = r.getString("user.password");
            }
            
            view.jTextField1.setText(username);
            view.jLabel1.setText(user_seq+"");
//            view.jTextField2.setText(password);
        } catch (Exception e) {
        } finally {
        }
    }
    
    public void updateData(Change_Password view) {
        try {
            if (view.jTextField1.getText().equals("") || view.jTextField2.getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                
                String sh256 = encrypt(view.jTextField2.getText());
                String sql = "update user set \n"
                        + "username='" + view.jTextField1.getText() + "',"
                        + "password='" + sh256 + "'"
                        + "where user_seq ='" + view.jLabel1.getText() + "'";

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                JOptionPane.showMessageDialog(view, "Password Successfully Replace", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Password Not Successful in Replace", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String encrypt(String str) {

        String SHA = "";

        try {

            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < byteData.length; i++) {

                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

            }

            SHA = sb.toString();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            SHA = null;

        }

        return SHA;
    }
}
