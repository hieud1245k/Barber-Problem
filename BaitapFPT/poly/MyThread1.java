package BaitapFPT.poly;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 10;i++) {
			System.out.println(i+" ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MyThread1 Thread1 = new MyThread1();
		MyThread1 Thread2 = new MyThread1();
		Thread t1 = new Thread(Thread1);
		Thread t2 = new Thread(Thread2);
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}
