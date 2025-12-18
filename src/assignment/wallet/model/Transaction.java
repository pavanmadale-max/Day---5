package assignment.wallet.model;


import java.time.LocalDateTime;


public sealed interface Transaction
        permits CreditTransaction, DebitTransaction, TransferTransaction {


    double amount();
    LocalDateTime timestamp();
}


