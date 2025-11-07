package db;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
    private static final String URL  = "jdbc:mysql://localhost:3306/FACS";
    private static final String USER = "root";      // <-- mi usuario
    private static final String PASS = "Holas3031";  // <-- mi contraseña

    static { try { Class.forName("com.mysql.cj.jdbc.Driver"); }
    catch (ClassNotFoundException e){ throw new RuntimeException("Driver MySQL no encontrado", e); } }

    public static Connection getConnection() throws SQLException {
        Properties p = new Properties(); p.put("user", USER); p.put("password", PASS);
        p.put("characterEncoding","utf8"); p.put("useUnicode","true");
        return DriverManager.getConnection(URL, p);
    }
}
