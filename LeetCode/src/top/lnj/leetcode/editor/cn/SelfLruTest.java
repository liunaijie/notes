package top.lnj.leetcode.editor.cn;

/**
 * 用链表实现lru算法
 * 最近最少使用
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-26
 */
public class SelfLruTest {

	public static void main(String[] args) {
		LruList lruList = new LruList(5);
		lruList.add(1);
		lruList.add(2);
		lruList.add(3);
		lruList.add(4);
		lruList.add(5);
		lruList.add(1);
		lruList.add(1);
		lruList.add(3);
		lruList.add(4);
		lruList.add(5);
		lruList.print();
	}

}

/**
 * 单向链表，从头部插入。
 * 如果元素存在则将元素从原有位置删除并新插入到头部
 * 如果未超过容量，则从头部插入
 * 否则删除尾部节点，再将新元素插入
 */
class LruList {
	Node head;
	int length;
	int maxLength;

	public LruList() {
	}

	public LruList(int maxLength) {
		this.maxLength = maxLength;
	}

	void add(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = node;
			length++;
			return;
		}
		//进行遍历，查找是否已经存在
		if (head.val == val) {
			//如果是跟头部一样，则直接返回，因为需要先删除这个头部旧节点再添加，所以直接返回不做操作
			return;
		}
		Node e = head;
		Node next = e.next;
		while (e != null && next != null) {
			if (next.val == val) {
				e.next = next.next;
				next = null;
				addHead(node);
				return;
			}
			e = e.next;
			next = next.next;
		}
		//新插入节点不存在，判断是否超过容量
		if (length < maxLength) {
			addHead(node);
			length++;
		} else {
			//删除尾部节点，然后再从头插入
			deleteLast();
			addHead(node);
		}

	}

	private void deleteLast() {
		Node t = head;
		while (t.next != null && t.next.next != null) {
			t = t.next;
		}
		t.next = null;
	}

	private void addHead(Node e) {
		e.next = head;
		head = e;
	}

	/**
	 * 将链表打印
	 */
	void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ,");
			temp = temp.next;
		}
		System.out.println();
	}

}

class Node {
	Node next;
	int val;

	public Node(int val) {
		this.val = val;
	}

}
