package cl.proyecto.wallet.transaction.dao;

import cl.proyecto.wallet.transaction.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    boolean createTransaction(Transaction transaction);
    List<Transaction> getTransactionsByUserId(int userId);
    boolean deposit(int id, Transaction transaction, double montoDeposit);
    double getBalance(int userId); // Para obtener el balance directamente desde el DAO
}

