package top.lnj.leetcode.editor.cn;

/**
 * @author ：LiuNaiJie
 * @date ：2020-07-23
 */
public class T83 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

}
