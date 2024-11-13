package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:.//database//";
    private static Connection connection;
    
    public static Connection getConnection(String DBName) throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {  // Перевірка на закриття
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DATABASE_URL+DBName+".db");
                System.out.println("Database connected");
            }
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection() {
        if(connection != null) {
            try{
                connection.close();
                System.out.println("Database disconnected");
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
