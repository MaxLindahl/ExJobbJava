package Uppgift4;

public class Main {
    public static void main(String[] args) {
        int noThreads = 8;
        int noAccounts = 8;
        int noLoops = 10000;

        Bank bank = new Bank();
        Thread[] threads = new Thread[noThreads];

        for(int i = 0; i<noAccounts;i++){
            bank.createAccount(0);
        }
        for(int i = 0; i<noAccounts;i++){
            threads[i] = new Thread(new Worker(noLoops,noAccounts,bank));
        }
        for(int i = 0; i<noAccounts;i++){
            threads[i].start();
        }
        for(int i = 0; i<noAccounts;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bank.printAccounts();


    }
}
