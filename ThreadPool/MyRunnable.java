package ThreadPool;

public class MyRunnable implements Runnable {
	private String name;
	public MyRunnable(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		try {
			System.out.println(name + " đang thực thi...");
			Thread.sleep(2000);
			System.out.println(name + " kết thúc.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
