package Uppgift4;

import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts = new ArrayList<>();


    public void withdrawMoneyFromAccount(int id, int money){
        synchronized (accounts.get(id)) {
            accounts.get(id).withdrawMoney(money);
        }
    }

    public void depositMoneyToAccount(int id,int money){
        synchronized (accounts.get(id)) {
            accounts.get(id).depositMoney(money);
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
