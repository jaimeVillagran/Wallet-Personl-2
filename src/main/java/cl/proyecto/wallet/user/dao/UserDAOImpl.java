package cl.proyecto.wallet.user.dao;

import cl.proyecto.wallet.shared.ConnectionDB;
import cl.proyecto.wallet.user.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl extends ConnectionDB implements UserDAO {


    @Override
    public boolean insertUser(User user) {
        // Validate that the input values are not empty or null
        if (user.getFirstname().trim().isEmpty() || user.getLastname().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
            return false; // Return false if any field is empty
        }
        String query = "INSERT INTO user (firstname, lastname, email, password, balance) VALUES" + " ('" + user.getFirstname() + "', '" + user.getLastname() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', " + user.getBalance() + ")";
        return modifyDb(query) > 0;
    }


    @Override
    public User getUserById(int id) {
        String query = "SELECT * FROM user WHERE user_id = " + id;
        ResultSet rs = consultDb(query);
        User user = null;
        try {
            if (rs != null && rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, stmt, conn);
        }
        return user;
    }


    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = '" + email + "'";
        ResultSet rs = consultDb(query);
        User user = null;
        try {
            if (rs != null && rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, stmt, conn);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        String query = "UPDATE user SET firstname = '" + user.getFirstname() + "', lastname = '" + user.getLastname() + "', email = '" + user.getEmail() + "', password = '" + user.getPassword() + "', balance = " + user.getBalance() + " WHERE user_id = " + user.getId();
        return modifyDb(query) > 0;
    }

    @Override
    public boolean deleteUser(int id) {
        String query = "DELETE FROM user WHERE user_id = " + id;
        return modifyDb(query) > 0;
    }
}
