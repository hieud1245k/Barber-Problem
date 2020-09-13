package Multi_Server;

import java.awt.*;

public class arrival implements Runnable {
	protected simulationQueue q_; // reference to server queue
	protected TextArea txt_; // where to print messages
	protected double r_; // delay

	public arrival(simulationQueue q, TextArea txt, double r) {
		q_ = q;
		txt_ = txt;
		r_ = r;
	}

	public synchronized void run() {
		for (;;) {
			try { // simulate arrival
				long delay = (long) (Math.random() * r_);
				Thread.currentThread().sleep(delay);
				// display the message
				txt_.appendText("Arrival occurred after " + delay / 1000.0 + " Seconds\n");
				q_.enqueue();// put on queue
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
