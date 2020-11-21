package top.lnj.leetcode;

/**
 * 查找算法
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-05
 */
public class BinarySearchUtil {


	/**
	 * 二分查找
	 * 循环的写法
	 *
	 * @param a     被查找的数组，要求有序
	 * @param value 要查找的值
	 * @return 如果存在则返回下标，不存在返回 -1
	 */
	public int binarySearch(int[] a, int value) {
		int n = a.length;
		int start = 0, end = n - 1;
		//这个地方是 <=
		while (start <= end) {
			//取中间值，这个方法可能会溢出，可以采用下面的方法
//			int mid = (start + end) / 2;
			int mid = start + (start - end) / 2;
			//更进一步，也可以使用位运算
//			int mid = start + ((start + end) >> 1);
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] > value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 递归实现的二分查找
	 *
	 * @param a     被查找的数组，要求有序
	 * @param value 要查找的值
	 * @return 存在则返回下标，否则返回 -1
	 */
	public int binarySearchDeep(int[] a, int value) {
		int n = a.length;
		return binarySearchDeepHelp(a, 0, n - 1, value);
	}

	private int binarySearchDeepHelp(int[] a, int low, int high, int value) {
		if (low > high) {
			return -1;
		}
		int mid = low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return binarySearchDeepHelp(a, mid + 1, high, value);
		} else {
			return binarySearchDeepHelp(a, low, mid - 1, value);
		}
	}

	/**
	 * 利用二分查找，求平方根，要求精确到小数点后6位
	 *
	 * @param x 要求的值
	 * @return
	 */
	public double mySqrt(double x) {
		double low = 0.0, high = x;
		double mid = low + (high - low) / 2.0;
		//表示 10（^-6^）即小数点后6位
		double eps = 1e-6;
		while (Math.abs(high - low) > eps) {
			// 首先找到中间值
			mid = low + (high - low) / 2;
			double temp = mid * mid;
			// 比较并更新 high和low
			if ((temp - x) > eps) {
				high = mid;
			} else if ((temp - x) < -eps) {
				low = mid;
			} else {
				return mid;
			}
		}
		return mid;
	}

	/**
	 * 二分查找的变形，查找第一个值等于给定值的元素
	 * [1,2,3,3,3,4,5]。要求返回第一个3
	 *
	 * @param a     待查找的数组
	 * @param value 待查证的值
	 * @return 下标
	 */
	public int binarySearchFirstMatch(int[] a, int value) {
		int n = a.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				// 主要在这个地方
				//如果这个元素已经是数组的第一个元素了，那么就直接返回
				//如果不是，则判断上一个元素的值是不是等于value，如果不是则返回
				//如果是则更新high ，high=mid-1
				if ((mid == 0) || (a[mid - 1] != value)) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 二分查找的变形，查找最后一个值等于给定值的元素
	 * 例子同上，要求返回最后一个3
	 * 这个代码在上面的过程中，将相同值的情况合并到了大于，两种情况一同进行处理
	 *
	 * @param a
	 * @param value
	 * @return
	 */
	public int binarySearchLastMatch(int[] a, int value) {
		int n = a.length;
		int high = n - 1, low = 0;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if ((mid == 0) || (a[mid - 1] < value)) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找 变形三
	 * 查找第一个大于等于给定值的元素
	 * [1,2,4,4,5,6]。当查找3或者4时都返回2
	 * 查找3不存在，则返回第一个比3大的元素4，下标为2
	 * 查找4存在，则返回第一个4，下标为2
	 *
	 * @param a     数组
	 * @param value 要查找的值
	 * @return
	 */
	public int binarySearch3(int[] a, int value) {
		int n = a.length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if ((mid == 0) || (a[mid - 1] < value)) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 变形四，查找最后一个小于等于给定值的元素
	 * [3,5,6,6,8,9,10]。
	 * 当值存在时，返回最后一个等于给定值的元素
	 * 不存在时，返回最后一个小于给定值的元素
	 * 查询6，7都返回下标3
	 *
	 * @param a     数组
	 * @param value 要查找的值
	 * @return
	 */
	public int binarySearch4(int[] a, int value) {
		int n = a.length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else {
				if ((mid == n - 1) || (a[mid + 1] > value)) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

}
