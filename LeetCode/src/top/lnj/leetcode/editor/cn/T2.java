package top.lnj.leetcode.editor.cn; /**
 * @author LiuNaiJie
 * on 2019-08-20
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode curr = node;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			sum = sum % 10;

			curr.val = sum;
			if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
				curr.next = new ListNode(0);
				curr = curr.next;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry == 1) {
			curr.next = new ListNode(carry);
		}
		return node;
	}


	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode curr = node;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			curr.next = new ListNode(sum);
			curr = curr.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry == 1) {
			curr.next = new ListNode(carry);
		}
		return node.next;
	}


	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
