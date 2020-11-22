package top.lnj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiuNaiJie
 * on 2019-10-20
 */
public class T225 {

	/**
	 * 使用队列实现栈的下列操作：
	 * <p>
	 * push(x) -- 元素 x 入栈
	 * pop() -- 移除栈顶元素
	 * top() -- 获取栈顶元素
	 * empty() -- 返回栈是否为空
	 * 注意:
	 * <p>
	 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
	 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
	 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
	 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		myStack.push(4);
		System.out.println(myStack.pop());
	}

}

/**
 * 用双队列实现
 */
class MyStack {

	Queue<Integer> input;
	Queue<Integer> output;
	/**
	 * 存储变量
	 */
	int top;

	/**
	 * Initialize your data structure here.
	 */
	public MyStack() {
		input = new LinkedList<Integer>();
		output = new LinkedList<Integer>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		input.add(x);
		top = x;
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		//留下最后一个，将其他的都放到 output 里面，并修改 top
		while (input.size() > 1) {
			top = input.poll();
			output.add(top);
		}
		//将 input 与 output 进行交换，这样在 push 方法中不用判断或改变
		Queue temp = input;
		input = output;
		output = temp;
		return output.poll();
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		return top;
	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}

/**
 * 用单队列实现
 */
class MyStack2 {

	Queue<Integer> queue;

	/**
	 * Initialize your data structure here.
	 */
	public MyStack2() {
		queue = new LinkedList<Integer>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		//每次添加都将之前的元素重新放一遍，这样在队列中的元素顺序就变成了 后入先出
		queue.add(x);
		int size = queue.size();
		while (size > 1) {
			queue.add(queue.poll());
			size--;
		}
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		return queue.poll();
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		return queue.peek();
	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return queue.isEmpty();
	}


}