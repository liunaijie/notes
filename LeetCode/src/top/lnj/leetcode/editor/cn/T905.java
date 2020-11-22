package top.lnj.leetcode.editor.cn;

/**
 * 按奇偶排序数组
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T905 {

	/**
	 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
	 * <p>
	 * 你可以返回满足此条件的任何数组作为答案。
	 * <p>
	 *  
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：[3,1,2,4]
	 * 输出：[2,4,3,1]
	 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
	 *  
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= A.length <= 5000
	 * 0 <= A[i] <= 5000
	 */

	public int[] sortArrayByParityArray(int[] A) {
		int[] result = new int[A.length];
		//先放偶数
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & 1) == 0) {
				result[index++] = A[i];
			}
		}
		//再放奇数
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & 1) == 1) {
				result[index++] = A[i];
			}
		}
		return result;
	}

	public int[] sortArrayByParity(int[] A) {
		int i = 0, j = A.length - 1;
		while (i < j) {
			//i遇到偶数继续前进
			if (A[i] % 2 == 0) {
				i++;
			}
			//j遇到奇数继续前进
			if (A[j] % 2 == 1) {
				j--;
			}
			//当i遇到奇数 1 > j遇到偶数0 时交换
			if (A[i] % 2 > A[j] % 2) {
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		return A;
	}


}
