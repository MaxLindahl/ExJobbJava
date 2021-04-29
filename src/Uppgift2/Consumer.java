package Uppgift2;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Task> queue;
    private int tasksToConsume;

    public Consumer(BlockingQueue<Task> queue, int tasks) {
        this.queue = queue;
        this.tasksToConsume = tasks;

    }

    @Override
    public void run() {
        while (tasksToConsume > 0) {
            try {
                Task task = queue.take();
                task.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task consumed");
            tasksToConsume--;
        }

    }
}
