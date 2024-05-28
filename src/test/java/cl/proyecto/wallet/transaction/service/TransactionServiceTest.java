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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

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

        assertTrue(result);
        assertEquals(1500.0, user.getBalance());
        verify(userDAO, times(1)).updateUser(user);
        verify(transactionDAO, times(1)).createTransaction(transaction);
    }

    @Test
    public void testWithdraw() {
        int userId = 1;
        double amount = 500.0;

        User user = new User(userId, "John", "Doe", "john.doe@example.com", "password", 1000.0);
        when(userDAO.getUserById(userId)).thenReturn(user);
        when(transactionDAO.createTransaction(any(Transaction.class))).thenReturn(true);

        boolean result = transactionService.withdraw(userId, amount);

        assertTrue(result);
        assertEquals(500.0, user.getBalance());
        verify(userDAO, times(1)).updateUser(user);
        verify(transactionDAO, times(1)).createTransaction(any(Transaction.class));
    }
}