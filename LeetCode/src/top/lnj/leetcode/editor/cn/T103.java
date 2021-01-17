package top.lnj.leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-31
 */
public class T103 {
	/**
	 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	 * 例如：
	 * 给定二叉树 [3,9,20,null,null,15,7],
	 * 3
	 * / \
	 * 9  20
	 * /  \
	 * 15   7
	 * 返回锯齿形层次遍历如下：
	 * [
	 * [3],
	 * [20,9],
	 * [15,7]
	 * ]
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addFirst(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> con = new LinkedList<>();
			if (level % 2 == 0) {
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pollFirst();
					con.add(node.val);
					if (node.left != null) {
						queue.addLast(node.left);
					}
					if (node.right != null) {
						queue.addLast(node.right);
					}
				}
			} else {
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pollLast();
					con.add(node.val);
					if(node.right!=null){
						queue.addFirst(node.right);
					}
					if(node.left!=null){
						queue.addFirst(node.left);
					}
				}
			}
			result.add(con);
			level++;
		}
		return result;
	}


	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
			// 修改集合结构
			if ("b".equals(s)) {
				list.remove(s);
			}
		}
	}

}
