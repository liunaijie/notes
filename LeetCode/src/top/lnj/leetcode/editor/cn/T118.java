package top.lnj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-15
 */
public class T118 {

	/**
	 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
	 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
	 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
	 * 示例:
	 * 输入: 5
	 * 输出:
	 * [
	 * [1],
	 * [1,1],
	 * [1,2,1],
	 * [1,3,3,1],
	 * [1,4,6,4,1]
	 * ]
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows < 1) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = Arrays.asList(new Integer[i + 1]);
			temp.set(0, 1);
			temp.set(i, 1);
			for (int j = 1; j < i; j++) {
				temp.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			result.add(temp);
		}
		return result;
	}


}
