import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuNaiJie
 * on 2019-11-20
 */
public class T109 {
	/**
	 * 有序链表转换二叉搜索树
	 * 使用 T141 中的 ListNode 作为链表
	 */

	/**
	 * @param head
	 * @return
	 */
	public static AVLTreeNode sortedListToBST(ListNode head) {
		AVLTreeNode root = null;
		while (head != null) {
			root = new AVLTree().add(head.val);
			head = head.next;
		}
		return root;
	}

	public TreeNode sortedListToBSTSelf(ListNode head) {
		//先将链表转化为数组，由于数组需要预先知道容量，所以使用了arraylist容器
		List<Integer> values = new ArrayList<Integer>();
		while (head != null) {
			values.add(head.val);
			head = head.next;
		}
		return help(values, 0, values.size() - 1);
	}

	private TreeNode help(List<Integer> list, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = help(list, left, mid - 1);
		node.right = help(list, mid + 1, right);
		return node;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		ListNode head5 = new ListNode(6);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		AVLTreeNode root = sortedListToBST(head);
		new AVLTree().print(root);
	}


}

/**
 * 平衡二叉树
 */
class AVLTree {

	AVLTreeNode head;

	public AVLTreeNode add(int value) {
		head = insert(head, value);
		return head;
	}

	private AVLTreeNode insert(AVLTreeNode root, int val) {
		if (root == null) {
			root = new AVLTreeNode(val);
			root.height = 0;
			return root;
		}
		if (val < root.val) {
			//左侧插入
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			//右侧插入
			root.right = insert(root.right, val);
		} else {
			//更新值
			root.val = val;
		}
		//检查失衡,左右节点的高度差绝对值大于 2 即为失衡
		if (Math.abs(Height(root.left) - Height(root.right)) >= 2) {
			//当左边树高时可能为 LL 型或 LR 型
			if (Height(root.left) > Height(root.right)) {
				//当新插入的值比 root.left 值小时为 LL 型，比 root.left 值大时为 LR 型
				if (val < root.left.val) {
					root = LL(root);
				} else if (val > root.left.val) {
					root = LR(root);
				}
			} else if (Height(root.right) > Height(root.left)) {
				//当右边树高时可能为 RR 型或 RL 型
				//当新插入的值比 root.right 值大时为 RR 型，比 root.right 值小时为 RL 型
				if (val > root.right.val) {
					root = RR(root);
				} else if (val < root.right.val) {
					root = RL(root);
				}
			}
		}
		root.height = Math.max(Height(root.left), Height(root.right)) + 1;
		return root;
	}

	/*四种类型转换*/

	public AVLTreeNode LL(AVLTreeNode node) {
		//反转结构
		AVLTreeNode result = node.left;
		node.left = result.right;
		result.right = node;
		//修改高度
		node.height = Math.max(Height(node.left), Height(node.right)) + 1;
		result.height = Math.max(Height(result.left), Height(result.right)) + 1;
		return result;
	}

	public AVLTreeNode LR(AVLTreeNode node) {
		AVLTreeNode result = node.left.right;
		node.left.right = result.left;
		result.left = node.left;
		node.left = result.right;
		result.right = node;
		//修改高度
		node.height = Math.max(Height(node.left), Height(node.right)) + 1;
		result.height = Math.max(Height(result.left), Height(result.right)) + 1;
		return result;
	}

	public AVLTreeNode RL(AVLTreeNode node) {
		AVLTreeNode result = node.right.left;
		node.right.left = result.right;
		result.right = node.right;
		node.right = result.left;
		result.left = node;
		//修改高度
		node.height = Math.max(Height(node.left), Height(node.right)) + 1;
		result.height = Math.max(Height(result.left), Height(result.right)) + 1;
		return result;
	}

	private AVLTreeNode RR(AVLTreeNode node) {
		AVLTreeNode result = node.right;
		node.right = result.left;
		result.left = node;
		//修改高度
		node.height = Math.max(Height(node.left), Height(node.right)) + 1;
		result.height = Math.max(Height(result.left), Height(result.right)) + 1;
		return result;
	}

	// 中序遍历
	public void print(AVLTreeNode node) {
		if (node == null) {
			return;
		}
		print(node.left);
		System.out.print(node.val + " ");
		print(node.right);
	}

	private int Height(AVLTreeNode avlTreeNode) {
		if (avlTreeNode == null) {
			return -1;
		} else {
			return avlTreeNode.height;
		}
	}

}

/**
 * 二叉平衡树的数据类型
 */
class AVLTreeNode {

	int val;
	int height = -1;
	AVLTreeNode left;
	AVLTreeNode right;

	public AVLTreeNode() {
	}

	public AVLTreeNode(int val) {
		this.val = val;
	}

}