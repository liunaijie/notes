package top.lnj.leetcode.editor.cn;

/**
 * @author LiuNaiJie
 * on 2019-10-20
 */
public class T24 {

	/**
	 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
	 *
	 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 *
	 *  
	 *
	 * 示例:
	 *
	 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
	 *
	 * @param head
	 * @return
	 */

	public ListNode swapPairs(ListNode head) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode curr = pre.next;
		while (curr != null && curr.next != null) {
			ListNode temp = curr.next;
			ListNode next = temp.next;
			pre.next = temp;
			temp.next = curr;

			pre = curr;
			curr = next;
		}
		pre.next = curr;
		return fakeHead.next;
	}


	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}


