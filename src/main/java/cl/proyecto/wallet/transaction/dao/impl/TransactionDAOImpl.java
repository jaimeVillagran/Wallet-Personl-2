package cl.proyecto.wallet.transaction.dao.impl;

import cl.proyecto.wallet.shared.ConnectionDB;
import cl.proyecto.wallet.transaction.dao.TransactionDAO;
import cl.proyecto.wallet.transaction.model.Transaction;


import java.util.List;

public class TransactionDAOImpl extends ConnectionDB implements TransactionDAO {


    @Override
    public boolean deposit(Transaction transaction, double montoDeposit ) {
        try {
            int id = transaction.getTransactionId();
            double amount = transaction.getAmount();
            String transactionType = transaction.getTransactionType();
            String transactionDate = transaction.getTransactionDate();

            String queryDeposit = "Update transactions set amount = amount + " + montoDeposit  ;
            String query = "INSERT INTO transactions (amount, transaction_type, transaction_date)" +
                    "VALUES (" + montoDeposit + ",'" + transactionType + "','" + transactionDate + "')";
            int resultModi = modificarDb(query);
            boolean result = resultModi > 0;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
