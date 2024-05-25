package cl.proyecto.wallet.transaction.dao;

import cl.proyecto.wallet.shared.ConnectionDB;
import cl.proyecto.wallet.transaction.model.Transaction;


import java.util.List;

public class TransactionDAOImpl extends ConnectionDB implements TransactionDAO {


    @Override
    public boolean deposit(int userId, Transaction transaction, double depositAmount ) {
        try {
            int id = transaction.getTransactionId();
            double amount = transaction.getAmount();
            String transactionType = transaction.getTransactionType();
            String transactionDate = transaction.getTransactionDate();

            String queryDeposit = "START TRANSACTION;" + "Update transactions set amount = amount + "
                    + depositAmount + " WHERE user_Id= "+userId+" ;"
                    + "INSERT INTO transactions (amount, transaction_type, transaction_date)" +
                    "VALUES (" + depositAmount + ",'" + transactionType + "','" + transactionDate + "')";
            int resultModi = modifyDb(queryDeposit);
            boolean result = resultModi > 0;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void withdraw(int userId, Transaction transaction, double withdrawalAmount) {

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

    /*@Override
    protected void conectDb() {
        super.connectDb();
    }*/
}
