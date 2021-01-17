package top.lnj.leetcode.editor.cn;

/**
 * @author ：LiuNaiJie
 * @date ：2020-12-26
 */
public class T867 {

	/**
	 * 给定一个矩阵A，返回A的转置矩阵。
	 * <p>
	 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
	 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
	 * 示例 2：
	 * <p>
	 * 输入：[[1,2,3],[4,5,6]]
	 * 输出：[[1,4],[2,5],[3,6]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= A.length<= 1000
	 * 1 <= A[0].length<= 1000
	 */

	public int[][] transpose(int[][] A) {
		int rows = A.length;
		int lines = A[0].length;
		int[][] res = new int[lines][rows];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < rows; j++) {
				res[i][j] = A[j][i];
			}
		}
		return res;
	}

}
