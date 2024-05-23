package cl.proyecto.wallet.user.dao;

import cl.proyecto.wallet.shared.ConnectionDB;
import cl.proyecto.wallet.user.model.User;

public class UserDAOImpl extends ConnectionDB implements UserDAO {

    @Override
    public boolean getUser() {
        try {
            User user = new User();
            int id = user.getId();
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            String password = user.getPassword();
            double balance = user.getBalance();

            String queryUser = "SELECT * FROM users WHERE id = " + id;

            int resultUser = modificarDb(queryUser);
            boolean result = resultUser > 0;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
