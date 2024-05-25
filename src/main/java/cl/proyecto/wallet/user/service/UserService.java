package cl.proyecto.wallet.user.service;

import cl.proyecto.wallet.user.model.User;

public interface UserService {
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean createUser(User user);
}
