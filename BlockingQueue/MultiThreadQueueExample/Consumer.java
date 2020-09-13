package BlockingQueue.MultiThreadQueueExample;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    protected BlockingQueue<String> queue = null;

    public Consumer(BlockingQueue<String> queue2) {
        this.queue = queue2;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}