package cl.proyecto.wallet.transaction.controller;

import java.io.*;

import cl.proyecto.wallet.transaction.dao.TransactionDAOImpl;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.transaction.service.TransactionService;
import cl.proyecto.wallet.transaction.service.TransactionServiceImpl;
import cl.proyecto.wallet.user.dao.UserDAOImpl;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet("/deposit")
public class DepositController extends HttpServlet {
    private static final long serialVersionUID = 1L;


	private TransactionService transactionService;

	public DepositController() {
		this.transactionService = new TransactionServiceImpl(new TransactionDAOImpl(), new UserDAOImpl());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter("user_Id");
		String amountStr = req.getParameter("amount");

		if (userIdStr == null && amountStr == null || userIdStr.isEmpty() && amountStr.isEmpty()) {
			resp.sendRedirect("view/error.jsp");
			return;
		}
		int userId;
		double amount;
		try {
			userId = Integer.parseInt(userIdStr);
			amount = Double.parseDouble(amountStr);
		} catch (NumberFormatException e) {
			resp.sendRedirect("view/error.jsp");
			return;
		}
		if (amount <= 0) {
			resp.sendRedirect("view/error.jsp");
			return;
		}
		Transaction transaction = new Transaction(userId, amount, "deposit");

		boolean isSuccess = transactionService.deposit(userId, transaction, amount);
		if (isSuccess) {
			resp.sendRedirect("view/success.jsp");
		} else {
			resp.sendRedirect("view/error.jsp");
		}
	}

}