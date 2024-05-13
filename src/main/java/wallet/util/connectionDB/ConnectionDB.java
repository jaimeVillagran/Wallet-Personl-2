package wallet.util.connectionDB;

import java.sql.*;

public class ConnectionDB {
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;

    protected void connectDb() {
        try {
            // Cargar el driver de JSBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/wallet_personal";
            String user = "root";
            String pass = "HelloLoreto54%";
            // Establecer la conexión con la base de datos
           // Statement DriverManager;
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.out.println("Connection failed" + e.getMessage());
            System.out.println("SQLState" + e.getSQLState());
            System.out.println("VendorError" + e.getErrorCode());
        }
    }

    protected ResultSet consultar(String sql) {
        if (conn == null) {
            System.out.println("Connection is not established");
            return null;
        }
        try {
            stmt = conn.createStatement();
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