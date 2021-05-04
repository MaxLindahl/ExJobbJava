package Uppgift2;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<Task> queue;
    int tasksToProduce;

    public Producer(BlockingQueue<Task> queue, int tasksToProduce) {
        this.queue = queue;
        this.tasksToProduce = tasksToProduce;
    }

    @Override
    public void run() {
        while (tasksToProduce > 0) {
            Task task = new Task();
            task.setNumber();
            try {
                queue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tasksToProduce--;
        }
    }

}
