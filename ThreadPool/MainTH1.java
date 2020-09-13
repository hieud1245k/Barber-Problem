package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTH1 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i <= 10; i++) {
			MyRunnable myRunnable = new MyRunnable("Runnable " + i);
			executorService.execute(myRunnable);
		}
		executorService.shutdown();
	}
}
