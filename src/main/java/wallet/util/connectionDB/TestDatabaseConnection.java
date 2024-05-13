package wallet.util.connectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.connectDb();

        // Intentar realizar una consulta simple
        String query = "SELECT 1";  // Esta consulta es neutral y casi siempre está permitida
        ResultSet rs = connectionDB.consultar(query);

        if (rs != null) {
            try {
                while (rs.next()) {
                    int result = rs.getInt(1);
                    System.out.println("Query result: " + result);
                }
            } catch (SQLException e) {
                System.out.println("Error reading from database: " + e.getMessage());
            } finally {
                // Asegúrate de cerrar la conexión y los recursos
                connectionDB.desconectar();
            }
        } else {
            System.out.println("Failed to execute query or connect to DB.");
        }
    }
}

