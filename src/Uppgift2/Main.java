package Uppgift2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        long timeBeforeSetup = System.nanoTime();
        int bufferSize = 10000;
        int noProducers = 4;
        int noConsumers = 4;
        int tasks = 200000;
        BlockingQueue<Task> queue = new ArrayBlockingQueue<>(bufferSize);


        Thread[] producerThreads = new Thread[noProducers];
        Thread[] consumerThreads = new Thread[noConsumers];

        for(int i=0;i<noProducers;i++)
            producerThreads[i] = new Thread(new Producer(queue,tasks/noProducers));
        for(int i=0;i<noConsumers;i++)
            consumerThreads[i] = new Thread(new Consumer(queue,tasks/noConsumers));
        long timeAfterSetup = System.nanoTime();
        for(int i=0;i<noProducers;i++)
            producerThreads[i].start();
        for(int i=0;i<noConsumers;i++)
            consumerThreads[i].start();

        for(int i=0;i<noConsumers;i++) {
            try {
                consumerThreads[i].join();
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

