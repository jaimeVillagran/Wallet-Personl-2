package cl.proyecto.wallet.transaction.controller;

import java.io.IOException;

import cl.proyecto.wallet.transaction.dao.TransactionDAOImpl;
import cl.proyecto.wallet.transaction.service.TransactionService;
import cl.proyecto.wallet.transaction.service.TransactionServiceImpl;
import cl.proyecto.wallet.user.dao.UserDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/withdrw")
public class WhitdrawController extends HttpServlet {
    private static final long serialVersionUID = -7409474943666580530L;

    private TransactionService transactionService;

    public WhitdrawController() {
        this.transactionService = new TransactionServiceImpl(new TransactionDAOImpl(), new UserDAOImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");
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
        transactionService.withdraw(userId, amount);
        resp.sendRedirect("view/success.jsp");
    }
}