package database;

import java.sql.*;
import javax.swing.*;

public class dbconnection {
    static Connection mysqlconfig;
    //static Statement mysqlstm;

    public Connection configDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/litera?serverTimezone=UTC";
            String user = "root";
            String pass = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            mysqlconfig = DriverManager.getConnection(url, user, pass);
            //mysqlstm = mysqlconfig.createStatement();
            return mysqlconfig;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi GAGAL!\n" + e.getMessage());
            return null;
        }
        
    }
}
