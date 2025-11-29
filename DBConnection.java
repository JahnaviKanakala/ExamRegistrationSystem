import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "your_username",
                "your_password"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
