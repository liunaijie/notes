/**
 * K个一组反转链表
 *
 * @author LiuNaiJie
 * on 2019-11-27
 */
public class T25 {

	/**
	 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	 * k 是一个正整数，它的值小于或等于链表的长度。
	 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	 * 示例 :
	 * 给定这个链表：1->2->3->4->5
	 * 当 k = 2 时，应当返回: 2->1->4->3->5
	 * 当 k = 3 时，应当返回: 3->2->1->4->5
	 * 说明 :
	 * 你的算法只能使用常数的额外空间。
	 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
	 */

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode lastNode = head;
		//根据 k ，分割每一组。最终 temp 为一组的最后一个节点
		for (int i = 1; i < k; i++) {
			if (lastNode != null) {
				lastNode = lastNode.next;
			}
		}
		//如果为空则表示不足一组，不用反转，返回头指针
		if (lastNode == null) {
			return head;
		}
		//开始每一组的反转，首先将下一组的开始存为一个变量
		ListNode nextGroupHead = lastNode.next;
		//然后将这一组与下一组分隔，不然无法反转这一组，后面再将两者连接
		lastNode.next = null;
		//将这一组反转
		ListNode newHead = reverseGroupHelp(head);
		//将后面的继续递归反转，得到的结果是下面一组反转后的头结点
		ListNode reverseNextHead = reverseKGroup(nextGroupHead, k);
		//当这一组进行反转后，传入的 head 变成了这一组最后一个节点，最后一个节点连接下一组的头结点。如果不够一组，在上面已经 return 掉了
		head.next = reverseNextHead;
		return newHead;
	}

	private ListNode reverseGroupHelp(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = reverseGroupHelp(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}


	/**
	 * 反转单链表变形 2
	 * 给定一个单链表的头节点，实现一个调整单链表的函数，使得每 k 个节点之间为一组进行逆序，并且从链表的尾部开始组起，剩余节点数量不够一组的不需要排序
	 * 例：
	 * 输入：1->2->3->4->5->6->7->8->NULL，k=3
	 * 则 1->2,3->4->5,6->7->8各为一组。其中 1->2不用调整，因为不够一组
	 * 输出：1->2->5->4->3->8->7->6->NULL
	 * 与变形 1 类似，不过是从尾部开始组起，所以我们先将链表进行反转，然后再按照变形 1 做，做完后再反转回来。
	 *
	 * @param head 头指针
	 * @param k    一组的个数
	 * @return
	 */
	public ListNode reverseKGroupFromTail(ListNode head, int k) {
		//首先将链表反转
		ListNode tail = reverseGroupHelp(head);
		//然后将链表分组反转
		ListNode reverse = reverseKGroup(tail, k);
		//再将链表反转回来
		return reverseGroupHelp(reverse);
	}

}
