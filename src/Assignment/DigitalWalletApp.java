package Assignment;

import java.util.ArrayList;
import java.util.List;

sealed abstract class Transaction permits Credit,Debit,Transfer{

    public abstract double amount();

}

final class Credit extends  Transaction{
    private final double amount;

    public Credit(double amount){
        this.amount=amount;
    }

    public double amount(){
        return amount;
    }
}

final class Debit extends Transaction{
    private final double amount;

    public Debit(double amount){
        this.amount=amount;
    }

    public double amount(){
        return amount;
    }
}

final class Transfer extends Transaction{
    private final double amount;

    public Transfer(double amount){
        this.amount=amount;
    }

    public double amount(){
        return amount;
    }
}

record walletTransaction(String id,Transaction transaction){

}

class Repository<T>{

List<T> data=new ArrayList<>();

void add(T item){
    data.add(item);
    }

    List<T> getAll(){
    return data;
    }

}



public class DigitalWalletApp {
    public static void main(String[] args) {

        Repository<walletTransaction> repo=new Repository<>();

   repo.add(new walletTransaction("T1",new Credit(300)));
   repo.add(new walletTransaction("T2",new Debit(200)));
   repo.add(new walletTransaction("T3",new Credit(400)));
   repo.add(new walletTransaction("T4",new Transfer(500)));

        double totalCredit=repo.getAll().stream().filter(t->t.transaction() instanceof Credit)
                .mapToDouble(t->t.transaction().amount()).sum();

        System.out.println("Total Credit amount: "+totalCredit);


    }
}
