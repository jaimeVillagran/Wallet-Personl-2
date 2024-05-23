package cl.proyecto.wallet.transaction.service;

import cl.proyecto.wallet.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {

    boolean deposit(int id, Transaction transaction, double montoDeposit);
    void withdraw(int userId, double amount);
    double getBalance(int userId);
    List<Transaction> getAllTransactions(int userId);
    double convertCurrency(double amount);
}
