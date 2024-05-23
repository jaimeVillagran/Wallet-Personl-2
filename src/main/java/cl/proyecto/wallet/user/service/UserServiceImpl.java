package cl.proyecto.wallet.user.service;

import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.model.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean obtainUser(User user) {
        if (user!=null && user.getFirstname().isBlank() && user.getLastname().isBlank() && user.getEmail().isBlank() && user.getPassword().isBlank()) {
            return userDAO.getUser();
        } else {
            return false;
        }
    }
}
