package top.lnj.leetcode.editor.cn;

/**
 * 盛最多水的容器
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-26
 */
public class T11 {

	/**
	 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。*
	 * 说明：你不能倾斜容器，且 n 的值至少为 2。
	 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
	 * 示例：
	 * 输入：[1,8,6,2,5,4,8,3,7]
	 * 输出：49
	 */
	/**
	 * 双指针法
	 * 盛水是由两块板的最小值决定的，所以盛水量为 左右指针中的较小值乘以两者之间的长度
	 * 当哪边的值小，哪边的指针就向另一侧移动，补短板
	 *
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			int temp = Math.min(height[left], height[right]) * (right - left);
			max = Math.max(temp, max);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
