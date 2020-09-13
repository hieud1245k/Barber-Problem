package BaitapFPT.poly;

public class MyThread3 {
	static int i = 0;
	public synchronized void print() {
		while(i++ < 10) {
			System.out.println(i);		
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public synchronized void printState() {
		while(true) {
			try {
				if(i%2 == 0) {
					System.out.println("chan");
				} else {
					System.out.println("le");
				}
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MyThread3 myThread3 = new MyThread3();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				myThread3.print();
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				myThread3.printState();
			}
		};
		thread1.start();
		thread2.start();
	}
}
