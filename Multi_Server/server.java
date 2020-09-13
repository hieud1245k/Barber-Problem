package Multi_Server;

import java.awt.*;

public class server implements Runnable {
	protected simulationQueue q_; // reference to server queue
	protected TextArea txt_; // where to print messages
	protected double r_; // delay rate
	protected int num_; // server number

	public server(simulationQueue q, TextArea txt, double r, int num) {
		q_ = q;
		txt_ = txt;
		r_ = r;
		num_ = num;
	}

	public void run() {
		for (;;) {
			try { // simulate service
				if (q_.dequeue()) { // wait for a successful dequeue
					txt_.appendText("Service started\n");
					long delay = (long) (Math.random() * r_);
					Thread.currentThread().sleep(delay);
					// display the message
					txt_.appendText("Service completed after " + delay / 1000.0 + " Seconds by server " + num_ + "\n");
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
