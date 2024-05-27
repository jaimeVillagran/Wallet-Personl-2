package cl.proyecto.wallet.transaction.controller;

import cl.proyecto.wallet.transaction.dao.TransactionDAOImpl;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.transaction.service.TransactionService;
import cl.proyecto.wallet.transaction.service.TransactionServiceImpl;
import cl.proyecto.wallet.user.dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;


@WebServlet("/transaction")
public class TransactionController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionServiceImpl(new TransactionDAOImpl(), new UserDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("user_id");
        if (userIdStr == null || userIdStr.isEmpty()) {
            resp.sendRedirect("view/error.jsp");
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException e) {
            resp.sendRedirect("view/error.jsp");
            return;
        }

        List<Transaction> transactions = transactionService.getAllTransactions(userId);
        double totalBalance = transactionService.getBalance(userId);

        req.setAttribute("transactions", transactions);
        req.setAttribute("totalBalance", totalBalance);
        req.getRequestDispatcher("/view/balance.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("user_id");
        String amountStr = req.getParameter("amount");
        String type = req.getParameter("type");

        if (userIdStr == null || userIdStr.isEmpty() || amountStr == null || amountStr.isEmpty() || type == null || type.isEmpty()) {
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

        Transaction transaction = new Transaction(userId, amount, type);

        boolean isSuccess;
        if ("deposit".equalsIgnoreCase(type)) {
            isSuccess = transactionService.deposit(userId, transaction, amount);
        } else if ("withdraw".equalsIgnoreCase(type)) {
            isSuccess = transactionService.withdraw(userId, amount);
        } else {
            resp.sendRedirect("view/error.jsp");
            return;
        }

        if (isSuccess) {
            List<Transaction> transactions = transactionService.getAllTransactions(userId);
            double totalBalance = transactionService.getBalance(userId);
            req.setAttribute("transactions", transactions);
            req.setAttribute("totalBalance", totalBalance);
            req.getRequestDispatcher("/view/balance.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}