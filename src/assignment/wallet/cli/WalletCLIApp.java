package assignment.wallet.cli;


import assignment.wallet.model.*;
import assignment.wallet.repository.*;
import assignment.wallet.util.*;


import java.time.LocalDateTime;
import java.util.*;


public class WalletCLIApp {


    public static void main(String[] args) {


        Repository<User> userRepo = new InMemoryRepository<>();
        Repository<Wallet> walletRepo = new InMemoryRepository<>();


        User user = new User(1, "Pavan");
        Wallet wallet = new Wallet(101);


        userRepo.save(user);
        walletRepo.save(wallet);


        wallet.credit(1000);
        wallet.debit(200);


        List<Transaction> txs = List.of(
                new CreditTransaction(1000, LocalDateTime.now()),
                new DebitTransaction(200, LocalDateTime.now())
        );


        System.out.println("Total Tx Amount: " +
                TransactionReportUtil.totalAmount(txs));


        System.out.println("Tx Count By Type: " +
                TransactionReportUtil.countByType(txs));
    }
}