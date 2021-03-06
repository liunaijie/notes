package top.lnj.leetcode.editor.cn; /**
 * @author LiuNaiJie
 * on 2019-06-10
 */

import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class T1051 {

	/**
	 * 要计算没有站在正确位置的数量，首先要知道正确的排列是什么样的
	 * 所以我们先进行排序得到正确的排列
	 * 然后与原来的数组进行比较，看每一位上的数值是否一样，如果不一样则就是错误的
	 * 我使用arrays.sort进行排序
	 * 所有要先将原数组复制一下到新数组中，不然排序的时候会将原有的数组也进行改变，最终得到的结果为0
	 *
	 * @param heights
	 * @return
	 */
	public static int heightChecker(int[] heights) {
		int[] after = Arrays.copyOf(heights, heights.length);
		Arrays.sort(after);
		int result = 0;
		for (int i = 0; i < after.length; i++) {
			if (after[i] != heights[i]) {
				result += 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] heights = {1, 1, 4, 2, 1, 3};
		System.out.println(heightChecker(heights));
	}

}
