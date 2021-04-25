package Uppgift1;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        try{
            long numbersToSearch = 10000000;
            int numberOfThreads = 8;

            long resultGatherer = 0;
            FutureTask[] tasks = new FutureTask[numberOfThreads];

            for(int i = 0; i<numberOfThreads; i++){
                tasks[i] = new FutureTask(new PrimeFinder(numbersToSearch, numberOfThreads, i));
            }
            for(FutureTask task : tasks){
                new Thread(task).start();
            }
            for(FutureTask task : tasks){
                resultGatherer += (long)task.get();
            }
            System.out.println("Number of priems found: " + resultGatherer);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
