package chart1;

/**
 * @author LiuNaiJie
 * on 2019-10-26
 */
public class T1_1_14 {

	/**
	 * 编写一个静态方法 lg(),接受一个整形参数 N，返回不大于 log2N的最大整数。不要使用 Math 库。
	 *
	 * @param N 参数
	 * @return 不大于 log2N的最大整数
	 */
	static int lg(int N) throws Exception {
		//首先检查参数，log2N 的参数大于 0
		if (N <= 0) {
			throw new Exception("参数范围不正确");
		}
		//由于是整数，所以最小为 1，这时的结果为 0
		if (N == 1) {
			return 0;
		}
		int result = 1;
		//计算 log2N 就是计算多少个 2 相乘等于 N。所以基数设置为 2，for 循环里面的阶乘设置为 2。如果求 log10N 都设置成 10 即可。
		int product = 2;
		while (product < N) {
			result++;
			product *= 2;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(lg(1024));
	}

}
