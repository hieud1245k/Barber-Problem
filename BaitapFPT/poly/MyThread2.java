package BaitapFPT.poly;

public class MyThread2 {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread 1:");
				for(int i = 0; i < 10;i+=2) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread 2:");
				for(int i = 1; i < 10;i+=2) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
