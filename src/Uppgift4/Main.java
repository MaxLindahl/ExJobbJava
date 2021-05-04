package Uppgift4;

public class Main {
    public static void main(String[] args) {
        long timeBeforeSetup = System.nanoTime();
        int noThreads = 1000;
        int noAccounts = 1;
        int noLoops = 1000;

        Bank bank = new Bank();
        Thread[] threads = new Thread[noThreads];

        for(int i = 0; i<noAccounts;i++){
            bank.createAccount(0);
        }
        for(int i = 0; i<noThreads;i++){
            threads[i] = new Thread(new Worker(noLoops,noAccounts,bank));
        }
        long timeAfterSetup = System.nanoTime();
        for(int i = 0; i<noThreads;i++){
            threads[i].start();
        }
        for(int i = 0; i<noThreads;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeDone = System.nanoTime();
        bank.printAccounts();
        System.out.println("Setup time: " + (timeAfterSetup-timeBeforeSetup)/1.0E9);
        System.out.println("Execution time: " + (timeDone-timeAfterSetup)/1.0E9);
        System.out.println("Total time: " + (timeDone-timeBeforeSetup)/1.0E9);


    }
}
