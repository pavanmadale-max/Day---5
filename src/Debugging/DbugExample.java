package Debugging;

public class DbugExample {

    public static void main(String[] args) {

        int withDraw=300;
        int balance=1000;

       balance=withDrawDetails(withDraw,balance);

       System.out.println(balance);
    }

    public static int  withDrawDetails(int amount,int balance){
        balance=balance-amount;
        return balance;
    }
}
