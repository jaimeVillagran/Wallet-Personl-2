package cl.proyecto.wallet.transaction.dao;

import cl.proyecto.wallet.transaction.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    boolean deposit(int userId, Transaction transaction, double depositAmount);
    void withdraw(int userId, Transaction transaction, double withdrawalAmount);
    double getBalance(int userId);
    List<Transaction> getAllTransactions(int userId);
    double convertCurrency(double amount);

}
