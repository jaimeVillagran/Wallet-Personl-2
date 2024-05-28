package cl.proyecto.wallet.transaction.service;

import cl.proyecto.wallet.transaction.dao.TransactionDAO;
import cl.proyecto.wallet.transaction.model.Transaction;
import cl.proyecto.wallet.user.dao.UserDAO;
import cl.proyecto.wallet.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    @Mock
    private TransactionDAO transactionDAO;

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeposit() {
        int userId = 1;
        double amount = 500.0;
        Transaction transaction = new Transaction(userId, amount, "deposit");

        User user = new User(userId, "Juan", "Riquelme", "juan.riquelme@example.com", "password", 1000.0);
        when(userDAO.getUserById(userId)).thenReturn(user);
        when(transactionDAO.createTransaction(transaction)).thenReturn(true);

        boolean result = transactionService.deposit(userId, transaction, amount);

        assertTrue(result, "El método deposit debería devolver true");
        assertEquals(1500.0, user.getBalance());
        verify(userDAO, times(1)).updateUser(user);
        verify(transactionDAO, times(1)).createTransaction(transaction);
    }


    @Test
    public void testWithdraw() {
        int userId = 1;
        double amount = 500.0;

        User user = new User(userId, "Juan", "Riqquelme", "juan.riquelme@example.com", "password", 1000.0);
        when(userDAO.getUserById(userId)).thenReturn(user);
        when(transactionDAO.createTransaction(any(Transaction.class))).thenReturn(true);

        boolean result = transactionService.withdraw(userId, amount);

        assertTrue(result, "El método withdraw debería devolver true");
        assertEquals(500.0, user.getBalance());
        verify(userDAO, times(1)).updateUser(user);
        verify(transactionDAO, times(1)).createTransaction(any(Transaction.class));
    }


    @Test
    public void testGetBalance() {
        int userId = 1;
        User user = new User(userId, "Juan", "Riquelme", "juan.riquelme@example.com", "password", 1000.0);
        when(userDAO.getUserById(userId)).thenReturn(user);

        double balance = transactionService.getBalance(userId);

        assertEquals(1000.0, balance);
    }


    @Test
    public void testGetAllTransactions() {
        int userId = 1;
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 500.0, "deposit", "2023-01-01", userId),
                new Transaction(2, 200.0, "withdraw", "2023-01-02", userId)
        );
        when(transactionDAO.getTransactionsByUserId(userId)).thenReturn(transactions);

        List<Transaction> result = transactionService.getAllTransactions(userId);

        assertEquals(2, result.size());
        assertEquals(500.0, result.get(0).getAmount());
        assertEquals(200.0, result.get(1).getAmount());
    }


    @Test
    public void createTransaction() {
        int userId = 1;
        double amount = 500.0;
        String type = "deposit";
        Transaction transaction = new Transaction(userId, amount, type);

        when(transactionDAO.createTransaction(transaction)).thenReturn(true);

        boolean result = transactionService.createTransaction(transaction);

        assertTrue(result, "El método createTransaction debería devolver true");
        verify(transactionDAO, times(1)).createTransaction(transaction);
    }
}