package cl.proyecto.wallet.user.dao;

import cl.proyecto.wallet.user.model.User;

public interface UserDAO {
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
    /*boolean updateUser(User user);
    boolean deleteUser(int id);*/
}
