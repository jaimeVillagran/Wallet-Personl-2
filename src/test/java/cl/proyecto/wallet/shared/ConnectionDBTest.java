package cl.proyecto.wallet.shared;


import org.junit.Assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConnectionDBTest {
    private ConnectionDB connectionDB;

    @BeforeEach
    public void setUp() {
        connectionDB = new ConnectionDB();
    }

    @AfterEach
    public void tearDown() {
        connectionDB.close();
    }

    @Test
    public void testConectDb() {
        connectionDB.connectDb();
        Connection conn = connectionDB.getConn();
        assertNotNull("Connection should be established");
    }

    @Test
    public void testConsulDb() {
        connectionDB.connectDb();
        String query = "SELECT 1";
        ResultSet resultSet = connectionDB.consultDb(query);
        Assert.assertNotNull("ResultSet should not be null", resultSet);

        try {
            assertTrue("ResultSet should have at least one row", resultSet.next());
            int result = resultSet.getInt(1);
            assertEquals("Result should be 1", 1, result);
        } catch (SQLException e) {
            fail("SQLException should not occur: " + e.getMessage());
        }
    }

    @Test
    public void testModifyDb() {
        connectionDB.connectDb();
        String createTableQuery = "CREATE TEMPORARY TABLE test_table (id INT)";
        int result = connectionDB.modifyDb(createTableQuery);
        assertEquals("Table should be created", 0, result);

        String insertQuery = "INSERT INTO test_table (id) VALUES (1)";
        result = connectionDB.modifyDb(insertQuery);
        assertEquals("One row should be inserted", 1, result);

        String selectQuery = "SELECT COUNT(*) FROM test_table";
        ResultSet resultSet = connectionDB.consultDb(selectQuery);
        try {
            assertTrue("ResultSet should have at least one row", resultSet.next());
            int count = resultSet.getInt(1);
            assertEquals("Count should be 1", 1, count);
        } catch (SQLException e) {
            fail("SQLException should not occur: " + e.getMessage());
        }

        String dropTableQuery = "DROP TABLE test_table";
        result = connectionDB.modifyDb(dropTableQuery);
        assertEquals("Table should be dropped", 0, result);
    }
}
