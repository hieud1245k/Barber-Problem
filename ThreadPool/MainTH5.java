package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTH5 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<String>> futures = new ArrayList<Future<String>>();
		for(int i = 0;i <= 10;i++) {
			futures.add(executorService.submit(new MyCallable("Callable "+ i)));
		}
		for(Future<String> future : futures) {
			System.out.println(future.get() + " kết thúc!");
		}
		executorService.shutdown();
	}
}
