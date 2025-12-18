package assignment.wallet.model;

import java.time.LocalDateTime;

public record CreditTransaction(
        double amount,
        LocalDateTime timestamp
) implements Transaction {
}
