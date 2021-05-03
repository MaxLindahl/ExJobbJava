package Uppgift1;


import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        long timeBeforeSetup = System.nanoTime();
        try{
            long numbersToSearch = 10000000;
            int numberOfThreads = 8;

            long resultGatherer = 0;

            FutureTask[] tasks = new FutureTask[numberOfThreads];

            for(int i = 0; i<numberOfThreads; i++){
                tasks[i] = new FutureTask(new PrimeFinder(numbersToSearch, numberOfThreads, i));
            }
            long timeAfterSetup = System.nanoTime();
            for(FutureTask task : tasks){
                new Thread(task).start();
            }
            for(FutureTask task : tasks){
                resultGatherer += (long)task.get();
            }
            long timeDone = System.nanoTime();
            System.out.println("Number of priems found: " + resultGatherer);
            System.out.println("Setup time: " + (timeAfterSetup-timeBeforeSetup)/1.0E9);
            System.out.println("Execution time: " + (timeDone-timeAfterSetup)/1.0E9);
            System.out.println("Total time: " + (timeDone-timeBeforeSetup)/1.0E9);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
