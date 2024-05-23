package cl.proyecto.wallet.transaction.controller;

import cl.proyecto.wallet.transaction.dao.TransactionDAOImpl;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.transaction.service.TransactionService;
import cl.proyecto.wallet.transaction.service.TransactionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/transaction")
public class TransactionController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("balance.jsp").forward(request, response);
    }
}



/*public class TransactionController extends HttpServlet {
    private TransactionService transactionService;

    void init() {
        transactionService = new TransactionServiceImpl(new TransactionDAOImpl());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        BigDecimal amount = new BigDecimal(req.getParameter("amount"));
        Transaction t = new Transaction();

        try {
            transactionService.performTransaction(transaction);
            resp.setRedirect("index.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Transaction> transactions = transactionService.getAllTransactions();
            BigDecimal totalBalance = transactionService.getTotslBalance();
            req.setAttribute("transactions", transactions);
            req.setAttribute("totalBalance", totalBalance);
            req.getRequestDispatcher("balance.jsp").forwaerd(req, resp);
        } catch (SQLException e) {
            trow new ServletException(e);
        }
    }

}*/
