package ThreadPool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	private String name;
	public MyCallable(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String call() throws Exception {
		System.out.println(name + " đang thực thi...");
		Thread.sleep(2000);
		return this.name;
	}

}
