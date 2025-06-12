package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
    public Connection configDB() {
        Connection mysqlconfig = null;
        try {
            String url = "jdbc:mysql://localhost:3306/litera"; 
            String user = "root";
            String pass = "admin123"; 

            Class.forName("com.mysql.cj.jdbc.Driver");
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Koneksi berhasil!");
        } catch (Exception e) {
            System.out.println("❌ Gagal koneksi: " + e.getMessage());
        }

        return mysqlconfig;
    }
}
