package Assignment;


import java.util.ArrayList;
import java.util.List;

sealed abstract class Txn permits CreditTxn,DebitTxn{
    double amount;

    Txn(double amount){
        this.amount=amount;
    }

    public double amount(){
        return amount;
    }

}


final class  CreditTxn extends Txn{
    public CreditTxn(double amount){
super(amount);
    }
}

final class  DebitTxn extends Txn{
    public DebitTxn(double amount){
        super(amount);
    }
}

record WalletTxn(String s,Txn txn){

}

class Wallet{

    List<WalletTxn> data=new ArrayList<>();

    public void add(WalletTxn txn){
        data.add(txn);
    }

    List<WalletTxn> getAll(){
        return data;
    }
}

class User{

    String name;

    Wallet wallet = new Wallet();

    public User(String name){
        this.name=name;
    }

}

public class WalletApp {
    public static void main(String[] args) {

       User user=new User("Pavan");

       user.wallet.add(new WalletTxn("T1",new CreditTxn(300)));
        user.wallet.add(new WalletTxn("T2",new DebitTxn(200)));
   user.wallet.add(new WalletTxn("T3",new CreditTxn(500)));


   double totalCredit=user.wallet.getAll().stream()
           .filter(t->t.txn() instanceof CreditTxn)
           .mapToDouble(t->t.txn().amount()).sum();

        double totalDebit=user.wallet.getAll().stream()
                .filter(t->t.txn() instanceof DebitTxn)
                .mapToDouble(t->t.txn().amount()).sum();



        System.out.println("User : "+user.name);
        System.out.println("Total Credit : "+totalCredit);
        System.out.println("Total Debit : "+totalDebit);
        System.out.println("Balance : "+(totalCredit-totalDebit));



    }
}
