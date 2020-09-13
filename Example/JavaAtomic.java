package Example;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaAtomic {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }

}

class ProcessingThread implements Runnable {
    private AtomicInteger count = new AtomicInteger();
	@Override
    public void run() {
		
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count.getAndIncrement();
            System.out.println("in for: "+count.get());
        }
        System.out.println("out for: "+count);
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class ProcessingThreadBasic implements Runnable {
    private Integer count = 0;
	@Override
    public void run() {
		
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
            System.out.println("in for: "+count);
        }
        System.out.println("out for: "+count);
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}