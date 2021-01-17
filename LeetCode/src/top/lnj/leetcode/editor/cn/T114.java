package top.lnj.leetcode.editor.cn;

import java.util.logging.Level;

/**
 * 二叉树展开为链表
 *
 * @author ：LiuNaiJie
 * @date ：2020-08-02
 */
public class T114 {

	/**
	 * 给定一个二叉树，原地将它展开为一个单链表。
	 * 例如，给定二叉树
	 * <p>
	 * 1
	 * / \
	 * 2   5
	 * / \   \
	 * 3   4   6
	 * 将其展开为：
	 * <p>
	 * 1
	 * \
	 * 2
	 * \
	 * 3
	 * \
	 * 4
	 * \
	 * 5
	 * \
	 * 6
	 */
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root, root.left, root.right);
	}


	private void helper(TreeNode node, TreeNode left, TreeNode right) {
		if (node == null || left == null) {
			return;
		}
		node.right = left;
		left.right = right;
	}

}
