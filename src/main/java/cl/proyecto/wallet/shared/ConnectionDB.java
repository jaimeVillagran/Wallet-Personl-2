package cl.proyecto.wallet.shared;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;


/**
 * The ConnectionDB class is responsible for managing the database connection and operations.
 * It contains the necessary methods to connect to the database, execute queries, and close the connection.
 *
 * It has three private attributes:
 * - conn: a Connection object that represents the database connection.
 * - rs: a ResultSet object that stores the result of a database query.
 * - stmt: a Statement object used to execute SQL commands.
 */
public class ConnectionDB {
    private Connection conn; // The database connection
    private ResultSet rs; // The result set of a database query
    private Statement stmt; // The statement for executing SQL commands


    /**
 * This method is used to establish a connection to the database.
 * It first checks if the connection is null or closed. If so, it loads the MySQL JDBC driver,
 * and then establishes a connection to the database using the provided connection string, user, and password.
 * If the connection is successful, a message is printed to the console.
 * If a ClassNotFoundException or SQLException occurs during this process, an error message is printed to the console.
 */
protected void conectarDb() {
    try {
        // Check if the connection is null or closed
        if (conn == null || conn.isClosed()) {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Define the connection string
            String stringConnection = "jdbc:mysql://localhost:3306/wallet-personal";
            // Define the user
            String user = "prueba";
            // Define the password
            String password = "54Prueba";
            // Establish a connection to the database
            conn = DriverManager.getConnection(stringConnection, user, password);
            // Print a success message to the console
            System.out.println("Conectado a la base de datos");
        }
    } catch (ClassNotFoundException ex) {
        // Print an error message to the console if the MySQL JDBC driver cannot be loaded
        System.out.println("Error al registrar el driver de MySQL: " + ex);
    } catch (SQLException ex) {
        // Print an error message to the console if a SQLException occurs
        System.out.println("Fallo: ");
        System.out.println("SQLExeption: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}

   /**
 * This method is used to execute a query on the database and return the result set.
 * It first establishes a connection to the database, then creates a Statement object.
 * The Statement object is used to execute the SQL query, which returns a ResultSet.
 * The ResultSet is then returned to the caller.
 * If an SQLException occurs during this process, an error message is printed and null is returned.
 *
 * @param query The SQL query to be executed.
 * @return The ResultSet obtained from executing the query.
 */
protected ResultSet consultarDb(String query) {
    try {
        conectarDb(); // Connect to the database
        this.stmt = conn.createStatement(); // Create a Statement object
        rs = stmt.executeQuery(query); // Execute the query and get the ResultSet
        close(); // Close the database resources
        return rs; // Return the ResultSet
    } catch (SQLException ex) {
        System.out.println(ex.getMessage()); // Print the error message
        return null; // Return null if an error occurred
    }
}

    /**
 * This method is used to modify the database with the provided SQL query.
 * It first establishes a connection to the database, then creates a Statement object.
 * The Statement object is used to execute the SQL query, which modifies the database.
 * The number of modified records is returned.
 * If an SQLException occurs during this process, an error message is printed and 0 is returned.
 *
 * @param query The SQL query to be executed.
 * @return The number of records modified by the query.
 */
protected int modificarDb(String query) {
    try {
        conectarDb(); // Connect to the database
        this.stmt = conn.createStatement(); // Create a Statement object
        int regModificados = stmt.executeUpdate(query); // Execute the query and get the number of modified records
        close(); // Close the database resources
        return regModificados; // Return the number of modified records
    } catch (SQLException ex) {
        System.out.println(ex.getMessage()); // Print the error message
        return 0; // Return 0 if an error occurred
    }
}
protected void close() {
    try {
        // If ResultSet is not null, close it
        if (rs != null) {
            rs.close();
        }
        // If Statement is not null, close it
        if (stmt != null) {
            stmt.close();
        }
        // If Connection is not null, close it
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        // Print the error if the connection cannot be closed
        System.out.println("Error al cerrar la conexión: " + ex);
    }
}
}