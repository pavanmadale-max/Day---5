package assignment.wallet.test;


import assignment.wallet.model.*;
import assignment.wallet.util.TransactionReportUtil;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


class TransactionReportTest {


    @Test
    void shouldCalculateTotal() {
        List<Transaction> txs = List.of(
                new CreditTransaction(100, LocalDateTime.now()),
                new DebitTransaction(50, LocalDateTime.now())
        );


        assertEquals(150,
                TransactionReportUtil.totalAmount(txs));
    }
}