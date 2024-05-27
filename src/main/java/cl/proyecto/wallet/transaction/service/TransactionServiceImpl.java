package cl.proyecto.wallet.transaction.service;

import cl.proyecto.wallet.transaction.dao.TransactionDAO;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.model.User;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO;
    private UserDAO userDAO;

    public TransactionServiceImpl(TransactionDAO transactionDAO, UserDAO userDAO) {
        this.transactionDAO = transactionDAO;
        this.userDAO = userDAO;
    }

    @Override
    public boolean deposit(int id, Transaction transaction, double montoDeposit) {
        if (transaction == null || montoDeposit <= 0 || id <= 0) {
            return false;
        }
        User user = userDAO.getUserById(id);
        if (user == null) {
            return false;
        }

        double newBalance = user.getBalance() + montoDeposit;
        user.setBalance(newBalance);
        userDAO.updateUser(user);

        // Crea la transacción
        return transactionDAO.createTransaction(transaction);
    }

    @Override
    public boolean withdraw(int userId, double amount) {
        if (amount <= 0 || userId <= 0) {
            return false;
        }

        User user = userDAO.getUserById(userId);
        if (user == null) {
            return false;
        }

        double currentBalance = user.getBalance();
        if (currentBalance < amount) {
            return false;
        }

        double newBalance = currentBalance - amount;
        user.setBalance(newBalance);
        userDAO.updateUser(user);

        Transaction transaction = new Transaction(userId, amount, "withdraw");
        return transactionDAO.createTransaction(transaction);
    }

    @Override
    public double getBalance(int userId) {
        User user = userDAO.getUserById(userId);
        return user != null ? user.getBalance() : 0;
    }

    @Override
    public List<Transaction> getAllTransactions(int userId) {
        return transactionDAO.getTransactionsByUserId(userId);
    }

    @Override
    public boolean createTransaction(Transaction transaction) {
        return transactionDAO.createTransaction(transaction);
    }
}