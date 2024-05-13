package wallet.util.connectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;

    protected void connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String stringConnection = "jdbc:mysql://localhost:3306/wallet";
            String user = "root";
            String pass = "root";
            Statement DriverManager;
            conn = DriverManager.getConnection();
            System.out.println("Connection established");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection failed");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.out.println("SQLExecption" + e.getMessage());
            System.out.println("SQLState" + e.getSQLState());
            System.out.println("VendorError" + e.getErrorCode());
        }
    }

    protected ResultSet consultar(String sql) {
        try {
            this.stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }

    protected int ejecutar(String sql) {
        try {
            this.stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar: " + e.getMessage());
            return 0;
        }
    }

    protected void desconectar() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }
}