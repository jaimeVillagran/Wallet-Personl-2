package cl.proyecto.wallet.transaction.dao;

import cl.proyecto.wallet.shared.ConnectionDB;
import cl.proyecto.wallet.transaction.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl extends ConnectionDB implements TransactionDAO {

    @Override
    public boolean createTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (user_id, amount, transaction_type, transaction_date) VALUES ("
                + transaction.getUserId() + ", "
                + transaction.getAmount() + ", '"
                + transaction.getTransactionType() + "', NOW())";
        return modifyDb(query) > 0;
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId) {
        String query = "SELECT * FROM transactions WHERE user_id = " + userId + " ORDER BY transaction_date DESC";
        ResultSet rs = consultDb(query);
        List<Transaction> transactions = new ArrayList<>();
        try {
            //Siempre vuleve recrear aunque la transaccion este OK
            while (rs != null && rs.next()) {
                //Esto se ahorra ya que se implementa en ConnectioDB
                Transaction transaction = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getDouble("amount"),
                        rs.getString("transaction_type"),
                        rs.getString("transaction_date"),
                        rs.getInt("user_id")
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, stmt, conn);  // Asegúrate de cerrar los recursos aquí.
        }
        return transactions;
    }

    @Override
    public boolean deposit(int id, Transaction transaction, double montoDeposit) {
        return false;
    }

    @Override
    public double getBalance(int userId) {
        return 0;
    }
}

