package cl.proyecto.wallet.transaction.dao;

import cl.proyecto.wallet.transaction.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    boolean deposit(Transaction transaction);
    void withdraw(int userId, double amount);
    double getBalance(int userId);
    List<Transaction> getAllTransactions(int userId);
    double convertCurrency(double amount);
}
