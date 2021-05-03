package Uppgift4;

public class Worker implements Runnable{

    private int loops;
    private int noAccounts;
    private int currentAccount = 0;
    private Bank bank;

    public Worker(int loops, int noAccounts, Bank bank) {
        this.bank = bank;
        this.loops = loops;
        this.noAccounts = noAccounts;
    }

    @Override
    public void run() {
        for (int i=0;i<loops;i++){
        bank.depositMoneyToAccount(currentAccount,10);
        currentAccount++;
        if(currentAccount==noAccounts)
            currentAccount = 0;
        }
        for (int i=0;i<loops;i++){
            bank.withdrawMoneyFromAccount(currentAccount,10);
            currentAccount++;
            if(currentAccount==noAccounts)
                currentAccount = 0;
        }
        for (int i=0;i<loops;i++){
            bank.depositMoneyToAccount(currentAccount,10);
            bank.withdrawMoneyFromAccount(currentAccount,10);
            currentAccount++;
            if(currentAccount==noAccounts)
                currentAccount = 0;
        }

    }
}
