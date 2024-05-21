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
    private double amount; // The amount involved in the transaction
    private String transactionType; // The type of the transaction
    private String transactionDate; // The date of the transaction

    /**
     * Default constructor for the Transaction class.
     * Initializes a new instance of the Transaction class with no parameters.
     */
    public Transaction() {
    }

    /**
     * Overloaded constructor for the Transaction class.
     * Initializes a new instance of the Transaction class with the given parameters.
     *
     * @param transactionId The unique ID of the transaction.
     * @param amount The amount involved in the transaction.
     * @param transactionType The type of the transaction.
     * @param transactionDate The date of the transaction.
     */
    public Transaction(int transactionId, double amount, String transactionType, String transactionDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    /**
     * Gets the transaction ID.
     *
     * @return The transaction ID.
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction ID.
     *
     * @param transactionId The transaction ID to set.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the amount involved in the transaction.
     *
     * @return The amount involved in the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount involved in the transaction.
     *
     * @param amount The amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the type of the transaction.
     *
     * @return The type of the transaction.
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the type of the transaction.
     *
     * @param transactionType The transaction type to set.
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Gets the date of the transaction.
     *
     * @return The date of the transaction.
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the date of the transaction.
     *
     * @param transactionDate The transaction date to set.
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}