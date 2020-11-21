package top.lnj.leetcode;

/**
 * 搜索插入位置
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T35 {

	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 *
	 * 你可以假设数组中无重复元素。
	 *
	 * 示例 1:
	 *
	 * 输入: [1,3,5,6], 5
	 * 输出: 2
	 * 示例 2:
	 *
	 * 输入: [1,3,5,6], 2
	 * 输出: 1
	 * 示例 3:
	 *
	 * 输入: [1,3,5,6], 7
	 * 输出: 4
	 * 示例 4:
	 *
	 * 输入: [1,3,5,6], 0
	 * 输出: 0
	 * @param nums
	 * @param target
	 * @return
	 */

	public int searchInsertSearch(int[] nums, int target) {
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
			if (target < nums[i]) {
				return i;
			}
		}
		return result;
	}

	public int searchInsertBinarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] >= target) {
				if ((mid == 0) || (nums[mid - 1] < target)) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return nums.length;
	}


}
