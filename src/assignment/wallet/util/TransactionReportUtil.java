package assignment.wallet.util;


import assignment.wallet.model.Transaction;
import java.util.*;
import java.util.stream.Collectors;


public class TransactionReportUtil {


    public static double totalAmount(List<Transaction> txs) {
        return txs.stream()
                .mapToDouble(Transaction::amount)
                .sum();
    }


    public static Map<String, Long> countByType(List<Transaction> txs) {
        return txs.stream()
                .collect(Collectors.groupingBy(
                        tx -> tx.getClass().getSimpleName(),
                        Collectors.counting()
                ));
    }
}