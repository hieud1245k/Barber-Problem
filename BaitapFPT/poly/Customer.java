package BaitapFPT.poly;

public class Customer {
	int amount = 1000;
	public synchronized void withdraw(int m) {
		System.out.println("Ban dang rut tien...");
		if(amount < m) {
			try {
				System.out.println("Ban khong du tien de rut!");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		amount -= m;
		System.out.println("Ban da rut tien thanh cong. so du con lai: " + amount);
	}
	
	public synchronized void deposit(int m) {
		System.out.println("Ban dang nap tien...");
		amount += m;
		System.out.println("Ban da nap tien thanh cong...");
		notify();
	}
	public static void main(String[] args) {
		final Customer customer = new Customer();
		Thread thread1 = new Thread() {
			public void run() {
				customer.withdraw(1500);
			};
		};
		thread1.start();
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				customer.deposit(2000);
			}
		};
		thread2.start();
	}
}
