/**
 * x的平方根
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T69 {

	/**
	 * 实现 int sqrt(int x) 函数。
	 * <p>
	 * 计算并返回 x 的平方根，其中 x 是非负整数。
	 * <p>
	 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: 4
	 * 输出: 2
	 * 示例 2:
	 * <p>
	 * 输入: 8
	 * 输出: 2
	 * 说明: 8 的平方根是 2.82842...,
	 * 由于返回类型是整数，小数部分将被舍去。
	 */

	public int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		int left = 2, right = x / 2;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			long num = (long) mid * mid;
			if (num > x) {
				right = mid - 1;
			} else if (num < x) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return right;
	}

}
