package BaberProblem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		WaitingRoom waitingRoom = new WaitingRoom(10);

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		executorService.execute(new Barber(waitingRoom));
		executorService.execute(new Barber(waitingRoom));
		executorService.execute(new Barber(waitingRoom));
//        executorService.submit(new Barber(waitingRoom));
//        executorService.submit(new Barber(waitingRoom));
//        executorService.submit(new Barber(waitingRoom));

		// Phương thức generate() cho phép truyền một Supplier vào để tự động generate
		// ra element. Nếu như kết quả của stream là vô hạn, chúng ta cần chỉ định rõ
		// giới hạn size.
		List<Customer> customers = Stream.generate(() -> new Customer(waitingRoom)).limit(20)
				.peek(executorService::execute).collect(toList());

		while (!customers.stream().allMatch(Customer::isShaved)) {
			TimeUnit.SECONDS.sleep(1);
		}

		System.out.println("all customers have been shaved");
		executorService.shutdownNow();
		executorService.awaitTermination(1, MINUTES);
	}

}
