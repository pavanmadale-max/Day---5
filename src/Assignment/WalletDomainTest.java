package Assignment;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WalletDomainTest {


    record User(String id, String name) {}

    sealed interface Transaction permits Credit, Debit {
        double amount();
    }

    record Credit(double amount) implements Transaction {}
    record Debit(double amount) implements Transaction {}

    static class Wallet {
        private double balance;

        void apply(Transaction tx) {
            if (tx instanceof Credit c) {
                balance += c.amount();
            } else if (tx instanceof Debit d) {
                balance -= d.amount();
            }
        }

        double getBalance() {
            return balance;
        }
    }

    static class TransactionRepository {
        private final List<Transaction> transactions = new java.util.ArrayList<>();

        void add(Transaction tx) {
            transactions.add(tx);
        }

        List<Transaction> getAll() {
            return transactions;
        }
    }

    // UNIT TESTS

    // Test User creation
    @Test
    void testUserCreation() {
        User user = new User("U1", "Pavan");
        assertEquals("U1", user.id());
        assertEquals("Pavan", user.name());
    }

    // Test Credit transaction
    @Test
    void testCreditTransaction() {
        Credit credit = new Credit(500);
        assertEquals(500, credit.amount());
    }

    // Test Debit transaction
    @Test
    void testDebitTransaction() {
        Debit debit = new Debit(200);
        assertEquals(200, debit.amount());
    }

    // Test Wallet balance update
    @Test
    void testWalletBalance() {
        Wallet wallet = new Wallet();
        wallet.apply(new Credit(1000));
        wallet.apply(new Debit(300));

        assertEquals(700, wallet.getBalance());
    }

    // Test Repository add and fetch
    @Test
    void testTransactionRepository() {
        TransactionRepository repo = new TransactionRepository();

        repo.add(new Credit(400));
        repo.add(new Debit(100));

        assertEquals(2, repo.getAll().size());
    }

    //  Test total credit using Streams
    @Test
    void testTotalCreditUsingStreams() {
        TransactionRepository repo = new TransactionRepository();
        repo.add(new Credit(500));
        repo.add(new Credit(300));
        repo.add(new Debit(200));

        double totalCredit = repo.getAll().stream()
                .filter(t -> t instanceof Credit)
                .mapToDouble(Transaction::amount)
                .sum();

        assertEquals(800, totalCredit);
    }
}

