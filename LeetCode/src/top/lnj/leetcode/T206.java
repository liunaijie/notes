package top.lnj.leetcode;

/**
 * 反转链表
 *
 * @author LiuNaiJie
 * on 2019-10-20
 */
public class T206 {

	/**
	 * 反转一个单链表。
	 * <p>
	 * 示例:
	 * <p>
	 * 输入: 1->2->3->4->5->NULL
	 * 输出: 5->4->3->2->1->NULL
	 * 进阶:
	 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	 */

	/**
	 * 迭代法
	 *
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}


	/**
	 * 递归法
	 *
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		return reverseHelp(prev, cur);
	}

	public ListNode reverseHelp(ListNode prev, ListNode cur) {
		if (cur == null) {
			return prev;
		}
		ListNode temp = cur.next;
		cur.next = prev;
		prev = cur;
		cur = temp;
		return reverseHelp(prev, cur);
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}



