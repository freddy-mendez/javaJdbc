package fmo.db;

import java.sql.*;

public class ConexionDB {
    private static String claseDriver = "com.mysql.cj.jdbc.Driver";
    private static String server = "localhost";
    private static int port = 3306;
    private static String dbName = "ventas";
    private static String username = "root";
    private static String password = "";
    
    private static Connection con=null;
    
    public static Connection getInstance() {
        if (con==null) {
            try {
            Class.forName(claseDriver);
            con = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+dbName, username, password);
            } catch (Exception ex) {
                System.out.println("Error al conectar el server");
                System.exit(-1);
            }
        }
        return con;
    }
    
}
