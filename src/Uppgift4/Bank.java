package Uppgift4;

import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts = new ArrayList<>();


    public void withdrawMoneyFromAccount(int id, int money){
        synchronized (accounts.get(id)) {
            accounts.get(id).withdrawMoney(money);
            //print here to avoid compiler optimisation
            System.out.println("Withdraw");

        }
    }

    public void depositMoneyToAccount(int id,int money){
        synchronized (accounts.get(id)) {
            accounts.get(id).depositMoney(money);
            //print here to avoid compiler optimisation
            System.out.println("Deposit");
        }
    }
    public void createAccount(int money){
        accounts.add(new BankAccount(accounts.size(), money));
    }
    public void printAccounts(){
        for(BankAccount account : accounts){
            System.out.println(account);
        }
    }


}
