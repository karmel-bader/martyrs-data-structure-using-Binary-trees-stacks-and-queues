package application;

public class QStack<T extends Comparable<T>> {
	Queue<T> firstQueue = new Queue<>();
	Queue<T> secondQueue = new Queue<>();

	public void push(T data) {

		secondQueue.enQueue(data);
		while (!firstQueue.isEmpty()) {
			secondQueue.enQueue(firstQueue.getFront());
			firstQueue.deQueue();
		}
		Queue<T> temp = firstQueue;
		firstQueue = secondQueue;
		secondQueue = temp;
	}

	public T pop() {
		if (firstQueue.isEmpty())
			return null;
		return firstQueue.deQueue();

	}

	public T peek() {
		if (firstQueue.isEmpty())
			return null;
		return firstQueue.getFront();
	}

	public boolean isEmpty() {
		return firstQueue.isEmpty();
	}

	public void clear() {
		firstQueue.clear();
		secondQueue.clear();
	}

}

