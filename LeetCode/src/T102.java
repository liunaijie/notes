import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-26
 */
public class T102 {

	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 例如:
	 * 给定二叉树: [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回其层次遍历结果：
	 * [
	 *   [3],
	 *   [9,20],
	 *   [15,7]
	 * ]
	 */

	/**
	 * 递归实现
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		helper(root, 0, result);
		return result;
	}

	private void helper(TreeNode node, int level, List<List<Integer>> result) {
		if (result.size() == level) {
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.val);
		if (node.left != null) {
			helper(node.left, level + 1, result);
		}
		if (node.right != null) {
			helper(node.right, level + 1, result);
		}
	}


	/**
	 * 迭代实现
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			result.add(new ArrayList<Integer>());
			//每一次有多少个
			int levelLength = queue.size();
			//每一次将一层的全部取出来，并且顺序添加下一层的内容
			for (int i = 0; i < levelLength; i++) {
				TreeNode node = queue.poll();
				result.get(level).add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			//每取完一层后，开始取下一层
			level++;
		}
		return result;
	}

}
