package cl.proyecto.wallet.shared;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The ConnectionDB class is responsible for managing the database connection and operations.
 * It contains the necessary methods to connect to the database, execute queries, and close the connection.
 * <p>
 * It has three private attributes:
 * - conn: a Connection object that represents the database connection.
 * - rs: a ResultSet object that stores the result of a database query.
 * - stmt: a Statement object used to execute SQL commands.
 */
public abstract class ConnectionDB {
    protected Connection conn; // The database connection
    protected ResultSet rs; // The result set of a database query
    protected Statement stmt; // The statement for executing SQL commands

    public Connection getConn() {
        return conn;
    }

    /**
     * This method is used to establish a connection to the database.
     * It first checks if the connection is null or closed. If so, it loads the MySQL JDBC driver,
     * and then establishes a connection to the database using the provided connection string, user, and password.
     * If the connection is successful, a message is printed to the console.
     * If a ClassNotFoundException or SQLException occurs during this process, an error message is printed to the console.
     */
    protected void connectDb() {
        try {
            // Check if the connection is null or closed
            if (conn == null || conn.isClosed()) {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Define the connection string
                String stringConnection = "jdbc:mysql://localhost:3306/wallet_personal";
                // Define the user
                String user = "prueba";
                // Define the password
                String password = "54Prueba";
                // Establish a connection to the database
                conn = DriverManager.getConnection(stringConnection, user, password);
                // Print a success message to the console
                System.out.println("Conectado a la base de datos");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex);
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
    protected ResultSet consultDb(String query) {
        connectDb();
        try {
            //Esto deberia ser ejecutado aqui y no en el "DAOImpl" TransacctionDOAImpl
            //connectDb();
            this.stmt = conn.createStatement(); // Create a Statement object
            rs = stmt.executeQuery(query); // Execute the query and get the ResultSet
            return rs; // Return the ResultSet*/
            /* return stmt.executeQuery(query);*/
        } catch (SQLException ex) {
            System.out.println("Error en consultDb: " + ex);
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
    protected int modifyDb(String query) {
        connectDb();
        try {
            this.stmt = conn.createStatement(); // Create a Statement object
            return stmt.executeUpdate(query); // Return the number of modified records
        } catch (SQLException ex) {
            System.out.println("Error en modifyDb: " + ex);
            return 0;
        }
    }

    // Método unificado `close`
    protected void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex);
        }
    }

    // Sobrecarga del método `close` para usar los atributos de la clase
    protected void close() {
        close(this.rs, this.stmt, this.conn);
    }
}