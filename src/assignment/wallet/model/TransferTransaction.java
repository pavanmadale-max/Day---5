package assignment.wallet.model;

import java.time.LocalDateTime;

public record TransferTransaction(
        double amount,
        LocalDateTime timestamp,
        long fromWalletId,
        long toWalletId
) implements Transaction {
}