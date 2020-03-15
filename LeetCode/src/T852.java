/**
 * @author LiuNaiJie
 * on 2019-07-18
 */
public class T852 {

	/**
	 * 山脉数组的峰顶索引
	 * 我们把符合下列属性的数组 A 称作山脉：
	 * <p>
	 * A.length >= 3
	 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
	 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：[0,1,0]
	 * 输出：1
	 * 示例 2：
	 * <p>
	 * 输入：[0,2,1,0]
	 * 输出：1
	 * 提示：
	 * <p>
	 * 3 <= A.length <= 10000
	 * 0 <= A[i] <= 10^6
	 * A 是如上定义的山脉
	 */

	/**
	 * 遍历扫描
	 */
	public int peakIndexInMountainArray(int[] A) {
		int i = 0;
		while (A[i] < A[i + 1]) {
			i++;
		}
		return i;
	}

	/**
	 * 双指针查找
	 *
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArrayDouble(int[] A) {
		int left = 0, right = A.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] < A[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

}
