package cl.proyecto.wallet.transaction.service;

import cl.proyecto.wallet.transaction.dao.TransactionDAO;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.model.User;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public boolean deposit(int id, Transaction transaction, double montoDeposit) {
        if (transaction == null && montoDeposit <= 0 && id <= 0) {
            return false;
        } else {
            return transactionDAO.deposit(id, transaction, montoDeposit);
        }
    }

    @Override
    public void withdraw(int userId, double amount) {

    }

    @Override
    public double getBalance(int userId) {
        return 0;
    }

    @Override
    public List<Transaction> getAllTransactions(int userId) {
        return List.of();
    }

    @Override
    public double convertCurrency(double amount) {
        return 0;
    }

}
