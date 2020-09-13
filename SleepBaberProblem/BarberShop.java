package SleepBaberProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class BarberShop {
	public static void main(String[] args) {

		AtomicInteger spaces = new AtomicInteger(15);
		final Semaphore barbers = new Semaphore(3, true);
		final Semaphore customers = new Semaphore(0, true);
		ExecutorService openUp = Executors.newFixedThreadPool(3);
		/*
		 * Phương thức này giúp tạo ra một Pool có thể chứa tối đa nThreads. Khi Pool
		 * đạt đến giá trị tối đa nThreads, các Thread còn lại sẽ được đưa vào hàng đợi
		 * và chờ đến khi có Thread trong Pool được xử lý xong mới được thực thi tiếp.
		 */

		Barber[] employees = new Barber[3];

		System.out.println("Opening up shop");
		for (int i = 0; i < 3; i++) {
			employees[i] = new Barber(spaces, barbers, customers);
			openUp.execute(employees[i]);
		}

		while (true) {
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Sleep until next person gets in
			} catch (InterruptedException e) {
			}

			System.out.println("Customer walks in");

			if (spaces.get() >= 0) {
				new Thread(new Customer(spaces, barbers, customers)).start();
			} else {
				System.out.println("Customer walks out, as no seats are available");
			}
		}
	}
}
