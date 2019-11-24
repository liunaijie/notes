import java.util.Stack;

/**
 * @author LiuNaiJie
 * on 2019-10-20
 */
public class T232 {

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.empty());
	}

}

class MyQueue {

	Stack<Integer> input;
	Stack<Integer> output;

	/**
	 * Initialize your data structure here.
	 */
	public MyQueue() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		input.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if (output.isEmpty()) {
			exchange();
		}
		return output.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (output.isEmpty()) {
			exchange();
		}
		return output.peek();
	}

	private void exchange() {
		while (!input.isEmpty()){
			output.push(input.pop());
		}
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}

