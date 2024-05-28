package cl.proyecto.wallet.user.controller;

import cl.proyecto.wallet.user.model.User;
import cl.proyecto.wallet.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoPostSuccess() throws Exception {
        when(request.getParameter("first_name")).thenReturn("John");
        when(request.getParameter("last_name")).thenReturn("Doe");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");
        when(request.getParameter("password")).thenReturn("password");

        User user = new User(0, "John", "Doe", "john.doe@example.com", "password", 0.0);
        when(userService.createUser(any(User.class))).thenReturn(true);

        userController.doPost(request, response);

        verify(response).sendRedirect("view/success.jsp");
    }


    @Test
    public void testDoPostFailure() throws Exception {
        when(request.getParameter("first_name")).thenReturn("");
        when(request.getParameter("last_name")).thenReturn("Riquelme");
        when(request.getParameter("email")).thenReturn("juan.riquelme@example.com");
        when(request.getParameter("password")).thenReturn("password");

        userController.doPost(request, response);

        verify(response).sendRedirect("view/error.jsp?error=invalidInput");
    }
}