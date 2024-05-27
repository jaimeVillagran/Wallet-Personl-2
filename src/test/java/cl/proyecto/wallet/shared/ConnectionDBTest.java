package cl.proyecto.wallet.shared;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionDBTest {

    private ConnectionDBTestImpl connectionDBTestImpl;

    @BeforeEach
    void setUp() {
        connectionDBTestImpl = new ConnectionDBTestImpl();
        connectionDBTestImpl.connectDb();
    }

    @AfterEach
    void tearDown() {
        connectionDBTestImpl.close();
    }

    @Test
    void testConnection() {
        Connection conn = connectionDBTestImpl.getConn();
        assertNotNull(conn, "Connection should not be null");
    }

    @Test
    void testConsultDb() {
        String query = "SELECT 1";
        ResultSet rs = connectionDBTestImpl.consultDb(query);
        assertNotNull(rs, "ResultSet should not be null");
        try {
            assertTrue(rs.next(), "ResultSet should have at least one row");
            assertEquals(1, rs.getInt(1), "The result should be 1");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testModifyDb() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS test_table (id INT PRIMARY KEY)";
        int result = connectionDBTestImpl.modifyDb(createTableQuery);
        assertEquals(0, result, "Result should be 0 for table creation");

        String insertQuery = "INSERT INTO test_table (id) VALUES (1)";
        result = connectionDBTestImpl.modifyDb(insertQuery);
        assertEquals(1, result, "One row should be inserted");

        String dropTableQuery = "DROP TABLE test_table";
        result = connectionDBTestImpl.modifyDb(dropTableQuery);
        assertEquals(0, result, "Result should be 0 for table drop");
    }

    // Clase de prueba concreta interna
    static class ConnectionDBTestImpl extends ConnectionDB {
        @Override
        protected void connectDb() {
            super.connectDb();
        }

        @Override
        protected ResultSet consultDb(String query) {
            return super.consultDb(query);
        }

        @Override
        protected int modifyDb(String query) {
            return super.modifyDb(query);
        }

        @Override
        protected void close() {
            super.close();
        }
    }
}