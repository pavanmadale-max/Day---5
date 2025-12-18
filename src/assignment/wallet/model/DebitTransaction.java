package assignment.wallet.model;

import java.time.LocalDateTime;

public record DebitTransaction(
        double amount,
        LocalDateTime timestamp
) implements Transaction {
}
