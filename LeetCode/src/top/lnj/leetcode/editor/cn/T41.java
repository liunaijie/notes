package top.lnj.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 缺失的第一个正数
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-29
 */
public class T41 {

	/**
	 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
	 * 示例 1:
	 * 输入: [1,2,0]
	 * 输出: 3
	 * 示例 2:
	 * 输入: [3,4,-1,1]
	 * 输出: 2
	 * 示例 3:
	 * 输入: [7,8,9,11,12]
	 * 输出: 1
	 * 提示：
	 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
	 */

	public static int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		//找到0元素，或者第一个正数数的下标
		int zeroIndex = binarySearch(nums, 0);
		//从这个元素向后查找，如果后面的元素不等于前面元素加一，则找到
		//如果第一个元素不是从1开始，那么返回1，如果是则返回该元素加一后的值
		if (zeroIndex == -1) {
			//全是负数
			return 1;
		} else if (nums[zeroIndex] == 0 || nums[zeroIndex] == 1) {
			for (int i = zeroIndex; i < nums.length - 1; i++) {
				if ((nums[i] != nums[i + 1]) && (nums[i] + 1) != nums[i + 1]) {
					return nums[i] + 1;
				}
			}
			//当全部完成后，仍然满足，那么返回数组最后一个元素的加一值
			return nums[nums.length - 1] + 1;
		} else {
			//不是从1开始的，如实例3
			return 1;
		}
	}

	public static int binarySearch(int[] a, int value) {
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

	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositiveArray(nums));
	}

	public static int firstMissingPositiveArray(int[] nums) {
		int n = nums.length;
		// 基本情况
		int contains = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				contains++;
			}
			if ((nums[i] <= 0) || (nums[i] > n)) {
				nums[i] = 1;
			}
		}
		//如果不存在1，那么返回1
		if (contains == 0) {
			return 1;
		}
		//如果数组长度为1，并且存在1，那么返回2
		// nums = [1]
		if (n == 1) {
			return 2;
		}

		// 使用索引和数字符号作为检查器
		// 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
		// 如果 nums[2] 是正数 表示数字 2 没有出现
		for (int i = 0; i < n; i++) {
			int a = Math.abs(nums[i]);
			// 如果发现了一个数字 a - 改变第 a 个元素的符号
			// 注意重复元素只需操作一次
			if (a == n) {
				nums[0] = -Math.abs(nums[0]);
			} else {
				nums[a] = -Math.abs(nums[a]);
			}
		}

		// 现在第一个正数的下标
		// 就是第一个缺失的数
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) {
				return i;
			}
		}
		if (nums[0] > 0) {
			return n;
		}
		return n + 1;
	}
}