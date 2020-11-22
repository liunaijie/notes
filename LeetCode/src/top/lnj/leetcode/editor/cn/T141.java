package top.lnj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuNaiJie
 * on 2019-11-19
 */
public class T141 {

	/**
	 * 环形链表
	 * 给定一个链表，判断链表中是否有环。
	 * 链表如果没有环则为一条直线，最后的节点 next 指向 null
	 * 如果中间有一个元素的 next 指向之前的元素，则构成了一个环
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		ListNode head6 = new ListNode(6);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		//现在构建的链表从 1-5，不存在环
		System.out.println(hasCycle1(head));
		//然后让最后一个节点指向前面的一个节点，构成环
		head6.next = head3;
		System.out.println(hasCycle1(head));

	}

	/**
	 * 使用外部元素进行存储
	 * 空间复杂度为 o(n)，时间复杂度为 o(n)
	 *
	 * @param head
	 * @return
	 */
	public static boolean hasCycle1(ListNode head) {
		if (head == null) {
			//入参检查，如果链表为空则不可能存在环
			return false;
		}
		Set set = new HashSet();
		while (head != null) {
			//如果当前节点在 set 中存储过，则表示有环
			if (set.contains(head)) {
				return true;
			}
			//不然将当前节点添加到 set 中，并将当前节点改为下一个节点
			set.add(head);
			head = head.next;
		}
		return false;
	}


	/**
	 * 双指针法
	 * 使用快慢两个指针，如果一个指针为空，则表示结束没有环
	 * 如果两者相遇则表示有环
	 *
	 * @param head
	 * @return
	 */
	public static boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}