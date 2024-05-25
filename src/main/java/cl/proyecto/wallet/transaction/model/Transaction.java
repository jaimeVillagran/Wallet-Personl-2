package cl.proyecto.wallet.transaction.model;

/**
 * The Transaction class represents a transaction in the wallet application.
 * It contains all the details of a transaction such as transactionId, amount, transactionType, and transactionDate.
 *
 * It has four private attributes:
 * - transactionId: an integer that represents the unique ID of the transaction.
 * - amount: a double that represents the amount involved in the transaction.
 * - transactionType: a String that represents the type of the transaction (e.g., "debit", "credit").
 * - transactionDate: a String that represents the date of the transaction.
 *
 * It has two constructors and getter and setter methods for all the attributes.
 */
public class Transaction {

    private int transactionId; // The unique ID of the transaction
    private int userId;
    private double amount; // The amount involved in the transaction
    private String transactionType; // The type of the transaction
    private String transactionDate;// The date of the transaction

    /**
     * Default constructor for the Transaction class.
     * Initializes a new instance of the Transaction class with no parameters.
     */
    public Transaction() {
    }

    public Transaction(int transactionId, double amount, String transactionType, String transactionDate, int idUser) {
        this.transactionId = transactionId;
        this.userId = idUser;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}