package top.lnj.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-12
 */
public class T1 {

	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * 示例:
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 */

	public int[] twoSum(int[] nums, int target) {
		int first = -1;
		int second = -1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					first = i;
					second = j;
					break;
				}
			}
		}
		int[] result = {first, second};
		return result;
	}

	public int[] twoSumBetter(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{-1, -1};
	}

	public int[] twoSumHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			int y = target - nums[i];
			if (map.containsKey(y)) {
				return new int[]{i, map.get(y)};
			}
			map.put(nums[i], i);
		}
		return new int[]{-1, -1};
	}

}
