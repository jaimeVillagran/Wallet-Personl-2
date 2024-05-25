package cl.proyecto.wallet.user.service;

import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.dao.UserDAOImpl;
import cl.proyecto.wallet.user.model.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public boolean createUser(User user) {
        return userDAO.insertUser(user);
    }
}
