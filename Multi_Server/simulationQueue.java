package Multi_Server;

import java.awt.*;

public class simulationQueue {
	protected int count_ = 0;

	public simulationQueue() {
	}

	public synchronized void enqueue() {
		count_++;
		notifyAll();
	}

	public synchronized boolean dequeue() {
		while (count_ <= 0)
			try {
				wait();
			} catch (InterruptedException ex) {
			}
		count_--;
		return true;
	}

	public boolean empty() {
		return count_ == 0;
	}

	public boolean full() {
		return false;
	}
}
