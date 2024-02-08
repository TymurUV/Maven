package homework1.domain.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static final String jdbcURL = "jdbc:mysql://localhost/album";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cl.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
