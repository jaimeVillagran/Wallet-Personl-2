package cl.proyecto.wallet.user.controller;

import cl.proyecto.wallet.user.model.User;
import cl.proyecto.wallet.user.service.UserService;
import cl.proyecto.wallet.user.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createUser")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public UserController() {
        this.userService = new UserServiceImpl();

    }

    /*protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        double balance = Double.parseDouble(req.getParameter("balance"));

        User user = new User(0, firstName, lastName, email, password, balance);
        boolean isCreated = userService.createUser(user);
        if(isCreated) {
            resp.sendRedirect("view/success.jsp");
        }else {
            resp.sendRedirect("view/error.jsp");
        }
    }*/

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name").trim();
        String lastName = req.getParameter("last_name").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        double balance = 0.0;

        // Validate inputs (ensure no empty strings after trimming)
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            resp.sendRedirect("view/error.jsp?error=invalidInput");
            return;
        }

        User user = new User(0, firstName, lastName, email, password, balance);
        boolean isCreated = userService.createUser(user);
        if (isCreated) {
            resp.sendRedirect("view/success.jsp");
        } else {
            resp.sendRedirect("view/error.jsp");
        }
    }
}