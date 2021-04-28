package Uppgift2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        int bufferSize = 10;
        int noProducers = 1000;
        int noConsumers = 10;
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(bufferSize);
        long timeBeforeSetup = System.nanoTime();
        Thread[] producerThreads = new Thread[noProducers];
        Thread[] consumerThreads = new Thread[noConsumers];

        for(int i=0;i<noProducers;i++)
            producerThreads[i] = new Thread(new Producer(queue));
        for(int i=0;i<noConsumers;i++)
            consumerThreads[i] = new Thread(new Consumer(queue));
        long timeAfterSetup = System.nanoTime();
        for(int i=0;i<noProducers;i++)
            producerThreads[i].start();
        for(int i=0;i<noConsumers;i++)
            consumerThreads[i].start();

        long timeDone = System.nanoTime();
        //System.out.println("Setup time: " + (timeAfterSetup-timeBeforeSetup)/1.0E9);
        //System.out.println("Execution time: " + (timeDone-timeAfterSetup)/1.0E9);
        //System.out.println("Total time: " + (timeDone-timeBeforeSetup)/1.0E9);
    }
}

