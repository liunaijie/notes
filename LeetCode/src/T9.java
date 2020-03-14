import java.util.Dictionary;

/**
 * 回文数
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-13
 */
public class T9 {

	/**
	 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: 121
	 * 输出: true
	 * 示例 2:
	 * <p>
	 * 输入: -121
	 * 输出: false
	 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	 * 示例 3:
	 * <p>
	 * 输入: 10
	 * 输出: false
	 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
	 * 进阶:
	 * <p>
	 * 你能不将整数转为字符串来解决这个问题吗？
	 */

	/**
	 * 使用字符串
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindromeString(int x) {
		if (x < 0) {
			return false;
		}
		String reverseStr = new StringBuilder(x).reverse().toString();
		return reverseStr.equals(x + "");
	}

	public boolean isPalindrome1(int x) {
		if (x < 0) {
			return false;
		}
		//先计算它的位数
		int count = 1;
		while (x / count >= 10) {
			count *= 10;
		}
		while (x > 0) {
			//头部的值
			int left = x / count;
			//尾部的值
			int right = x % 10;
			//判断是否相等
			if (left != right) {
				return false;
			}
			//将比较过的前后位置去掉
			// 10201为例， 先对1000取余，得到201，然后除以10，得到20
			//以这个20为例，再次计算是 20/100=0 20%100=0 相等，不会有影响
			x = (x % count) / 10;
			//因为这里每次都去掉了前后两位，所以是除以100
			count /= 100;
		}
		return true;
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		//当x不为0时，余数出现了0，比如 10，这种情况肯定不是回文数
		if (x % 10 == 0 && x != 0) {
			return false;
		}
		int m = 0;
		while (x > m) {
			m = m * 10 + x % 10;
			x /= 10;
		}
		//有两种情况，偶数时m=x,奇数时m/10=x
		return x == m || x == m / 10;
	}

}
