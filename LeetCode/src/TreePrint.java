import java.util.*;

/**
 * 记录几种树的访问方法
 * 前序，中序，后序
 * 深度优先遍历 DFS
 * 广度优先遍历 BFS
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-03
 */
public class TreePrint {

	/**
	 * 前序打印
	 *
	 * @param root
	 */
	public void prologuePrint(TreeNode root) {
		if (root == null) {
			return;
		}
		prologuePrint(root.left);
		System.out.print(root.val + " ");
		prologuePrint(root.right);
	}

	/**
	 * 前序，将数据放到集合中
	 *
	 * @param root
	 * @return
	 */
	public List prologueList(TreeNode root) {
		List result = new ArrayList();
		prologueListHelp(root, result);
		return result;
	}

	private void prologueListHelp(TreeNode node, List list) {
		if (node == null) {
			return;
		}
		prologueListHelp(node.left, list);
		list.add(node.val);
		prologueListHelp(node.right, list);
	}

	/**
	 * 中序打印
	 *
	 * @param root
	 */
	public void middlePrint(TreeNode root) {
		if (root == null) {
			return;
		}
		middlePrint(root.left);
		System.out.print(root.val + "");
		middlePrint(root.right);
	}

	/**
	 * 中序添加到集合
	 *
	 * @param root
	 * @return
	 */
	public List middleList(TreeNode root) {
		List result = new ArrayList();
		middleListHelp(root, result);
		return result;
	}

	private void middleListHelp(TreeNode node, List list) {
		if (node == null) {
			return;
		}
		middleListHelp(node.left, list);
		list.add(node.val);
		middleListHelp(node.right, list);
	}

	/**
	 * 后序打印
	 *
	 * @param root
	 */
	public void postPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		postPrint(root.left);
		System.out.print(root.val + " ");
		postPrint(root.right);
	}

	public List postList(TreeNode root) {
		List result = new ArrayList();
		postListHelp(root, result);
		return result;
	}

	private void postListHelp(TreeNode node, List list) {
		if (node == null) {
			return;
		}
		prologueListHelp(node.left, list);
		list.add(node.val);
		prologueListHelp(node.right, list);
	}

	/**
	 * 使用队列实现一个广度优先遍历
	 *
	 * @param root
	 */
	public static void BFSPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			//先进先出，先放左节点，再放右节点。遍历的时候就是每一层从左到右的顺序
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}


	public static void DFSPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			//由于栈，先进后出，所以先放右节点
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		BFSPrint(root);
		System.out.println();
		DFSPrint(root);
	}

}
