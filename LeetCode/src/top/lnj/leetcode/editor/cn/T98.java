package top.lnj.leetcode.editor.cn;

import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-26
 */
public class T98 {

	/**
	 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	 * 假设一个二叉搜索树具有如下特征：
	 * 节点的左子树只包含小于当前节点的数。
	 * 节点的右子树只包含大于当前节点的数。
	 * 所有左子树和右子树自身必须也是二叉搜索树。
	 * 示例 1:
	 * 输入:
	 * 2
	 * / \
	 * 1   3
	 * 输出: true
	 * 示例 2:
	 * 输入:
	 * 5
	 * / \
	 * 1   4
	 *      / \
	 *     3   6
	 * 输出: false
	 * 解释: 输入为: [5,1,4,null,null,3,6]。
	 *      根节点的值为 5 ，但是其右子节点值为 4
	 */
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	private boolean helper(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		//当前节点的值返回应该在这个子树上的最大值和最小值之间
		if (min != null && node.val <= min) {
			return false;
		}
		if (max != null && node.val >= max) {
			return false;
		}
		//右子树上的最小值应该是当前节点的值
		if (!helper(node.right, node.val, max)) {
			return false;
		}
		//左子树上的最大值应该是当前节点的值
		if (!helper(node.left, min, node.val)) {
			return false;
		}
		return true;
	}

}