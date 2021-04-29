package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abuyusuf
 */
public class DBConnect {

//    public Properties mypanel, myLanguage;
//    private String strNamePanel;
//    
//    public String SettingPanel(String nmPanel) {
//        try {
//            mypanel = new Properties();
//            mypanel.load(new FileInputStream("DBConnect.ini"));
//            strNamePanel = mypanel.getProperty(nmPanel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Tidak Bisa Koneksi", "Error", JOptionPane.INFORMATION_MESSAGE);
//            System.err.println(e.getMessage());
//            System.exit(0);
//        }
//        return strNamePanel;
//    }
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url;
                url = "jdbc:mysql://Localhost/tugas_akhir_agasta";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                JOptionPane.showMessageDialog(null, "Error Creating a Connection");
            }
        }

        return koneksi;
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
