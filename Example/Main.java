package Example;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> queueIntegers = new ArrayBlockingQueue<Integer>(100);
		queueIntegers.add(3);
		queueIntegers.add(4);
		queueIntegers.add(5);
		queueIntegers.add(2);
		System.out.println(queueIntegers.remove());
		System.out.println(queueIntegers);
	}
}
