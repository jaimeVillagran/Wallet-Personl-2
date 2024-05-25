package cl.proyecto.wallet.transaction.controller;

import cl.proyecto.wallet.user.model.User;
import cl.proyecto.wallet.user.service.UserService;
import cl.proyecto.wallet.user.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public LoginController() {
		this.userService = new UserServiceImpl();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = userService.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("view/dashboard.jsp");
		} else {
			resp.sendRedirect("view/login.jsp?error=1");
		}
	}
}

