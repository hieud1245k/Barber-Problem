package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTH4 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Future> futures = new ArrayList<Future>(); // khởi đi list futures
		for(int i = 0;i <= 10;i++) {
			futures.add(executorService.submit(new MyRunnable("Runner "+ i))); // từng future sẽ quản lý runnable
		}
		for(Future future : futures) {
			try {
				// khi kết thúc, get của future sẽ trả về null
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}
}
