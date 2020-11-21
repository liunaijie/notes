package top.lnj.leetcode;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-26
 */
public class T101 {

	/**
	 * 对称二叉树
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
