package Uppgift4;

public class BankAccount {
    private int id;
    private int money;

    public BankAccount(int id, int money){
        this.id = id;
        this.money = money;
    }
    public void depositMoney(int money){
        this.money+=money;
    }

    public void withdrawMoney(int money){
        this.money-=money;
    }

    public int getMoney() {
        return money;
    }

    public String toString(){
        return "Account: " + id + " Balance: "+money;
    }
}
