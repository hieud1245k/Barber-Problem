package ThreadPool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<MyRunnable> listExecutorServices = new ArrayList<MyRunnable>();
		/*
		 * ExecutorService executorService = Executors.newCachedThreadPool(); Nghe nói
		 * là hệ thống sẽ tự quyết định số lượng Thread được thực thi trong Hồ. Có vài
		 * thông tin hay ho đối với Pool này, đó là Pool sẽ cache và sử dụng lại cấu
		 * trúc của Thread cũ đã xử lý xong để thực thi cho Thread mới. Ngoài ra nếu một
		 * Thread trong Pool này không được sử dụng trong vòng 60 giây sẽ bị gỡ ra khỏi
		 * cache. Những tính năng này giúp cho Pool được khởi tạo theo kiểu này tận dụng
		 * được hiệu năng của hệ thống, đồng thời cũng giúp tránh bị tình trạng nắm giữ
		 * resource của hệ thống quá lâu.
		 */

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		/*
		 * Phương thức này giúp tạo ra một Pool có thể chứa tối đa nThreads. Khi Pool
		 * đạt đến giá trị tối đa nThreads, các Thread còn lại sẽ được đưa vào hàng đợi
		 * và chờ đến khi có Thread trong Pool được xử lý xong mới được thực thi tiếp.
		 */

		for (int i = 0; i < 100; i++) {
			listExecutorServices.add(new MyRunnable("Runnable " + i));
//			executorService.invokeAny((Collection<? extends Callable<MyRunnable>>) listExecutorServices);
//			executorService.execute(new MyRunnable("Runnable " + i));
			/*
			 * Đó là phương thức này được xem như việc đưa các Runnable vào Thread Pool và
			 * khởi chạy chúng theo kiểu bất đồng bộ. Đó là bạn sẽ không biết được khi nào
			 * các Runnable kết thúc, và các kết quả mà chúng trả về là gì.
			 */
		}
		executorService.shutdown(); // từ chối nhận thêm task, kết thúc khi hoàn thành nhiệm vụ
		// shutdownNow(): kết thúc ngay khi được gọi
	}
}
