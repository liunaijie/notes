/**
 * @author LiuNaiJie
 * on 2019-05-29
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class T728 {

	/**
	 * 循环获取每一个边界内的数
	 * 判断这个数是否是自除数
	 *
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividing(i)) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * 用一个变量存储要计算的数字
	 * <p>
	 * 1.获取最后一位数
	 * 2.当这位数字不为零并且能被要计算的数字整除时继续计算 否则返回false
	 * 3.变量除以10 然后重复进行 1，2步操作
	 *
	 * @param num
	 * @return
	 */
	public boolean isSelfDividing(int num) {
		int temp = num;
		while (temp != 0) {
			int digit = temp % 10;
			if (digit == 0 || num % digit != 0) {
				return false;
			}
			temp /= 10;
		}
		return true;
	}

}
