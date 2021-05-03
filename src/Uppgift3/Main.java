package Uppgift3;

public class Main {

    public static void main(String[] args) {
        long timeBeforeSetup = System.nanoTime();

        int noThreads = 8;



        Thread[] threads = new Thread[noThreads];

        for(int i=0; i<noThreads;i++) {
            threads[i] = new Thread(new Multitasker(i));
            System.out.println("Thread "+ i + " created");
        }

        long timeAfterSetup = System.nanoTime();

        for(int i=0; i<noThreads;i++) {
            threads[i].start();
        }
        for(int i=0; i<noThreads;i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeDone = System.nanoTime();

        System.out.println("Setup time: " + (timeAfterSetup-timeBeforeSetup)/1.0E9);
        System.out.println("Execution time: " + (timeDone-timeAfterSetup)/1.0E9);
        System.out.println("Total time: " + (timeDone-timeBeforeSetup)/1.0E9);


    }
}