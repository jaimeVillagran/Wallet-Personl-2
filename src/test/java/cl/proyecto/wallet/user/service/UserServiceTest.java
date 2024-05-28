package cl.proyecto.wallet.user.service;


import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertUser() {
        User user = new User(1, "Juan", "Riquelme", "juan.riquelme@example.com", "password", 0.0);
        when(userDAO.insertUser(user)).thenReturn(true);

        boolean result = userService.createUser(user);

        assertTrue(result);
        verify(userDAO, times(1)).insertUser(user);
    }

    @Test
    public void testGetUserById() {
        User user = new User(1, "Juan", "Riquelme", "juan.riquelme@example.com", "password", 0.0);
        when(userDAO.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);

        assertEquals(user, result);
        verify(userDAO, times(1)).getUserById(1);
    }
}