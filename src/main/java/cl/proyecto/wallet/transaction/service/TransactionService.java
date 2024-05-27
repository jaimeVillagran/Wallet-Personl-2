package cl.proyecto.wallet.transaction.service;

import cl.proyecto.wallet.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {
    boolean createTransaction(Transaction transaction);
    boolean deposit(int id, Transaction transaction, double montoDeposit);
    boolean withdraw(int userId, double amount);
    double getBalance(int userId);
    List<Transaction> getAllTransactions(int userId);

}
