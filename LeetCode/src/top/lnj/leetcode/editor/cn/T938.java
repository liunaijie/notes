package top.lnj.leetcode.editor.cn;

/**
 * @author ：LiuNaiJie
 * @date ：2020-03-21
 */
public class T938 {

	/**
	 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
	 * 二叉搜索树保证具有唯一的值。
	 * 示例 1：
	 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
	 * 输出：32
	 * 示例 2：
	 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	 * 输出：23
	 * 提示：
	 * 树中的结点数量最多为 10000 个。
	 * 最终的答案保证小于 2^31。
	 */
	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;
		help(root, L, R, sum);
		return sum;
	}

	private void help(TreeNode node, int L, int R, int sum) {
		if (node == null) {
			return;
		}
		if (L <= node.val && node.val <= R) {
			sum += node.val;
		}
		if (L < node.val) {
			help(node.left, L, R, sum);
		}
		if (R > node.val) {
			help(node.right, L, R, sum);
		}
	}
}
