package BlockingQueue.MultiThreadQueueExample;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            synchronized(this) {                  //this is suck!!!! and slow!!
                queue.put("1");
                Thread.sleep(1000);
            }

            synchronized(this) {                  //this is suck!!!! and slow!!
                queue.put("2");
                Thread.sleep(1000);
            }

            synchronized(this) {                  //this is suck!!!! and slow!!
                queue.put("3");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}